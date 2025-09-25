package sort;

public class BinaryInsertion extends InsertionSort implements Sortable {
    public void sort(int[] array){
        if(array == null || array.length <= 1) return;
        for(int curIndex = 1; curIndex < array.length; curIndex++){
            int curValue = array[curIndex];
            int index = binarySearch(array,0, curIndex - 1, curValue);
            insert(array,index,curIndex);
        }
    }
    public int binarySearch(int[] array,int startIndex, int endIndex, int value){
        while(startIndex <= endIndex){
            int midIndex = startIndex + (endIndex - startIndex) / 2;
            if(array[midIndex] < value) startIndex = midIndex + 1;
            else endIndex = midIndex - 1;
        }
        return startIndex;
    }
}
