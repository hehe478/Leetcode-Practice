package basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MakeSubKSumEqual {
    public long makeSubKSumEqual(int[] arr, int k){
        long totalOperation = 0;
        int n = arr.length;
        int count  = gcd(n,k);
        for(int start = 0; start < count; start++){
            List<Integer> temp = new ArrayList<>();
            for(int j = start; j < n; j += count){
                temp.add(arr[j]);
            }
            Collections.sort(temp);

            int median = temp.get(temp.size() / 2);

            for(int element : temp){
                totalOperation += Math.abs((long)element - median);
            }
        }
        return totalOperation;
    }
    public int gcd(int a, int b){
        int temp;
        while(b != 0){
            temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
