class Solution {
    public int minPathSum(int[][] grid) {
        //logic is - for every cell, it can be reached only from top or left, since movement is only down and right
        //hence, we can update minimum values to reach each cell in first row and column by adding from left and up respectively
        //once we have that, traverse from 1,1 to m-1,n-1 -> updating value as grid[i][j] + min(top, left)
        //then return grid[m-1][n-1] as the answer
        int m = grid.length;
        int n = grid[0].length;
        
        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i-1][0];
        }

        for (int j = 1; j < n; j++) {
            grid[0][j] += grid[0][j-1];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }

        return grid[m-1][n-1];
    }
}

