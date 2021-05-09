class Solution {
    public boolean canReach(int[] arr, int start) {
        if(start < 0 || start > arr.length - 1 || arr[start] < 0) return false;
        if(arr[start] == 0) return true;
        else arr[start] = -arr[start];
        return canReach(arr, start - arr[start]) || canReach(arr, start + arr[start]);
    }
}