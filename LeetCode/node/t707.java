package node;

public class t707 {
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class MyLinkedList {
        int size;
        ListNode head;// 虚拟头节点
        public MyLinkedList() {
            size = 0;
            head = new ListNode(0);
        }

        public int get(int index) {
            ListNode cur = head;
            if(index >= size || index < 0){
                return -1;
            }
            for(int i = 0; i <= index; i++){
                cur = cur.next;
            }
            return cur.val;
        }

        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        public void addAtIndex(int index, int val) {
            ListNode pre = head;
            if(index > size){
                return;
            }
            if(index < 0){
                index = 0;
            }
            size++;
            for(int i = 0; i < index;i++){
                pre = pre.next;
            }
            ListNode toAdd = new ListNode(val);
            toAdd.next = pre.next;
            pre.next = toAdd;
        }

        public void deleteAtIndex(int index) {
            if(index < 0 || index>=size){
                return;
            }
            size--;
            if(index == 0){
                head = head.next;
                return;
            }
            ListNode pre = head;
            for(int i=0;i<index;i++){
                pre=pre.next;
            }
            pre.next = pre.next.next;
        }
    }

}
