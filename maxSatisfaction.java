class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int sum = 0;
        int len = satisfaction.length;
        int until = 0;
        for(int i = len - 1; i >= 0 && satisfaction[i] + until > 0; i--){
            sum += until;
            sum += satisfaction[i];
            until += satisfaction[i];
        }
        return sum;
    }
}