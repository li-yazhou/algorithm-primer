package problem.crack_code_interview;

import org.junit.Test;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-06-27 10:19
 *
 * 9.1 数组与字符串
 *
 * 题目 1.4
 *      编写一个方法，将字符串中的空格全部替换为 “%20”。假定该字符串尾部有足够的空间存放
 *      新增字符，并且知道字符串的 “真实长度”。
 *
 * 思路：
 *      1. 计算出处理之后的字符串的长度，然后从右向左依次往后移动
 *      2. 统计空格的总个数，计算出处理后的字符串的末尾字符的下标；
 *         将字符从右向左依次移动；
 *         遇到空格则依次插入字符 '0','2','%'
 */
public class Test04 {

    public void replaceSpaces(char[] chars, int len){
        int spaceNum = 0;
        for (char ch : chars){
            if (ch == ' ') spaceNum ++;
        }

        int newLen = len + spaceNum * 2;

        for (int i = len-1; i >= 0; i --){
            if (chars[i] != ' '){
                chars[--newLen] = chars[i];
            }else{
                chars[--newLen] = '0';
                chars[--newLen] = '2';
                chars[--newLen] = '%';
            }
        }
    }


    @Test
    public void test(){
        String[] strs = {
                "i am a student.",
                " it is a good day. ",
        };

        for (String str : strs){
            char[] chars = new char[100];
            for (int i = 0; i < str.length(); i ++)
                chars[i] = str.charAt(i);
            System.out.print(str + "\t");
            replaceSpaces(chars, str.length());
            System.out.println(new String(chars));
        }
    }
}
