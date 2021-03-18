package leetcode;

import java.util.*;

public class minAvailableDuration {
	public List<Integer> minAvailableDuration1(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, (a,b)->a[0]-b[0]);
        Arrays.sort(slots2, (a,b)->a[0]-b[0]);
        List<Integer> res = new ArrayList<>();
        int end = 0;
        int head = 0;
        boolean found = false;
        for(int i = 0; i < slots1.length; i++){
            if(found == true) break;
            if(slots1[i][1] - slots1[i][0] < duration) continue;
            for(int j = 0; j < slots2.length; j++){
                if(slots2[j][1] - slots2[j][0] < duration || slots2[j][1] <= slots1[i][0]){
                    continue;
                }
                if(slots2[j][0] >= slots1[i][1]){
                    j = slots2.length;
                }else{
                    end = Math.min(slots1[i][1], slots2[j][1]);
                    head = Math.max(slots1[i][0], slots2[j][0]);
                    if(end - head >= duration){
                        found = true;
                        res.add(head);
                        res.add(head + duration);
                        break;
                    }
                }
            }
        }
        return res;
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
