package leetcode;

import java.util.*;

/**
 * @No          49
 * @problem     Group Anagrams
 * @level       Medium
 * @desc        字母异位词分组
 * @author      liyazhou1
 * @date        2019/0928
 *
 * <pre>
 * Given an array of strings, group anagrams together.
 *
 * Example:
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 * Note:
 *
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 * </pre>
 */
public class _0049_GroupAnagrams {


    /**
     * Thought
     *      方法一，直观的方法（笨拙方法）
     *          对原字符串排序，并将排序后的字符串作为key，原字符串存放在key对应的List对象中，最终返回Map的values即可
     *
     *      方法二，善用字母（字符）的方法
     *          关于字符，可以巧妙的使用数组作为字典，字符作为下标即key，方便地计算value
     *
     *          改进key，降低时间复杂度
     *              使用数组统计字符串中的每个字符出现的次数；
     *              拼接 key，拼接每个字符及出现的次数，使其作为 key，字母异位词的 key 是相同的；
     *              使用 Map<String, List<String> 保存字母异位词；
     *              返回 Map 的 values 即可
     *
     * Challenge
     *
     *
     * Algorithm
     *      1.
     *      2.
     *      3.
     */
    private static class Solution {

        public List<List<String>> groupAnagrams(String[] strs) {
            if (strs == null || strs.length == 0) {
                return Collections.emptyList();
            }

            Map<String, List<String>> groups = new HashMap<>();
            int[] map = new int[26];

            for (String str: strs) {
                Arrays.fill(map, 0);

                for (int i = 0; i < str.length(); i ++) {
                    char ch = str.charAt(i);
                    map[ch-'a'] += 1;
                }

                StringBuilder key = new StringBuilder();
                for (int j = 0; j < map.length; j ++) {
                    char ch = (char)('a' + j);
                    int count = map[j];
                    key.append(ch).append(count);
                }
                String k = key.toString();
                if (groups.containsKey(k)) {
                    List<String> group = groups.get(k);
                    group.add(str);
                } else {
                    List<String> group = new ArrayList<>();
                    group.add(str);
                    groups.put(k, group);
                }
            }

            return new ArrayList<>(groups.values());
        }

        public static void main(String[] args) {
            String[][] inputs = {
                    {"eat", "tea", "tan", "ate", "nat", "bat"}
            };

            for (String[] input: inputs) {
                System.out.println("input = " + Arrays.toString(input));
                List<List<String>> result = new Solution().groupAnagrams(input);
                System.out.println("result = " + result);
            }
        }
    }
}
