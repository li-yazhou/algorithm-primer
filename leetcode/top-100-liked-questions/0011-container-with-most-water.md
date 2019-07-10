# 【LeetCode】011 Container With Most Water

2017-08

## [题目](https://leetcode.com/problems/container-with-most-water/description/)
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.


----------


## 思路
蛮力法，超时。

另外一种方法：
我们认为长度越长且高度越大，则面积越大。
现在，使用两个指针分别指向首、尾，这时它的宽度是最大的。
可能还会出现面积更大的情况，只有当高度变大的时候，所以可以移动两个指针中的较小者，这样可以能会使高度增加以弥补长度变短造成面积减少的损失。
一直移动两者中较小者，直到两者相遇，取各种情况的最大值即是最后的结果。


----------


## AC

```
class Solution {
    // time out
    public int maxArea0(int[] height) {
        int maximum = 0;
        for (int i = 0; i < height.length-1; i ++){
            for (int j = i+1; j < height.length; j ++){
                int area = calArea(i, height[i], j, height[j]);
                if (area > maximum) maximum = area;
            }
        }
        return maximum;
    }
    
    
    public int maxArea(int[] height){
        int maxarea = 0;
        int l = 0, r = height.length-1;
        while(l < r){
            int area = calArea(l, height[l], r, height[r]);
            if (area > maxarea) maxarea = area;
            
            if (height[l] <= height[r]) l ++;
            else                        r --;
        }
        return maxarea;
    }
    
    
    private int calArea(int i, int h1, int j, int h2){
        return  Math.min(h1, h2) * (j-i);
    }
}
```