package algorithm.program_pre_interview.huawei;

import org.junit.Test;

import java.util.Scanner;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-09-06 18:49
 */

/*
题目描述
请一个在字符串中找出连续最长的数字串，并把这个串的长度返回；如果存在长度相同的连续数字串，返回最后一个连续数字串；
注意：数字串只需要是数字组成的就可以，并不要求顺序，比如数字串“1234”的长度就小于数字串“1359055”，如果没有数字，则返回空字符串（“”）而不是NULL！（说明：不需要考虑负数）

输入描述:
字符串
输出描述:
连续数字串&在所有数字串最长的长度

示例1
输入
abcd12345ed125ss123058789
输出
123058789
9

*/
public class Main06 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        int[] length = {0};
        String result = maxDigitSeq(input, length);
        System.out.println(result);
        System.out.println(length[0]);
    }

    private static String maxDigitSeq(String input, int[] length) {
        int[] bounds = new int[2];

        int maxLen = 0;
        int fromIndex = -1;
        int endIndex = -1;
        boolean isRestart = true;
        for (int i = 0; i < input.length(); i ++){
            char ch = input.charAt(i);
            if (ch >= '0' && ch <= '9'){
                if (isRestart)  {
                    fromIndex = i;
                    // endIndex = i;
                    isRestart = false;
                } else{
                    endIndex = i;
                }
            }else{
                isRestart = true;
                int len = endIndex - fromIndex + 1;
                if (len >= maxLen){
                    bounds[0] = fromIndex;
                    bounds[1] = endIndex;
                    maxLen = len;
                }
            }
        }

        int len = endIndex - fromIndex + 1;
        if (len >= maxLen){
            bounds[0] = fromIndex;
            bounds[1] = endIndex;
            maxLen = len;
        }
        String result = "";
        if (maxLen > 0 && fromIndex >= 0) {
            result = input.substring(bounds[0], bounds[1] + 1);
            length[0] = maxLen;
        }
        return result;
    }


    @Test
    public void test(){
        String[] inputs = {
                "abcd12345ed125ss123058789",
                "abcd123ed12345ss123058789",
                "abcd123ed1234512305",
                "abcd123ed456789",
                "000abcd123ed456789",
                "abcd",
                "000000000000abcd123ed456789",
                "000000000000",
                "",
        };

        for (String s : inputs){
            int[] length = {0};
            System.out.println(s + " :: " + maxDigitSeq(s, length) + " :: " + length[0]);

        }
    }



}
