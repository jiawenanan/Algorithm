package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class removeCoveredIntervals {
	 public int removeCoveredIntervals(int[][] intervals) {
	        if(intervals.length == 1){
	            return 0;
	        }
	        Arrays.sort(intervals, new myComparator());
	        int end = intervals[0][1];
	        int head = intervals[0][0];
	        int count = 1;//won't be removed 
	        for(int i = 1; i < intervals.length; i++){
	            if(intervals[i][0] > head && intervals[i][1] > end){
	                count++;
	            }
	            head = Math.min(head, intervals[i][0]);
	            end = Math.max(end, intervals[i][1]);
	        }
	        return count;
	    }
	    
	    class myComparator implements Comparator<int[]>{
	        public int compare(int[] a, int[] b){
	                return a[0] - b[0];
	            }
	    }
}
//add number
