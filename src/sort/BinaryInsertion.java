package sort;

public class BinaryInsertion extends InsertionSort implements sortable{
    public void sort(int[] array){
        if(array.length == 1 || array.length == 0) return;
        for(int curIndex = 1; curIndex < array.length; curIndex++){
            int curValue = array[curIndex];
            int index = binarySearch(array,0, curIndex - 1, curValue);
            insert(array,index,curIndex);
        }
    }
    public int binarySearch(int[] array,int startIndex, int endIndex, int value){
        if(endIndex - startIndex == 1){
            if(value < array[startIndex]) return startIndex;
            else if (value > array[endIndex]) return endIndex + 1;
            return endIndex;
        }
        if(endIndex - startIndex == 0){
            if(value >= array[startIndex]) return startIndex + 1;
            else return startIndex;
        }
        int midIndex = startIndex + (endIndex - startIndex)/2;
        if(value == array[midIndex]) return midIndex + 1;
        else if(value > array[midIndex]) return binarySearch(array,midIndex,endIndex,value);
        else return binarySearch(array,startIndex,midIndex,value);
    }
}
