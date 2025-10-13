package practice;

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
        if(index == size)   { addLast(e); }
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
        Node<E> toRemove = tail.pre;
        Node<E> preNode = toRemove.pre;

        preNode.next = tail;
        tail.next = preNode;
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
        return tail.pre.val;
    }

    public E get(int index){
        checkElementIndex(index);
        if(index == size - 1) return getLast();

        return getNode(index).val;
    }

    public void setLast(E e){
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
    private Node<E> getNode(int index){
        Node<E> cur = head;
        for(int i = 0; i < index; i++){
            cur = cur.next;
        }
        return cur;
    }
}
