# 581. Shortest Unsorted Continuous Subarray

2017-08


## Level

Easy


---


## [Shortest Unsorted Continuous Subarray](https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/)

Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

You need to find the shortest such subarray and output its length.

Example 1:
Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
Note:
Then length of the input array is in range [1, 10,000].
The input array may contain duplicates, so ascending order here means <=.


---


## Thought

发现规律：
起始点的特征，右边存在小于其的元素；
终止点的特征，左边存在大于其的元素。


---


## Solution

```
class Solution {
    
    // [2, 6, 4, 8, 10, 9, 15]
    // [6, 4, 8, 10, 9] 
    // 起始点的特征，右边存在小于其的元素；
    // 终止点的特征，左边存在大于其的元素。
    
    
    public int findUnsortedSubarray(int[] nums) {
        
        int start = 0;
        int end = 0;
        
        int max = nums[0];  // 当前元素左边范围内的最大值，从前面往后面查找起始元素
        int min = nums[nums.length-1];  // 从后面往前查找终止元素
        
        
        // 从左往右遍历，如果A[i]小于左边所有元素的最大值，则其可能是右边界
        for (int i = 1; i < nums.length; i ++){
            max = Math.max(max, nums[i]);
            if (nums[i] < max) end = i;
        }
        
        
        // 从右往左遍历，如果A[j]大于右边所有元素的最小值，则其可能是左边界
        for (int j = nums.length-2; j >= 0; j --){
            min = Math.min(min, nums[j]);
            if (nums[j] > min) start = j;
        }
        
        return end == 0 ? 0 : end - start + 1;
    }
    
    
 
    // Time Limit Exceeded
    public int findUnsortedSubarray01(int[] nums) {
        
        int start = 0;
        int end = 0;
        
        outer:for (int i = 0; i < nums.length; i ++){
            for (int j = i+1; j < nums.length; j ++){
                if (nums[i] > nums[j]){  // 如果后面存在元素小于当前元素，则该元素需要排序
                    start = i;
                    break outer;
                } 
            }
        }
        
        
        for (int i = start; i < nums.length; i ++){
            for (int j = i+1; j < nums.length; j ++){
                if (nums[i] > nums[j]){  // 如果后面存在元素小于当前元素，则该元素需要排序
                    end = Math.max(end, j);
                } 
            }
        }
        
        return end == 0 ? 0 : end - start + 1;
    }
    
}
```


---


**声明：题目来自Leetcode.**