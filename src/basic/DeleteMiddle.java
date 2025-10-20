package basic;

import basic.ReverseList.ListNode;
public class DeleteMiddle {
    public ListNode deleteMiddle(ListNode head){
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode oneStepPointer = head;
        ListNode twoStepsPointer = head;

        while(twoStepsPointer != null && twoStepsPointer.next != null){
            twoStepsPointer = twoStepsPointer.next.next;
            oneStepPointer = oneStepPointer.next;
            pre = pre.next;
        }

        pre.next = oneStepPointer.next;
        oneStepPointer.next = null;
        return dummy.next;
    }
}
