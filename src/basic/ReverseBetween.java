package basic;

import basic.ReverseList.ListNode;
import static basic.ReverseList.reverseList;

public class ReverseBetween {
    public ListNode reverseBetween(ListNode head ,int left ,int right){
        ListNode dummy = new ListNode(-1,head);
        ListNode pre = dummy;
        for(int i = 0; i < left - 1; i++) pre = pre.next;
        ListNode rightNode = pre;
        for(int j = 0; j < right - left + 1; j++) rightNode = rightNode.next;

        ListNode leftNode = pre.next;
        ListNode successor = rightNode.next;
        rightNode.next = null;
        pre.next = null;

        pre.next = reverseList(leftNode);
        leftNode.next = successor;
        return dummy.next;
    }
}
