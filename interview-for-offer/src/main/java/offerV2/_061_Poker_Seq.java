package offerV2;

import java.util.Arrays;

/**
 * @No          v2-061,v1-044
 * @problem     扑克牌的顺子
 * @tag         数组
 * @author      liyazhou
 * @date        2017-06-02
 *
 * <pre>
 *      从扑克牌中随机抽 5 张牌，判断是不是顺子，即这 5 张牌是不是连续的。
 *      2~10为数字本身， A 为 1，J 为 11，Q 为 12，K 为13，而大、小王可以看成任意数字。
 * </pre>
 */
public class _061_Poker_Seq {

    /**
     * Note
     *
     * Thought
     *
     * Algorithm
     *      1. 对非大小王的数字排序
     *             如果有相同的数字，则返回 false
     *             统计大、小王的数目(大小王初始化为0，区分其他的牌)
     *             计算相邻数字之间的差，相差为1，表示连续，相差大于 1，则不连续，统计相邻的牌空缺总数（大于大小王数目，返回 false）
     */
    private static class Solution {

        /**
         * 2017-8-17 20:16:33
         * @param numbers 数组
         * @return 是否是顺子
         */
        public boolean isContinuous2(int [] numbers) {
            if (numbers == null || numbers.length == 0) return false;

            // Arrays.sort(numbers， Comparator.reverseOrder());
             Arrays.sort(numbers);

            int count = 0;
            for (int num : numbers){
                if (num == 0) {
                    count++;
                }
                else {
                    break;
                }
            }

            int diff = 0;
            for (int i = count+1; i < numbers.length; i ++){
                if (numbers[i] == numbers[i-1]) {
                    return false;
                }
                diff += numbers[i] - numbers[i-1] - 1;
            }

            return count >= diff;
        }
    }
}
