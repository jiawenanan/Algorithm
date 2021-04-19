class Solution {
    public int[] getOrder(int[][] tasks) {
        int num = tasks.length;
        int[] res = new int[num];
        if(num == 1){
            res[0] = 0;
            return res;
        }
        
        int[][] helper = new int[num][];
        for(int i = 0; i < num; i++){
            helper[i] = new int[]{tasks[i][0], tasks[i][1], i};
        }
        Arrays.sort(helper, (a, b) -> {
            if(a[0] != b[0])return a[0] - b[0];
            if(a[1] != b[1])return a[1] - b[1];
            return a[2] - b[2];
        });
        //int[3]
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> {
            if(a[1] < b[1]){
                return -1;
            }else if(a[1] == b[1]){
                return a[2] - b[2];
            }else{
                return 1;
            }
        });
            
        int time =0;
        int index = 0;
        int i = 0;
        while(i < num){
            while(i < num && helper[i][0] <= time){
                pq.offer(helper[i]);
                i++;
            }
            if(pq.size() == 0){
                time = helper[i][0];
                continue;
            } 
            // while(i < num && helper[i][0] <= time){
            //     pq.offer(helper[i]);
            //     i++;
            // }
            int[] curr = pq.poll();
            time += curr[1];
            res[index++] = curr[2];
        }
        
        while(!pq.isEmpty()){
            res[index++] = pq.poll()[2];
        }
        return res;
    }
    
    // class myComparator implements Comparator<int[]>{
    //     public int compare(int[] a, int[] b){
    //         if(a[0] < b[0]){
    //             return -1;
    //         }else if(a[0] == b[0]){
    //             return a[1] - b[1];   
    //     }else{
    //             return 1;
    //         }
    //    }
    // }
}