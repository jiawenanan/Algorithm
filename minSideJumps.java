class Solution {
    public int minSideJumps(int[] obstacles) {
        int length = obstacles.length;
        int[] dp = new int[]{0, 1, 0, 1};
        if(length == 1) return 0;
        for(int lane : obstacles){
            dp[lane] = 10000000;
            for(int i = 1; i <= 3; i++){
                if(i != lane){
                    for(int j = 1; j <=3; j++){
                        dp[i] = Math.min(dp[i], dp[j] + (j == i ? 0 : 1));
                    }
                }
            }
        }
        return Math.min(dp[1], Math.min(dp[2], dp[3]));
    }
}