# 448. Find All Numbers Disappeared in an Array

2017-08


## Level

Easy


---



## [Find All Numbers Disappeared in an Array](https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/discuss/)

Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]


---


## Thought

充分使用数组长度和数组元素大小的关系，数组元素可以作为数组的下标使用
      
      The basic idea is that we iterate through the input array and mark elements as negative using nums[nums[i] -1] = -nums[nums[i]-1].
      In this way all the numbers that we have seen will be marked as negative.
      In the second iteration, if a value is not marked as negative, it implies we have never seen that index before, 
      so just add it to the return list.

![这里写图片描述](https://imgconvert.csdnimg.cn/aHR0cDovL2ltZy5ibG9nLmNzZG4ubmV0LzIwMTcxMDE4MDg0NDQxMzg5)


---


## Solution

```
class Solution {
    
    
    /**
      充分使用数组长度和数组元素大小的关系，数组元素可以作为数组的下标使用
      
      The basic idea is that we iterate through the input array and mark elements as negative using nums[nums[i] -1] = -nums[nums[i]-1].
      In this way all the numbers that we have seen will be marked as negative.
      In the second iteration, if a value is not marked as negative, it implies we have never seen that index before, 
      so just add it to the return list.
    */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i ++){
            int index = Math.abs(nums[i]) - 1;  // 元素关联的下标
            if (nums[index] > 0)  nums[index] = -nums[index]; // 元素标记下标对应数字是否出现
        }
        for (int j = 0; j < nums.length; j ++){
            if (nums[j] > 0) list.add(j+1);
        }
        return list;
    }
}
```
