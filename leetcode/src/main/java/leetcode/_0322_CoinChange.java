package leetcode;

import java.util.Arrays;

/**
 * @No          322
 * @problem     Coin Change
 * @level       Medium
 * @desc        零钱兑换
 * @author      liyazhou1
 * @date        2019/10/06
 *
 * <pre>
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * Example 1:
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 *
 * Example 2:
 * Input: coins = [2], amount = 3
 * Output: -1
 *
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 * </pre>
 */
public class _0322_CoinChange {


    /**
     * Note
     *
     * Thought
     *      DP
     *
     * Challenge
     *
     * Algorithm
     *      1. DP数组的初始值是 amount+1
     *      2. 动态转移条件是余额大于硬币面值大小
     *      3. 动态转移方程是
     *              dp[i] = min(dp[i], dp[i-coin]+1)
     *      4. return dp[amount] > amount ? -1 : dp[amount]
     *
     * Complexity
     *      Time,
     *      Space,
     */
    private static class Solution {

        public int coinChange(int[] coins, int amount) {

            int[] dp = new int[amount+1];
            int max = amount + 1;
            Arrays.fill(dp, max);
            dp[0] = 0;

            for (int i = 1; i <= amount; i ++) {
                for (int coin: coins) {
                    if (coin > i) {
                        continue;
                    }

                    dp[i] = Math.min(dp[i], dp[i-coin] + 1);
                }
            }

            return dp[amount] > amount ? -1 : dp[amount];
        }


        public static void main(String[] args) {
            int[][] inputs = {
                    {1, 2, 5},
                    {2},
                    {1, 2, 5}
            };
            int[] amounts = {
                    11,
                    3,
                    120
            };

            for (int i = 0; i < inputs.length; i ++) {
                int[] coins = inputs[i];
                int amount = amounts[i];
                System.out.println("coins = " + Arrays.toString(coins));
                System.out.println("amount = " + amount);
                int numCoins = new Solution().coinChange(coins, amount);
                System.out.println("numCoins = " + numCoins);
                System.out.println("-----------------");
            }
        }
    }


    /**
     * Note
     *
     * Thought
     *      DFS，有条件的计算二叉树的深度
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
    private static class Solution1 {

        public int coinChange(int[] coins, int amount) {

            int minCoins = minCoins(coins, amount);
            if (minCoins == Integer.MAX_VALUE) {
                minCoins = -1;
            }
            return minCoins;
        }


        private int minCoins(int[] coins, int amount) {
            if (amount == 0) {
                return 0;
            }

            int depth = Integer.MAX_VALUE;
            for (int coin: coins) {
                if (coin <= amount) {
                    int childDepth = minCoins(coins, amount - coin);
                    if (childDepth != Integer.MAX_VALUE) {
                        depth = Math.min(depth,  childDepth+1);
                    }
                }
            }

            return depth;
        }

        public static void main(String[] args) {
            int[][] inputs = {
                    {1, 2, 5},
                    {2},
                    {1, 2, 5}
            };
            int[] amounts = {
                    11,
                    3,
                    20
            };

            for (int i = 0; i < inputs.length; i ++) {
                int[] coins = inputs[i];
                int amount = amounts[i];
                System.out.println("coins = " + Arrays.toString(coins));
                System.out.println("amount = " + amount);
                int numCoins = new Solution1().coinChange(coins, amount);
                System.out.println("numCoins = " + numCoins);
                System.out.println("-----------------");
            }
        }
    }
}
