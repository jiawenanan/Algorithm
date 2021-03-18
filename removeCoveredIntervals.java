package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class removeCoveredIntervals {
	 public int removeCoveredIntervals1(int[][] intervals) {
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
	
	public List<Integer> minAvailableDuration2(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, (a,b)->a[0]-b[0]); // sort increasing by start time
        Arrays.sort(slots2, (a,b)->a[0]-b[0]); // sort increasing by start time

        int i = 0, j = 0;
        int n1 = slots1.length, n2 = slots2.length;
        while (i < n1 && j < n2) {
            int intersectStart = Math.max(slots1[i][0], slots2[j][0]);
            int intersectEnd = Math.min(slots1[i][1], slots2[j][1]);

            if (intersectStart + duration <= intersectEnd) // Found the result
                return Arrays.asList(intersectStart, intersectStart + duration);
            else if (slots1[i][1] < slots2[j][1])
                i++;
            else
                j++;
        }
        return new ArrayList<>();
    }
}
//add number
