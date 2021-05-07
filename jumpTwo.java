class Solution {
    public int jump(int[] nums) {
        int len = nums.length;
        if(len == 1) return 0;
        int canReach = 0;
        int jump = 0;
        int end = 0;
        for(int i = 0; i < len - 1; i++){
            int curr = i + nums[i];
            canReach = Math.max(canReach, curr);
            if(i == end){
                jump++;
                end = canReach;
            }
        }
        return jump;
    }
}