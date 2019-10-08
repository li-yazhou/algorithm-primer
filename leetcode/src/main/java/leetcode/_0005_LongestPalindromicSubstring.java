package leetcode;

/**
 * @No          5
 * @problem     Longest Palindromic Substring
 * @level       Medium
 * @desc        最长回文子串
 * @author      liyazhou
 * @date        2017/08
 *
 * <pre>
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 *
 * Example 2:
 * Input: "cbbd"
 * Output: "bb"
 * </pre>
 */
public class _0005_LongestPalindromicSubstring {


    /**
     * Note
     *
     * Thought
     *      方法一，暴力验证所有子串
     *      方法二，中心扩展法
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

        public String longestPalindrome(String s) {
            if (s == null || s.length() <= 1) {
                return s;
            }

            int start = 0;
            int end = 0;
            for (int i = 0; i < s.length(); i ++) {
                int len1 = expandAroundCenter(s, i, i);
                int len2 = expandAroundCenter(s, i, i+1);

                int len = Math.max(len1, len2);
                if (len > end-start+1) {
                    start = i - (len-1)/2;
                    end = i + len/2;
                }
                System.out.println(start + ", " + end);
            }
            return s.substring(start, end+1);
        }


        /*
        public String longestPalindrome(String s) {
            if (s == null || s.length() <= 1) {
                return s;
            }

            int start = 0;
            int end = 0;
            for (int i = 0; i < s.length(); i ++) {
                int len1 = expandAroundCenter(s, i, i);
                int len2 = expandAroundCenter(s, i, i+1);

                int len = Math.max(len1, len2);
                if (len > end-start+1) {
                    if (len1 >= len2) {
                        int offset = (len1 - 1) / 2;
                        start = i - offset;
                        end = i + offset;
                    } else {
                        int offset = (len2 - 2) / 2;
                        start = i - offset;
                        end = i + 1 + offset;
                    }
                }
                System.out.println(start + ", " + end);
            }
            return s.substring(start, end+1);
        }
        */

        private int expandAroundCenter(String s, int left, int right) {
            int L = left, R = right;
            while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
                L --;
                R ++;
            }
            return R - L - 1;
        }

    }
}
