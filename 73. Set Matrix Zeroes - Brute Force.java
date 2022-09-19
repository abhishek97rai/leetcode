class Solution {
    public void setZeroes(int[][] matrix) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;
        boolean[] row = new boolean[ROWS];
        boolean[] col = new boolean[COLS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] =  true;
                }
            }
        }
        
        for (int i = 0; i < ROWS; i++) {
            if (row[i]) {
                Arrays.fill(matrix[i], 0);
                continue;
            }
            for (int j = 0; j < COLS; j++) {
                if (col[j])
                    matrix[i][j] = 0;
            }
        }
    }
}
