package practice;

import java.util.ArrayList;

public class Learn {
    public void learn(){
        ArrayList<Integer> arr = new ArrayList<>();
//        增删查改操作

        for(int i = 0; i < 10; i++){
            arr.add(i);
        }
        arr.add(2,666);

        arr.remove(2);
        arr.remove(arr.size() - 1);

        int a = arr.get(1);

        arr.set(1,100);
    }
}
