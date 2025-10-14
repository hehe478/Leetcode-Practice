package practice;

import java.util.NoSuchElementException;

public class DoublyLinkedList<E> {
    final private Node<E> head, tail;
    private int size;

    private static class Node<E>{
        E val;
        Node<E> pre , next;
        Node(E val){
            this.val = val;
        }
    }

    public DoublyLinkedList(){
        this.head = new Node<>(null);
        this.tail = new Node<>(null);
        head.next = tail;
        tail.pre = head;
        this.size = 0;
    }

    public void addLast(E e){
        Node<E> cur = tail.pre;
        Node<E> newNode = new Node<>(e);

        newNode.pre = cur;
        newNode.next = tail;
        cur.next = newNode;
        tail.pre = newNode;

        size++;
    }
    public void add(E e , int index){
        checkPositionIndex(index);
        if(index == size){
            addLast(e);
            return;
        }
        Node<E> newNode = new Node<>(e);

        Node<E> cur = getNode(index);
        Node<E> preNode = cur.pre;

        newNode.pre = preNode;
        newNode.next = cur;
        preNode.next = newNode;
        cur.pre = newNode;

        size++;
    }

    public E removeLast(){
        checkIsEmpty();
        Node<E> toRemove = tail.pre;
        Node<E> preNode = toRemove.pre;

        preNode.next = tail;
        tail.pre = preNode;
        toRemove.pre = null;
        toRemove.next = null;

        size--;

        return toRemove.val;
    }

    public E remove(int index){
        checkElementIndex(index);
        if(index == size - 1)  return removeLast();

        Node<E> toRemove = getNode(index);
        Node<E> preNode = toRemove.pre;
        Node<E> nextNode = toRemove.next;

        preNode.next = nextNode;
        nextNode.pre = preNode;
        toRemove.pre = null;
        toRemove.next = null;

        size--;

        return toRemove.val;
    }

    public E getLast(){
        checkIsEmpty();
        return tail.pre.val;
    }

    public E get(int index){
        checkElementIndex(index);
        if(index == size - 1) return getLast();

        return getNode(index).val;
    }

    public void setLast(E e){
        checkIsEmpty();
        tail.pre.val = e;
    }

    public void set(E e, int index){
        checkElementIndex(index);
        if(index == size - 1) setLast(e);

        getNode(index).val = e;
    }

    private void checkPositionIndex(int index){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("index" + index + "size" + size);
        }
    }
    private void checkElementIndex(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("index" + index + "size" + size);
        }
    }
    private void checkIsEmpty(){
        if(size == 0){
            throw new NoSuchElementException("Operation cannot be performed on an empty list.");
        }
    }
    private Node<E> getNode(int index){
        Node<E> cur;
        if(index < (size / 2)){
            cur = head.next;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
        }else{
            cur = tail.pre;
            for(int i = size - 1; i > index; i--){
                cur = cur.pre;
            }
        }
        return cur;
    }
    public int size(){
        return size;
    }
}
