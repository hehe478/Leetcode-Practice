package basic;

import basic.ReverseList.ListNode;
import static basic.ReverseList.reverseList;

public class ReverseBetween {
    public ListNode reverseBetween(ListNode head ,int left ,int right){
        ListNode dummy = new ListNode(-1,head);
        ListNode pre = dummy;
        for(int i = 0; i < left - 1; i++) pre = pre.next;
        ListNode cur = pre.next;

        for(int j = 0; j < right - left; j++){
            ListNode nextNode = cur.next;

            cur.next = nextNode.next;
            nextNode.next = pre.next;
            pre.next = nextNode;
        }
        return dummy.next;
    }
}
