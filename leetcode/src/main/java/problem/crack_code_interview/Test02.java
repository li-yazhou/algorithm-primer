package problem.crack_code_interview;

import org.junit.Test;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-06-25 21:21
 *
 * 9.1 数组与字符串
 *
 * 题目 1.2
 *      用 C 或者 C++ 实现 void reverse(char* str) 函数，
 *      即反转一个 null 结尾的字符串。
 *
 * 思路：
 *      1. Java.lang.StringBuilder 的 reverse()方法
 *      2. 交换数组中元素的位置
 */
public class Test02 {

    public void reverse(char[] chars){
        for (int i = 0; i < chars.length/2; i ++){
            char temp = chars[i];
            chars[i] = chars[chars.length-1-i];
            chars[chars.length-1-i] = temp;
        }
    }

    @Test
    public void test(){
        String[] strs = {
                "abcdefghijklmnopqrstuvwxyz",
                "interview",
        };
        for (String str : strs){
            System.out.print(str + "  -->   ");
            char[] chs = str.toCharArray();
            reverse(chs);
            System.out.println(new String(chs));
        }
    }
}
