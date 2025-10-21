package basic;


import basic.ReverseList.ListNode;
public class DetectCycle {
    public ListNode detectCycle(ListNode head){
        ListNode oneStepPointer = head;
        ListNode twoStepsPointer = head;

        while(twoStepsPointer != null && twoStepsPointer.next != null){
            oneStepPointer = oneStepPointer.next;
            twoStepsPointer = twoStepsPointer.next.next;
            if(twoStepsPointer == oneStepPointer) break;
        }

        if(twoStepsPointer == null || twoStepsPointer.next == null) return null;
        twoStepsPointer = head;
        while(oneStepPointer != twoStepsPointer){
            oneStepPointer = oneStepPointer.next;
            twoStepsPointer = twoStepsPointer.next;
        }
        return oneStepPointer;
    }
}
