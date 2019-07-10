# 【LeetCode】003 Longest Substring Without Repeating Characters

2017-08


## [题目](https://leetcode.com/problems/longest-substring-without-repeating-characters/description/)

Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.


----------


## 思路


----------


## AC

```
import java.util.*;
public class Solution {
    // 超时，不通过
    public int lengthOfLongestSubstring0(String s) {
        int maxLen = 0;
        List<Character> subList = new ArrayList<>();
        for (int i = 0; i < s.length(); i ++){
            char ch = s.charAt(i);
            int index = subList.indexOf(ch);
            if (index != -1){
                if (maxLen < subList.size()) maxLen = subList.size();
                if (index == subList.size()-1) subList.clear(); 
                else                           subList = subList.subList(index+1, subList.size());
            }
            
            subList.add(ch);
        }
        if (maxLen < subList.size()) maxLen = subList.size();
        return maxLen;
    }
    
    
    
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        StringBuilder sub = new StringBuilder(s.length());
        int fromIndex = 0;
        
        for (int i = 0; i < s.length(); i ++){
            char ch = s.charAt(i);
            
            int index = sub.indexOf(ch+"", fromIndex);  // 重复“字符”（字符串）的位置 
            
            if (index != -1) fromIndex = index+1;  // 不断调整起始下标
            
            sub.append(ch);
            
            int len = sub.length() - fromIndex;  // 总长度 - 起始下标 = 当前子字符串的长度
            
            if (maxLen < len) maxLen = len;
        }
        
        return maxLen;
    }
}
```