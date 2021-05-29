class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int pre = 0;
        int res = 0;
        int[] count = new int[nums.length + 1];
        count[0] = 1;
        for(int i = 0; i < nums.length; i++){
            pre += nums[i];
            if(pre >= goal){
                res += count[pre - goal];
            }
            count[pre]++;
        }
        return res;
  }
}