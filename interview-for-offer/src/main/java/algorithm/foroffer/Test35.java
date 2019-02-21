package algorithm.foroffer;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Created by liyazhou on 2017/5/30.
 * 面试题35：第一个只出现一次的字符
 *
 * 题目：
 *      在字符串中找出第一个只出现一次的字符。
 *      如输入"abaccdeff"，则输出'b'。
 *
 * 考查点：
 *      1. 哈希表
 *
 * 思路：
 *      1. 使用哈希表统计每一个字符出现的次数
 *      2. 遍历哈希表，找出第一个出现次数为 1 的字符（不能使用排序）
 */
public class Test35 {

    /**
     * 2017-8-16 20:15:41
     */
    public int firstNotRepeatingChar(String str) {
        int[] chars = new int[128];
        for(int i = 0; i < str.length(); i ++){
            chars[str.charAt(i)] += 1;
        }

        for(int i = 0; i < str.length(); i ++){
            if (chars[str.charAt(i)] == 1)
                return i;
        }
        return -1;
    }

    public static Character firstDistinctChar(char[] chars){
        if (chars == null) return null;

        Map<Character, Integer> characterIntegerMap = new LinkedHashMap<>();
        for (char ch : chars){
            if (characterIntegerMap.containsKey(ch)) characterIntegerMap.put(ch, characterIntegerMap.get(ch)+1);
            else                                     characterIntegerMap.put(ch, 1);
        }
        Character result = null;
        for (Entry<Character, Integer> entry : characterIntegerMap.entrySet()){
            // System.out.println(entry.getKey() + " :: " + entry.getValue());
            if (entry.getValue() == 1) {
                result = entry.getKey();
                break;
            }
        }
        return result;
    }


    public static void main(String[] args){
        String[] strs = {
                "baaccdeff",
                "abaccdedbfe",
        };
        for (String str : strs)
            System.out.println(str + ":\t" + firstDistinctChar(str.toCharArray()));
    }
}
