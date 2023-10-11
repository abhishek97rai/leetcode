class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> resList = new ArrayList<>();
        int r = heights.length;
        int c = heights[0].length;
        boolean[][] pacificVisited = new boolean[r][c];
        boolean[][] atlanticVisited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            dfs(heights, pacificVisited, Integer.MIN_VALUE, i, 0);
            dfs(heights, atlanticVisited, Integer.MIN_VALUE, i, c-1);
        }
        for (int j = 0; j < c; j++) {
            dfs(heights, pacificVisited, Integer.MIN_VALUE, 0, j);
            dfs(heights, atlanticVisited, Integer.MIN_VALUE, r-1, j);
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (pacificVisited[i][j] && atlanticVisited[i][j]) {
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(i);
                    tempList.add(j);
                    resList.add(tempList);
                }
            }
        }
        return resList;
    }

    public void dfs(int[][] heights, boolean[][] visited, int height, int x, int y) {
        if (x < 0 || x >= heights.length || y < 0 || y >= heights[0].length || visited[x][y] || heights[x][y] < height)
            return;
        visited[x][y] = true;
        dfs(heights, visited, heights[x][y], x-1, y);
        dfs(heights, visited, heights[x][y], x+1, y);
        dfs(heights, visited, heights[x][y], x, y-1);
        dfs(heights, visited, heights[x][y], x, y+1);
    }
}
