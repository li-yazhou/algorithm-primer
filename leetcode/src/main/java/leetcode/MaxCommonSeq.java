package leetcode;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-10-16 16:47
 */

import org.junit.Test;

import java.util.Arrays;

/**
 题目：最长公共子序列


 思路：

 动态规划

 1、序列str1和序列str2
     ·长度分别为m和n；
     ·创建1个二维数组L[m.n]；
     ·初始化L数组内容为0
     ·m和n分别从0开始，m++，n++循环（两层循环）：
         - 如果str1[m] == str2[n]，则L[m,n] = L[m - 1, n -1] + 1；
         - 如果str1[m] != str2[n]，则L[m,n] = max{L[m,n - 1]，L[m - 1, n]}
     ·最后从L[m,n]中的数字一定是最大的，且这个数字就是最长公共子序列的长度
     ·从数组L中找出一个最长的公共子序列

 2、从数组L中查找一个最长的公共子序列
    i和j分别从m，n开始，递减循环（单层循环）直到i = 0，j = 0。其中，m和n分别为两个串的长度。
         ·如果str1[i] == str2[j]，则将str[i]字符插入到子序列内，i--，j--；
         ·如果str1[i] != str[j]，则比较L[i,j-1]与L[i-1,j]，L[i,j-1]大，则j--，否则i--；（如果相等，则任选一个）

    使用二维数组保存比较状态
     [0, 0, 0, 0, 0, 0, 0, 0]
     [0, 0, 1, 1, 1, 1, 1, 1]
     [0, 0, 1, 1, 1, 2, 2, 2]
     [0, 0, 1, 2, 2, 2, 2, 2]
     [0, 1, 1, 2, 2, 2, 3, 3]
     [0, 1, 2, 2, 3, 3, 3, 4]
     [0, 1, 2, 2, 3, 3, 4, 4]

 */
public class MaxCommonSeq {


    public String maxCommonSeq(String str1, String str2){
        int[][] states = new int[str1.length()+1][str2.length()+1];

        for (int i = 1; i < states.length; i ++){
            char ch1 = str1.charAt(i-1);
            for (int j = 1; j < states[i].length; j ++){
                char ch2 = str2.charAt(j-1);
                if (ch1 == ch2) states[i][j] = states[i-1][j-1] + 1;
                else            states[i][j] = Math.max(states[i][j-1], states[i-1][j]);
            }
        }

        printArrs(states);

        int maxLen = states[states.length-1][states[0].length-1];
        StringBuilder sBuilder = new StringBuilder(maxLen);
        for (int i = states.length-1, j = states[i].length-1 ; i > 0 && j > 0; ){
            char ch1 = str1.charAt(i-1);
            char ch2 = str2.charAt(j-1);
            if (ch1 == ch2){
                i --;
                j --;
                System.out.println(i + ", " + j);
                sBuilder.append(ch1);
            } else {
                if (states[i][j-1] > states[i-1][j]) j --;
                else                                 i --;
            }
        }
        sBuilder = sBuilder.reverse();
        return sBuilder.toString();
    }



    @Test
    public void test(){
        String[][] strs = {
                {"bdcaba", "abcbdab"},
        };

        for (String[] str : strs)
            System.out.println(maxCommonSeq(str[0], str[1]));
    }

    private void printArrs(int[][] arrs){
        for (int[] arr : arrs)
            System.out.println(Arrays.toString(arr));
        System.out.println();
    }


/*

[0, 0, 0, 0, 0, 0, 0, 0]
[0, 0, 1, 1, 1, 1, 1, 1]
[0, 0, 1, 1, 1, 2, 2, 2]
[0, 0, 1, 2, 2, 2, 2, 2]
[0, 1, 1, 2, 2, 2, 3, 3]
[0, 1, 2, 2, 3, 3, 3, 4]
[0, 1, 2, 2, 3, 3, 4, 4]

4, 6
3, 5
1, 4
0, 3
bdab


 */














}
