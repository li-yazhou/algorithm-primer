package leetcode;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-10-16 15:12
 */


import org.junit.Test;

import java.util.Arrays;

/**
 题目：
    查找一个字符串中两个相同的最大的子串，
    比如str="xabcdabdabc"中的两个相同的最大的子串是"abc"或"dab"，它们的长度均为3。

 分析：
    将问题转化为查找两个字符串的最大子串问题，状态变量states如下：

            x   a   b   c   d   a   b   d   a   b   c
        x   -
        a   0   -
        b   0   0   -
        c   0   0   0   -
        d   0   0   0   0   -
        a   0   1   0   0   0   -
        b   0   0   2   0   0   0   -
        d   0   0   0   0   1   0   0   -
        a   0   1   0   0   0   2   0   0   -
        b   0   0   2   0   0   0   3   0   0   -
        c   0   0   0   3   0   0   0   0   0   0   -

 */
public class MaxSameSubstring {

    /**
     * 查找一个字符串中两个相同的最大的子串
      * @param str 字符串
     * @return [起始下标1， 起始下标2， 最大长度， 最大的相同的子串]
     */
    public Object[] maxSameSubstring(String str){
        // TODO: 2017/10/16 可以优化的地方，使辅助空间减少一半（空间复杂度并没有改变）
        int[][] states = new int[str.length()][str.length()];
        for (int c = 0; c < str.length()-1; c ++){ // str.charAt[i] 跟[i+1, end]区间内的元素比较
            char ch = str.charAt(c);
            for (int r = c+1; r < str.length(); r ++){
                if (str.charAt(r) == ch){
                    if (c == 0) states[r][c] = 1;
                    else        states[r][c] = states[r-1][c-1] + 1;
                }
            }
        }

        printArrs(states);

        int x = 0, y = 0;
        int maxLen = 0;
        for (int i = 0; i < states.length; i ++){
            for (int j = 0; j < states[i].length; j ++){
                if (states[i][j] > maxLen){
                    x = i;
                    y = j;
                    maxLen = states[i][j];
                }
            }
        }

        int start1 = x + 1 - maxLen;
        int start2 = y + 1 - maxLen;
        return new Object[]{start1, start2, maxLen, str.substring(start1, start1+maxLen)};
    }



    @Test
    public void test(){
        String str = "xabcdabdabc";
        Object[] result = maxSameSubstring(str);
        System.out.println("起始位置1 = \t" + result[0]);
        System.out.println("起始位置2 = \t" + result[1]);
        System.out.println("子串长度 = \t" + result[2]);
        System.out.println("最大的相同子串 = \t" + result[3]);
    }



    private void printArrs(int[][] arrs){
        for (int[] arr : arrs)
            System.out.println(Arrays.toString(arr));
        System.out.println();
    }
}
