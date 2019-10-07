package leetcode;

/**
 * @No          647
 * @problem     Palindromic Substrings
 * @level       Medium
 * @desc        回文子串
 * @author      liyazhou1
 * @date        2019/10/07
 *
 * <pre>
 * Given a string, your task is to count how many palindromic substrings in this string.
 *
 * The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
 *
 * Example 1:
 *
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 *
 *
 * Example 2:
 *
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 *
 *
 * Note:
 *
 * The input string length won't exceed 1000.
 * </pre>
 */
public class _0647_PalindromicSubstrings {


    /**
     * Note
     *
     * Thought
     *      方法一，中心扩展法
     *      方法二，动态规划
     *      方法三，暴力验证所有子串
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
         * 方法一，中心扩展法
         *
         */
        public int countSubstrings(String s) {
            int count = 0;
            for (int i = 0; i < s.length(); i ++) {
                count += palindromicSubstrings(s, i, i);
                count += palindromicSubstrings(s, i, i+1);
            }
            return count;
        }


        private int palindromicSubstrings(String str, int left, int right) {
            int count = 0;
            while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
                count ++;
                left --;
                right ++;
            }
            return count;
        }

        public static void main(String[] args) {
            String[] inputs = {"abc", "aaa", "fdsklf"};
            for (String input: inputs) {
                System.out.println("input = " + input);
                int result = new Solution().countSubstrings(input);
                System.out.println("result = " + result);
                System.out.println("-----------------");
            }
        }
    }


    private static class Solution1 {

        /**
         * 方法三，暴力验证所有子串
         */
        public int countSubstrings(String s) {
            int counter = 0;

            for (int i = 0; i < s.length(); i ++){
                for (int j = i+1; j < s.length()+1; j ++){
                    String str = s.substring(i, j);
                    if (isPalindromicString(str))
                        counter ++;
                }
            }
            return counter;
        }


        private boolean isPalindromicString(String s){
            if (s.length() == 1) return true;

            boolean bool = true;
            for (int i = 0; i < s.length()/2; i ++){
                if (s.charAt(i) != s.charAt(s.length()-1-i)){
                    bool = false;
                    break;
                }
            }
            return bool;

        }

        public static void main(String[] args) {
            String[] inputs = {"abc", "aaa", "fdsklf"};
            for (String input: inputs) {
                System.out.println("input = " + input);
                int result = new Solution1().countSubstrings(input);
                System.out.println("result = " + result);
                System.out.println("-----------------");
            }
        }
    }
}
