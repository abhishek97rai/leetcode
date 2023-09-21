class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (!hm.containsKey(r-c)) {
                    hm.put((r-c), matrix[r][c]);
                } else {
                    if (matrix[r][c] != hm.get(r-c)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
