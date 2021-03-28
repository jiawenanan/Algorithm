package leetcode;

public class maxSum {
	public int maxSum(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        long res1=0;
        long res2=0;
        int l=0;
        int r=0;
        while (l<m||r<n){
            if(l<m&&r<n){
                if(nums1[l]<nums2[r]){
                    res1+=nums1[l];
                    l++;
                }else if(nums1[l]>nums2[r]){
                    res2+=nums2[r];
                    r++;
                }else {
                    res1=Math.max(res1+nums1[l],res2+nums2[r]);
                    res2=res1;
                    l++;
                    r++;
                }
            }else {
                if(l<m){
                    res1+=nums1[l++];
                }else {
                    res2+=nums2[r++];
                }
            }
        }
        return (int) (Math.max(res1,res2)%1000000007);
    }
}
