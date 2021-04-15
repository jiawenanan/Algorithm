class SnapshotArray {
    
    private int snap_id;
    private Map<Integer, HashMap<Integer, Integer>> record;
    private int len;
    public SnapshotArray(int length) {
        snap_id = 0;
        record = new HashMap<>();
        len = length;
        HashMap<Integer, Integer> init = new HashMap<>();
        record.put(0, init);
    }
    
    public void set(int index, int val) {
        HashMap<Integer, Integer> curr = this.record.get(snap_id);
        curr.put(index, val);
    }
    
    public int snap() {
        int res = this.snap_id;
        this.snap_id++;
        HashMap<Integer, Integer> old = this.record.get(res);
        HashMap<Integer, Integer> init = (HashMap<Integer, Integer>) old.clone();
        record.put(snap_id, init);
        return res;
    }
    
    public int get(int index, int snap_id) {
        HashMap<Integer, Integer> curr = this.record.get(snap_id);
        return curr.getOrDefault(index, 0);
    }
}