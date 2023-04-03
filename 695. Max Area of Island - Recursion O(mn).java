class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maxArea = Math.max(maxArea, maxAreaOfIsland(grid, i, j));
            }
        }
        return maxArea;
    }

    public int maxAreaOfIsland(int[][] grid, int i, int j) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1) {
            grid[i][j] = 0;
            return 1 + maxAreaOfIsland(grid, i+1, j) + maxAreaOfIsland(grid, i, j+1) + maxAreaOfIsland(grid, i-1, j) + maxAreaOfIsland(grid, i, j-1);
        }
        return 0;
    }
}
