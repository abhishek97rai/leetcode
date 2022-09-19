class Solution {
    public void setZeroes(int[][] matrix) {
        boolean firstRow = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 && matrix[0][j] == 0) {
                    firstRow = true;
                    matrix[0][j] = 999;
                } else if (i > 0 && matrix[i][j] == 0) {
                    matrix[i][0] = 999;
                    matrix[0][j] = 999;
                }
            }
        }
        
        //traversing bottom right to top left, since we have set first cells of each row and column as zero flag, and that shouldnt be affected till the end
        for (int i = matrix.length-1; i >= 0; i--) {
            if (matrix[i][0] == 999) {
                if (i > 0) {
                    Arrays.fill(matrix[i], 0);
                    continue;
                } 
            }
            for (int j = matrix[0].length-1; j >= 0; j--) {
                if (matrix[0][j] == 999)
                    matrix[i][j] = 0;
            }
        }
        if (firstRow)
            Arrays.fill(matrix[0], 0);
    }
}
