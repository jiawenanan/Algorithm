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

//method II

class Solution {
    private int target;
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        Map<Integer, Integer> record = new HashMap<>();
        target = targetSum;
        record.put(0, 1);
        return dfs(root, 0, record);
    }
    
    private int dfs(TreeNode root, int preSum, Map<Integer, Integer> record){
        if(root == null) return 0;
        
        preSum += root.val;
        //preSum - target: mapping to the pre node --> ensure that the order is from parent nodes to child nodes
        int currAns = record.getOrDefault(preSum - target, 0);
        record.put(preSum, record.getOrDefault(preSum, 0) + 1);
        currAns += dfs(root.left, preSum, record) + dfs(root.right, preSum, record);
        record.put(preSum, record.get(preSum) - 1);
        return currAns;
    }
}
