# 463. Island Perimeter

2017-08


## Level

Easy


---


## [Island Perimeter](https://leetcode.com/problems/island-perimeter/description/)

You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water. Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

Example:

[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Answer: 16
Explanation: The perimeter is the 16 yellow stripes in the image below:
![这里写图片描述](https://imgconvert.csdnimg.cn/aHR0cDovL2ltZy5ibG9nLmNzZG4ubmV0LzIwMTcxMDE0MjEzOTM5MjM2)


---


## Thought

扩展边界


---


## Solution

```
class Solution {
    public int islandPerimeter(int[][] grid) {
        
        int[][] newGrid = new int[grid.length+2][grid[0].length+2];
        
        int perimeter = 0;
        
        for (int i = 0; i < grid.length; i ++){
            for (int j = 0; j < grid[0].length; j ++){
                newGrid[i+1][j+1] = grid[i][j];               
            }
        }
        
        for (int i = 1; i < newGrid.length-1; i ++){
            for (int j = 1; j < newGrid[0].length-1; j ++){
                if (newGrid[i][j] == 1){
                    if (newGrid[i-1][j] == 0) perimeter ++;  // 若1的上边是0，则周长加1
                    if (newGrid[i][j+1] == 0) perimeter ++;  // 若1的右边是0，则周长加1 
                    if (newGrid[i+1][j] == 0) perimeter ++;  // 若1的下边是0，则周长加1 
                    if (newGrid[i][j-1] == 0) perimeter ++;  // 若1的左边是0，则周长加1 
                }
            }
        }
        return perimeter;
    }
}
```


**声明：** 题目来源于Leetcode。