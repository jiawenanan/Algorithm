class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        List<Integer> ans = new ArrayList<>();
        ans.add(root.val);
        dfs(root, targetSum, ans, root.val, res);
        return res;
    }
    
    private void dfs(TreeNode root, int targetSum, List<Integer> ans, int currSum, List<List<Integer>> res){
        if(root.left == null && root.right == null){
            if(currSum == targetSum){
                res.add(new ArrayList(ans));
            }
            ans.remove(ans.size() - 1);
            return;
        }
        if(root.left != null){
            int leftVal = root.left.val;
            ans.add(leftVal);
            dfs(root.left, targetSum, ans, currSum + leftVal, res);
        }
        if(root.right != null){
            int rightVal = root.right.val;
            ans.add(rightVal);
            dfs(root.right, targetSum, ans, currSum + rightVal, res);
        }
        ans.remove(ans.size() - 1);
        return;
    }
}
