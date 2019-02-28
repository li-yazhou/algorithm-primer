package algorithm.search;


/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-14 8:15
 */
public class BinSearch {

    /**
     * 二分查找，折半查找
     * @param arr 有序数组
     * @param key 关键字
     * @return 关键字在数组中的下标
     */
    public int search(int[] arr, int key){
        int low = 0;
        int high = arr.length-1;
        while(low <= high){
            int mid = (low + high) / 2;
            if (arr[mid] == key) return mid;
            else if (arr[mid] < key) low = mid + 1;
            else if (arr[mid] > key) high = mid - 1;
        }
        return -1;
    }

    public void searchTest(){
        int[] arr = new int[20];
        for (int i = 0; i < 20; i ++)
            arr[i] = i;
        int index = search(arr, 10);
        System.out.println(index);
    }
}
