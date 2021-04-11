class Solution {
    private static int mo = 1000000007;
    public int numOfWays(int[] nums) {
        if(nums.length <= 2) return 1;
        List<Integer> root = new ArrayList<>();
        for(int i = 0; i < nums.length; i++)
            root.add(nums[i]);            
        return (helper(root)-1 + mo)%mo;
    }
    
    public static int f(int m,int n){
        if(n==0)

            return 1;

        if(m==1)

            return 1;

        else if(m==n)

            return 1;

        return f(m-1,n-1) + f(m-1,n);

    }
    
    private int helper(List<Integer> input){
        if(input.size() <= 2){
            return 1;
        }
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        int root = input.get(0);
        for(int curr: input){
            if(curr < root)
                left.add(curr);
            if(curr > root)
                right.add(curr);
        }
        return f(left.size() + right.size(), left.size()) * helper(left) * helper(right);          
    }
}