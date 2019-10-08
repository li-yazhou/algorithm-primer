package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @No          17
 * @problem     Letter Combinations of a Phone Number
 * @level       Medium
 * @desc        电话号码的字母组合
 * @author      liyazhou1
 * @date        2019/09/21
 *
 * <pre>
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 * "2" -> "abc"
 * "3" -> "def"
 * "4" -> "ghi"
 * "5" -> "jkl"
 * "6" -> "mno"
 * "7" -> "pqrs
 * "8" -> "tuv"
 * "9" -> "wxyz"
 *
 * Example:
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 * </pre>
 */
public class _0017_LetterCombinationsOfAPhoneNumber {


    /**
     * Note
     *
     * Thought
     *      回溯法，穷举所有可能
     *
     * Challenge
     *      组合问题，剪枝操作，消除重复的解
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

        private Map<String, String> digitToLetters = initPhone();

        public List<String> letterCombinations(String digits) {
            List<String> result = new ArrayList<>();
            if (digits == null || digits.isEmpty()) {
                return result;
            }

            backtrack(result, "", digits);

            return result;
        }

        private void backtrack(List<String> result, String solution, String nextDigits) {
            if (nextDigits.isEmpty()) {
                result.add(solution);
                return;
            } else {
                String digit = nextDigits.substring(0, 1);
                String letters = digitToLetters.get(digit);
                for (char letter : letters.toCharArray()) {
                    backtrack(result, solution+letter, nextDigits.substring(1));
                }
            }
        }


        private Map<String, String> initPhone() {
            Map<String, String> digitToLetters  = new HashMap<>();
            digitToLetters.put("2", "abc");
            digitToLetters.put("3", "def");
            digitToLetters.put("4", "ghi");
            digitToLetters.put("5", "jkl");
            digitToLetters.put("6", "mno");
            digitToLetters.put("7", "pqrs");
            digitToLetters.put("8", "tuv");
            digitToLetters.put("9", "wxyz");
            return digitToLetters;
        }


        @Test
        public void solution() {
            List<String> result = letterCombinations("3");
            System.out.println("result = " + result);
        }

    }


}
