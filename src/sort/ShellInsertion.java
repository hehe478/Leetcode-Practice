package sort;

public class ShellInsertion extends InsertionSort implements Sortable{
    public void sort(int[] array){
        if(array == null || array.length <= 1) return;
        for(int gap = array.length / 2; gap > 0; gap /= 2){
            for(int index = gap; index < array.length; index++){
                int value = array[index];
                int indexCopy = index;
                while(indexCopy >= gap && value < array[indexCopy - gap]){
                    array[indexCopy] = array[indexCopy - gap];
                    indexCopy -= gap;
                }
                array[indexCopy] = value;
            }
        }
    }
}
