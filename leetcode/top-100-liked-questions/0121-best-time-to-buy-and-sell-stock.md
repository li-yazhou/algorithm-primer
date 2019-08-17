# 121. Best Time to Buy and Sell Stock

2017-08


## Level
Easy


---


## [Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/)
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Example 1:
Input: [7, 1, 5, 3, 6, 4]
Output: 5

max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
Example 2:
Input: [7, 6, 4, 3, 1]
Output: 0

In this case, no transaction is done, i.e. max profit = 0.


---


## Thought

找出截止当前位置的最小值和截至当前位置的最大值，
记录两者之差，保留最大的差值。

---


## Solution

```
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int profit = 0;
        int low = prices[0];
        for (int i = 0; i < prices.length; i ++){
            low = Math.min(low, prices[i]);
            profit = Math.max(profit, prices[i]-low);
        }
        return profit;
    }
}
```

---


**声明：题目来自Leetcode.**