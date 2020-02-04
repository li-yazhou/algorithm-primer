package offerV2;

import java.util.LinkedList;
import java.util.List;

/**
 * @No          v2-062,v1-045
 * @problem     圆圈中最后剩下的数字
 * @tag         递归
 * @author      liyazhou
 * @date        2017-06-03
 *
 * <pre>
 *      0, 1, 2, ..., n-1 这 n 个数字排成一个圆圈，从数字 0 开始每次从这个圆圈里删除第 m 个数字。
 *      求出这个圆圈里剩下的最后一个数字。
 *
 * </pre>
 */
public class _062_Joseph_Circle {


    /**
     * Note
     *
     * Thought
     *      约瑟夫环
     *
     * Algorithm
     *      1.
     *      2.
     *      3.
     */
    private static class Solution {


        public int lastRemainElement3(int n, int m) {
            if (n == 1) {
                return 0;
            }
            return (lastRemainElement3(n-1, m) + m) % n;
        }


        public int lastRemainElement2(int n, int m){
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < n; i ++) list.add(i);

            int idx = 0;
            for (int i = 0; i < n-1; i ++){
                idx = idx + (m-1);
                idx = idx % list.size();
                list.remove(idx);
            }
            return list.get(0);
        }


        public int LastRemaining(int n, int m) {
            if (n == 0 || m == 0) return -1;

            int[] arr = new int[n];  // 下标表示id
            int num = 0;  // 当前报数
            int idx = 0;  // 当前报数的id
            int counter = 0;  // 已经被删除的个数

            while (true) {
                if (num >= m) {
                    num %= m;
                }

                if (num == m-1) {
                    arr[idx] = -1;
                    counter ++;
                    if (counter == n-1) break;
                }

                // 查找下一个报数的id
                idx ++;
                if (idx == n) idx = 0;
                while (arr[idx] == -1){
                    idx ++;
                    if (idx == n) idx = 0;
                }

                num ++;
            }

            for (int j = 0; j < arr.length; j ++){
                if (arr[j] == 0) return j;
            }

            return -1;
        }
    }
}
