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

    public boolean isIntegerArray(){
        for(int i = 0; i < size; i++){
            E element = this.array[i];
            if(element != null && !(element instanceof Integer)) return false;
        }
        return true;
    }
    public int[] toIntArray(){
        if(!isIntegerArray()) throw new IllegalStateException("数组不是Integer类型，无法使用");
        int[] intArray = new int[size];
        for(int i = 0; i < size; i++){
            intArray[i] = (Integer) array[i];
        }
        return intArray;
    }
    public void sort(){
        int[] intArray = toIntArray();
        quickSort(intArray,0,size - 1);
    }
    public void quickSort(int[] list, int left, int right){
        if(left >= right) return;
        int index = partition(list, left, right);
        quickSort(list, left, index - 1);
        quickSort(list, index + 1, right);
    }
    public int partition(int[] array ,int left,int right){
        int pivotIndex = left;
        left++;
        int pivot = array[pivotIndex];
        while(left < right){
            while(left < right && array[left] > pivot) left++;
            while(left < right && array[right] < pivot) right--;
            swap(array,left,right);
        }
        swap(array, pivotIndex, right);
        return right;
    }
    public void swap(int[] array, int left, int right){
        array[left] = array[left] ^ array[right];
        array[right] = array[left] ^ array[right];
        array[left] = array[left] ^ array[right];
    }
}
