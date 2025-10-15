package basic;

public class ReverseList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverseList(ListNode head){
        ListNode current = head;
        ListNode pre = null;
        while(current != null){
            ListNode nextNode = current.next;
            current.next = pre;
            pre = current;
            current = nextNode;
        }
        return pre;
    }
}
