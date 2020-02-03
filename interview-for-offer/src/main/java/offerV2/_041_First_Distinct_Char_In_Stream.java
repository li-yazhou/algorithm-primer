package offerV2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @No          v2-041,v1-055
 * @problem     字符流中第一个不重复的字符
 * @tag         字符的数组索引、队列
 * @author      liyazhou
 * @date        2017-06-18
 *
 * <pre>
 *      请实现一个函数用来找出字符流中第一个只出现一次的字符。
 *      例如，当从字符流中只读出前两个字符 "go" 时，第一个只出现一次的字符是 "g"，
 *      当从该字符串中读出前六个字符 "google" 时，第一个只出现一次的字符是 "l"。
 * </pre>
 */
public class _041_First_Distinct_Char_In_Stream {


    /**
     * Note
     *
     * Thought
     *
     * Algorithm
     *      1.
     *      2.
     */
    private static class Solution {

        private int[] cnts = new int[256];
        private Queue<Character> queue = new LinkedList<>();

        public void insert(char ch) {
            cnts[ch] ++;
            queue.offer(ch);
            while (!queue.isEmpty() && cnts[queue.peek()] > 1) {
                queue.poll();
            }
        }

        public char firstCharAppearingOnce() {
            return queue.isEmpty() ? '#' : queue.peek();
        }
    }
}
