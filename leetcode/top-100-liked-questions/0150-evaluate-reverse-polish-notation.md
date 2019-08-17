# 150. Evaluate Reverse Polish Notation

2017-08


## Level

Medium


---


## [Evaluate Reverse Polish Notation](https://leetcode.com/problems/evaluate-reverse-polish-notation/description/)

Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6


---


## Thought

栈


---


## Solution

```
import java.util.*;
class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) 
            throw new RuntimeException("illegal argument exception.");
        LinkedList<Integer> stack = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        
        for (String token : tokens){
            if (set.contains(token)){
                int num2 = Integer.valueOf(stack.pop());
                int num1 = Integer.valueOf(stack.pop());
                switch(token){
                    case "+" : 
                        stack.push(num1 + num2); 
                        break;
                    case "-" :
                        stack.push(num1 - num2);
                        break;
                    case "*" : 
                        stack.push(num1 * num2); 
                        break;
                    case "/" :
                        stack.push(num1 / num2);
                        break;
                }
            }else{
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.peek();
    }
}
```