# 【Leetcode】002 Add Two Numbers

2017-08

## [题目](https://leetcode.com/problems/add-two-numbers/description/)
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8


## 思路
使用dummyHead避免写重复的代码，非常巧妙



## 实现

### Java实现
```
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers0(ListNode l1, ListNode l2) {
        int val = (l1.val + l2.val) % 10;
        int increment = (l1.val + l2.val) / 10;
        ListNode head = new ListNode(val);
        
        ListNode currNode = head;
        l1 = l1.next;
        l2 = l2.next;
        for (ListNode n1 = l1, n2 = l2; l1 != null && l2 != null; l1 = l1.next, l2 = l2.next){
            int result = l1.val + l2.val + increment;
            currNode.next = new ListNode(result % 10);
            increment = result / 10;
            currNode = currNode.next;
        }
        
        for (; l1 != null; l1 = l1.next){
            int result = l1.val + increment;
            currNode.next = new ListNode(result % 10);
            increment = result / 10;
            currNode = currNode.next;
        }
        
        for (; l2 != null; l2 = l2.next){
            int result = l2.val + increment;
            currNode.next = new ListNode(result % 10);
            increment = result / 10;
            currNode = currNode.next;
        }
        
        if (increment == 1){
            currNode.next = new ListNode(1);
        }
        return head;
    }
    
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);  // 第二个结点是链表的头结点
        int increment = 0;
        ListNode currNode = dummyHead;
        
        for (ListNode n1 = l1, n2 = l2; l1 != null || l2 != null;){
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
                        
            int result = x + y + increment;
            currNode.next = new ListNode(result % 10);
            increment = result / 10;
            currNode = currNode.next;
            
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        
        if (increment == 1){
            currNode.next = new ListNode(1);
        }
        
        return dummyHead.next;
    }
}
```


### Scala实现
```
/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
object Solution {
    def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
        
        var dummyNode = new ListNode(0)
        var currNode = dummyNode
        
        var currNodeA = l1
        var currNodeB = l2
        var increment = 0
        while (currNodeA != null || currNodeB != null) {
            val a = if (currNodeA != null) currNodeA.x else 0
            val b = if (currNodeB != null) currNodeB.x else 0
            val sum = a + b + increment
            val x = sum % 10
            increment = sum / 10
            currNode.next = new ListNode(x)
            currNode = currNode.next
            
            if (currNodeA != null) currNodeA = currNodeA.next
            if (currNodeB != null) currNodeB = currNodeB.next
        }
        if (increment == 1) {
            currNode.next = new ListNode(1)
        }
        return dummyNode.next
    }
}
```