package practice;


public class MyLinkedList<E> {
    final private Node<E> head;  // 虚拟头节点
    private Node<E> tail;  // 实际尾节点
    public int size;

    private static class Node<E>{
        E val;
        Node<E> next;

        public Node(E val){
            this.val = val;
            next = null;
        }
    }

    public MyLinkedList(){
        this.head = new Node<>(null);
        this.tail = head;
        this.size = 0;
    }

    public void addLast(E element){
        tail.next = new Node<>(element);
        tail = tail.next;
        size++;
    }

    public void add(E element, int index){
        checkPositionIndex(index);
        if(index == size){  // 处理index在最后的情况,顺便由于一开始尾指针指向头指针，处理了空链表情况
            addLast(element);
            return;
        }

        Node<E> cur = head;
        int i = 0;
        while(i < index){
            cur = cur.next;
            i++;
        }
        Node<E> newNode = new Node<>(element);
        newNode.next = cur.next;
        cur.next = newNode;
        size++;
    }

    private E removeFirst(){
        Node<E> firstNode = head.next;
        head.next = firstNode.next;
        firstNode.next = null;
        size--;
        if(size == 0){
            tail = head;
        }
        return firstNode.val;
    }

    public E remove(int index){
        checkElementIndex(index);  // 检查索引是否合法
        if(index == 0){
            return removeFirst();  // 删除首节点
        }
        Node<E> cur = head;
        for(int i = 0; i < index; i++){
            cur = cur.next;
        }
        Node<E> nodeToRemove = cur.next;
        cur.next = nodeToRemove.next;
        nodeToRemove.next = null;
        if(index == size - 1){  // 如果删除的是尾节点，需要调整一下实际尾节点指针
            tail = cur;
        }
        size--;
        return nodeToRemove.val;
    }

    public E getLast(){
        return tail.val;
    }
    public E get(int index){
        checkElementIndex(index);
        if(index == size - 1) return getLast();  // 处理尾节点的获取操作
        return getNode(index).val;
    }

    public E set(int index,E element){
        checkElementIndex(index);
        Node<E> nodeToSet = getNode(index);

        E oldVal = nodeToSet.val;
        nodeToSet.val = element;

        return oldVal;
    }

    public void checkPositionIndex(int index){
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index" + index + "Size" + size);
        }
    }
    public void checkElementIndex(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index" + index + "Size" + size);
        }
    }
    private Node<E> getNode(int index){
        Node<E> cur = head;
        for(int i = 0; i <= index; i++){
            cur = cur.next;
        }
        return cur;
    }
}
