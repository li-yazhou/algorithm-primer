package offerV2;

/**
 * @No          v2-010,v1-009
 * @problem     矩形覆盖
 * @tag         递归、动态规划
 * @author      liyazhou1
 * @date        2017/5/24
 *
 * <pre>
 *    我们可以用 2*1 的小矩形横着或者竖着去覆盖更大的矩形。
 *    请问用 n 个 2*1 的小矩形无重叠地覆盖一个 2*n 的大矩 形，总共有多少种方法?
 * </pre>
 */
public class _010_Rectangle_Coverage {


    /**
     * Note
     *
     * Thought
     *      与斐波那契数列求解相同
     *
     * Algorithm
     *      要覆盖 2*n 的大矩形，可以先覆盖 2*1 的矩形，再覆盖 2*(n-1) 的矩形;
     *      或者先覆盖 2*2 的矩形，再覆盖 2*(n-2) 的矩形。
     *      而覆盖 2*(n-1) 和 2*(n-2) 的矩形可以看成子问题。
     */
    private static class Solution {



    }


}
