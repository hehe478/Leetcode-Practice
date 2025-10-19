package basic;

import basic.ReverseList.ListNode;
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        ListNode curA = headA;
        ListNode curB = headB;

        while(curB != curA){
            curA = (curA != null) ? curA.next : headB;
            curB = (curB != null) ? curB.next : headA;
        }
        return curA;
    }
}
