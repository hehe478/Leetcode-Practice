package basic;

import basic.ReverseList.ListNode;
public class MiddleNode {
    public ListNode middleMode(ListNode head){
        ListNode oneStepPointer = head;
        ListNode twoStepsPointer = head;
        while(twoStepsPointer != null && twoStepsPointer.next != null){
            oneStepPointer = oneStepPointer.next;
            twoStepsPointer = twoStepsPointer.next.next;
        }
        return oneStepPointer;
    }
}
