package tree;

import java.util.*;

public class t515 {
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
        Queue<Node> tmpQueue = new LinkedList<>();
        if(root!=null){
            tmpQueue.add(root);
        }
        while(!tmpQueue.isEmpty()){
            int n=tmpQueue.size();
            Node cur = tmpQueue.poll();
            if(cur.left!=null) tmpQueue.add(cur.left);
            if(cur.right!=null) tmpQueue.add(cur.right);
            for(int i=1;i<n;i++){
                Node next = tmpQueue.poll();
                if(next.left!=null) tmpQueue.add(next.left);
                if(next.right!=null) tmpQueue.add(next.right);
                cur.next = next;
                cur = next;
            }
        }
        return root;
    }
}

