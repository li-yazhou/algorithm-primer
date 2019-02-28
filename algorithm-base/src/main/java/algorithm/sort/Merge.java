package algorithm.sort;


import java.util.Arrays;
import java.util.Random;

/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-21 14:41
 */


/**
 * algorithm: merge sort，归并排序
 *
 * algorithm thought:
 *      归并排序的基本思想基于合并，将两个或两个以上有序表合并成一个新的有序表。
 *
 * algorithm description:
 *
 * description:
 *
 * expense: 时间复杂度 O(N*log(N))
 *
 * character:
 */
public class Merge {

    public static void sort(Comparable[] arr){
        if (arr == null || arr.length < 2) return;
        Comparable[] aux = new Comparable[arr.length];  // 归并排序所需要的辅助空间
        sort(arr, 0, arr.length-1, aux);
    }

    private static void sort(Comparable[] arr, int low, int high, Comparable[] aux) {
        if (low >= high) return;
        int mid = low + (high - low)/2;
        sort(arr, low, mid, aux);           // 将左部区间排序
        sort(arr, mid+1, high, aux);        // 将右部区间排序
        merge(arr, low, mid, high, aux);    // 归并左右两部分区间的结果
    }

    /**
     * 合并位于 [low, mid] 和 [mid+1, high] 这两段闭区间内的元素
     * 每一个区间的内部都是有序的
     * @param arr 序列
     * @param low 开始索引
     * @param mid 中间索引，属于前半部分
     * @param high 末尾索引
     * @param aux 辅助空间
     */
    private static void merge(Comparable[] arr, int low, int mid, int high, Comparable[] aux) {
        int i = low;
        int j = mid + 1;

        for (int k = low; k <= high; k ++) aux[k] = arr[k];

        int k = low;
        while (i <= mid && j <= high){
            if (aux[i].compareTo(aux[j]) < 0) arr[k++] = aux[i++];
            else                              arr[k++] = aux[j++];
        }

        while (i <= mid) arr[k++] = aux[i++];
        while (j <= high) arr[k++] = aux[j++];
    }

    public void test(){
        Random random = new Random();
        int N = 20;
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i ++) arr[i] = random.nextInt(100);
        System.out.println(Arrays.toString(arr));
        Merge.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
