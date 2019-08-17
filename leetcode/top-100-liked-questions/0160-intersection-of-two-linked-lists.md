# 160. Intersection of Two Linked Lists

2017-08


## Level

Easy


---


## [Intersection of Two Linked Lists](https://leetcode.com/problems/intersection-of-two-linked-lists/)
Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:
<pre>

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
</pre>
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
Credits:
Special thanks to @stellari for adding this problem and creating all test cases.




---


## Thought

链表的双指针应用。

参考，一个链表的倒数第K个结点。

计算两条链表的长度；
使用两个指针“右对齐”两个链表；
查找相同的结点。


---


## Solution

```
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = lenOfLinkedList(headA);
        int len2 = lenOfLinkedList(headB);
        
        
        // "右对齐"两条链表
        int diff = len1 - len2;
        if (diff < 0){
            diff = - diff;
            while (diff > 0){
                headB = headB.next;
                diff --;
            }
        }else{
            while (diff > 0){
                headA = headA.next;
                diff --;
            } 
        }
        
        
        // 查找两条链表的公共节点
        while (headA != null && headB != null){
            if (headA == headB){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
        
    }
    
    private int lenOfLinkedList(ListNode head){
        int len = 0;
        while (head != null){
            len ++;
            head = head.next;
        }
        return len;
    }
}
```

