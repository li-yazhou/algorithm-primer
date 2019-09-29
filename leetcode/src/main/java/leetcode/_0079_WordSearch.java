package leetcode;

import java.util.Arrays;

/**
 * @No          79
 * @problem     Word Search
 * @level       Medium
 * @desc        单词搜索
 * @author      liyazhou1
 * @date        2019/09/29
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * Example:
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 * </pre>
 */
public class _0079_WordSearch {


    /**
     * Note
     *
     * Thought
     *      回溯法
     *          DFS + 重置状态
     *
     * Challenge
     *      递归回溯条件
     *      递归递进条件
     *
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
    private static class Solution {

        public boolean exist(char[][] board, String word) {
            if (board == null || board.length == 0 || board[0].length == 0
                    || word == null || word.isEmpty()) {
                return false;
            }

            boolean[][] visited = new boolean[board.length][board[0].length];
            int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

            /* ********* 每个点都可能是字符串的起点 *********/
            for (int i = 0; i < board.length; i ++) {
                for (int j = 0; j < board[0].length; j ++) {
                    if (dfs(visited, directions, i, j, 0, board, word)) {
                        return true;
                    }
                }
            }
            return false;
        }

        /* ********** 递归求解以 i,j 为首元素，是否连续的字符序列等于目标字符串 *********/
        private boolean dfs(boolean[][] visited, int[][] directions, int i, int j, int start,
                            char[][] board, String word) {
//            if (start >= word.length()) {
//                return true;
//            }

            /* ********* 递归回溯条件 *********/
            if (start == word.length()-1) {
                return word.charAt(start) == board[i][j];
            }

            System.out.println("i = " + i + ", j = " + j + ", start = " + start);
            if (board[i][j] == word.charAt(start)) {
                visited[i][j] = true;

                for (int k = 0; k < directions.length; k ++) {
                    int nextI= i + directions[k][1];
                    int nextJ = j + directions[k][0];
                    /* ********* 递归递进条件 *********/
                    if (nextI >= 0 &&  nextI < board.length && nextJ >= 0 && nextJ < board[0].length
                            && !visited[nextI][nextJ]) {
                        if (dfs(visited, directions, nextI, nextJ,start+1, board, word)) {
                            return true;
                        }
                    }
                }
                visited[i][j] = false;
            }

            return false;
        }

        public static void main(String[] args) {
            char[][][] inputs = {
                    {
                            {'A', 'B', 'C', 'E'},
                            {'S', 'F', 'C', 'S'},
                            {'A', 'D', 'E', 'E'}
                    },
                    {
                            {'a'},
                            {'a'}
                    }
            };
            String[][] words = {
                    {
                            "ABCCED",
                            "SEE",
                            "ABCB"
                    },
                    {
                            "aa"
                    }
            };

            for (int i = 0; i < inputs.length; i ++) {
                char[][] board = inputs[i];
                String[] targets = words[i];
                System.out.println("board = " + Arrays.deepToString(board));
                for (String target: targets) {
                    System.out.println("target = " + target);
                    boolean exist = new Solution().exist(board, target);
                    System.out.println("exist = " + exist);
                    System.out.println("-----------------------------");
                }
            }
        }
    }
}
