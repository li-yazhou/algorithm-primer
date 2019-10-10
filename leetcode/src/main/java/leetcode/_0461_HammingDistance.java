package leetcode;

import org.junit.Test;

/**
 * @No          461
 * @problem     Hamming Distance
 * @level       Easy
 * @desc        汉明距离
 * @author      liyazhou
 * @date        2017-10-12 10:57
 *
 * <pre>
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 *
 * Given two integers x and y, calculate the Hamming distance.
 *
 * Note:
 * 0 ≤ x, y < 231.
 *
 * Example:
 * Input: x = 1, y = 4
 * Output: 2
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 *
 * The above arrows point to positions where the corresponding bits are different.
 * </pre>
 */
public class _0461_HammingDistance {


    /**
     * Note
     *
     * Thought
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
    private static class Solution {

        public int hammingDistance(int x, int y) {
            int counter = 0;
            while (x != 0 || y != 0){
                if ((x & 1) != (y & 1)) counter ++;
                x = x >> 1;
                y = y >> 1;
            }
            return counter;
        }

        public int hammingDistance1(int x, int y) {
            int counter = 0;
            for (int i = 0; i < 32; i ++){
                if ((x & 1) != (y & 1)) counter ++;
                x = x >> 1;
                y = y >> 1;
            }
            return counter;
        }



        @Test
        public void test(){
            int result = hammingDistance(1, 4);
            System.out.println(result);
        }
    }

}
