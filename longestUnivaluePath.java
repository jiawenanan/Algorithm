class Solution {
    private int max;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null) return 0;
        max = 0;
        dfs(root.val, root);
        return max;
    }
    
    private int dfs(int rootVal, TreeNode root){
        if(root == null) return 0;
        int left = dfs(root.val, root.left);
        int right = dfs(root.val, root.right);
        max = Math.max(max, left + right);
        if(root.val == rootVal){
            return Math.max(left, right) + 1;
        }
        return 0;        
    }
}