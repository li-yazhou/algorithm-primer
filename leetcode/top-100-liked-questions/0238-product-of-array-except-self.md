# 238. Product of Array Except Self

2017-08


## Level

Easy


---


## [Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/description/)

Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)


---


## Thought

寻找规律：
将每因子分为两种部分，左半部分和右半部分。
先计算左半部分的乘积，把结果存储到返回值中；
然后循环计算右半部分的乘积，不需要额外的存储空间。


---


## Solution

```
class Solution {
    /*
    [1, 2, 3, 4]
    
    [-, 2, 3 ,4]
    [1, -, 3, 4]
    [1, 2, -, 4]
    [1, 2, 3, -]
    
    */
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        
        res[0] = 1;
        for (int i = 1; i < nums.length; i ++){
            res[i] = res[i-1] * nums[i-1];
        }
        
        int mul = 1;
        for (int j = nums.length-1; j > 0; j --){
            mul *= nums[j];
            res[j-1] *= mul;
        }
        
        return res;
    }
}
```


**声明：题目来自Leetcode.**