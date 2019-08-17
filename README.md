# algorithm-primer

>
> algorithm primer - 算法基础、剑指offer 和 Leetcode 编程
>


# 目录
<!-- TOC -->
- 算法基础
	 - [排序算法](docs/algorithm-base-排序算法.md)
	 - [查找算法](docs/algorithm-base-查找算法.md)
	 - [树的前中后序递归与非递归遍历](docs/algorithm-base-树的递归与非递归遍历.md)
     - [树的层次遍历](docs/algorithm-base-树的层次遍历.md)
     - [图的深搜与广搜](docs/algorithm-base-图的深搜与广搜.md)
- 算法进阶
    * [LRU算法与实现](docs/LRU算法与实现.md)  
    * [一致性Hash算法介绍与实现](docs/一致性Hash算法介绍与实现.md)  
    * [限流算法之漏斗算法与令牌桶算法](docs/限流算法之漏斗算法与令牌桶算法.md)
- [剑指offer](#剑指offer)
- [Leetcode编程](#Leetcode编程)
- [参考](#参考)
<!-- /TOC -->


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


# Leetcode编程


## [Leetcode编程源码](leetcode)

>
> [Top 100 Liked Questions](leetcode/README.md)
>

## Top 100 Liked Questions

|  No  | Problem | Comment | Difficulty | Solution |
|------|---------|---------|------------|----------| 
|   x |  |  |  | [Java](top-100-liked-questions/00xx-) | 
|   1 | [Two Sum](https://leetcode.com/problems/two-sum/) |  | Easy | [Java](leetcode/top-100-liked-questions/0001-two-sum.md) | 
|   2 | [Add Two Numbers](https://leetcode.com/problems/add-two-numbers/description/) |  | Medium | [Java-Scala](leetcode/top-100-liked-questions/0002-add-two-numbers.md) | 
|   3 | [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-palindromic-substring)|  |  | [Java](leetcode/top-100-liked-questions/0003-longest-substring-without-repeating-characters.md) | 
|   5 | [Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring)|  |  | [Java](leetcode/top-100-liked-questions/0005-longest-palindromic-substring.md) | 
|  11 | [Container With Most Water](https://leetcode.com/problems/container-with-most-water) |  |  | [Java](leetcode/top-100-liked-questions/0011-container-with-most-water.md) | 
|  20 | [Valid Parentheses](https://leetcode.com/problems/valid-parentheses) |  |  | [Java](leetcode/top-100-liked-questions/0020-valid-parentheses.md) | 
|  21 | [Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists) |  |  | [Java](leetcode/top-100-liked-questions/0021-merge-two-sorted-lists.md) | 
|  22 | [Generate Parentheses](https://leetcode.com/problems/generate-parentheses) |  |  | [Java](leetcode/top-100-liked-questions/0022-generate-parentheses.md) | 
|  46 | [Permutations](https://leetcode.com/problems/permutations)|  |  | [Java](leetcode/top-100-liked-questions/0046-permutations.md) | 
|  53 | [Maximum Subarray](https://leetcode.com/problems/maximum-subarray) |  |  | [Java](leetcode/top-100-liked-questions/0053-maximum-subarray.md) | 
|  70 | [Climbing Stairs](https://leetcode.com/problems/climbing-stairs) |  |  | [Java](leetcode/top-100-liked-questions/0070-climbing-stairs.md) | 
|  94 | [Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal) |  |  | [Java](leetcode/top-100-liked-questions/0094-binary-tree-inorder-traversal.md) | 


## LeetCode List


---


# 参考
* 《剑指offer 第2版》
* [leetcode overview](https://leetcode.com/problemset/all/)
* [leetcode top-100-liked-questions](https://leetcode.com/problemset/top-100-liked-questions/)

