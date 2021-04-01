class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int sum = 0;
        int l = 0;
        for(int curr : weights){
            l = Math.max(l, curr); //prevent comparision of each curr & mid in following iteration
            sum += curr;
        }
        int r = sum;
        while(l < r){
            int mid = l + (r - l) / 2;
            int res = 0;
            int add = 0;
            for(int i = 0; i < weights.length; i++){
                add += weights[i];
                if(add == mid){
                    add = 0;
                    res++;
                }else if(add > mid){
                    add = 0;
                    res++;
                    i--;
                }else if(add < mid && i == weights.length - 1){
                    res++;
                }
            }
            if(res > D) 
                l = mid + 1;
            else r = mid;
        }
        return l;
    }
}