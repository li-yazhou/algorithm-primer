package leetcode;


/**
 * @No          121
 * @problem     Best Time to Buy and Sell Stock
 * @level       Easy
 * @desc        买卖股票的最佳时机
 * @author      liyazhou
 * @date        2017/08
 *
 * <pre>
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 *
 * Note that you cannot sell a stock before you buy one.
 *
 * Example 1:
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *              Not 7-1 = 6, as selling price needs to be larger than buying price.
 *
 * Example 2:
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 * </pre>
 */
public class _0121_BestTimeToBuyAndSellSock {


    /**
     * Note
     *
     * Thought
     *      方法一，暴力求解
     *      方法二，动态规划
     *
     * Challenge
     *
     * Algorithm
     *      1.
     *      2.
     *
     * Complexity
     *      Time,
     *      Space,
     */
    private static class Solution {

        /**
         * 方法二，动态规划
         */
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


        /**
         * 方法一，暴力求解
         */
        public int maxProfit1(int[] prices) {
            int maxProfit = 0;
            for (int i = 0; i < prices.length; i ++) {
                for (int j = i + 1; j < prices.length; j ++) {
                    int profit = prices[j] - prices[i];
                    if (profit > maxProfit) {
                        maxProfit = profit;
                    }
                }
            }
            return maxProfit;
        }
    }

}