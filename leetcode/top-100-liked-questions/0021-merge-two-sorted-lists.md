# 【Leetcode-Easy-21】Merge Two Sorted Lists

2017-08

## [题目](https://leetcode.com/problems/merge-two-sorted-lists/description/)

Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.


## 思路
巧用头结点（哑结点）

## 程序

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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode currNode = dummyHead;
        
        
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                currNode.next = l1;
                l1 = l1.next;
            }else{
                currNode.next = l2;
                l2 = l2.next;
            }
            currNode = currNode.next;
        }
        
        if (l1 != null) currNode.next = l1;
        if (l2 != null) currNode.next = l2;
        
        return dummyHead.next;
    }
}
```


----------


**声明：题目来自Leetcode.**