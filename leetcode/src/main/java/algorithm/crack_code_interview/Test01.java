package algorithm.crack_code_interview;

import org.junit.Test;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-06-25 20:12
 *
 * 9.1 数组与字符串
 *
 * 题目 1.1：
 *      实现一个算法，确定一个字符串的所有字符是否全都不同。
 *      假如不允许使用额外的数据结构，又改如何处理？
 *
 * 思路：
 *      1. 使用长度为 256 的数组模拟字典，统计字符出现的次数
 *      2. 可以使用蛮力法，当前元素和其后面的每一个元素比较，两层循环即可实现
 *         （数据较小，不用创建数组，效果可能更好）
 */
public class Test01 {

    public boolean isUniqueChars(char[] chars){
        if (chars.length > 256) return false;

        boolean result = true;
        boolean[] isUnique = new boolean[256];
        for (int i = 0; i < chars.length; i ++){
            if (isUnique[chars[i]]) {
                result = false;
                break;
            }
            isUnique[chars[i]] = true;
        }
        return result;
    }


    @Test
    public void test(){
        String[] strs = {
                "aaaabbbb",
                "abcdefg",
        };

        for (String str : strs){
            boolean result = isUniqueChars(str.toCharArray());
            System.out.println(str + " :: " + result);
        }
    }
}
