class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if(nums.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int start = -1;
        int end = -2;
        for(int i = 0; i < nums.length; i++){
            min = Math.min(min, nums[nums.length - 1 - i]);
            max = Math.max(max, nums[i]);
            if(nums[i] < max) end = i;
            if(nums[nums.length - 1 - i] > min) start = nums.length - 1 - i;
        }
        return end - start + 1;
    }
}
