package offerV2;

/**
 * @No          v2-010,v1-009
 * @problem     青蛙跳台阶
 * @tag         递归、动态规划
 * @author      liyazhou1
 * @date        2017/5/24
 *
 * <pre>
 * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级。
 * 求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * </pre>
 */
public class _010_Jump_Step {


    /**
     * Note
     *
     * Thought
     *      与斐波那契数列求解相同
     *      跳 n 阶台阶，可以先跳 1 阶台阶，再跳 n-1 阶台阶;或者先跳 2 阶台阶，再跳 n-2 阶台阶。
     *      而 n-1 和 n-2 阶台阶的 跳法可以看成子问题
     *
     * Algorithm
     *
     */
    private static class Solution {



    }


}
