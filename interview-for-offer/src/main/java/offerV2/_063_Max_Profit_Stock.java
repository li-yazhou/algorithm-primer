package offerV2;

/**
 * @No          v2-063,-
 * @problem     股票的最大利润
 * @tag         动态规划、贪心
 * @author      liyazhou
 * @date
 *
 * <pre>
 * 可以有一次买入和一次卖出，买入必须在前。求最大收益。
 * </pre>
 */
public class _063_Max_Profit_Stock {


    /**
     * Note
     *
     * Thought
     *
     * Algorithm
     *      1.
     *      2.
     *      3.
     */
    private static class Solution {


        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }

            int minPrice = prices[0];
            int maxProfit = 0;

            for (int price : prices) {
                minPrice = Math.min(minPrice, price);
                maxProfit = Math.max(maxProfit, price-minPrice);
            }

            return maxProfit;
        }
    }
}
