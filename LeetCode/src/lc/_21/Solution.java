package lc._21;
import lc._21.ListNode;

public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        else if(list2 == null){
            return list1;
        }
        else if(list1.val < list2.val){
            list1.next =  mergeTwoLists(list2, list1.next);
            return list1;
        }
        else{
            list2.next =  mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    public static void main(String[] args){
        // 创建链表l1,ls
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        // 创建Solution实例
        Solution solution = new Solution();
        ListNode merged = solution.mergeTwoLists(l1,l2);

        while (merged!=null){
            System.out.print(merged.val+" ");
            merged = merged.next;
        }
    }
}
