class Solution {

    private static final int[][] directions = new int[][]{{-1,-1}, {0,-1}, {1,-1}, {1,0}, {1,1}, {0,1}, {-1,1}, {-1,0}};
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0 || grid[grid.length-1][grid[0].length-1] != 0)
            return -1;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] values = queue.remove();
            int row = values[0];
            int col = values[1];
            int distance = values[2];
            if (row == grid.length-1 && col == grid[0].length-1)
                return distance;
            for(int[] nbr: getNbrs(row, col, grid)) {
                int newRow = nbr[0];
                int newCol = nbr[1];
                if (visited[newRow][newCol])
                    continue;
                visited[newRow][newCol] = true;
                queue.add(new int[]{newRow, newCol, distance+1});
            }
        }
        return -1;
    }

    List<int[]> getNbrs(int row, int col, int[][] grid) {
        List<int[]> nbrList = new ArrayList<>();
        for (int i = 0; i < directions.length; i++) {
            int newRow = row + directions[i][0];
            int newCol = col + directions[i][1];
            if (newRow < 0 || newCol < 0 || newRow > grid.length-1 || newCol > grid[0].length-1
            || grid[newRow][newCol] != 0) {
                continue;
            }
            nbrList.add(new int[]{newRow, newCol});
        }
        return nbrList;
    }
    
}
