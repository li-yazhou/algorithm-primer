package problem.crack_code_interview;

import org.junit.Test;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-06-27 10:45
 * 9.1 数组与字符串
 *
 * 题目 1.5
 *      利用字符串重复出现的次数，编写一个方法，实现基本的字符串压缩功能。
 *      比如，字符串 aabcccccaaa 会变成 a2b1c5a3。
 *      若“压缩”后的字符串没有变短，则返回原先的字符串。
 *
 * 思路
 *      1. 先遍历字符串，计算压缩后的空间大小
 *
 */
public class Test05 {

    // 是否可用 StringBuilder 类
    public String compress2(String str){
        if (str == null) return null;

        StringBuilder sBuilder = new StringBuilder();
        char currChar = str.charAt(0);
        int counter = 1;
        for (int i = 1; i < str.length(); i ++){
            if (str.charAt(i) == currChar) counter ++;
            else {
                sBuilder.append(currChar).append(counter);

                currChar = str.charAt(i);
                counter = 1;
            }
        }
        sBuilder.append(currChar).append(counter);

        return sBuilder.length() < str.length() ? sBuilder.toString() : str;
    }


    public char[] compress(char[] chars){
        if (chars == null) return chars;
        int newLen = calculateLen(chars);
        if (newLen > chars.length) return chars;

        char[] compressedChars = new char[newLen];
        int newIdx = 0;
        char currChar = chars[0];
        int counter = 1;
        for (int i = 1; i < chars.length; i ++){
            if (chars[i] == currChar) counter ++;
            else {
                compressedChars[newIdx++] = currChar;
                String str = String.valueOf(counter);
                for (int j = 0; j < str.length(); j ++)
                    compressedChars[newIdx++] = str.charAt(j);

                currChar = chars[i];
                counter = 1;
            }
        }
        compressedChars[newIdx++] = currChar;
        String str = String.valueOf(counter);
        for (int j = 0; j < str.length(); j ++)
            compressedChars[newIdx++] = str.charAt(j);

        return compressedChars;
    }

    private int calculateLen(char[] chars) {
        int total = 0;
        char currChar = chars[0];
        int counter = 1;
        for (int i = 1; i < chars.length; i ++){
            if (chars[i] == currChar) counter ++;
            else{
                total ++;  // 当前字符占一个位置
                total += String.valueOf(counter).length(); // 当前字符重复的次数是几位数字，则占几位

                currChar = chars[i];
                counter = 1;
            }
        }
        total ++;
        total += String.valueOf(counter).length();

        return total;
    }

    @Test
    public void test(){
        String[] strs = {
                "aaabbbcccddd",
                "abcdefghijklmn"
        };
        for (String str : strs){
            System.out.println(str);
            char[] result = compress(str.toCharArray());
            System.out.println(new String(result));
            System.out.println(compress2(str));
            System.out.println();
        }
    }
}
