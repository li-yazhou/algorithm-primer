package leetcode;

import java.util.Arrays;

/**
 * @No          309
 * @problem     Best Time to Buy and Sell Stock with Cooldown
 * @level       Medium
 * @desc        最佳买卖股票时机含冷冻期
 * @author      liyazhou1
 * @date        2019/10/06
 *
 * <pre>
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
 *
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 *
 * Example:
 * Input: [1,2,3,0,2]
 * Output: 3
 *
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 * </pre>
 */
public class _0309_BestTimeToBuyAndSellStockWithCooldown {


    /**
     * Note
     *
     * Thought
     *
     * Challenge
     *
     * Algorithm
     *      1.
     *      2.
     *      3.
     *
     * Complexity
     *      Time,
     *      Space,
     */
    private static class Solution {

        public int maxProfit(int[] prices) {

            if (prices == null || prices.length < 1) {
                return 0;
            }

            int len = prices.length;

            int[] buy = new int[len];
            int[] sell = new int[len];
            int[] rest = new int[len];

            sell[0] = 0;
            sell[1] = 0;
            rest[0] = 0;
            buy[0] = -prices[0];

            for (int i = 1; i < len; i ++) {
                buy[i] = rest[i-1]-prices[i];
                sell[i] = Math.max(rest[i-1]+prices[i], buy[i-1]+prices[i]);
                rest[i] = Math.max(Math.max(buy[i-1], rest[i-1]), sell[i-1]);
            }

            return Math.max(sell[len-1], rest[len-1]);
        }


        public static void main(String[] args) {
            int[][] inputs = {
                    {1, 2, 3, 0, 2}
            };
            for (int[] input: inputs) {
                System.out.println("input = " + Arrays.toString(input));
                int profit = new Solution().maxProfit(input);
                System.out.println("profit = " + profit);
            }
        }


    }
}
