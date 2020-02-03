package offerV2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @No          v2-040,v1-030
 * @problem     最小的 k 个数
 * @tag         数组、topK、大根堆
 * @author      liyazhou
 * @date        2017/5/29
 *
 * <pre>
 *      输入 n 个整数，找出其中最小的 k 个数。
 *      例如输入 4、5、1、6、2、7、3、8 这 8 个数字，则最小的 4 个数是 1、2、3、4。
 * </pre>
 */
public class _040_Min_K_In_Array {


    /**
     * Note
     *
     * Thought
     *      大根堆
     *
     * Algorithm
     *      1. 使用最大堆，优先队列 PriorityQueue 和比较器 Comparator
     *      2. 将数组的中前 k 个数字存储到 最大堆中
     *      3. 遍历在数组区间[k,n)的元素，
     *             如果该元素小于最大堆中的第一个元素，则最大堆中的第一个元素出队，将该元素加入最大堆中
     */
    private static class Solution {

        public ArrayList<Integer> minK(int [] input, int k) {
            if (k <= 0 || k > input.length) return new ArrayList<Integer>();

            PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, Collections.reverseOrder());
            // PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k);

            for (int i = 0; i < k; i ++) {
                maxHeap.offer(input[i]);
            }

            for (int j = k; j < input.length; j ++){
                if (input[j] < maxHeap.peek()){
                    maxHeap.poll();
                    maxHeap.offer(input[j]);
                }
            }

            return new ArrayList<>(maxHeap);
        }

    }
}
