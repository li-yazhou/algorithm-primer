package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @No          406
 * @problem     Queue Reconstruction by Height
 * @level       Medium
 * @desc        根据身高重建队列
 * @author      liyazhou1
 * @date        2019/10/07
 *
 * <pre>
 * Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.
 *
 * Note:
 * The number of people is less than 1,100.
 *
 * Example
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 * </pre>
 */
public class _0406_QueueReconstructionByHeight {


    /**
     * Note
     *
     * Thought
     *      先排序后插入
     *
     * Challenge
     *      发现规律
     *
     * Algorithm
     *      1. 排序规则，按照先 H 高度降序，K 个数升序排序；
     *      2. 遍历排序后的数组，根据 K 将元素插入到结果列表的 K 位置上。
     *
     *      高个子先排好相对位置，矮个子插入到 K 位上，矮个子前面必然存在 K 个高个子，
     *      而插入的矮个子又不会影响高个子的 K
     *
     * Complexity
     *      Time,
     *      Space,
     */
    private static class Solution {

        public int[][] reconstructQueue(int[][] people) {

            Arrays.sort(people, (hk1, hk2) -> hk1[0] > hk2[0] ? -1 : hk1[0] < hk2[0] ? 1 : hk1[1] - hk2[1]);

            List<int[]> result = new LinkedList<>();
            for (int[] p: people) {
                result.add(p[1], p);
            }
            return result.toArray(new int[people.length][2]);
        }


        public static void main(String[] args) {
           int[][] input = {
                   {7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}
           };
            System.out.println("input = " + Arrays.deepToString(input));
           int[][] result = new Solution().reconstructQueue(input);
            System.out.println("result = " + Arrays.deepToString(result));
        }

    }
}
