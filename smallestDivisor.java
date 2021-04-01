class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int l = 1;
        int r = (int) 1e6;
        while(l < r){
            int res = 0;
            int mid = l + (r - l) / 2;
            for(int curr: nums){
                res += (curr % mid == 0 ? curr / mid : curr / mid + 1);
            }
            if(res > threshold)
                l = mid + 1;
            else r = mid;
        }
        return l;
    }
}
