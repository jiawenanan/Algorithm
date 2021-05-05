class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        int target = nums.length - 1;
        for(int i = target - 1; i >= 0; i--){
            //if target is reachable from index i, set i as the next target.
            if(i + nums[i] >= target){
                target = i;
            }
        }
        return target == 0 ? true : false;
    }
}