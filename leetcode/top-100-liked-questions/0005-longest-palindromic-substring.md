#【LeetCode】005 Longest Palindromic Substring 最长的回文子字符串

2017-08


## [题目](https://leetcode.com/problems/longest-palindromic-substring/description/)
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example:

Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.
Example:

Input: "cbbd"

Output: "bb"


----------


## 思路


----------


## AC

```
class Solution {
    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length()-1; i ++){
            int len1 = expandAroundCenter(s, i, i);  // 假设回文字符串的长度是奇数
            int len2 = expandAroundCenter(s, i, i+1);  // 假设回文字符串的长度是偶数
            int len = Math.max(len1, len2);
			// 边界判断
            if (len > end-start){
                start = i - (len-1)/2;  // 计算新的边界
                end = i + len/2;
            }
        }
        return s.substring(start, end+1);
        
    }
    
    // 从left,right向左右扩展
    // 双参数真是很巧妙，一直卡在这里了
    private int expandAroundCenter(String s, int left, int right){
        int L = left, R = right;
        for (; L >= 0 && R < s.length(); L --, R ++){
            if (s.charAt(L) != s.charAt(R)) 
                break;
        }
        return R-L-1;  // 根据example判断是否减去1
    }
}
```