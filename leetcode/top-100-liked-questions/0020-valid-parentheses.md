# 【Leetcode-Easy-20】 Valid Parentheses

2017-08

## [题目](https://leetcode.com/problems/valid-parentheses/description/)

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.


## 思路

栈


## 程序

```
class Solution {
    public boolean isValid(String s) {
        LinkedList<String> stack  = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        set.add("(");
        set.add("[");
        set.add("{");
        for (int i = 0; i < s.length(); i ++){
            String part = s.charAt(i) + "";
            if (set.contains(part)) stack.push(part);
            else{
                if (stack.isEmpty()) return false;
                String prepart = stack.pop();
                if ("}".equals(part) && !"{".equals(prepart) ||
                    ")".equals(part) && !"(".equals(prepart) ||
                    "]".equals(part) && !"[".equals(prepart)){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
```


----------

更为巧妙的解法

```
public boolean isValid(String s) {
	Stack<Character> stack = new Stack<Character>();
	for (char c : s.toCharArray()) {
		if (c == '(')
			stack.push(')');
		else if (c == '{')
			stack.push('}');
		else if (c == '[')
			stack.push(']');
		else if (stack.isEmpty() || stack.pop() != c)
			return false;
	}
	return stack.isEmpty();
}
```


----------