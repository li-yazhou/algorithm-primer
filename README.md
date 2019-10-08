# algorithm-primer

>
> algorithm primer - 算法基础、Leetcode 编程、剑指offer
>


# 目录
<!-- TOC -->
- 算法基础
- 算法进阶
- [Leetcode编程](#Leetcode编程)
    * [Leetcode编程源码](leetcode/src/main/java/leetcode)  
    * [Top 100 Liked Questions](#Top-100-Liked-Questions)  
    * [Leetcode Category](#Leetcode-Category) 
        * [Array](#Array) 
        * [Tree](#Tree) 
        * [DFS](#DFS) 
    * [Leetcode Difficulty](#Leetcode-Difficulty) 
        * [Leetcode Easy List](#Leetcode-Easy-List)
        * [Leetcode Medium List](#Leetcode-Medium-List)
        * [Leetcode Hard List](#Leetcode-Hard-List)
- [剑指offer](#剑指offer)
- 编程之美 
- 编程珠玑
- 算法第四版
- 算法导论第三版
- [参考](#参考)
<!-- /TOC -->


---


# Leetcode编程

## [Leetcode编程源码](leetcode/src/main/java/leetcode)
## [Leetcode Markdown](leetcode/top-100-liked-questions/)


## Top 100 Liked Questions

|  No  | Problem | Solution | Category | Difficulty |
|------|---------|----------|----------|------------|
|   1 | Two Sum | [Java](leetcode/src/main/java/leetcode/_0001_TwoSum.java) | Array | Easy |
|   2 | Add Two Numbers | [Java](leetcode/src/main/java/leetcode/_0002_AddTwoNumbers.java) |  | Medium |
|   3 | Longest Substring Without Repeating Characters | [Java](leetcode/src/main/java/leetcode/_0003_LongestSubstringWithoutRepeatingCharacters.java) |  | Medium |
|   5 | Longest Palindromic Substring | [Java](leetcode/src/main/java/leetcode/_0005_LongestPalindromicSubstring.java) |  | Medium |
|  11 | Container With Most Water | [Java](leetcode/src/main/java/leetcode/_0011_ContainerWithMostWater.java) |  | Medium |
|  15 | 3Sum | [Java](leetcode/src/main/java/leetcode/_0015_3Sum.java) |  | Medium |
|  17 | Letter Combinations of a Phone Number | [Java](leetcode/src/main/java/leetcode/_0017_LetterCombinationsOfAPhoneNumber.java) |  | Medium |
|  19 | Remove Nth Node From End of List | [Java](leetcode/src/main/java/leetcode/_0019_RemoveNthNodeFromEndOfList.java) |  | Medium |
|  20 | Valid Parentheses | [Java](leetcode/src/main/java/leetcode/_0020_ValidParentheses.java) |  | Easy | 
|  21 | [Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists) | [Java](leetcode/top-100-liked-questions/0021-merge-two-sorted-lists.md) |  | Easy | 
|  22 | [Generate Parentheses](https://leetcode.com/problems/generate-parentheses) | [Java](leetcode/top-100-liked-questions/0022-generate-parentheses.md) |  | Medium | 
|  34 | Find First and Last Position of Element in Sorted Array | [Java](leetcode/src/main/java/leetcode/_0034_FirstAndLastPositionOfElementInSortedArray.java) | Array | Medium |
|  46 | [Permutations](https://leetcode.com/problems/permutations) | [Java](leetcode/top-100-liked-questions/0046-permutations.md) |  |  Medium |
|  53 | [Maximum Subarray](https://leetcode.com/problems/maximum-subarray) | [Java](leetcode/top-100-liked-questions/0053-maximum-subarray.md) |  |  Easy |
|  56 | Merge Intervals | [Java](leetcode/src/main/java/leetcode/_0056_MergeIntervals.java) | Array | Medium |
|  62 | Unique Paths | [Java](leetcode/src/main/java/leetcode/_0062_UniquePaths.java) | Array, DP | Medium |
|  62 | Minimum Path Sum | [Java](leetcode/src/main/java/leetcode/_0064_MinimumPathSum.java) | Array, DP | Medium |
|  70 | [Climbing Stairs](https://leetcode.com/problems/climbing-stairs) | [Java](leetcode/top-100-liked-questions/0070-climbing-stairs.md) |  | Medium |
|  75 | Sort Colors | [Java](leetcode/src/main/java/leetcode/_0075_SortColors.java) | Array, 3 Pointers | Medium |
|  79 | Word Search | [Java](leetcode/src/main/java/leetcode/_0079_WordSearch.java) | DFS, Backtrack | Medium |
|  94 | Binary Tree Inorder | [Java](leetcode/src/main/java/leetcode/_0094_BinaryTreeInorderTraversal.java) | BinaryTree | Medium | 
|  96 | Unique Binary Search Trees | [Java](leetcode/src/main/java/leetcode/_0096_UniqueBinarySearchTrees.java) | Dynamic Program | Medium | 
|  98 | Validate Binary Search Tree | [Java](leetcode/src/main/java/leetcode/_0098_ValidateBinarySearchTree.java) | BinaryTree | Medium | 
| 101 | [Symmetric Tree](https://leetcode.com/problems/symmetric-tree/description/) | [Java](leetcode/top-100-liked-questions/0101-symmetric-tree.md) |  | Easy | 
| 102 | Binary Tree Level Order Traversal | [Java](leetcode/src/main/java/leetcode/_0102_BinaryTreeLevelOrderTraversal.java) | BinaryTree, Queue | Medium | 
| 104 | [Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree/description/) | [Java](leetcode/top-100-liked-questions/0104-maximum-depth-of-binary-tree.md) |  | Easy | 
| 110 | [Balanced Binary Tree](https://leetcode.com/problems/balanced-binary-tree/) | [Java](leetcode/top-100-liked-questions/0110-balanced-binary-tree.md) |  | Easy | 
| 114 | Flatten Binary Tree to Linked List | [Java](leetcode/src/main/java/leetcode/_0114_FlattenBinaryTreeToLinkedList.java) | BinaryTree, LinkedList | Medium | 
| 111 | [Minimum Depth of Binary Tree](https://leetcode.com/problems/minimum-depth-of-binary-tree/description/) | [Java](leetcode/top-100-liked-questions/0111-minimum-depth-of-binary-tree.md) |  | Easy | 
| 121 | [Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/) | [Java](leetcode/top-100-liked-questions/0121-best-time-to-buy-and-sell-stock.md) |  | Easy |  
| 124 | Binary Tree Maximum Path Sum | [Java](leetcode/src/main/java/leetcode/_0124_BinaryTreeMaximumPathSum.java) | DFS |  Hard |  
| 136 | [Single Number](https://leetcode.com/problems/single-number/description/)  | [Java](leetcode/top-100-liked-questions/0136-single-number.md) |  | Easy |  
| 139 | Word Break | [Java](leetcode/src/main/java/leetcode/_0139_WordBreak.java) | DFS, DP |  Medium |  
| 141 | Linked List Cycle | [Java](leetcode/src/main/java/leetcode/_0141_LinkedListCycle.java) | LinkedList, Pointers |  Easy |  
| 142 | Linked List Cycle II | [Java](leetcode/src/main/java/leetcode/_0142_LinkedListCycleII.java) | LinkedList, Pointers |  Medium |  
| 146 | LRU Cache | [Java](leetcode/src/main/java/leetcode/_0146_LRUCache.java) | Map, DoubleLinkedList | Medium |  
| 148 | Sort List | [Java](leetcode/src/main/java/leetcode/_0148_SortList.java) | Sort LinkedList | Medium |  
| 150 | [Evaluate Reverse Polish Notation](https://leetcode.com/problems/evaluate-reverse-polish-notation/description/) | [Java](leetcode/top-100-liked-questions/0150-evaluate-reverse-polish-notation.md) |  | Medium | 
| 152 | Maximum Product Subarray | [Java](leetcode/src/main/java/leetcode/_0152_MaximumProductSubarray.java) | DP, Array | Medium | 
| 155 | [Min Stack](https://leetcode.com/problems/min-stack/description/) | [Java](leetcode/top-100-liked-questions/0155-min-stack.md) |  | Easy | 
| 160 | [Intersection of Two Linked Lists](https://leetcode.com/problems/intersection-of-two-linked-lists/) | [Java](leetcode/top-100-liked-questions/0160-intersection-of-two-linked-lists.md) |  | Easy | 
| 169 | [Majority Element](https://leetcode.com/problems/majority-element/description/) | [Java](leetcode/top-100-liked-questions/0169-majority-element.md) |  | Easy | 
| 198 | [House Robber](https://leetcode.com/problems/house-robber/description/) | [Java](leetcode/top-100-liked-questions/0198-house-robber.md) |  | Easy | 
| 200 | Number of Islands | [Java](leetcode/src/main/java/leetcode/_0200_NumberOfIslands.java) | DFS, Marking | Medium | 
| 206 | [Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/description/) | [Java](leetcode/top-100-liked-questions/0206-reverse-linked-list.md) |  | Easy | 
| 207 | Course Schedule | [Java](leetcode/src/main/java/leetcode/_0207_CourseSchedule.java) | Topology Sort, Queue, Matrix, Array | Medium | 
| 208 | Implement Trie (Prefix Tree) | [Java](leetcode/src/main/java/leetcode/_0208_ImplementTrie.java) | Mutil-way Search Tree | Medium | 
| 215 | Kth Largest Element in an Array | [Java](leetcode/src/main/java/leetcode/_0215_KthLargestElementInAnArray.java) | Quick-Sort, PriorityQueue, Sort | Medium | 
| 221 | Maximal Square | [Java](leetcode/src/main/java/leetcode/_0221_MaximalSquare.java) | DP | Medium | 
| 226 | [Invert Binary Tree](https://leetcode.com/problems/invert-binary-tree/) | [Java](leetcode/top-100-liked-questions/0226-invert-binary-tree.md) |  | Easy | 
| 234 | [Palindrome Linked List](https://leetcode.com/problems/palindrome-linked-list/description/) | [Java](leetcode/top-100-liked-questions/0234-palindrome-linked-list.md) |  | Easy | 
| 236 | Lowest Common Ancestor of a Binary Tree | [Java](leetcode/src/main/java/leetcode/_0236_LowestCommonAncestorOfABinaryTree.java) | BinaryTree Traversal, BinaryTree Path | Medium | 
| 238 | Product of Array Except Self | [Java](leetcode/src/main/java/leetcode/_0238_ProductOfArrayExceptSelf.java)  |  | Medium | 
| 240 | Search a 2D Matrix II | [Java](leetcode/src/main/java/leetcode/_0240_SearchA2DMatrixII.java) |  | Medium | 
| 253 | **Meeting Rooms II** | [Java](leetcode/src/main/java/leetcode/_0253_MeetingRoomsII.java) |  | Medium | 
| 279 | Perfect Squares | [Java](leetcode/src/main/java/leetcode/_0279_PerfectSquares.java) | DP, Backtrack | Medium | 
| 283 | [Move Zeroes](https://leetcode.com/problems/move-zeroes/description/) | [Java](leetcode/top-100-liked-questions/0283-move-zeroes.md) |  | Easy |  |
| 287 | Find the Duplicate Number | [Java](leetcode/src/main/java/leetcode/_0287_FindTheDuplicateNumber.java) | Sort, Double-Pointers | Medium | 
| 300 | Longest Increasing Subsequence | [Java](leetcode/src/main/java/leetcode/_0300_LongestIncreasingSubsequence.java) | DP, DFS | Medium | 
| 309 | Best Time to Buy and Sell Stock with Cooldown | [Java](leetcode/src/main/java/leetcode/_0309_BestTimeToBuyAndSellStockWithCooldown.java) | DP | Medium | 
| 322 | Coin Change | [Java](leetcode/src/main/java/leetcode/_0322_CoinChange.java) | DP, DFS | Medium | 
| 337 | House Robber III | [Java](leetcode/src/main/java/leetcode/_0337_HouseRobberIII.java) | DFS, Tree DP | Medium | 
| 338 | [Counting Bits](https://leetcode.com/problems/counting-bits/description/) | [Java](leetcode/top-100-liked-questions/0338-counting-bits.md) |  | Medium |  |
| 347 | Top K Frequent Elements | [Java](leetcode/src/main/java/leetcode/_0347_TopKFrequentElements.java) | Heap, KV Sort, Bucket Sort | Medium | 
| 394 | Decode String | [Java](leetcode/src/main/java/leetcode/_0394_DecodeString.java) | Double Stack, DFS | Medium | 
| 399 | Evaluate Division | [Java](leetcode/src/main/java/leetcode/_0399_EvaluateDivision.java) | Graph | Medium | 
| 406 | Queue Reconstruction by Height | [Java](leetcode/src/main/java/leetcode/_0406_QueueReconstructionByHeight.java) | Sort | Medium | 
| 448 | [Find All Numbers Disappeared in an Array](https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/discuss/) | [Java](leetcode/top-100-liked-questions/0448-find-all-numbers-disappeared-in-an-array.md) |  | Easy |
| 463 | [Island Perimeter](https://leetcode.com/problems/island-perimeter/description/) | [Java](leetcode/top-100-liked-questions/0463-island-perimeter.md) |  | Easy |
| 494 | Target Sum | [Java](leetcode/src/main/java/leetcode/_0494_TargetSum.java) |  | Medium |
| 543 | [Diameter of Binary Tree](https://leetcode.com/problems/diameter-of-binary-tree/) | [Java](leetcode/top-100-liked-questions/0543-diameter-of-binary-tree.md) |  | Easy | 
| 547 | [Friend Circles](https://leetcode.com/problems/friend-circles/) | [Java](leetcode/top-100-liked-questions/0547-friend-circles.md) |  | Medium | 
| 572 | [Subtree of Another Tree](https://leetcode.com/problems/subtree-of-another-tree/description/) | [Java](leetcode/top-100-liked-questions/0572-subtree-of-another-tree.md) |  | Easy |
| 581 | [Shortest Unsorted Continuous Subarray](https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/) | [Java](leetcode/top-100-liked-questions/0581-shortest-unsorted-continuous-subarray.md) |  | Easy |
| 583 | [Delete Operation for Two Strings](https://leetcode.com/problems/delete-operation-for-two-strings/description/) | [Java](leetcode/top-100-liked-questions/0583-delete-operation-for-two-strings.md) |  |  Medium | 
| 617 | [Merge Two Binary Trees](https://leetcode.com/problems/merge-two-binary-trees/description/) | [Java](leetcode/top-100-liked-questions/0617-merge-two-binary-trees.md) |  |  Easy |
| 647 | Palindromic Substrings | [Java](leetcode/src/main/java/leetcode/_0647_PalindromicSubstrings.java) |  |  Medium |


Note: 

    着重体的问题表示未开放。
    

---


## Leetcode Category
### Array
|  No  | Problem | Solution | Category | Difficulty |
|------|---------|----------|----------|------------|


### Dynamic Program
|  No  | Problem | Solution | Category | Difficulty |
|------|---------|----------|----------|------------|


### Tree
|  No  | Problem | Solution | Category | Difficulty |
|------|---------|----------|----------|------------|
| 257 | Binary Tree Paths | [Java](leetcode/src/main/java/leetcode/_0257_BinaryTreePaths.java)  | Tree | Easy |


### DFS
|  No  | Problem | Solution | Category | Difficulty |
|------|---------|----------|----------|------------|


---


## Leetcode Difficulty

### Leetcode Easy List
|  No  | Problem | Solution | Category | Difficulty |
|------|---------|----------|----------|------------|
| 257 | Binary Tree Paths | [Java](leetcode/src/main/java/leetcode/_0257_BinaryTreePaths.java)  | Tree | Easy |


### Leetcode Medium List
|  No  | Problem | Solution | Category | Difficulty |
|------|---------|----------|----------|------------|


### Leetcode Hard List
|  No  | Problem | Solution | Category | Difficulty |
|------|---------|----------|----------|------------|


---


# 剑指offer

> 
> [剑指offer编程题汇总](interview-for-offer)
> 
> [剑指offer编程题目录](interview-for-offer/README.md)
> 
> [剑指offer编程题汇总--Java实现](interview-for-offer/md/剑指offer面试题汇总.md)
>
> [《剑指offer》编程题 Java 代码](https://github.com/li-yazhou/algorithm-primer/tree/master/interview-for-offer/src/main/java/algorithm/foroffer)
> 
> [《剑指offer》编程题 Markdown 版本，包含题目、分析及代码](https://github.com/li-yazhou/algorithm-primer/tree/master/interview-for-offer/md)
>


|  No  | Problem & Solution |
| --- | --- |
|  2  | [实现单例模式](interview-for-offer/md/002-单例模式.md) |
|  3  | [二维数组中的查找](interview-for-offer/md/003-二维数组中的查找.md) |
|  4  | [替换空格](interview-for-offer/md/004-替换空格.md) |
|  5  | [从尾到头打印链表](interview-for-offer/md/005-从头到尾打印链表.md) |
|  6  | [重建二叉树2](interview-for-offer/md/006-重建二叉树.md) |
|  7  | [用两个栈实现队列](interview-for-offer/md/007-用两个栈实现队列.md) |
|  8  | [旋转数组的最小数字](interview-for-offer/md/008-旋转数组的最小数字.md) |
|  9  | [斐波那契数列/青蛙跳台阶/矩形覆盖/变态跳台阶](interview-for-offer/md/009-斐波那契数列-青蛙跳台阶-矩形覆盖-变态跳台阶.md) |
|  10 | [二进制中 1 的个数](interview-for-offer/md/010-二进制中1的个数.md) |
|  11 | [数值的整数次方](interview-for-offer/md/011-数值的整数次方.md) |
|  12 | [打印 1 到最大的 n 位整数](interview-for-offer/md/012-打印1到最大的n位整数.md) |
|  13 | [在 o(1) 时间删除链表结点](interview-for-offer/md/013-在o(1)时间删除链表结点.md)  |
|  14 | [调整数组顺序使奇数位于偶数前面](interview-for-offer/md/014-调整数组顺序使奇数位于偶数前面.md) |
|  15 | [链表中倒数第 k 个节点](interview-for-offer/md/015-链表中倒数第k个结点.md) |
|  16 | [反转链表](interview-for-offer/md/016-反转链表.md) |
|  17 | [合并两个排序的链表](interview-for-offer/md/017-合并两个排序的链表.md) |
|  18 | [树的子结构](interview-for-offer/md/018-树的子结构.md) |
|  19 | [二叉树的镜像](interview-for-offer/md/019-二叉树的镜像.md) |
|  20 | [顺时针打印矩阵](interview-for-offer/md/020-顺时针打印矩阵.md) |
|  21 | [包含 min 函数的栈](interview-for-offer/md/021-包含min函数的栈.md) |
|  22 | [栈的压入、弹出序列](interview-for-offer/md/022-栈的压入和弹出序列.md) |
|  23 | [从上到下打印二叉树](interview-for-offer/md/023-从上到下打印二叉树.md) |
|  24 | [二叉搜索树的后序遍历序列](interview-for-offer/md/024-二叉搜索树的后序遍历序列.md) |
|  25 | [二叉树中和为某一值的路径](interview-for-offer/md/025-二叉树中和为某一值的路径.md) |
|  26 | [复杂链表的复制](interview-for-offer/md/026-复杂链表的复制.md) |
|  27 | [二叉搜索树与双向链表](interview-for-offer/md/027-二叉搜索树与双向链表.md) |
|  28 | [字符串的排列](interview-for-offer/md/028-字符串的排列.md) |
|  29 | [数组中出现次数超过一半的数字](interview-for-offer/md/029-数组中出现次数超过一半的数字.md) |
|  30 | [最小的 k 个数](interview-for-offer/md/030-最小的k个数.md) |
|  31 | [连续子数组的最大和](interview-for-offer/md/031-连续子数组的最大和.md) |
|  32 | [从 1 到 n 整数中 1 出现的次数](interview-for-offer/md/032-从1到n整数中1出现的次数.md) |
|  33 | [把数组排成最小的数](interview-for-offer/md/033-把数组排成最小的数.md) |
|  34 | [丑数](interview-for-offer/md/034-丑数.md) |
|  35 | [第一个只出现一次的字符](interview-for-offer/md/035-第一个只出现一次的字符.md) |
|  36 | [数组中的逆数对](interview-for-offer/md/036-数组中的逆数对.md) |
|  37 | [两个链表的第一个公共结点](interview-for-offer/md/037-两个链表的第一个公共结点.md) |
|  38 | [数字在排序数组中出现的次数](interview-for-offer/md/038-数字在排序数组中出现的次数.md) |
|  39 | [二叉树的深度](interview-for-offer/md/039-二叉树的深度.md) |
|  40 | [数组中只出现一次的数字](interview-for-offer/md/040-数组中只出现一次的数字.md) |
|  41 | [和为 s 的两个数字 VS 和为 s 的连续正数序列](interview-for-offer/md/041-和为s的两个数字VS和为s的连续正数序列.md) |
|  42 | [翻转单词顺序 VS 左旋转字符串](interview-for-offer/md/042-翻转单词顺序VS左旋转字符串.md) |
|  43 | [n 个骰子的点数]() |
|  44 | [扑克牌的顺子](interview-for-offer/md/044-扑克牌的顺子.md) |
|  45 | [圆圈中最后剩下的数字](interview-for-offer/md/045-圆圈中最后剩下的数字.md) |
|  46 | [求前 n 项正整数的和（不能使用乘除法以及for、while、if 等关键字）](interview-for-offer/md/046-不使用乘除与判断求前N项正整数的和.md) |
|  47 | [不用加减乘除做加法](interview-for-offer/md/047-不用加减乘除做加法.md) |
|  48 | [不能被继承的类](interview-for-offer/md/048-不能被继承的类.md) |
|  49 | [把字符串转换成整数](interview-for-offer/md/049-把字符串转换成整数.md) |
|  50 | [树中两个结点的最低公共祖先结点](interview-for-offer/md/050-树中两个结点的最低公共祖先结点.md) |
|  51 | [数组中重复的数字](interview-for-offer/md/051-数组中重复的数字.md) |
|  52 | [构建乘积数组](interview-for-offer/md/052-构建乘积数组.md) |
|  53 | 正则表达式匹配 |
|  54 | 表示数值的字符串 |
|  55 | [字符流中第一个不重复的字符](interview-for-offer/md/055-字符流中第一个不重复的字符.md) |
|  56 | [链表中环的入口结点](interview-for-offer/md/056-链表中环的入口结点.md) |
|  57 | [删除链表中重复的结点](interview-for-offer/md/057-删除链表中重复的结点.md) |
|  58 | [二叉树的下一个结点](interview-for-offer/md/058-二叉树的下一个结点.md) |
|  59 | [对称的二叉树](interview-for-offer/md/059-对称的二叉树.md) |
|  60 | [把二叉树打印成多行](interview-for-offer/md/060-把二叉树打印成多行.md) |
|  61 | [按之字形顺序打印二叉树](interview-for-offer/md/061-按之字形顺序打印二叉树.md) |
|  62 | [序列化二叉树](interview-for-offer/md/062-序列化和反序列化二叉树.md) |
|  63 | [二叉搜索树的第k个结点](interview-for-offer/md/063-二叉搜索树的第k个结点.md) |
|  64 | [数据流中的中位数](interview-for-offer/md/064-数据流中的中位数.md) |
|  65 | [滑动窗口的最大值](interview-for-offer/md/065-滑动窗口的最大值.md) |
|  66 | 矩阵中的路径 |
|  67 | 机器人的运动范围 |


--- 


# 参考
* [leetcode overview](https://leetcode.com/problemset/all/)
* 《剑指offer 第2版》
* 《编程之美》
* 《编程珠玑》
* 《算法第四版》
* 《算法导论第三版》
