package algorithm.foroffer;

import java.util.Arrays;

/**
 * Created by liyazhou on 2017/5/26.
 * 面试题14：调整数组顺序使奇数位于偶数前面
 * 题目：
 *      输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 *      使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 * 问题：
 *      1. 排序
 *
 * 思路：
 *      1. 快速排序的思想
 *      2. 用 A、B 两个指针分别指向数组的开始和末尾
 *          A 指针往右移动，若发现偶数则停止移动
 *          B 指针往左移动，若发现奇数则停止移动
 *          若 A 指向偶数，B 指向奇数。交换两者的位置
 *          直到 A、B 指针相遇
 *
 */
public class Test14 {

    public static void reorderOddEven(int[] array){
        if (array == null) return;
        int first = 0;
        int second = array.length-1;

        while (first < second){
            // 从左往右，找到第一个偶数
            while(((array[first] & 1) == 1) && first < second) first ++;
            while(((array[second] & 1) == 0) && second > first) second --;
            // 从右往左，找到第一个奇数
            if (first < second){
                int tmp = array[first];
                array[first] = array[second];
                array[second] = tmp;
            }
        }
    }

    public static void main(String[] args){
        int[] array = {1, 2 ,3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(Arrays.toString(array));
        Test14.reorderOddEven(array);
        System.out.println(Arrays.toString(array));
    }

}
