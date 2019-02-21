package algorithm.foroffer;

import org.junit.Test;


/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-18 10:51
 *
 * 题目：
 *      请实现一个函数用来找出字符流中第一个只出现一次的字符。
 *      例如，当从字符流中只读出前两个字符 "go" 时，第一个只出现一次的字符是 "g"，
 *      当从该字符串中读出前六个字符 "google" 时，第一个只出现一次的字符是 "l"。
 *
 * 考查点：
 *      1. 字符串
 *
 * 思路：
 *      0。要做到：
 *          一、统计字符出现的次数；
 *          二、标记只出现一次的字符的先后位置
 *      1. 使用长度为 256 的整型数组，数组元素的值是字符出现的"先后顺序"，如果出现多次标记为-1，否则标记为 order
 *         (order初始值为 1，随输入的字符流个数增长)
 *      2. 查找最小 order 出现的位置，也即是数组中不为0或-1的所有元素中的最小值。即是最小的order，
 *         对应下标就是字符流中第一个只出现一次的字符。
 *
 */
public class Test55 {

    public char firstCharAppearingOnce(char[] chars){
        // if (chars == null || chars.length == 0) throw new IllegalArgumentException("Argument is illegal.");
        if (chars == null) throw new IllegalArgumentException("Argument is illegal.");

        int order = 1;
        int[] occurrence = new int[256];
        for (int idx : chars)  {
            if (idx < 0 || idx > 255) throw new IllegalArgumentException();

            if (occurrence[idx] == 0)  occurrence[idx] = order;
            else                      occurrence[idx] = -1;
            order ++;
        }

        char ch = '\u0000';
        int minFlag = chars.length + 1;
        for (int i = 0; i < occurrence.length; i ++){
            if (occurrence[i] >= 1 && occurrence[i] < minFlag){
                ch = (char)i;
                minFlag = occurrence[i];
            }
        }
        return ch;
    }


    @Test
    public void test(){
        String[] strings = {
                "",
                "g",
                "go",
                "goo",
                "goog",
                "googl",
                "google",
        };

        for (String string : strings){
            char[] chars = string.toCharArray();
            String line = String.format("%s :: %s", string, firstCharAppearingOnce(chars));
            System.out.println(line);
        }
    }
}
