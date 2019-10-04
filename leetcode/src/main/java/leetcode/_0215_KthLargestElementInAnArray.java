package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @No          215
 * @problem     Kth Largest Element in an Array
 * @level       Medium
 * @desc        数组中的第K个最大元素
 * @author      liyazhou1
 * @date        2019/10/04
 *
 * <pre>
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Example 1:
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 *
 * Example 2:
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 * </pre>
 */
public class _0215_KthLargestElementInAnArray {


    /**
     * Note
     *
     * Thought
     *       方法一，排序，取倒数第 n-k 个元素
     *       方法二，小根堆
     *       方法三，快排改进方法
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

        public int findKthLargest(int[] nums, int k) {

            k = nums.length - k;
            int low = 0;
            int high = nums.length - 1;
            while (low < high) {
                int pos = partition(nums, low, high);
                if (pos < k) {
                    low = pos + 1;
                } else if (pos > k) {
                    high = pos - 1;
                } else {
                    break;
                }
            }
            return nums[k];
        }


        private int partition(int[] nums, int low, int high) {
            int key = nums[low];
            while (low < high) {
                for (; low < high && nums[high] > key; high --);
                if (low < high) {
                    nums[low] = nums[high];
                    low ++;
                }
                for (; low < high && nums[low] < key; low ++);
                if (low < high) {
                    nums[high] = nums[low];
                    high --;
                }
            }
            nums[low] = key;
            return low;
        }

        public static void main(String[] args) {
            int[][] inputs = {
                    {3, 2 ,1 ,5 ,6 ,4},
                    {3, 2, 3, 1, 2, 4, 5, 5, 6}
            };
            int[] kths = {
                    2,
                    4
            };

            for (int i = 0; i < inputs.length; i ++) {
                int[] input = inputs[i];
                int kth = kths[i];
                System.out.println("input = " + Arrays.toString(input));
                System.out.println("kth = " + kth);
                int kthVal = new Solution().findKthLargest(input, kth);
                System.out.println("kthVal = " + kthVal);
                System.out.println("------------------");
            }
        }

    }


    private static class Solution1 {

        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> minRootHeap = new PriorityQueue<>();
//            PriorityQueue<Integer> minRootHeap = new PriorityQueue<>(Comparator.reverseOrder());

//            for (int num: nums) {
//                System.out.println("num = " + num);
//                minRootHeap.offer(num);
//                if (minRootHeap.size() > k) {
//                    minRootHeap.poll();
//                }
//            }

            for (int i = 0; i < k; i ++) {
                minRootHeap.offer(nums[i]);
            }

            for (int j = k; j < nums.length; j ++) {
                if (nums[j] > minRootHeap.peek()) {
                    minRootHeap.poll();
                    minRootHeap.offer(nums[j]);
                }
            }

            return minRootHeap.peek();
        }

        public static void main(String[] args) {
            int[][] inputs = {
                    {3, 2 ,1 ,5 ,6 ,4},
                    {3, 2, 3, 1, 2, 4, 5, 5, 6}
            };
            int[] kths = {
                    2,
                    4
            };

            for (int i = 0; i < inputs.length; i ++) {
                int[] input = inputs[i];
                int kth = kths[i];
                System.out.println("input = " + Arrays.toString(input));
                System.out.println("kth = " + kth);
                int kthVal = new Solution1().findKthLargest(input, kth);
                System.out.println("kthVal = " + kthVal);
                System.out.println("------------------");
            }
        }

    }


    private static class Solution2 {

        public int findKthLargest(int[] nums, int k) {
            Arrays.sort(nums);
            return nums[nums.length-k];
        }

        public static void main(String[] args) {
            int[][] inputs = {
                    {3, 2 ,1 ,5 ,6 ,4},
                    {3, 2, 3, 1, 2, 4, 5, 5, 6}
            };
            int[] kths = {
                    2,
                    4
            };

            for (int i = 0; i < inputs.length; i ++) {
                int[] input = inputs[i];
                int kth = kths[i];
                System.out.println("input = " + Arrays.toString(input));
                System.out.println("kth = " + kth);
                int kthVal = new Solution2().findKthLargest(input, kth);
                System.out.println("kthVal = " + kthVal);
                System.out.println("------------------");
            }
        }
    }
}
