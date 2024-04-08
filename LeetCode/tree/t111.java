package tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class t111 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val, TreeNode left,TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public int minDepth(TreeNode root) {
        int res = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        if(root!=null){
            queue.add(root);
        }
        while(!queue.isEmpty()){
            int n=queue.size();res++;
            for(int i=0;i<n;i++){
                TreeNode node = queue.poll();

                if(node.left==null&&node.right==null){
                    return res;
                }
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }

        }
        return res;
    }
}
