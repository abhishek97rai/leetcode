class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        int startRow = 0;
        int endRow = rowCount - 1;
        int startCol = 0;
        int endCol = colCount - 1;
        List<Integer> res = new ArrayList<>();
        while (startRow <= endRow && startCol <= endCol) {
            int i = startRow;
            int j = startCol;
            while (j <= endCol && startRow <= endRow && startCol <= endCol) {
                res.add(matrix[i][j]);
                j++;
            }
            startRow++;
            i = startRow;
            j = endCol;
            while (i <= endRow && startRow <= endRow && startCol <= endCol) {
                res.add(matrix[i][j]);
                i++;
            }
            endCol--;
            i = endRow;
            j = endCol;
            while (j >= startCol && startRow <= endRow && startCol <= endCol) {
                res.add(matrix[i][j]);
                j--;
            }
            endRow--;
            i = endRow;
            j = startCol;
            while (i >= startRow && startRow <= endRow && startCol <= endCol) {
                res.add(matrix[i][j]);
                i--;
            }
            startCol++;
        }
        return res;
    }
}
