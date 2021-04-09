List<Integer> res = new ArrayList<>();
    boolean flag = true;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        int count = 0;
        List<Integer> neg = new ArrayList<>();
        neg.add(-1);
        helper(count, voyage, root);
        return flag == true ? res : neg;
    }
    
    void helper(int count, int[] voyage, TreeNode root){
        if(flag == false) return;
        if(root == null){
            flag = false;
            return;
        }
        if(root.val != voyage[count]){
            flag = false;
            return;
        }
        if(root.left == null && root.right == null) return;
        if((root.left != null && root.left.val != voyage[count + 1]) || root.left == null){
            res.add(root.val);
            helper(count + 1, voyage, root.right);
        }else{
            helper(count + 1, voyage, root.left);
        }
    }