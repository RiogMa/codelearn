package tree;

public class t101 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public boolean isSymmetric(TreeNode root) {
        return compare(root.left, root.right);
    }
    public boolean compare(TreeNode left, TreeNode right){
        if(left==null && right!=null) return false;
        if(left!=null && right==null) return false;
        if(left==null && right==null) return true;
        if(left.val!=right.val) return false;
        boolean compareOuter = compare(left.left, right.right);
        boolean compareInner = compare(left.right, right.left);
        return compareInner&compareOuter;
    }
}
