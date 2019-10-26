package problem.crack_code_interview;

import org.junit.Test;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-06-25 21:57
 *
 * 9.1 数组与字符串
 *
 * 题目 1.3
 *      给定两个字符串，请编写程序，确定其中一个字符串的字符重新排列后，
 *      能否编程另一个字符串。
 *
 * 思路：
 *      1. 简单的方法是，将字符数组排序，然后比较两个排序后的字符数组
 *      2. 方法二，比较各个字符出现的次数
 */
public class Test03 {

    public boolean permutation(char[] chars1, char[] chars2){
        if (chars1 == null || chars2 == null || chars1.length != chars2.length)
            return false;

        int[] counters = new int[256];

        for (char ch : chars1) counters[ch] ++;

        for (char ch : chars2){
            counters[ch] --;
            if (counters[ch] < 0) return false;
        }

        return true;
    }

    @Test
    public void test(){
        String[] strs = {
                "liyazhou",
                "yazhouli",
                "yazhoull",
        };
        System.out.println(permutation(strs[0].toCharArray(), strs[1].toCharArray()));
        System.out.println(permutation(strs[0].toCharArray(), strs[2].toCharArray()));
    }

}
