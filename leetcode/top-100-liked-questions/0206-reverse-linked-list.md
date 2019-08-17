# 206. Reverse Linked List


2017-08


## Level

Easy


---


## [Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/description/)

Reverse a singly linked list.


---


## Thought

双指针


---


## Solution
```
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode first = head;
        first.next = null;
        ListNode second = head.next;
        
        while (second != null){
            ListNode tempNode = second.next;
            second.next = first;
            first = second;
            second = tempNode;
        }
        return first;
    }
}
```