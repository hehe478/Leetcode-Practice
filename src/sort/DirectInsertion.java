package sort;

public class DirectInsertion extends InsertionSort implements Sortable {
    public void sort(int[] array){
        if(array == null || array.length <= 1) return;
        int curValue;
        for(int curIndex = 1; curIndex < array.length; curIndex++){
            curValue = array[curIndex];
            int temp = curValue;
            while(curIndex > 0 && curValue < array[curIndex - 1]){
                array[curIndex] = array[curIndex - 1];
                curIndex--;
            }
            array[curIndex] = temp;
        }
    }
}
