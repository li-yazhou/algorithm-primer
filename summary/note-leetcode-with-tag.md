# Leetcode Tags


> Author: liyazhou
>
> Github: li-yazhou
>
> Repo: https://github.com/li-yazhou/algorithm-primer


## 目录
* [数组与矩阵](#)
* [链表](#链表)
* [栈与队列](#)
* [字符串]()
* [哈希表](#哈希表)
* [树](#)
  * [二叉树]()
  * [二叉搜索树]()
* [图](#)
* [位运算]()
* [排序]()
* [二分查找]()
* [双指针]()
* [贪心]()
* [分治]()
* [搜索](#)
  * [BFS]()
  * [DFS]()
  * [BackTracking]()
* [动态规划](#)



## 数组与矩阵


## 链表


## 哈希表
* [0001 两数之和](#0001-两数之和)

#### 0001 两数之和
```java
/**
 * @level       Easy
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class _0001_TwoSum {
    private static class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i ++){
                int remainder = target - nums[i];
                if(map.containsKey(nums[i]))
                    return new int[]{map.get(nums[i]), i};
                map.put(remainder, i);
            }
            throw new IllegalArgumentException("no solution.");
        }
    }
}
```


