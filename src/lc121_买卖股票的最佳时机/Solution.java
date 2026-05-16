package lc121_买卖股票的最佳时机;

public class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int total = 0;
        for (int price : prices) {
            min = Math.min(min, price);
            total = Math.max(total, price - min);
        }
        return total;
    }
}
