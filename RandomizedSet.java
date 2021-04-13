class RandomizedSet {

    /** Initialize your data structure here. */
    Random rand = new Random();
    private Map<Integer, Integer> s;
    private List<Integer> k;
    public RandomizedSet() {
        s = new HashMap<>(); //record position
        k = new ArrayList<>(); //random
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        boolean res = this.s.containsKey(val);
        if(res == false){
           k.add(val);
           this.s.put(val, this.s.size());
           return true;
        } 
        return false;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        boolean res = this.s.containsKey(val);
        if(res == true){
           int position = this.s.get(val);
           int last = this.s.size() - 1;
           if(position != last){
              this.s.put(k.get(last), position);
              this.k.set(position, k.get(last));
           }
           this.k.remove(last);
           this.s.remove(val);
           return true;
        } 
        return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int index = rand.nextInt(s.size());
        return k.get(index);
    }
}