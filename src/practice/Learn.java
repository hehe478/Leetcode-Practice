package practice;

import java.util.ArrayList;

public class Learn {
    public void learnArray(){
        ArrayList<Integer> arr = new ArrayList<>();
//        增删查改操作

        for(int i = 0; i < 10; i++){
            arr.add(i);
        }
        arr.add(2,666);

        arr.remove(2);
        arr.remove(arr.size() - 1);

        int a = arr.get(1);

        arr.set(1,100);
    }

//    转化数组为链表
    public <E> LearnListNode<E> createLinkedList(E[] arr){
        if(arr == null || arr.length == 0) return null;
        LearnListNode<E> head = new LearnListNode<>(arr[0]);
        LearnListNode<E> cur = head;
        for(int i = 1; i < arr.length; i++){
            cur.next = new LearnListNode<>(arr[i]);
            cur = cur.next;
        }
        cur.next = null;
        return head;
    }
    public static void main(String[] args){
        Learn learn = new Learn();
        Integer[] arr = {1,2,3};
        LearnListNode<Integer>head = learn.createLinkedList(arr);
        LearnListNode<Integer> cur = head;
        if (head != null) {
            for(;cur != null ;cur = cur.next){
                System.out.println(cur.val);
            }
        }
    }
}
