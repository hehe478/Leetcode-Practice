package basic;

import basic.ReverseList.ListNode;

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2){
        ListNode dummyNode = new ListNode(-1);
        ListNode cur = dummyNode;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                cur.next = list1;
                list1 = list1.next;
            }else{
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if(list1 != null){
            cur.next = list1;
        }else{
            cur.next = list2;
        }

        return dummyNode.next;
    }
}
