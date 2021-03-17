package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class findMinArrowShots {
	public int findMinArrowShots(int[][] points) {
        if(points.length == 0) return 0;
        Arrays.sort(points, new myComparator());
        int end = points[0][1];
        int res = 1;
        for(int i = 1; i < points.length; i++){
            if(points[i][0] > end){
                res++;
                end = points[i][1];
            }else{
                end = Math.min(end, points[i][1]);
            }
        }
        return res;
    }
    
   class myComparator implements Comparator<int[]>{
        public int compare(int[] a, int[] b){
            return a[1] < b[1] ? -1 : (a[1] == b[1] ? 0 : 1);
        }
    }
}
