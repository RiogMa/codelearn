package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class t637 {
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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if(root!=null) queue.add(root);
        while (!queue.isEmpty()){
            int n = queue.size();
            double sum=0.0;
            for(int i=0;i<n;i++){
                TreeNode node = queue.poll();
                sum+=node.val;
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            res.add((double) (sum/n));
        }
        return res;
    }
}
