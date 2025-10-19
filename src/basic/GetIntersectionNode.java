package basic;

import basic.ReverseList.ListNode;
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        ListNode curA = headA;
        ListNode curB = headB;

        for(int i = 0; i < 2; i++) {
            while (curA != null && curB != null) {
                curA = curA.next;
                curB = curB.next;
            }
            if (curA == null) {
                curA = headB;
            } else {
                curB = headA;
            }
        }
        while(curA != null && curB != null){
            if(curA == curB) return curA;
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}
