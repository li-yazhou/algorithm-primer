package leetcode;

/**
 * @No          11
 * @problem     Container With Most Water
 * @level       Medium
 * @desc        盛最多水的容器
 * @author      liyazhou1
 * @date        2019/09/15
 *
 * <pre>
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container and n is at least 2.
 *
 * The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 *
 * Example:
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * </pre>
 */
public class _0011_ContainerWithMostWater {


    /**
     * Note
     *
     * Thought
     *      左右双指针
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

        public int maxArea(int[] height) {
            if (height == null || height.length <= 1) {
                return 0;
            }
            int maxarea = 0;
            for (int L = 0, R = height.length-1; L < R;) {
                maxarea = Math.max(maxarea, (R - L) * Math.min(height[L], height[R]));
                if (height[L] > height[R]) {
                    R --;
                } else {
                    L ++;
                }
            }
            return maxarea;
        }

    }
}
