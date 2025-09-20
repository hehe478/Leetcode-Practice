package practice;

public class MyArrayList<E> {
    private E[] array;
    private int size;
    public static final int INIT_CAP = 1;

    public MyArrayList(int initialCapital){
        if(initialCapital < 0){
            initialCapital = INIT_CAP;
        }
        this.size = 0;
        this.array = (E[])new Object[initialCapital];
    }

    public MyArrayList(){
        this(INIT_CAP);
    }

    public void insert(int index, E e){
        int insertIndex = checkPositionIndex(index);

        if(size == array.length){
            resize(2 * array.length);
        }

        for(int i = size - 1; i > insertIndex; i--){
            array[i + 1] = array[i];
        }
        array[insertIndex] = e;
        size++;
    }

    public void add(E e){
        insert(size,e);
    }

    public void remove(int index){
        int removeIndex = checkElementIndex(index);

        if(size == array.length / 4 && array.length >= INIT_CAP){
            resize(array.length / 2);
        }

        for(int i = removeIndex; i < size - 1; i++){
            array[i] = array[i + 1];
        }
        array[size - 1] = null;
        size--;
    }

    public E get(int index){
        int getIndex = checkElementIndex(index);
        return array[getIndex];
    }

    public void set(int index, E e){
        int setIndex = checkElementIndex(index);
        array[setIndex] = e;
    }

    private int checkPositionIndex(int index){
        if(index <= size && index >= 0) return index;
        else {
            throw new IndexOutOfBoundsException("索引越界:" + index + "有效范围0~" + (size - 1));
        }
    }

    private int checkElementIndex(int index){
        if(index < size && index >= 0) return index;
        else {
            throw new IndexOutOfBoundsException("索引越界" + index + "有效范围 0~" + size);
        }
    }

    private void resize(int cap){
        E[] temp = (E[]) new Object[cap];
        if (size >= 0) System.arraycopy(array, 0, temp, 0, size);
        array = temp;
    }

    public int size(){
        return size;
    }
}
