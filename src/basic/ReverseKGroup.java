package basic;

import basic.ReverseList.ListNode;
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k){
        if(head == null || k == 1) return head;
        ListNode dummy = new ListNode(-1,head);
        ListNode preTail = dummy;
        ListNode currentHead = head;


        outer:
        while(currentHead != null){
            ListNode currentEnd = currentHead;
            for(int i = 0; i < k - 1; i++){
                currentEnd = currentEnd.next;
                if(currentEnd == null) break outer;
            }
            ListNode nextHead = currentEnd.next;

            ListNode pre = null;
            ListNode cur = currentHead;

            while(cur != nextHead){
                ListNode nextNode = cur.next;
                cur.next = pre;
                pre = cur;
                cur = nextNode;
            }
            preTail.next = pre;
            currentHead.next = nextHead;
            preTail = currentHead;
            currentHead = nextHead;
        }
        return dummy.next;
    }
}
