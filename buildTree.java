class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null ||inorder.length == 0 || preorder.length == 0)
            return null;
        TreeNode root = new TreeNode(preorder[0]);
        if(preorder.length == 1) return root;
        int cutPoint = -1;
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == preorder[0]){
                cutPoint = i;
                break;
            }
        }
        int[] leftPre = Arrays.copyOfRange(preorder, 1, cutPoint + 1);
        int[] leftIn = Arrays.copyOfRange(inorder, 0, cutPoint);
        int[] rightPre = Arrays.copyOfRange(preorder,  cutPoint + 1, preorder.length);
        int[] rightIn = Arrays.copyOfRange(inorder, cutPoint + 1, inorder.length);
        root.left = buildTree(leftPre, leftIn);
        root.right = buildTree(rightPre, rightIn);
        return root;
    }
}