# 647. Palindromic Substrings

2017-08


## Level

Medium


---


## [Palindromic Substrings](https://leetcode.com/problems/palindromic-substrings/description/)

Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:
Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:
Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
Note:
The input string length won't exceed 1000.


---


## Thought

暴力验证


---


## Solution

```
class Solution {
    public int countSubstrings(String s) {
        int counter = 0;
        
        for (int i = 0; i < s.length(); i ++){
            for (int j = i+1; j < s.length()+1; j ++){
                String str = s.substring(i, j);
                if (isPalindromicString(str))
                    counter ++;
            }
        }
        return counter;
    }
    
    
    private boolean isPalindromicString(String s){
        if (s.length() == 1) return true;
        
        boolean bool = true;
        for (int i = 0; i < s.length()/2; i ++){
            if (s.charAt(i) != s.charAt(s.length()-1-i)){
                bool = false;
                break;
            }
        }
        return bool;
        
    }
}
```


---


**声明：题目来自Leetcode.**