package algorithm.sort;


/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-09 8:18
 */
public class Sort {

    //================================插入类排序================================
    // 直接插入排序、希尔排序
    /**
     * 直接插入排序，Straight Insertion Sort
     * @param arr 待排序的数组
     */
    public static void straightInsertionSort(int[] arr){
        if (arr == null || arr.length == 0) return;
        for (int i = 1; i < arr.length; i ++){
            int idx = i;  // 新插入元素的位置
            int newEle = arr[i];  // 新插入的元素
            for (int j = i-1; j >= 0; j --){
                if (arr[j] > newEle) {
                    arr[j+1] = arr[j];
                    idx = j;
                }
            }
            if (idx != i) arr[idx] = newEle;
        }
    }


    /**
     * 希尔排序，直接插入排序的改进版本
     * 与直接插入排序统一书写格式
     * @param arr 数组
     */
    public static void shellSort(int[] arr){
        if (arr == null || arr.length == 0) return;
        int increment = arr.length;
        do {
            increment = increment / 3 + 1;   // 本轮循环的增量，使小组内更加有序
            for (int i = increment; i < arr.length; i ++){
                Integer newEle = arr[i];
                int idx = i;
                for (int j = i - increment; j >= 0; j -= increment){  // 增量是 increment, 区别于直接插入排序的增量 1
                    if (arr[j] > newEle){
                        arr[j + increment] = arr[j];
                        idx = j;
                    }
                }
                if (idx != i) arr[idx] = newEle;
            }
        } while(increment > 1);
    }


    //================================选择类排序================================
    // 简单选择排序、堆排序


    /**
     * 简单选择排序
     *   使用数组存储完全二叉树（堆），则结点下标关系是：
     *   父结点 i 的左子结点是 2 * i + 1；
     *   父结点 i 的右子结点是 2 * i + 2；
     *   子结点 i 的父结点是 floor((i-1)/2)
     *
     * @param arr 数组
     */
    public static void simpleSelectionSort(int[] arr){
        for (int i = 0; i < arr.length; i ++){
            int minIdx = i;  // 剩余元素中最小者的下标
            for (int j = i + 1; j < arr.length; j ++){
                if (arr[j] < arr[minIdx])
                    minIdx = j;
            }
            if (minIdx != i){  // 找到剩余元素中的最小者，将其与当前元素交换位置
                int tmp = arr[i];
                arr[i] = arr[minIdx];
                arr[minIdx] = tmp;
            }
        }
    }


    /**
     * 堆排序
     *
     * @param arr 数组
     */
    public static void heapSort (int[] arr){
        if (arr == null || arr.length < 2) return;

        // 自底向上使每一个有孩子的结点都成为一个有序堆（宏观角度）
        for (int i = arr.length/2-1; i >= 0; i --)  // 完全二叉树中最后一个非叶子结点是 N/2-1
            maxHeapify(arr, i, arr.length);

        // 循环地将剩余的元素堆化
        // 下面的程序基础是，只有根结点相对孩子结点是无序的，也就只需要把该根结点移动到合适的位置即可
        for (int j = arr.length - 1; j > 0; j --) {
            swap(arr, 0, j);  // 堆首元素不断和堆尾元素交换位置，堆的大小减 1
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
    private static void maxHeapify (int[] arr, int index, int newSize){
        while (2 * index + 1 < newSize){  // 当前结点至少有左孩子
            int childIdx = 2 * index + 1;  // index 左孩子的下标
            // 存在右孩子，且右孩子比左孩子更大，则记录右孩子的下标
            if (childIdx + 1 < newSize && arr[childIdx] < arr[childIdx+1]) childIdx ++;
            if (arr[childIdx] <= arr[index]) break;  // 两个孩子均小于等于当前元素，则退出循环
            swap(arr, index, childIdx);
            index = childIdx;  // 当前不断跟新的孩子比较，跟其中一个较大的孩子交换位置
        }
    }

    private static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    //================================交换类排序================================
    // 冒泡排序、快速排序

    /**
     * 冒泡排序
     * 第二层循环，从后往前进行，注意边界
     * @param arr 数组
     */
    public static void bubbleSort(int[] arr){
        if (arr == null || arr.length == 0) return;
        for (int i = 0; i < arr.length; i ++){
            for (int j = arr.length-1; j > i; j --){
                if (arr[j] < arr[j-1]){
                    int tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                }
            }
        }
    }


    /**
     *  1. 从待排序的数列中选择一个元素，作为基准元素（pivot），也称为切分元素，通常选择第一个元素或者最后一个元素
     *  2. 对数列排序，所有比基准值小的元素摆放在基准前面，所有比基准值大的元素摆放在基准后面（相等的元素可以放到任意一边）。
     *         该基准就处于两部分的中间位置。这个称为分区（partition）操作。
     *  3. 然后，分别对基准元素左右两部分用同样的方法继续进行排序，直到整个序列有序（递归 recursive）。
     * @param arr 数组
     * @param low 区间的左边界，包含
     * @param high 区间的右边界，包含
     */
    public static void quickSort(int[] arr, int low, int high){
        if (low < high){
            // 调用一趟快速排序，以切分元素（枢轴元素 pivot）为界划分两个子表
            int pos = partition(arr, low, high);
            quickSort(arr, low, pos-1);  // 对左部子表快速排序
            quickSort(arr, pos+1, high);  // 对右部子表快速排序
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int key = arr[low];
        while (low < high){
            // 从右到左找一个比切分元素key小的元素
            for (; low < high && arr[high] >= (key); high --);
            // 若找到一个比切分元素小的元素，则将它放置在低位，此时高位出生产一个空位
            // 低位处的初始值是切分元素，之后低位处是一个空位
            if (low < high) {
                arr[low] = arr[high];
                low ++;
            }

            // 从左到右找一个比切分元素大的元素
            for (; low < high && arr[low] <= key; low ++);
            // 若找到一个比切分元素大的元素，则将它放置在高位，此时低位产生一个空位
            if (low < high){
                arr[high] = arr[low];
                high --;
            }
        }
        arr[low] = key;  // 将切分元素放置在空位
        return low;
    }



    //================================归并排序================================

    public static void mergeSort(int[] arr){
        if (arr == null || arr.length < 2) return;
        int[] aux = new int[arr.length];  // 归并排序所需要的辅助空间
        mergeSort(arr, 0, arr.length-1, aux);
    }

    private static void mergeSort(int[] arr, int low, int high, int[] aux) {
        if (low >= high) return;
        int mid = low + (high - low)/2;
        mergeSort(arr, low, mid, aux);           // 将左部区间排序
        mergeSort(arr, mid+1, high, aux);        // 将右部区间排序
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
    private static void merge(int[] arr, int low, int mid, int high, int[] aux) {
        int i = low;
        int j = mid + 1;

        for (int k = low; k <= high; k ++) aux[k] = arr[k];

        int k = low;
        while (i <= mid && j <= high){
            if (aux[i] < aux[j]) arr[k++] = aux[i++];
            else                 arr[k++] = aux[j++];
        }

        while (i <= mid) arr[k++] = aux[i++];
        while (j <= high) arr[k++] = aux[j++];
    }



}
