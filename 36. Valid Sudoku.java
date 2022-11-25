class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean isValid = true;
        Set<String> status = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch != '.') {
                    if (!status.add(ch + " added in row " + i) ||
                        !status.add(ch + " added in col " + j) ||
                        !status.add(ch + " added in block " + i/3 + j/3)) {
                        return false;
                    }
                }
            }
        }
        return isValid;
    }
}
