package algorithm.foroffer;

import org.junit.Test;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-19 16:26
 *
 * 面试题64：数据流中的中位数
 *
 * 题目：
 *      如何得到一个数据流中的中位数？
 *      如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 *      如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 *
 * 考查点：
 *      1. 查找
 *      2. 最大堆和最小堆
 *
 * 思路：
 *      1. 将数据流中的数据保存到两个容器中，这两个容器需要满足以下的条件：
 *            a. 保证一个容器中的最大值不大于另一个容器中的最小值
 *            b. 保证两个容器中的元素个数相差 0 或者 1
 *            c. 存放较小值的容器能够快速获取到最大值，存放较大值的容器能够快速获取到最小值
 *      2. 这个数据结构就是最大堆和最小堆
 *      3. 步骤：
 *            当新输入一个数据时，
 *            若两个容器中元素的总数目是偶数，
 *              则将最大堆中的最大值和当前值中较大值保存到最小堆中，较小者保存到最大堆中。
 *              （为了保证一个容器中的最大值不大于另一个容器中的最小值）
 *            若两个容器中元素的总数目是奇数，
 *              则将最小堆中的最小值和当前值中的较小者保存到最大堆中，较大者保存到最小堆中。
 *              （为了保证一个容器中的最大值不大于另一个容器中的最小值）
 *            通过对两个容器中总元素个数的判断，控制新的数据保存到哪一个堆中，实现了两个容器中元素个数相差为 0 或者 1。
 *            此时，已然满足了 1 中的 a、b 和 c 三个条件。
 *
 *
 *
 */
public class Test64 {
    private Queue<Integer> minHeap = new PriorityQueue<>();
    // Comparator<Integer> reverse = new Comparator<Integer>(){
    //    @Override public int compare(Integer obj1, Integer obj2){ return obj2 - obj1; }
    // };
    private Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public void insert(int num){
        if (((minHeap.size() + maxHeap.size()) & 1) == 0){ // 数字的总数为偶数，将新的数据插入到最小堆中（最小堆中保存的都是较大的数字）
            // 若当前值最大堆中的最大值小，则将当前数字和最大数字交换（为了保证最大堆的最大值始终不大于最小堆中的最小值）
            // 即，将当前数字保存到最大堆中，将最大堆中的最大数字弹出并保存到最小堆中
            if (maxHeap.size() > 0 && num < maxHeap.peek()){
                maxHeap.offer(num);
                num = maxHeap.poll();
            }
            minHeap.offer(num);
        }
        else{  // 数字的总数为奇数，将新的数据插入到最大堆中（最大堆中保存的都是较小的数字）
            // 若当前值比最小堆中的最小值大，则将当前数字和最小值交换（为了保证最大堆中的最大值始终不大于最小堆中的最小值）
            // 即，将当前数字存放到最小堆中，将最小堆中的最小数字弹出并保存到最大堆中
            if (minHeap.size() > 0 && num > minHeap.peek()){
                minHeap.offer(num);
                num = minHeap.poll();
            }
            maxHeap.offer(num);
        }
    }


    public double getMedain(){
        int size = minHeap.size() + maxHeap.size();
        if (size == 0) throw new IllegalArgumentException("Argument is illegal.");
        double medain;
        if ((size & 1) == 1) medain = minHeap.peek();
        else                 medain = (minHeap.peek() + maxHeap.peek()) / 2.0;
        return medain;
    }




    @Test
    public void test(){
        Random random = new Random();
        int N = 10;
        for (int i = 0; i < N; i ++)  insert(random.nextInt(100));

        for (int i = 0; i < 5; i ++) {
            insert(random.nextInt(100));
            System.out.println("maxHeap : " + maxHeap);
            System.out.println("minHeap : " + minHeap);
            System.out.println(getMedain());
            System.out.println();
        }
    }
}
