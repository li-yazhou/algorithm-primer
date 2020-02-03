package offerV2;

/**
 * @No          v2-0
 * @problem     字符串的排列
 * @tag         递归、回溯
 * @author      liyazhou
 * @date        2017/5/29
 *
 * <pre>
 *      输入一个字符串，打印出该字符串中字符的所有排列。
 *      例如输入字符串 abc，则打印出 a、b、c 所能排列出来的所有字符串
 *      abc、acb、bac、bca、cab 和 cba。
 * </pre>
 */
public class _038_Permutation_String {


    /**
     * Note
     *
     * Thought
     *
     * Algorithm
     *      1. 把字符串分为两部分，一部分是字符串的第一个字符，另一部分是第一个字符以后的所有字符
     *         求第二部分字符串的排列
     *      2. 第一个字符和它后面的字符交换位置
     */
    private static class Solution {

        public static void permutation(char[] chars){
            if (chars == null) return;
            permutation(chars, 0);
        }

        private static void permutation(char[] chars, int start) {
            if (start == chars.length) {
                System.out.println(chars);
            }

            for (int idx = start; idx < chars.length; idx++){
                char tmp = chars[idx];
                chars[idx] = chars[start];
                chars[start] = tmp;

                permutation(chars, start+1);

                tmp = chars[idx];
                chars[idx] = chars[start];
                chars[start] = tmp;
            }
        }


        public static void main(String[] args){
            String str = "abc";
            char[] chars = str.toCharArray();
            permutation(chars);
        }
    }
}
