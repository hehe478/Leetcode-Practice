package basic;

public class MaxProfit {
    public int maxProfit(int[] price){
        int n = price.length;
        int max = 0;
        for(int i = 0; i < n - 1; i++){
            for(int j = i + 1; j < n; j++){
                if(price[j] - price[i] > max) max = price[j] - price[i];
            }
        }
        return max;
    }
}
