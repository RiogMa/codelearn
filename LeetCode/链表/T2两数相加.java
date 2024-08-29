package 链表;

//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode(int x) {
//        val = x;
//        next = null;
//    }
//}
public class T2两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int cnt = 0;
        while (l1!=null || l2!=null){
            int x = l1 == null? 0: l1.val;;
            int y = l2 == null? 0: l2.val;
            int sum = x+y+cnt;
            cnt  =sum/10;
            sum%=10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;
        }
        if(cnt==1){
            cur.next = new ListNode(cnt);
        }
        return pre.next;
    }
}
