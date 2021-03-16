package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class eraseOverlapIntervals {
	public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length <= 1) return 0;
        Arrays.sort(intervals, new myComparator());
        int end = intervals[0][1];
        int res = 1;
        for(int i = 1; i < intervals.length; i++){
            if (intervals[i][0] >= end){
                res++;
                end = intervals[i][1];
            } 
        }
        return intervals.length - res;
    }
    
    class myComparator implements Comparator<int[]>{
        public int compare(int[] a, int[] b){
            return a[1] - b[1];
        }
    }
}
