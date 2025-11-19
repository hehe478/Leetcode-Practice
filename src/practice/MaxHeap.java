package practice;

import java.util.ArrayList;
import java.util.Collections;

public class MaxHeap<E extends Comparable<E>> {
    private final ArrayList<E> data;

    public MaxHeap(){
        this.data = new ArrayList<>();
    }

    public int size(){
        return data.size();
    }
    public boolean isEmpty(){
        return data.isEmpty();
    }

    private int parent(int index){
        if(index == 0) throw new IllegalArgumentException("Root has no parent");
        return (index - 1)/2;
    }
    private int leftChild(int index){ return index * 2 + 1;}
    private int rightChild(int index){ return index * 2 + 2;}

    private void swap(int i,int j){ Collections.swap(data,i,j);}

    public void add(E element){
        data.add(element);
        siftUp(data.size() - 1);
    }

    private void siftUp(int k){
        while(k > 0 && data.get(k).compareTo(data.get(parent(k))) > 0){
            swap(k,parent(k));
            k = parent(k);
        }
    }

    public E extractMax(){
         E ret = findMax();
         swap(0,data.size()-1);
         data.remove(data.size() - 1);
         siftDown(0);
         return ret;
    }

    private E findMax(){
        if(data.isEmpty()) throw new IllegalArgumentException("Heap is empty");
        return data.get(0);
    }
    private void siftDown(int k){
        while(leftChild(k) < data.size()){
            int left = leftChild(k);
            int right = left + 1;
            int largerChildIndex = left;

            if(right < data.size() && data.get(right).compareTo(data.get(left)) > 0){
                largerChildIndex = right;
            }
            if(data.get(k).compareTo(data.get(largerChildIndex)) >= 0) break;

            swap(k,largerChildIndex);
            k = largerChildIndex;
        }
    }
}
