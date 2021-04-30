class Solution {
//     // private int target;
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        return dfs(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }
    
    private int dfs(TreeNode root, int leftSum){
        //no answer found
        if(root == null) return 0;
        
        if(root.val == leftSum) return 1 + dfs(root.left, leftSum - root.val) + dfs(root.right, leftSum - root.val);
        
        return 0 + dfs(root.left, leftSum - root.val) + dfs(root.right, leftSum - root.val);
    }
}