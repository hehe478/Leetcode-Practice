package basic;

import basic.ReverseList.ListNode;

import static basic.ReverseList.reverseList;

public class IsPalindrome {
    public boolean isPalindrome(ListNode head){
        if(head.next == null) return true;
        ListNode fast = head;
        ListNode slow = head;

        ListNode pre = null;
        ListNode nextNode = slow.next;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow.next = pre;
            pre = slow;
            slow = nextNode;
            nextNode = nextNode.next;
        }
        if(fast != null) slow = slow.next;
        while(pre != null){
            if(pre.val != slow.val) return false;
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }
}
