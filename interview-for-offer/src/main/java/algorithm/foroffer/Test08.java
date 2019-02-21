package algorithm.foroffer;

import java.util.Arrays;

/**
 * Created by liyazhou on 2017/5/24.
 * 面试题 8：旋转数组的最小数字
 * 题目：
 *      把一个数组的最开始的若干元素搬到数组的末尾，我们称之为数组的旋转。
 *      输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 *      例如，数组 {3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 *
 * 思路：
 *      1. 二分查找（双指针，确定边界）
 *      2. 初始时，A 指针指向第一个元素，B 指针指向最后一个元素;
 *              两个指针分别从开头和末尾向中间移动，直到指向同一个位置
 *         两个指针所在的下标之和折半，
 *              若该元素大于 B 指针指向的元素，则该元素属于第一个递增子数组，
 *                  最小值位于折半位置和 B 指针之间，所以将 A 指向折半后的位置
 *              若该元素小于 B 指针指向的元素，则该元素属于第二个递增子数组，
 *                  最小值位于 A 指针和折半位置之间，所以将 B 指向折半后的位置
 *         当 A 指针和 B 指针位置相同时，它们指向的元素就是最小值
 *
 *
 * 思路2：
 *      1. 二分查找（双指针，确定边界）
 *      2. 初始时，A 指针指向第一个元素，B 指针指向最后一个元素;
 *              两个指针分别从开头和末尾向中间移动，直到指向同一个位置
 *         两个指针所在的下标之和折半得到指针 mid，
 *              若A、B 和 mid 三者指向的元素相等，
 *                  则无法判断 mid 指向的元素属于第一个还是第二个递增子数组，所以顺序查询最小元素
 *              若该元素大于等于 A 指针指向的元素，
 *                  则该元素属于第一个递增子数组，最小值位于折半位置和 B 指针之间，所以将 A 指向折半后的位置
 *              若该元素小于等于 B 指针指向的元素，
 *                  则该元素属于第二个递增子数组，最小值位于 A 指针和折半位置之间，所以将 B 指向折半后的位置
 *         当 A 指针和 B 指针位置相同时，它们指向的元素就是最小值
 */
public class Test08 {

    public int min(int[] array){
        // 判断输入
        if (array == null || array.length == 0) throw new RuntimeException("Invalid input.");

        int first = 0;
        int second = array.length-1;
        // 特殊情况：当第二递增子数组的长度为 0 时，不执行下面的程序，返回数组的第一个元素
        int mid = first;
        while(array[first] >= array[second]) {
            // 找到最小数字，记录位置，退出循环
            if (second - first <= 1){  // 等于 0 时，表示数组中只有一个元素
                mid = second;
                break;
                // return array[mid];
            }

            // 对 first 和 second 折半
            mid = (first + second) / 2;
            int midElement = array[mid];

            if (midElement == array[first] && midElement == array[second]){
                // 特殊情况，当折半后的下标和 A、B 指向的元素都相等时，
                // 无法判断该元素属于第一个还是第二个递增子数组，则顺序查找
                for(int i = first+1; i <= second; i++)
                    if (array[i-1] - array[i] > 0 ) {
                        return array[i];
                    }
            }

            if (midElement >= array[first]) first = mid;
            else if (midElement <= array[second]) second = mid;

            System.out.println(String.format("first = %d, second = %d", first, second));
        }
        return array[mid];
    }


    public static void main(String[] args){
         int[][] arrays = {
                            {3, 4, 5, 1, 2},  // 典型输入，单调升序的数组的旋转数组
                            {1, 0, 1, 1, 1},  // 折半后的指针指向的元素等于两个指针指向的元素，且该元素属于第二个递增子数组
                            {1, 1, 1, 0, 1},  // 折半后的指针指向的元素等于两个指针指向的元素，且该元素属于第一个递增子数组
                            {1, 2, 3, 4, 5},  // 第二个递增子数组的长度为 0
                            {3, 4, 5, 1, 1},  // 有重复元素
                            {2},              // 只有一个数字
                            // null,             // 数组为 null
                          };

        for (int i = 0; i < arrays.length; i++){
            int[] array = arrays[i];
            Test08 test = new Test08();
            int min = test.min(array);
            System.out.println(String.format("array = %s, min = %d", Arrays.toString(array), min));
        }
    }
}
