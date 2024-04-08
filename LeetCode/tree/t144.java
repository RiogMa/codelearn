package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class t144 {
    public static class TreeNode{
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
    public static TreeNode buildTree(Integer[] arr){
        if(arr.length==0||arr[0]==null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(arr[0]);
        queue.offer(root);
        int i =1;
        while (!queue.isEmpty()&&i<arr.length){
            TreeNode current = queue.poll();
            if(arr[i]!=null){
                current.left = new TreeNode(arr[i]);
                queue.offer(current.left);
            }
            i++;
            if(i<arr.length && arr[i]!=null){
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
        for(int i = 0;i<arr.length;i++){
            if(split[i].equals("null")){
                arr[i] = null;
            }else {
                arr[i] = Integer.parseInt(split[i]);
            }
        }
        TreeNode root = buildTree(arr);
        List<Integer> res = new LinkedList<>();
        res = preorderTraversal(root);
        System.out.print(res);
    }
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        preorder(root, res);
        return res;
    }
    static void  preorder(TreeNode root, List<Integer> res){
        if(root == null) return;
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }

}
