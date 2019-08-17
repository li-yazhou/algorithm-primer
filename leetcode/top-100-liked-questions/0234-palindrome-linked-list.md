# 234. Palindrome Linked List

2017-08


## Level

Easy


---


## [Palindrome Linked List](https://leetcode.com/problems/palindrome-linked-list/description/)

Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?


---


## Thought

双指针找到链表的中间结点；
反转链表的后半部分；
比较链表的前半部分和“后半部分”。


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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        
        ListNode fast = head;
        ListNode slow = head;
        
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        // slow 是链表后半截的头指针
        if (fast != null) slow = slow.next;
        
        ListNode head1 = head;
        ListNode head2 = reverseList(slow); // 反转链表的后半截
        
        while (head1 != null && head2 != null){
            if (head1.val != head2.val) return false;
            
            head1 = head1.next;
            head2 = head2.next;
        }
        
        return true;
        
    }
    
    
    
    // 反转链表
    private ListNode reverseList(ListNode head){
        if (head == null || head.next == null) return head;
        
        ListNode first = head;
        ListNode second = head.next;
        first.next = null;  // 表示链表末尾
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


