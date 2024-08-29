package 链表;


//class ListNode {
//    int val;
//    ListNode next;
//    ListNode() {}
//    ListNode(int val) { this.val = val; }
//     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}
public class T21合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode pre = new ListNode(-1);
        ListNode cur = pre;
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        while(cur1!=null&&cur2!=null){
            if(cur1.val<cur2.val){
                cur.next = cur1;
                cur1 = cur1.next;
            }else {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        if (cur1==null){
            cur.next = cur2;
        }
        if(cur2==null){
            cur.next = cur1;
        }
        return pre.next;

    }
}
