class CustomStack {
private int cap;
    private int size;
    private ArrayList<Integer> stack;
    private int[] record;
    public CustomStack(int maxSize) {
        stack = new ArrayList<Integer>(maxSize);
        size = 0;
        record = new int[maxSize];
        cap = maxSize;
    }
    
    public void push(int x) {
        if(size == cap) return;
        stack.add(0);
        stack.set(size, x);
        size++;
        return;
    }
    
    public int pop() {
        if(size == 0) return -1;
        int res = stack.get(size - 1);
        size--;
        res += record[size];
        if(size != 0){
           record[size - 1] += record[size];
        }
        record[size] = 0;
        return res;
    }
    
    public void increment(int k, int val) {
        if(k > size) k = size;
        if(k != 0){
            record[k - 1] += val;
        }
        return;
    }
}