package tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class t117 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    public Node connect(Node root) {
        Queue<Node> queue = new ArrayDeque<>();
        if(root!=null){
            queue.add(root);
        }
        while(!queue.isEmpty()){
            int n=queue.size();
            Node node=null;
            Node prenode=null;
            for(int i=0;i<n;i++){
                if(i==0){
                    prenode=queue.poll();
                    node=prenode;
                }else {
                    node = queue.poll();
                    prenode.next = node;
                    prenode = prenode.next;
                }
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            prenode.next = null;
        }
        return root;
    }
}
