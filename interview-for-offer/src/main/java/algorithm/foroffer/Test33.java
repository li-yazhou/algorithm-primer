package algorithm.foroffer;

import java.util.*;

/**
 * Created by liyazhou on 2017/5/30.
 * 面试题33：把数组排成最小的数
 *
 * 题目：
 *      输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个，
 *      例如输入数组 {3, 32, 321}，则打印出这 3 个数字能排成的最小数字 321323。
 *
 * 考查点：
 *      1. 字符串排序，// 字典顺序排序（字典序顺序排序，字典序逆序排序）
 *      2. 比较器
 *
 * 思路：
 *      1. 将数组中所有的整数转换为字符串
 *      2. 比较两个字符串A、B的大小（谁排在前，谁排在后）的原则：
 *         比较 A+B 和 B+A，让两者按字典序排序的准则，返回大小值（后验），
 *         A、B 依据返回的结果进行排序
 */
public class Test33 {

    public static void cancatMinNumber(int[] array){
        List<String> dictOrderList = new LinkedList<>();
        for (int element: array)
            dictOrderList.add(element + "");

        Collections.sort(dictOrderList, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });
        for (String num: dictOrderList)
            System.out.print(num);
    }

    public static void main(String[] args){
        Integer[] arr = {1, 2, 3};
        List<Integer> list = Arrays.asList(arr);
        System.out.println(list);
        list.set(2, 33);
        // list.remove(2);
        // list.add(4);
        int[] arr2 = {1, 2, 3};
        List<Integer> list2 = new ArrayList<>(arr2.length);
        for (int ele: arr2) list2.add(ele);


        int[][] arrays = {
                {3, 32, 323},
                {31, 32, 323},
        };
        for(int[] array: arrays){
            System.out.println(Arrays.toString(array));
            cancatMinNumber(array);
            System.out.println();
        }
    }

}
