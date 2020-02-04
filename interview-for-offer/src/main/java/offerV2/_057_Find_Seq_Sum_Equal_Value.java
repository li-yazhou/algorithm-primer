package offerV2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @No          v2-057,v1-041
 * @problem     为 s 的连续正数序列
 * @tag         数组、双指针
 * @author      liyazhou
 * @date        2017-06-01
 *
 * <pre>
 *      输入一个正数 s，打印出所有和为 s 的连续正数序列（至少含有两个数）。
 *      例如输入 15，由于 1+2+3+4+5 = 4+5+6 = 7+8 = 15，
 *      所以结果打印出3个连续序列 1~5、4~6 和 7~8。
 * </pre>
 */
public class _057_Find_Seq_Sum_Equal_Value {


    /**
     * Note
     *
     * Thought
     *      1. 二叉查找的思想（对于排序数组，首先要想到二分查找，使用两个指针不断缩小范围）
     *
     * Algorithm
     *      1. 连续的数字序列之和正好，则返回该序列
     *         连续的数字序列之和较小，则从后面添加数字
     *         连续的数字序列之和较大，则从前面删除数字，
     *         （每添加一个较大的数字，可以能会删除若干个较小的数字，需要使用循环）
     *         循环条件是，最小值的下标minIdx小于 (sum+1)/2
     */
    private static class Solution {

        public List<List<Integer>> findContinuousSequence(int sum){
            if (sum < 3) return Collections.emptyList();

            List<List<Integer>> ret = new ArrayList<>();

            int start = 1;
            int end = 2;

            int currSum = start + end;
            while (end < sum) {
                if (currSum > sum) {
                    // 减去start，start往后移动
                    currSum -= start;
                    start ++;
                } else if (currSum < sum) {
                    // end往后移动，加上end
                    end ++;
                    currSum += end;
                } else {
                    ret.add(rangeSeq(start, end));

                    // 减去start，start往后移动
                    currSum -= start;
                    start ++;

                    // end往后移动，加上end
                    end ++;
                    currSum += end;
                }
            }

            return ret;
        }


        private List<Integer> rangeSeq(int start, int end) {
            List<Integer> seq = new ArrayList<>();
            for (int i = start; i < end; i ++) {
                seq.add(i);
            }
            return seq;
        }

    }
}
