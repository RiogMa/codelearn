package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class t199 {
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if(root!=null) queue.add(root);
        while (!queue.isEmpty()){
            int n=queue.size();
//            List<Integer> level = new ArrayList<>();
            for(int i=0;i<n;i++){
                TreeNode node = queue.poll();
//                level.add(node.val);
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
                if(i==n-1){
                    res.add(node.val);
                }
            }


        }
        return  res;
    }
}
