package sort;

public class DirectInsertion extends InsertionSort implements Sortable {
    public void sort(int[] array){
        if(array == null || array.length <= 1) return;
        int curValue;
        for(int curIndex = 1; curIndex < array.length; curIndex++){
            curValue = array[curIndex];
            int searchIndex = 0;
            while(curValue > array[searchIndex] && searchIndex < curIndex) searchIndex++;
            insert(array,searchIndex,curIndex);
        }
    }
}
