class Solution {
  
    public int maximizeSweetness(int[] sweetness, int K) {
      int min = Integer.MAX_VALUE;
      int sum = 0;
      for(int sweet : sweetness) {
        min = Math.min(min, sweet);
        sum += sweet;
      }
      int left = min;
      int right = sum;

      while(left < right) {

        int targetSweetness = left + (right - left) / 2;
        
        int chunks = 0;
        int currentSweetness = 0;

        for(int chunk : sweetness) {
          currentSweetness += chunk;

          if (currentSweetness > targetSweetness) {
            chunks ++;
            currentSweetness = 0;
          }
        }

        if(chunks > K) {
          left = targetSweetness + 1;
        } else {

          right = targetSweetness;
        }
      }
      

      return left;
    }
}