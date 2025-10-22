package basic;

import basic.ReverseList.ListNode;

import static basic.ReverseList.reverseList;

public class IsPalindrome {
    public boolean isPalindrome(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast != null) slow = slow.next;
        fast = head;
        ListNode newHead = reverseList(slow);
        while(newHead != null){
            if(newHead.val != fast.val) return false;
            newHead = newHead.next;
            fast = fast.next;
        }
        return true;
    }
}
