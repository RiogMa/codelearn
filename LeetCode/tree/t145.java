package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class t145 {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode bulidTree(Integer[] arr){
        if(arr.length == 0 || arr[0] == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(arr[0]);
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty() && i<arr.length){
            TreeNode current = queue.poll();
            if(arr[i] != null){
                current.left = new TreeNode(arr[i]);
                queue.offer(current.left);
            }
            i++;
            if(i<arr.length && arr[i] != null){
                current.right = new TreeNode(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] split = s.split(" ");
        Integer[] arr = new Integer[split.length];
        for(int i = 0;i < arr.length; i++){
            if(split[i].equals("null")){
                arr[i] = null;
            }else {
                arr[i] = Integer.parseInt(split[i]);
            }
        }
        TreeNode root = bulidTree(arr);
        List<Integer> res = new LinkedList<>();
        res = postorderTraversal(root);
        System.out.print(res);
    }

    public static List<Integer> postorderTraversal(TreeNode root){
        List<Integer> res = new LinkedList<>();
        postorder(root, res);
        return res;
    }
    static void postorder(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }
}
