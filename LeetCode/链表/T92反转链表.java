package 链表;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class T92反转链表 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode start = dummy.next;
        for(int i=0;i<left;i++){
            pre=pre.next;
            start=start.next;
        }
        for(int i=0;i<right-left;i++){
            ListNode tmp = start.next;
            start.next = start.next.next;
            tmp.next = pre.next;
            pre.next = tmp;
        }
        return dummy.next;
    }
}
