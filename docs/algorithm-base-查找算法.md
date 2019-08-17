# 查询算法

## 折半查找
二分查找，也称为折半查找

```
/**
 * 二分查找，折半查找
 * @param arr 有序数组
 * @param key 关键字
 * @return 关键字在数组中的下标
 */
public int binsearch(int[] arr, int key){
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
```


---


## 参考
* [1] [算法-4](https://algs4.cs.princeton.edu/home/)