package algorithm.sort;


import java.util.Arrays;
import java.util.Random;

/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-20 10:49
 */

/**
 * algorithm: insertion sort，插入排序
 *
 * description:
 *      一个形象生动的比喻：一张一张地整理扑克牌，将每一张牌插入到已经整理好的扑克中
 *
 *      依次插入元素，每次插入新的元素后，保持已插入元素的顺序性。
 *      怎么保证已插入元素的顺序性呢？
 *          从右向左的方向和已排序数组比较，如果当前元素比它小，则交换两者，
 *          直到当前元素位于第一个位置或者是前面没有比其更大的元素。
 *
 *      优化，减少元素交换的次数
 *          在已排序的元素中从右向左找到第一个等于或者小于当前元素的位置，
 *          将位于它后面而且是已排序的元素依次往后移动一位，并将当前元素插入它的后面即可。
 *
 * expense: 时间复杂度 O(n^2)
 *
 * character:
 *      插入排序所需的时间取决于数组中元素的初始顺序。
 *      适用场景，当数组是部分有序的时候，插入排序效率会有明显提升。
 */
public class Insertion {

    public static void sort(Comparable[] arr){
        for (int i = 0; i < arr.length; i ++){
            for (int j = i; j > 0 && arr[j].compareTo(arr[j-1]) < 0; j --){
                Comparable tmp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = tmp;
            }
        }
    }

    public static void sort2(Comparable[] arr){
        for (int i = 0; i < arr.length; i ++){
            Comparable newEle = arr[i];
            int j = i-1;
            // 从右向左找到第一个小于或者等于当前值的元素，找到返回其下标
            // 边界问题（如果已插入的所有元素均比当前值大，则 j = -1；如果已插入的所有元素均比当前值小，j = i-1）
            for (; j >= 0 && arr[j].compareTo(newEle) > 0; j --)
                arr[j+1] = arr[j];  // 将这些较大的元素依次向右移动
            arr[j+1] = newEle;  // 将新元素插入其从右边起第一个比其小的元素后面即可
        }
    }


    /**
     * 直接插入排序
     * 熟练精确记住这个算法，并和shell排序算法对比
     * @param arr 数组
     */
    public static void insertSort(Integer[] arr){
        if (arr == null || arr.length == 0) return;
        for (int i = 1; i < arr.length; i ++){
            int idx = i;   // 暂时保存新插入元素的下标
            int val = arr[i];  // 暂时保存新插入的元素
            for (int j = i-1; j >= 0; j--){
                if (arr[j] > val){
                    arr[j+1] = arr[j];
                    idx = j;
                }
            }
            if (idx != i) arr[idx] = val;
        }
    }

    public void test(){
        int N = 20;
        Integer[] arr = new Integer[N];
        Random random = new Random();
        for (int i = 0; i < N; i ++) arr[i] = random.nextInt(100);
        System.out.println(Arrays.toString(arr));
        Insertion.sort2(arr);
        System.out.println(Arrays.toString(arr));
        Insertion.insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
