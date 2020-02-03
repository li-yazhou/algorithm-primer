package offerV2;

/**
 * @No          v2-049,v1-034
 * @problem     第 N 个丑数
 * @tag         动态规划
 * @author      liyazhou
 * @date        2017/5/30
 *
 * <pre>
 *      我们把只包含因子 2、3 和 5 的数称作为丑数（Ugly number）。求从小到大的顺序的第 1500 个丑数。
 *      例如 6、8 都是丑数，但 14 不是，因为它包含了因子 7。习惯上，我们把 1 当做第一个丑数。
 * </pre>
 */
public class _049_Kth_Ugly_Num {


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

        public int getKthUglyNum(int N) {
            if (N < 6) {
                return N;
            }

            int i2 = 0;
            int i3 = 0;
            int i5 = 0;

            int[] dp = new int[N];
            dp[0] = 1;
            for (int i = 1; i < N; i ++) {
                int next2 = dp[i2] * 2;
                int next3 = dp[i3] * 3;
                int next5 = dp[i5] * 5;

                dp[i] = Math.min(next2, Math.min(next3, next5));

                if (dp[i] == next2) {
                    i2 ++;
                } else if (dp[i] == next3) {
                    i3 ++;
                } else {
                    i5 ++;
                }
            }

            return dp[N-1];

        }
    }
}
