package leetcode;

import java.util.*;

/**
 * @No          56
 * @problem     Merge Intervals
 * @level       Medium
 * @desc        合并区间
 * @author      liyazhou1
 * @date        2019/09/29
 *
 * <pre>
 *
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 *
 * Example 2:
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 *
 * </pre>
 */
public class _0056_MergeIntervals {


    /**
     * Note
     *
     * Thought
     *      排序
     *
     * Challenge
     *      代码实现
     *
     * Algorithm
     *      1. 排序
     *      2. 合并
     *
     * Complexity
     *      Time,
     *      Memory,
     *
     * Rank
     *      Runtime, 41.39%
     *      Memory Usage, 48.55%
     */
    private static class Solution {

        public int[][] merge(int[][] intervals) {
            if (intervals == null || intervals.length == 0) {
                return intervals;
            }

            List<Interval> intervalList = new ArrayList<>();
            for (int[] interval: intervals) {
                intervalList.add(new Interval(interval));
            }
            // System.out.println("origin intervalList = " + intervalList);

            Comparator<Interval> cmp = (intervalA, intervalB) ->
                    intervalA.start < intervalB.start ? -1 :
                        (intervalA.start > intervalB.start ? 1 : intervalA.end - intervalB.end);
            intervalList.sort(cmp);
            // System.out.println("sorted intervalList = " + intervalList);

            List<Interval> result = new ArrayList<>();
            Interval merged = intervalList.get(0);
            result.add(merged);
            for (int i = 0; i < intervalList.size(); i ++) {
                Interval curr = intervalList.get(i);
                if (curr.start <= merged.end) {
                    merged.end = Math.max(merged.end, curr.end);
                } else {
                    merged = curr;
                    result.add(merged);
                }
            }

            int[][] ans = new int[result.size()][2];
            for (int i = 0; i < result.size(); i ++) {
                ans[i] = result.get(i).toIntArray();
            }

            return ans;
        }


        private class Interval {
            int start;
            int end;

            Interval(int start, int end) {
                this.start = start;
                this.end = end;
            }

            Interval(int[] range) {
                this.start = range[0];
                this.end = range[1];
            }

            int[] toIntArray() {
                return new int[]{this.start, this.end};
            }

            @Override
            public String toString(){
                return Arrays.toString(this.toIntArray());
            }
        }

        public static void main(String[] args) {
            int[][][] inputs = {
                    {{2, 6}, {1, 3}, {8, 10}, {15, 18}},
                    {{1, 4}, {4, 5}}
            };

            for (int[][] input: inputs) {
                System.out.println("input = " + Arrays.deepToString(input));
                int[][] result = new Solution().merge(input);
                System.out.println("result = " + Arrays.deepToString(result));
                System.out.println("-------------");
            }
        }

    }
}
