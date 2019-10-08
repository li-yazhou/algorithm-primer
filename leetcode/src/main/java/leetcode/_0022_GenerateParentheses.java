package leetcode;

import org.junit.Test;

import java.util.*;


/**
 * @No          22
 * @problem     Generate Parentheses
 * @level       Medium
 * @desc        括号生成
 * @author      liyazhou1
 * @date        2019/09/21
 *
 * <pre>
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 * </pre>
 */
public class _0022_GenerateParentheses {


    /**
     * Note
     *
     * Thought
     *      方法三，直接生成满足条件的括号
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
    private class Solution {

        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();
            int open = 0;
            int close = 0;
            backTrack(result, "", open, close, n);
            return result;
        }

        private void backTrack(List<String> result, String solution, int open, int close, int n) {
            if (solution.length() == n * 2) {
                result.add(solution);
                return;
            }
            if (open < n) {
                backTrack(result, solution + "(", open+1, close, n);
            }
            if (close < open) {
                backTrack(result, solution + ")", open, close + 1, n);
            }
        }

        @Test
        public void solution() {
            List<String> result = generateParenthesis(3);
            System.out.println("result = " + result);
        }
    }


    /**
     * Note
     *
     * Thought
     *     方法二，与方法一大致相同，改进了验证括号是否成对的方法
     *          对序列全排列
     *          验证每一种情况是否满足条件，即括号是否成对
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
    private class Solution2 {

        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();
            List<Character> seq = new ArrayList<>();
            for (int i = 0; i < n; i ++) {
                seq.add('(');
            }
            for (int i = 0; i < n; i ++) {
                seq.add(')');
            }
            backtrack(result, seq, 0);
            return result;
        }


        private void backtrack(List<String> result, List<Character> seq, int depth) {
            System.out.println("depth = " + depth + "\tseq = " + seq);
            if (depth == seq.size()) {
                String solution = seq.stream().map(ch -> ch.toString()).reduce(String::concat).orElse("");
                // String solution = seq.stream().map(ch -> ch.toString()).collect(Collectors.joining(""));
                boolean isTrue = validatePairs(solution);
                System.out.println("solution = " + solution + "\t" + isTrue);
                if (isTrue) {
                    result.add(solution);
                }
                return;
            }

            for (int i = depth; i < seq.size(); i ++) {
                if (i > 0 && seq.get(i).equals(seq.get(i-1))) {
                    System.out.print("i = " + i + "\t");
                    System.out.println("seq = " + seq + "\t continue");
                    continue;
                }
                Collections.swap(seq, i, depth);
                backtrack(result, seq, depth+1);
                Collections.swap(seq, i, depth);
            }
        }

        /**
         * 验证括号是否成对
         */
        private boolean validatePairs(String solution) {
            if (solution == null || solution.isEmpty()) {
                return false;
            }
            int balance = 0;
            for (char ch : solution.toCharArray()) {
                if (ch == '(') {
                    balance ++;
                } else if (ch == ')'){
                    balance --;
                    if (balance < 0) {
                        return false;
                    }
                }
            }
            return balance == 0;
        }


        @Test
        public void solution() {
            List<String> result = generateParenthesis(2);
            System.out.println("result = " + result);
        }

    }


    /**
     * Note
     *
     * Thought
     *     方法一，
     *          对序列全排列
     *          验证每一种情况是否满足条件，即括号是否成对
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
    private class Solution1 {

        public List<String> generateParenthesis1(int n) {

            Set<String> result = new HashSet<>();

            List<Character> seq = new ArrayList<>();
            for (int i = 0; i < n; i ++) {
                seq.add('(');
                seq.add(')');
            }

            int depth = 0;
            permute(result, seq, depth);

            return new ArrayList<>(result);
        }


        private void permute(Set<String> result, List<Character> seq, int depth) {
            if (depth == seq.size()) {
                boolean isTrue = validateParenthesis(seq);
                if (isTrue) {
                    StringBuilder sbuilder = new StringBuilder();
                    for (Character ch: seq) {
                        sbuilder.append(ch);
                    }
                    result.add(sbuilder.toString());
                }
            }

            for (int i = depth; i < seq.size(); i ++) {
                Collections.swap(seq, i, depth);
                permute(result, seq, depth+1);
                Collections.swap(seq, i, depth);
            }
        }

        private boolean validateParenthesis(List<Character> chars) {
            LinkedList<Character> stack = new LinkedList<>();
            for (Character ch : chars) {
                if (ch == '(') {
                    stack.push(ch);
                } else {
                    if (stack.isEmpty()) {
                        return false;
                    } else {
                        stack.pop();
                    }
                }
            }
            return stack.isEmpty();
        }

        @Test
        public void solution1() {
            List<String> result = generateParenthesis1(2);
            System.out.println("result = " + result);
        }
    }


    /**
     * Note
     *
     * Thought
     *     方法一，
     *          对序列全排列
     *          验证每一种情况是否满足条件，即括号是否成对
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
    private class Solution0 {

        public List<String> generateParenthesis0(int n) {
            char[] chs = new char[n*2];
            for (int i = 0; i < n; i ++){
                chs[i] = '(';
                chs[n+i] = ')';
            }

            Set<String> set = new HashSet<>();
            permutate(chs, 0, set);

            return new ArrayList<String>(set);
        }



        // 字符串全排列
        private void permutate(char[] chs, int start, Set<String> set){
            if (start == chs.length){
                boolean bool = validate(chs);
                if (bool)
                    set.add(new String(chs));

            }

            for (int i = start; i < chs.length; i ++){
                char temp = chs[start];
                chs[start] = chs[i];
                chs[i] = temp;

                permutate(chs, start+1, set);

                temp = chs[start];
                chs[start] = chs[i];
                chs[i] = temp;
            }
        }


        private boolean validate(char[] chs){
            LinkedList<Character> stack = new LinkedList<>();
            for (char ch : chs){
                if (ch == ')') {
                    if (stack.isEmpty() || stack.pop() != '(') return false;
                } else {
                    stack.push(ch);
                }
            }

            return stack.isEmpty();
        }

        @Test
        public void solution0() {
            List<String> result = generateParenthesis0(2);
            System.out.println("result = " + result);
        }
    }

}