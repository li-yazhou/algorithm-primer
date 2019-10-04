package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @No          206
 * @problem     Course Schedule
 * @level       Medium
 * @desc        课程表
 * @author      liyazhou1
 * @date        2019/10/02
 *
 * <pre>
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 *
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 *
 * Example 1:
 * Input: 2, [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0. So it is possible.
 *
 * Example 2:
 * Input: 2, [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0, and to take course 0 you should
 *              also have finished course 1. So it is impossible.
 *
 * Note:
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices.
 * Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input prerequisites.
 * </pre>
 */
public class _0206_CourseSchedule {


    /**
     * Note
     *
     * Thought
     *      拓扑排序
     *      拓扑顺序验证
     *
     * Challenge
     *      入度、出度计算
     *      程序实现
     *      优化Solution1，避免重复遍历
     *
     * Algorithm
     *      1. 初始化0~n-1每个元素的入度，设置满足条件的元素个数count为0，及入度为0的Queue；
     *      2. 遍历入度数组，
     *              若当前元素的入度为0
     *                  将其加入到Queue
     *      3. 循环访问Queue，直到其为空
     *              取出第一个元素
     *              count ++
     *              将其出度元素的入度减1，若入度为0，则将其加入到Queue
     *      4. 返回  count == numCourses
     *
     * Complexity
     *      Time,
     *      Space,
     */
    private static class Solution {

        public boolean canFinish(int numCourses, int[][] prerequisites) {

            // 建立标记两点之间是否存在有向边的索引

            int[][] matrix = new int[numCourses][numCourses];
            // 初始化每个元素的入度
            int[] inDegrees = new int[numCourses];
            for (int[] edge: prerequisites) {
                inDegrees[edge[1]] ++;
                matrix[edge[0]][edge[1]] = 1;
            }

            int count = 0;

            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < inDegrees.length; i ++) {
                if (inDegrees[i] == 0) {
                    queue.offer(i);
                }
            }

            if (queue.isEmpty()) {
                return false;
            }

            while (!queue.isEmpty()) {
                int element = queue.poll();
                count ++;

                // 查找以该元素为起始点的有向边，并将它们的入度减1
                for (int i = 0; i < numCourses; i ++) {
                    if (matrix[element][i] == 1) {
                        inDegrees[i] --;  // 可能为负整数
                        if (inDegrees[i] == 0) {
                            queue.offer(i);
                        }
                    }
                }
            }
            return count == numCourses;
        }

        public static void main(String[] args) {
            int[][][] inputs = {
                    {
                            {1, 0}
                    },
                    {
                            {1, 0},
                            {0, 1}
                    }
            };
            int[] numCourses = {
                    2,
                    2
            };

            for (int i = 0; i < inputs.length; i ++) {
                int[][] prerequisites = inputs[i];
                int num = numCourses[i];
                boolean result = new Solution().canFinish(num, prerequisites);
                System.out.println("result = " + result);
            }
        }
    }

    /**
     * Note
     *
     * Thought
     *      拓扑排序
     *      拓扑顺序验证
     *
     * Challenge
     *      入度、出度计算
     *      程序实现
     *
     * Algorithm
     *      1. 初始化0~n-1每个元素的入度，设置满足条件的元素个数count为0，及入度为0的Queue；
     *      2. 遍历入度数组，
     *              若当前元素的入度为0
     *                  将其加入到Queue
     *      3. 循环访问Queue，直到其为空
     *              取出第一个元素
     *              count ++
     *              将其出度元素的入度减1，若入度为0，则将其加入到Queue
     *      4. 返回  count == numCourses
     *
     *
     * Complexity
     *      Time,
     *      Space,
     */
    private static class Solution1 {

        public boolean canFinish(int numCourses, int[][] prerequisites) {

            // 初始化每个元素的入度
            int[] inDegrees = new int[numCourses];
            for (int[] edge: prerequisites) {
                inDegrees[edge[1]] ++;
            }

            int count = 0;

            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < inDegrees.length; i ++) {
                if (inDegrees[i] == 0) {
                    queue.offer(i);
                }
            }

            if (queue.isEmpty()) {
                return false;
            }

            while (!queue.isEmpty()) {
                int element = queue.poll();
                count ++;
                // 查找以该元素为起始点的有向边，并将它们的入度减1
                for (int[] edge: prerequisites) {
                    if (edge[0] == element) {
                        inDegrees[edge[1]]--;
                        if (inDegrees[edge[1]] == 0) {
                            queue.offer(edge[1]);
                        }
                    }
                }
            }
            return count == numCourses;
        }

        public static void main(String[] args) {
            int[][][] inputs = {
                    {
                            {1, 0}
                    },
                    {
                            {1, 0},
                            {0, 1}
                    }
            };
            int[] numCourses = {
                    2,
                    2
            };

            for (int i = 0; i < inputs.length; i ++) {
                int[][] prerequisites = inputs[i];
                int num = numCourses[i];
                boolean result = new Solution().canFinish(num, prerequisites);
                System.out.println("result = " + result);
            }
        }
    }
}
