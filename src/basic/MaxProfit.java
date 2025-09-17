package basic;

public class MaxProfit {
    public int maxProfit(int[] price){
        int n = price.length;
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            minPrice = Math.min(minPrice, price[i]);
            maxProfit = Math.max(maxProfit, price[i] - minPrice);
        }
        return maxProfit;
    }
}
