# 338. Counting Bits

2017-08


## Level

Medium


---


## [Counting Bits](https://leetcode.com/problems/counting-bits/description/)

Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Example:
For num = 5 you should return [0,1,1,2,1,2].

Follow up:

It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
Space complexity should be O(n).
Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
Credits:
Special thanks to @ syedee for adding this problem and creating all test cases.


---


## Thought

发现规律：
An easy recurrence for this problem is f[i] = f[i / 2] + i % 2.


---


## Solution

```
/**

An easy recurrence for this problem is f[i] = f[i / 2] + i % 2.

i % 2 == (i & 1), true

*/

class Solution {
    public int[] countBits(int num) {
        int[] result = new int[num+1];
        for (int i = 1; i <= num; i ++)
            result[i] = result[i/2] + i % 2;
        return result;
    }
}
```
