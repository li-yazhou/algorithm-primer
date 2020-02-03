package offerV2;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @No          v2-045,v1-0
 * @problem     把数组排成最小的数
 * @tag         字符串、数组
 * @author      liyazhou
 * @date        2017/5/30
 *
 * <pre>
 *      1. 将数组中所有的整数转换为字符串
 *      2. 比较两个字符串A、B的大小（谁排在前，谁排在后）的原则：
 *         比较 A+B 和 B+A，让两者按字典序排序的准则，返回大小值（后验），
 *         A、B 依据返回的结果进行排序
 * </pre>
 */
public class _045_Combine_Min_Num_By_Array {


    /**
     * Note
     *
     * Thought
     *      1. 字符串排序，// 字典顺序排序（字典序顺序排序，字典序逆序排序）
     *      2. 比较器
     *
     * Algorithm
     *      1. 将数组中所有的整数转换为字符串
     *      2. 比较两个字符串A、B的大小（谁排在前，谁排在后）的原则：
     *         比较 A+B 和 B+A，让两者按字典序排序的准则，返回大小值（后验），
     *         A、B 依据返回的结果进行排序
     */
    private static class Solution {

        public static String cancatMinNumber(int[] array){
            List<String> dictOrderList = new LinkedList<>();
            for (int element: array) {
                dictOrderList.add(element + "");
            }

            Collections.sort(dictOrderList, new Comparator<String>(){
                @Override
                public int compare(String o1, String o2) {
                    return (o1+o2).compareTo(o2+o1);
                }
            });

            String ret = "";
            for (String num: dictOrderList) {
                ret += num;
            }

            return ret;
        }

    }
}
