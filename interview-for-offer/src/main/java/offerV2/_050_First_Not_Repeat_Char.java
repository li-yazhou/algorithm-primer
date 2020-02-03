package offerV2;

import java.util.BitSet;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @No          v2-050,V1-035
 * @problem     第一个只出现一次的字符
 * @tag
 * @author      liyazhou
 * @date        2017/5/30
 *
 * <pre>
 *      在字符串中找出第一个只出现一次的字符。
 *      如输入"abaccdeff"，则输出'b'。
 * </pre>
 */
public class _050_First_Not_Repeat_Char {


    /**
     * Note
     *
     * Thought
     *
     * Algorithm
     *      1. 使用哈希表统计每一个字符出现的次数
     *      2. 遍历哈希表，找出第一个出现次数为 1 的字符（不能使用排序）
     */
    private static class Solution {




        public int firstNotRepeatingChar2(String str) {
            BitSet m1 = new BitSet(256);
            BitSet m2 = new BitSet(256);

            for (char ch : str.toCharArray()) {
                if (!m1.get(ch) && !m2.get(ch)) {
                    m1.set(ch);
                } else if (m1.get(ch) && !m2.get(ch)) {
                    m2.set(ch);
                }
            }

            for (int i = 0; i < str.length(); i ++) {
                char ch = str.charAt(i);
                if (m1.get(ch) && !m2.get(ch)) {
                    return i;
                }
            }
            return -1;

        }


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
            for (Map.Entry<Character, Integer> entry : characterIntegerMap.entrySet()){
                // System.out.println(entry.getKey() + " :: " + entry.getValue());
                if (entry.getValue() == 1) {
                    result = entry.getKey();
                    break;
                }
            }
            return result;
        }

    }
}
