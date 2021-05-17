class Solution {
    public int maximumGap(int[] nums) {
        int len = nums.length;
        int res = 0;
        if(len == 1) return 0;
        Arrays.sort(nums);
        for(int i = 1; i < len; i++){
            res = Math.max(res, nums[i] - nums[i - 1]);
        }
        return res;
    }
}
