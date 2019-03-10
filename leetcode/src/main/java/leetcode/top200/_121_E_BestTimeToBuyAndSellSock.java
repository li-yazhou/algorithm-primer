package leetcode.top200;

class _121_E_BestTimeToBuyAndSellSock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int profit = 0;
        int low = prices[0];
        for (int i = 0; i < prices.length; i ++){
            low = Math.min(low, prices[i]);
            profit = Math.max(profit, prices[i]-low);
        }
        return profit;
    }
}