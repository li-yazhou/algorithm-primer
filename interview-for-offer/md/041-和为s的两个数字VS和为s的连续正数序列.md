## 面试题41 和为 s 的两个数字 VS 和为 s 的连续正数序列


>题目一：
     输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得他们的和正好是 s。
     如果有多对数字的和等于 s， 输出任意一对即可。
     例如，输入数组 {1, 2, 4, 7, 11, 15}和数字15，输出 4,7。
>
>题目二：
     输入一个正数 s，打印出所有和为 s 的连续正数序列（至少含有两个数）。
     例如输入 15，由于 1+2+3+4+5 = 4+5+6 = 7+8 = 15，
     所以结果打印出3个连续序列 1~5、4~6 和 7~8。

```
package algorithm.foroffer.top50;

import org.junit.Test;

import java.util.Arrays;

/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-01 21:19
 *
 * 面试题41：和为 s 的两个数字 VS 和为 s 的连续正数序列
 *
 * 题目一：
 *      输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得他们的和正好是 s。
 *      如果有多对数字的和等于 s， 输出任意一对即可。
 *      例如，输入数组 {1, 2, 4, 7, 11, 15}和数字15，输出 4,7。
 *
 * 考查点：
 *      1. 二叉查找的思想（对于排序数组，首先要想到二分查找，使用两个指针不断缩小范围）
 *
 * 思路：
 *      1. 使用两个指针，分别指向查找范围的最小值 min 和最大值 max
 *      2. 如果 min + max < sum，则 min 向后移动一位
 *         如果 min + max > sum，则 max 向前移动一位
 *         如果 min + max == sum，则输出 min, max，停止循环
 *
 *
 * 题目二：
 *      输入一个正数 s，打印出所有和为 s 的连续正数序列（至少含有两个数）。
 *      例如输入 15，由于 1+2+3+4+5 = 4+5+6 = 7+8 = 15，
 *      所以结果打印出3个连续序列 1~5、4~6 和 7~8。
 *
 * 考查点：
 *      1. 找规律
 *
 * 思路：
 *      1. 连续的数字序列之和正好，则返回该序列
 *         连续的数字序列之和较小，则从后面添加数字
 *         连续的数字序列之和较大，则从前面删除数字，
 *         （每添加一个较大的数字，可以能会删除若干个较小的数字，需要使用循环）
 *         循环条件是，最小值的下标minIdx小于 (sum+1)/2
 *
 */
public class Test41 {

    /**
     * 在数组 array 中查找一对和为 sum 的数字
     * @param array 数组
     * @param sum 两个数字之和
     * @return 如果存在，返回这对数字；不存在，返回 null
     */
    public int[] findTwoNum(int[] array, int sum){
        if (array == null || array.length < 2)  return null;

        int minIdx = 0;
        int maxIdx = array.length-1;

        while (minIdx < maxIdx){
            if (array[minIdx] + array[maxIdx] == sum)       return new int[]{array[minIdx], array[maxIdx]};
            else if (array[minIdx] + array[maxIdx] < sum)   minIdx ++;
            else                                            maxIdx --;
        }
        return null; // 违背单一出口原则，但是这种写法简洁，是适合刷题的写法
    }

    @Test
    public void test11(){
        int[][] arrs = {
                {1, 2, 4, 7, 11, 15},
        };

        int[] result = findTwoNum(arrs[0], 109);
        System.out.println(Arrays.toString(result));
    }


    public void findContinuousSequence(int sum){
        if (sum < 3) return;

        int small = 1;
        int big = 2;
        int middle = (sum + 1) / 2;
        int currSum = small + big;
        while (small < middle){
            if (currSum == sum) printSequence(small, big+1);

            // 每添加一个较大的数字，可以能会删除若干个较小的数字
            while (currSum > sum && small < middle){
                currSum -= small;
                small ++;
                if (currSum == sum) printSequence(small, big+1);
            }

            big ++;
            currSum += big;
        }
    }

    private void printSequence(int start, int end) {
        for (int i = start; i < end; i ++)
            System.out.print(i + "\t");
        System.out.println();
    }

    @Test
    public void test21(){
        findContinuousSequence(4);
    }

}

```