package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @No          3
 * @problem     Longest Substring Without Repeating Characters
 * @level       Medium
 * @desc        无重复的最长子串
 * @author      liyazhou1
 * @date        2017-09-05 13:53
 *
 * <pre>
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * </pre>
 */
public class _0003_LongestSubstringWithoutRepeatingCharacters {


    /**
     * Note
     *
     * Thought
     *      方法一，暴力验证
     *      方法二，使用Map索引
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
         * 方法二，使用Map索引
         */
        public int lengthOfLongestSubstring(String s) {

            int maxLen = 0;

            // 字符的最大索引
            Map<Character, Integer> chToLatestIndexMap = new HashMap<>();
            int start = 0;
            for (int end = 0; end < s.length(); end ++) {
                char ch = s.charAt(end);
                if (chToLatestIndexMap.containsKey(ch)) {
                    // 若该字符出现在start之前，则start不改变
                    start = Math.max(start, chToLatestIndexMap.get(ch)+1);
                }
                chToLatestIndexMap.put(ch, end);
                maxLen = Math.max(maxLen, end-start+1);
            }
            return maxLen;
        }


        public static void main(String[] args) {
            String[] inputs = {
                    "abcabcbb",
                    "bbbbb",
                    "pwwkew",
                    "abba"
            };

            for (String input: inputs) {
                System.out.println("input = " + input);
                int result = new Solution().lengthOfLongestSubstring(input);
                System.out.println("result = " + result);
            }
        }


        public int lengthOfLongestSubstring2(String s) {
            int maxLen = 0;
            StringBuilder sub = new StringBuilder(s.length());
            int fromIndex = 0;

            for (int i = 0; i < s.length(); i ++){
                char ch = s.charAt(i);

                int index = sub.indexOf(ch+"", fromIndex);  // 重复“字符”（字符串）的位置

                if (index != -1) fromIndex = index+1;  // 不断调整起始下标

                sub.append(ch);

                int len = sub.length() - fromIndex;  // 总长度 - 起始下标 = 当前子字符串的长度

                if (maxLen < len) maxLen = len;
            }

            return maxLen;
        }


        /**
         * 方法一，暴力验证
         *
         * 超时，不通过
         */
        public int lengthOfLongestSubstring1(String s) {
            int maxLen = 0;
            List<Character> subList = new ArrayList<>();
            for (int i = 0; i < s.length(); i ++){
                char ch = s.charAt(i);
                int index = subList.indexOf(ch);
                if (index != -1){
                    if (maxLen < subList.size()) maxLen = subList.size();
                    if (index == subList.size()-1) subList.clear();
                    else                           subList = subList.subList(index+1, subList.size());
                }

                subList.add(ch);
            }
            if (maxLen < subList.size()) maxLen = subList.size();
            return maxLen;
        }

    }
}
