class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE; // Initialize min price
        int maxProfit = 0; // Initialize max profit

        for (int price : prices) {
    
            if (price < minPrice) {
                minPrice = price;
            }
            // Calculate profit if we sell at the current price
            int profit = price - minPrice;
            // Update max profit
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }

        return maxProfit;
    }
}
