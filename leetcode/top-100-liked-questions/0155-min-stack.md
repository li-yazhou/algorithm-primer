# 155. Min Stack

2017-08


## Level

Easy


---


## [Min Stack](https://leetcode.com/problems/min-stack/description/)

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.


Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.


---


## Thought

双栈


---


## Solution

```
class MinStack {

    private LinkedList<Integer> dataStack = null;
    private LinkedList<Integer> minStack = null; 
    
    /** initialize your data structure here. */
    public MinStack() {
        dataStack = new LinkedList<>();
        minStack = new LinkedList<>();
    }
    
    public void push(int x) {
        dataStack.push(x);
        if (minStack.isEmpty()) minStack.push(x);
        else                    minStack.push(Math.min(minStack.peek(), x));
    }
    
    public void pop() {
        if(!minStack.isEmpty()) minStack.pop();
        if(!dataStack.isEmpty()) dataStack.pop();
    }
    
    public int top() {
        return dataStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
```


---


**声明：题目来自Leetcode.**
