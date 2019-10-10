package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @No          438
 * @problem     Find All Anagrams in a String
 * @level       Medium
 * @desc        找到字符串中所有字母异位词
 * @author      liyazhou1
 * @date        2019/09
 *
 * <pre>
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 *
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 *
 * The order of output does not matter.
 *
 * Example 1:
 * Input:
 * s: "cbaebabacd" p: "abc"
 * Output:
 * [0, 6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 *
 * Example 2:
 * Input:
 * s: "abab" p: "ab"
 * Output:
 * [0, 1, 2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 * </pre>
 */
public class _0438_FindAllAnagramsInAString {


    /**
     * Note
     *
     * Thought
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

        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> result = new ArrayList<>();
            if (s == null || p == null) {
                return result;
            }

            int[] needs = new int[26];
            int count = 0;
            for (int i = 0; i < p.length(); i ++) {
                int index = p.charAt(i) - 'a';
                if (needs[index] == 0) {
                    count ++;
                }
                needs[index] ++;
            }

            int[] window = new int[26];
            int left = 0;
            int right = 0;
            int match = 0;

            while (right < s.length()) {
                int index = s.charAt(right) - 'a';
                right ++;
                if (needs[index] > 0) {
                    window[index] ++;
                    if (window[index] == needs[index]) {
                        match ++;
                    }
                }

                while (match == count) {
                    int removeIndex = s.charAt(left) - 'a';
                    left ++;
                    if (needs[removeIndex] > 0) {
                        window[removeIndex] --;
                        if (window[removeIndex] < needs[removeIndex]) {
                            match --;
                            int len = right - (left - 1);
                            if (len == p.length()) {
                                result.add(left-1);
                            }
                        }
                    }
                }

            }
            return result;

        }


        public List<Integer> findAnagrams1(String s, String p) {
            List<Integer> result = new ArrayList<>();
            if (s == null || p == null) {
                return result;
            }

            int[] standard = count(p);

            for (int i = 0; i < s.length() - p.length() + 1; i ++) {
                int end = i + p.length();
                String sub = s.substring(i, end);
                int[] map = count(sub);
                boolean equals = compare(map, standard);
                if (equals) {
                    result.add(i);
                }
            }
            return result;
        }

        private int[] count(String sub) {
            int[] map = new int[26];
            for (int i = 0; i < sub.length(); i ++) {
                int index = sub.charAt(i) - 'a';
                map[index] ++;
            }
            return map;
        }

        private boolean compare(int[] map, int[] standard) {
            boolean equals = true;
            for (int i = 0; i < map.length; i ++) {
                if (map[i] != standard[i]) {
                    equals = false;
                    break;
                }
            }
            return equals;
        }

    }
}
