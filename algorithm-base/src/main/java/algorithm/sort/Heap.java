package algorithm.sort;



/**
 * description:
 *
 * @author liyazhou
 * @create 2017-06-22 10:04
 */


import java.util.Arrays;
import java.util.Random;

/**
 * algorithm: heap sort，堆排序
 *
 * algorithm thought:
 *
 * algorithm description:
 *
 * description:
 *
 *      创建最大堆：
 *          从最后一个非叶子结点到根结点（自底向上，这点非常关键）调整每一个子堆，使子堆有序化。
 *          最开始的子堆的根结点是最后一个非叶子结点，它有一个或者两个孩子，它与较大者交换位置即可实现子堆有序化。
 *          底部的子堆有序化，是其上面的堆进行调整的前提条件。
 *          也即是，如果子堆是无序的，那么包含它的一个更大的堆就无法进行调整操作，
 *          所以需要从最后一个非叶子结点到根结点（自底向上，这点非常关键）调整每一个子堆，使子堆有序化。。
 *
 *      调整最大堆（有序化堆）：（只有一个或者零个父结点相对孩子是无序）
 *          如果当前结点有孩子结点，
 *              如果当前结点的孩子结点的较大者比当前结点大，则交换两者位置，
 *              否则调整结束，退出，
 *              继续比较当前结点与其新的孩子结点
 *
 *       堆排序：
 *          1. 初始化最大堆（使堆有序化，可能所有的子堆都是无序的，需要调整所有的子堆）
 *          2. 将最大堆的第一个元素和最后一个元素交换位置；
 *             使堆的长度减 1；
 *             最大堆调整（使堆有序化，只有第一个元素相对于它的孩子是无序的，不断调整此元素和其后代的相对位置即可）；
 *             重复以上三步，直到堆的长度为 1。
 *
 *
 *      使用数组存储完全二叉树（堆），则结点下标关系是：
 *          父结点 i 的左子结点是 2 * i + 1；
 *          父结点 i 的右子结点是 2 * i + 2；
 *          子结点 i 的父结点是 floor((i-1)/2)
 *          最后一个非叶子结点是 floor(N/2)-1
 *
 *
 * expense: 时间复杂度 O(N*log(N))
 *
 * character:
 */
public class Heap {

    public static void sort (Comparable[] arr){
        if (arr == null || arr.length < 2) return;

        // 自底向上使每一个有孩子的结点都成为一个有序堆（宏观角度）
        for (int i = arr.length/2-1; i >= 0; i --)  // 完全二叉树中最后一个非叶子结点是 N/2-1
            maxHeapify(arr, i, arr.length);

        // 循环地将剩余的元素堆化
        // 下面的程序基础是，只有根结点相对孩子结点是无序的，也就只需要把该根结点移动到合适的位置即可
        for (int j = arr.length - 1; j > 0; j --) {
            swap(arr, 0, j);  // 将最大元素放在数组末尾，也就是堆首元素不断和堆尾元素交换位置，堆的大小减 1
            maxHeapify(arr, 0, j);  // 将去掉一个元素的新堆调整为最大堆（有序堆）
        }
    }


    /**
     * 从上到下有序化堆，使小于孩子的父结点下沉（sink）
     * 此时，根结点的左右子树都是最大堆，只有根结点相对于左右孩子结点是无序的，
     * 也就只需要把该根结点移动至合适的位置即可，因此不需要递归操作
     *
     * 过程：
     *      当前根结点是否有左孩子，则执行下面两个步骤：
     *          当前根结点与其左右孩子中的较大者交换位置；
     *          并将当前结点左右孩子的较大者设置为新的需要排序的根结点；
     *
     * @param arr 二叉堆
     * @param index 待调整的子堆的根结点
     * @param newSize 除了排序后的元素外，堆中剩余元素的个数
     */
    private static void maxHeapify (Comparable[] arr, int index, int newSize){
        while (2 * index + 1 < newSize){  // 当前结点至少有左孩子
            int childIdx = 2 * index + 1;  // index 左孩子的下标
            // 存在右孩子，且右孩子比左孩子更大，则记录右孩子的下标
            if (childIdx + 1 < newSize && arr[childIdx].compareTo(arr[childIdx+1]) < 0) childIdx ++;
            if (arr[childIdx].compareTo(arr[index]) <= 0) break;  // 两个孩子均小于等于当前元素，则退出循环
            swap(arr, index, childIdx);
            index = childIdx;  // 当前不断跟新的孩子比较，跟其中一个较大的孩子交换位置
        }
    }


    private static void swap(Comparable[] arr, int i, int j){
        Comparable tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }



    public void test(){
        Random random = new Random();
        int N = 20;
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i ++) arr[i] = random.nextInt(100);
        System.out.println(Arrays.toString(arr));
        Heap.sort(arr);
        System.out.println(Arrays.toString(arr));
    }




    public static void sort (Comparable[] arr, boolean isAsc){
        if (arr == null || arr.length < 2) return;
        if (isAsc) ascendSort(arr);
        else       descendSort(arr);

    }

    private static void ascendSort (Comparable[] arr){
    }

    private static void descendSort(Comparable[] arr){

    }
}
