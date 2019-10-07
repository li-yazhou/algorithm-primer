package leetcode;

import java.util.*;

/**
 * @No          347
 * @problem     Top K Frequent Elements
 * @level       Medium
 * @desc        前 K 个高频元素
 * @author      liyazhou1
 * @date        2019/10/07
 *
 * <pre>
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 *
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * </pre>
 */
public class _0347_TopKFrequentElements {

    /**
     * Note
     *
     * Thought
     *      方法一，键值对排序，O(nlogn)
     *      方法二，小根堆，O(nlogK)
     *      方法三，桶排序，O(n)
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

        /**
         * 方法二，小根堆
         */
        public List<Integer> topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num: nums) {
                int val = map.getOrDefault(num, 0);
                map.put(num, val + 1);
            }

            Comparator<Integer> cmp = (i1, i2) -> map.get(i1) - map.get(i2);
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(cmp);
            for (Integer key: map.keySet()) {
                if (minHeap.size() < k) {
                    minHeap.offer(key);
                } else if (map.get(key) > map.get(minHeap.peek())){
                    minHeap.poll();
                    minHeap.offer(key);
                }
            }

            List<Integer> result = new ArrayList<>(k);
            while (!minHeap.isEmpty()) {
                result.add(minHeap.poll());
            }
            Collections.reverse(result);
            return result;
        }


        public static void main(String[] args) {
            int[][] inputs = {
                    {1, 1, 1, 2, 2, 3},
                    {1}
            };
            int[] topKs = {2, 1};
            for (int i = 0; i < inputs.length; i ++) {
                int[] nums = inputs[i];
                int k = topKs[i];
                List<Integer> result = new Solution().topKFrequent(nums, k);
                System.out.println("nums = " + Arrays.toString(nums));
                System.out.println("k = " + k);
                System.out.println("result = " + result);
                System.out.println("------------------------");
            }
        }
    }


    /**
     * Note
     *
     * Thought
     *      方法一，键值对排序
     *      方法二，小根堆
     *      方法三，桶排序
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
    private static class Solution1 {

        /**
         * 方法一，键值对排序
         */
        public List<Integer> topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num: nums) {
                int val = map.getOrDefault(num, 0);
                map.put(num, val + 1);
            }

            List<Map.Entry<Integer, Integer>> kvList = new ArrayList<>(map.entrySet());
            kvList.sort((e1, e2) -> {
                int v1 = e1.getValue();
                int v2 = e2.getValue();
                return v1 - v2 > 0 ? -1 : v1 - v2 < 0 ? 1 : e1.getKey() - e2.getKey();
            });

            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < k; i ++) {
                result.add(kvList.get(i).getKey());
            }

            return result;
        }


        public static void main(String[] args) {
            int[][] inputs = {
                    {1, 1, 1, 2, 2, 3},
                    {1}
            };
            int[] topKs = {2, 1};
            for (int i = 0; i < inputs.length; i ++) {
                int[] nums = inputs[i];
                int k = topKs[i];
                List<Integer> result = new Solution1().topKFrequent(nums, k);
                System.out.println("nums = " + Arrays.toString(nums));
                System.out.println("k = " + k);
                System.out.println("result = " + result);
                System.out.println("------------------------");
            }
        }
    }
}
