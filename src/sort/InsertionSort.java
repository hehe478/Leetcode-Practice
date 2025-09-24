package sort;

public class InsertionSort {
    public void insert(int[] array, int lateIndex, int preIndex){
        int temp = array[preIndex];
        for(int i = preIndex; i > lateIndex; i--){
            array[i] = array[i - 1];
        }
        array[lateIndex] = temp;
    }
}
