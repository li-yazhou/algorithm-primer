# 547. Friend Circles

<font color="red" size=10>TODO：</font>
对比2017-09-12去哪儿校招真题"六度人脉，最大的度"

2017-08


## Level

Medium


---


## [Friend Circles](https://leetcode.com/problems/friend-circles/)

There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in nature. For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C. And we defined a friend circle is a group of students who are direct or indirect friends.

Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not. And you have to output the total number of friend circles among all the students.

Example 1:
<pre>
Input: 
[[1,1,0],
 [1,1,0],
 [0,0,1]]
Output: 2
</pre>
Explanation:The 0th and 1st students are direct friends, so they are in a friend circle. 
The 2nd student himself is in a friend circle. So return 2.

Example 2:
<pre>
Input: 
[[1,1,0],
 [1,1,1],
 [0,1,1]]
Output: 1
</pre>
Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends, 
so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.
Note:
<pre>
N is in range [1,200].
M[i][i] = 1 for all students.
If M[i][j] = 1, then M[j][i] = 1.
</pre>


---


## Thought

深度优先搜索


---


## Solution

```
class Solution {
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int counter = 0;
        for (int i = 0; i < M.length; i ++){
            if (visited[i] == 0){
                dfs(M, i, visited);
                counter ++;
            }
        }
        return counter;
    }
    
    
    private void dfs(int[][] M, int i, int[] visited){
        for (int j = 0; j < M[i].length; j ++){
            // i 和 j 相连，而且j没有被访问过
            if (M[i][j] == 1 && visited[j] == 0){
                visited[j] = 1;
                dfs(M, j, visited);
            }    
        }
        
    }
}
```


---


**声明：题目来自Leetcode.**