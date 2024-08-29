package 链表;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class T138随机链表的复制 {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node p = head;
        while (p!=null){
            Node newnode = new Node(p.val);
            newnode.next = p.next;
            p.next = newnode;
            p = p.next.next;
        }
        p = head;
        while (p!=null){
            if(p.random!=null){
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }
        Node dummy = new Node(-1);
        Node cur = dummy;
        p = head;
        while (p!=null){
            cur.next = p.next;
            cur = cur.next;
            p.next = p.next.next;
            p = p.next;
        }
        return dummy.next;
    }
}
