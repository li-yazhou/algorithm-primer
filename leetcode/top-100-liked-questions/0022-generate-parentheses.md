# 【Leetcode-Medium-22】Generate Parentheses

2017-08

## [题目](https://leetcode.com/problems/generate-parentheses/discuss/)

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]


## [思路](https://leetcode.com/problems/generate-parentheses/discuss/)

    backtracking solution，回溯
    
    The idea here is to only add '(' and ')' that we know will guarantee us a solution (instead of adding 1 too many close).
    Once we add a '(' we will then discard it and try a ')' which can only close a valid '('. 
    Each of these steps are recursively called.

![这里写图片描述](https://imgconvert.csdnimg.cn/aHR0cDovL2ltZy5ibG9nLmNzZG4ubmV0LzIwMTcxMDIxMTk0ODAzODQ3)



## 程序

```
import java.util.*;
class Solution {
    
    /**
    backtracking solution，回溯
    
    The idea here is to only add '(' and ')' that we know will guarantee us a solution (instead of adding 1 too many close).
    Once we add a '(' we will then discard it and try a ')' which can only close a valid '('. 
    Each of these steps are recursively called.
    
    
    */
    
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list, "", 0, 0, n);
        return list;
    }
    
    
    private void backtrack(List<String> list, String str, int open, int close, int max){
        if (str.length() == 2*max){
            list.add(str);
            return;
        }
        
        if (open < max)
            backtrack(list, str+"(", open+1, close, max);
        
        if (close < open)
            backtrack(list, str+")", open, close+1, max);
    }
    
    
    //------------------------------------------------

    
    // Time limit exceeded
    /*
    思路：
        排列组合出所有的字符串
        验证每一个字符串是否合格
    */
    
    public List<String> generateParenthesis0(int n) {
        char[] chs = new char[n*2];
        for (int i = 0; i < n; i ++){
            chs[i] = '(';
            chs[n+i] = ')';
        }
        
        Set<String> set = new HashSet<>();
        permutate(chs, 0, set);
        
        return new ArrayList<String>(set);
    }
    
    
    
    // 字符串全排列
    private void permutate(char[] chs, int start, Set<String> set){
        if (start == chs.length){
            boolean bool = validate(chs);
            if (bool)
                set.add(new String(chs));
                
        }
        
        for (int i = start; i < chs.length; i ++){
            char temp = chs[start];
            chs[start] = chs[i];
            chs[i] = temp;
            
            permutate(chs, start+1, set);
            
            temp = chs[start];
            chs[start] = chs[i];
            chs[i] = temp;
        }
    }
    
    
    private boolean validate(char[] chs){
        LinkedList<Character> stack = new LinkedList<>();
        for (char ch : chs){
            if (ch == ')') {
                if (stack.isEmpty() || stack.pop() != '(') return false;
            } else {
                stack.push(ch);
            }
        }
        
        return stack.isEmpty();
    }   
}
```


----------


**声明：题目来自Leetcode.**