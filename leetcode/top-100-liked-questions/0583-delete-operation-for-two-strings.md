# 583. Delete Operation for Two Strings

2017-08


## Level

Medium


---


## [Delete Operation for Two Strings](https://leetcode.com/problems/delete-operation-for-two-strings/description/)

Given two words word1 and word2, find the minimum number of steps required to make word1 and word2 the same, where in each step you can delete one character in either string.

Example 1:
Input: "sea", "eat"
Output: 2
Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
Note:
The length of given words won't exceed 500.
Characters in given words can only be lower-case letters.


---


## Thought

最长公共子序列，Longest Common Subsequence，LCS，
参考[最长公共子序列](http://blog.csdn.net/liyazhou0215/article/details/78252909)。


---


## Solution

```
class Solution {
    
    // 最长公共子序列，LCS
    public int minDistance(String word1, String word2) {
                
        int W = word1.length() + 1;
        int H = word2.length() + 1;
        
        int[][] states = new int[H][W];
        
        for (int i = 1; i < H; i ++){
            char ch1 = word2.charAt(i-1);
            for (int j = 1; j < W; j ++){
                char ch2 = word1.charAt(j-1);
                if (ch1 == ch2) states[i][j] = states[i-1][j-1] + 1;
                else            states[i][j] = Math.max(states[i][j-1], states[i-1][j]);
            }
        }
        
        int maxLen = 0;
        for (int i = 0; i < H; i ++){
            for (int j = 0; j < W; j ++){
                maxLen = Math.max(maxLen, states[i][j]);
            }
        }
        
        return word1.length()+word2.length()-maxLen*2;
    }
}
```


---


**声明：题目来自Leetcode.**