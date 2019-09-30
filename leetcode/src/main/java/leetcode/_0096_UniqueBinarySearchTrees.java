package leetcode;

/**
 * @No          96
 * @problem     Unique Binary Search Trees
 * @level       Medium
 * @desc        不同的二叉搜索树
 * @author      liyazhou1
 * @date        2019/09/30
 *
 * <pre>
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 *
 * Example:
 * Input: 3
 * Output: 5
 *
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 * </pre>
 */
public class _0096_UniqueBinarySearchTrees {


    /**
     * Note
     *
     * Thought
     *      卡特兰公式
     *
     * Challenge
     *      发现规律
     *      动态规划
     *
     *      定义两个函数
     *          G(n)，表示长度为n的序列可以构造不同的BST的个数
     *          F(i, n) ，表示以第i个为根，且长度为n的序列可以构造不同的BST的个数，1 <= i <= n
     *
     *      G(n) = F(1, n) + F(2, n) + F(3, n) + ... + F(n, n)
     *      F(i, n) = G(i-1)*G(n-i)
     *
     *      G(n) = G(0)*G(n-1) + G(1)*G(n-2) + G(2)*G(n-3) + ... + G(n-1)G(0)
     *
     *      G(0) = 1
     *      G(1) = 1
     *      G(2) = G(0)*G(1) + G(1)
     *
     *
     * Algorithm
     *      1. 设置
     *      2.
     *
     * Complexity
     *      Time,
     *      Space,
     */
    private static class Solution {

        public int numTrees(int n) {
            int[] dp = new int[n+1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= n; i ++) {
                for (int j = 1; j <= i; j ++) {
                    dp[i] += dp[j-1] * dp[i-j];
                }
            }
            return dp[n];
        }

        public static void main(String[] args) {
            int[] inputs = {
                    3
            };
            for (int input: inputs) {
                System.out.println("input = " + input);
                int result = new Solution().numTrees(input);
                System.out.println("result = " + result);
            }
        }
    }
}
