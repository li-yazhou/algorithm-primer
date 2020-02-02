package offerV2;

import java.util.Arrays;

/**
 * @No          v2-010,v1-009
 * @problem     变态跳台阶
 * @tag         递归、动态规划
 * @author      liyazhou1
 * @date
 *
 * <pre>
 * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级... 它也可以跳上 n 级。
 * 求该青蛙跳上一个 n 级的台阶总共有多少 种跳法。
 * </pre>
 */
public class _010_Random_Jump_Step {


    /**
     * Note
     *
     * Thought
     *  跳上 n-1 级台阶，可以从 n-2 级跳 1 级上去，也可以从 n-3 级跳 2 级上去...，那么
     *      f(n-1) = f(n-2) + f(n-3) + ... + f(0)
     *  同样，跳上 n 级台阶，可以从 n-1 级跳 1 级上去，也可以从 n-2 级跳 2 级上去... ，那么
     *      f(n) = f(n-1) + f(n-2) + ... + f(0)
     *
     *  综上可得
     *      f(n) - f(n-1) = f(n-1)
     *  即
     *      f(n) = 2*f(n-1)
     *
     * Algorithm
     *
     */
    private static class Solution {

        public int randomJump(int target) {
            int[] dp = new int[target];
            Arrays.fill(dp, 1);
            for (int i = 1; i < target; i ++) {
                for (int j = 0; j < i; j ++) {
                    dp[i] += dp[j];
                }
            }
            return dp[target-1];
        }
    }
}
