# 141. Linked List Cycle

2017-08


## Level

Easy


---


## [Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/description/)

Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?


---


## Thought

快指针和慢指针


---


## Solution

```
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode quick = head;
        ListNode slow = head;
        
        while (quick != null && slow != null){
            if (quick.next != null) quick = quick.next.next;
            else                    return false;
            slow = slow.next;
            if (quick == slow) return true;
        }
        
        return false;
    }
}
```

