package sort;

public class QuickSort implements sortable{
    public void sort(int[] intArray){
        int size = intArray.length;
        int[] arraySorted = quickSort(intArray,0,size - 1);
    }
    public int[] quickSort(int[] list, int left, int right){
        if(left >= right) return list;
        int index = partition(list, left, right);
        quickSort(list, left, index - 1);
        quickSort(list, index + 1, right);
        return list;
    }
    public int partition(int[] array ,int left,int right){
        int pivot = array[right];
        int lessBound = left - 1;
        for(int index = left; index < right; index++){
            if(array[index] <= pivot) {
                lessBound++;
                swap(array, index, lessBound);
            }
        }
        swap(array,++lessBound,right);
        return lessBound;
    }
    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
