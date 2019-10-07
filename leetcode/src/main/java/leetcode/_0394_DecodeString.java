package leetcode;

import java.util.Stack;

/**
 * @No          394
 * @problem     Decode String
 * @level       Medium
 * @desc        字符串解码
 * @author      liyazhou1
 * @date        2019/10/07
 *
 * <pre>
 * Given an encoded string, return its decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 *
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 *
 * Examples:
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 * </pre>
 */
public class _0394_DecodeString {


    /**
     * Note
     *
     * Thought
     *      方法一，递归法
     *      方法二，双栈，分别保存子字符串和其出现的次数
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
         * 方法二，双栈
         */
        public String decodeString(String s) {

            Stack<Integer> count = new Stack<>();
            Stack<String> result = new Stack<>();
            result.push("");

            int i = 0;
            while (i < s.length()) {
                char ch = s.charAt(i);
                if (Character.isDigit(ch)) {  // 数字
                    int start = i;
                    while (Character.isDigit(s.charAt(i+1))) {
                        i ++;
                    }
                    count.push(Integer.parseInt(s.substring(start, i+1)));
                } else if (ch == '[') {  // 子字符串开始
                    result.push("");
                } else if (ch == ']') {  // 子字符串结尾
                    String substr = result.pop();
                    StringBuilder str = new StringBuilder();
                    int times = count.pop();
                    for (int k = 0; k < times; k ++) {
                        str.append(substr);
                    }
                    result.push(result.pop() + str.toString());
                } else {  // 字符
                    result.push(result.pop() + ch);
                }
                i ++;
            }
            return result.pop();
        }

        public static void main(String[] args) {
            String[] inputs = {
                    "3[a]2[bc]",
                    "3[a2[c]]",
                    "2[abc]3[cd]ef"
            };
            for (String input: inputs) {
                System.out.println("input = " + input);
                String result = new Solution().decodeString(input);
                System.out.println("result = " + result);
                System.out.println("----------------------------");
            }
        }

    }
}
