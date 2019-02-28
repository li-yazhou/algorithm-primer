package algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-20 12:55
 */


/**
 * algorithm: shell sort，希尔排序，也成为缩减增量排序算法，递减增量排序算法
 *
 *
 * algorithm description:
 *      1、先取一个小于n的整数d1作为第一个增量，把文件的全部记录分成d1个组。
 *      2、所有距离为d1的倍数的记录放在同一个组中，在各组内进行直接插入排序。
 *      3、取第二个增量d2<d1重复上述的分组和排序，
 *      4、直至所取的增量dt=1(dt<dt-l<…<d2<d1)，即所有记录放在同一组中进行直接插入排序为止。
 *
 *
 * description:
 *      在数组内的元素基本有序的情况下，直接插入排序是非常高效的。
 *      而希尔排序就是通过对局部数据使用直接插入排序而创造出数组基本有序的条件，之后对数组整体进行直接插入排序。
 *
 *      希尔排序的做法是，
 *          将数组间隔为increment的元素分别划分到若干个小组，对每一个小组进行直接插入排序（每一小组的数据量较小，操作代价更小）；
 *          不断地减小间隔，将数组划分为更多个小组，继续对每一个小组进行直接插入排序（可以使近邻的元素基本有序）；
 *          最后，将数组划分为 N 个小组，也即是对全体元素进行一次直接插入排序。
 *          （最后一步，数组已经基本有序，就对数组直接插入排序）
 *
 *      解释它的做法，
 *          希尔排序的思想是使数组中任意间隔为 increment 元素都是有序的。
 *          对间隔为increment的元素进行直接插入排序，可以使一个元素一次性地朝着最终位置前进一大步。
 *          缩小间隔 increment，可以使任意一个局部的元素都是基本有序的。
 *          当数组基本有序时，对全体元素进行直接插入排序。
 *
 * expense: 时间复杂度 O(n^(3/2))
 *
 * character:
 */
public class Shell {
    public static void sort(Comparable[] arr){
        int increment = arr.length;
        do{
            increment = increment/3 + 1;  // 当前的增量，保证最小增量是 1
            // 每次为一个分组添加一个的新的元素，直到把所有的元素添加到各个分组中
            for (int i = increment; i < arr.length; i ++){
                Comparable newEle = arr[i];  // 待插入的新元素，下面的操作是找到合适的位置
                int j = i-increment;  // 组内的已排序的最后一个元素
                // 小组内新添加了一个元素，对其进行插入排序
                // 分组内所有比新元素大的元素依次向后移动increment位
                for (; j >= 0 && arr[j].compareTo(newEle) > 0; j -= increment) // 对每一个小组，组内插入排序
                    arr[j+increment] = arr[j];  // 组内右边的元素较当前元素大，则一次往后移动一位
                arr[j+increment] = newEle;  // 把新元素插入到合适的位置
            }
        } while (increment > 1);  // 增量increment = 1时，是对全体基本有序的数组进行插入排序，之后停止循环
    }


    /**
     * 希尔排序，直接插入排序的改进版本
     * 与直接插入排序统一书写格式
     * @param arr 数组
     */
    public static void shellSort(Integer[] arr){
        if (arr == null || arr.length == 0) return;
        int increment = arr.length;
        do {
            increment = increment / 3 + 1;   // 本轮循环的增量，使小组内更加有序
            for (int i = increment; i < arr.length; i ++){
                Integer newEle = arr[i];
                int idx = i;
                for (int j = i - increment; j >= 0; j -= increment){
                    if (arr[j] > newEle){
                        arr[j + increment] = arr[j];
                        idx = j;
                    }
                }
                if (idx != i) arr[idx] = newEle;
            }
        } while(increment > 1);
    }


    public void test(){
        int N = 30;
        Integer[] arr = new Integer[N];
        Random random = new Random();
        for (int i = 0; i < N; i ++) arr[i] = random.nextInt(100);
        System.out.println(Arrays.toString(arr));
        Shell.sort(arr);
        System.out.println(Arrays.toString(arr));
        Shell.shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
