# 169. Majority Element


2017-08


## Level

Easy


---


## [Majority Element](https://leetcode.com/problems/majority-element/description/)

Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.



---


## Thought

充分使用数据的特征


---


## Solution

```
class Solution {
    public int majorityElement(int[] nums) {
        int counter = 0;
        int curr = nums[0];
        for (int i = 0; i < nums.length; i ++){
            if (counter == 0) curr = nums[i];
            
            if (nums[i] == curr) counter ++;
            else{
                counter --;
                if (counter <= 0) counter = 0;
            }
        }
        return curr;
    }
}
```