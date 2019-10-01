package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @No          139
 * @problem     Word Break
 * @level       Medium
 * @desc        单词拆分
 * @author      liyazhou1
 * @date        2019/10/01
 *
 * <pre>
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note:
 *
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 *
 * Example 1:
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 *
 * Example 2:
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 *              Note that you are allowed to reuse a dictionary word.
 *
 * Example 3:
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 * </pre>
 */
public class _0139_WordBreak {


    /**
     * Note
     *
     * Thought
     *      动态规划
     *
     * Challenge
     *
     * Algorithm
     *      1. 定义两个变量 i 和 j，i 表示由前 i 个字符组成的字符串，j 表示长度为 i 的字符串的一个分割点；
     *      2. 定义动态规划的转移状态 boolean[] dp = new int[n+1]，初始状态为 dp[0] = true，表示空字符串在字典中存在；
     *      3. 使用两层循环遍历字符串，变量为i和j
     *              若 dp[j] 为 true，且s.substring(j, i)在字典中也存在，则 dp[i] 为 true，表示该字符串可以被分拆
     *      4. 返回 dp[n]。
     *
     * Complexity
     *      Time,
     *      Space,
     */
    private static class Solution {

        public boolean wordBreak(String s, List<String> wordDict) {
            if (wordDict == null) {
                return false;
            }
            if (s == null || s.length() == 0) {
                return true;
            }

            Set<String> wordDictSet = new HashSet<>(wordDict);

            boolean[] dp = new boolean[s.length()+1];
            dp[0] = true;

            for (int i = 1; i <= s.length(); i ++) {
                for (int j = 0; j < i; j ++) {
                    if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[s.length()];
        }

        public static void main(String[] args) {
            String[] inputs = {
                    "leetcode",
                    "applepenapple",
                    "catsandog"
            };

            List<List<String>> wordDictList = Arrays.asList(
                    Arrays.asList("leet", "code"),
                    Arrays.asList("apple", "pen"),
                    Arrays.asList("cats", "dog", "sand", "and", "cat")
            );

            for (int i = 0; i < inputs.length; i ++) {
                String s = inputs[i];
                List<String> wordDict = wordDictList.get(i);
                System.out.println("s = " + s);
                System.out.println("wordDict = " + wordDict);
                boolean result = new Solution().wordBreak(s, wordDict);
                System.out.println("result = " + result);
                System.out.println("-----------------");
            }
        }
    }


    /**
     * Note
     *
     * Thought
     *      递归法
     *
     * Challenge
     *
     * Algorithm
     *      1.
     *      2.
     *      3.
     *
     * Complexity
     *      Time,
     *      Space,
     */
    private static class Solution1 {

        public boolean wordBreak(String s, List<String> wordDict) {
            if (wordDict == null) {
                return false;
            }

            if (s == null || s.length() == 0) {
                return true;
            }

            return wordBreak(s, new HashSet(wordDict), 0);
        }

        private boolean wordBreak(String s, Set<String> wordDict, int start) {
            if (start == s.length()) {
                return true;
            }

            for (int end = start+1; end <= s.length(); end ++) {
                if (wordDict.contains(s.substring(start, end)) && wordBreak(s, wordDict, end)) {
                    return true;
                }
            }

            return false;
        }

        public static void main(String[] args) {
            String[] inputs = {
                    "leetcode",
                    "applepenapple",
                    "catsandog"
            };

            List<List<String>> wordDictList = Arrays.asList(
                    Arrays.asList("leet", "code"),
                    Arrays.asList("apple", "pen"),
                    Arrays.asList("cats", "dog", "sand", "and", "cat")
            );

            for (int i = 0; i < inputs.length; i ++) {
                String s = inputs[i];
                List<String> wordDict = wordDictList.get(i);
                System.out.println("s = " + s);
                System.out.println("wordDict = " + wordDict);
                boolean result = new Solution1().wordBreak(s, wordDict);
                System.out.println("result = " + result);
                System.out.println("-----------------");
            }
        }
    }
}
