package basic;

import basic.ReverseList.ListNode;
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k){
        ListNode currentEnd = head;
        for(int i = 0; i < k; i++){
            if(currentEnd == null) return head;
            currentEnd = currentEnd.next;
        }

        ListNode pre = null;
        ListNode cur = head;
        while(cur != currentEnd){
            ListNode nextNode = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextNode;
        }
        head.next = reverseKGroup(cur,k);
        return pre;
    }
}
