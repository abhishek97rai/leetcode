class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int i = 0;
        int j = 0;
        int[] res = new int[mat.length * mat[0].length];
        int k = 0;
        boolean isUpward = true;
        while (i != mat.length-1 || j != mat[0].length-1) {
            res[k] = mat[i][j];
            k++;
            if (isUpward) {
                i--;
                j++;
                if (i < 0 || j == mat[0].length) {
                    if (j == mat[0].length) {
                        i = i+2;
                        j--;
                    } else if (i < 0) {
                        i++;
                    }
                    isUpward = false;
                }
            } else {
                i++;
                j--;
                if (j < 0 || i == mat.length) {
                    if (i == mat.length) {
                        j = j+2;
                        i--;
                    } else if (j < 0) {
                        j++;
                    }
                    isUpward = true;
                }
            }
            
        }
        res[k] = mat[i][j];
        return res;
    }
}
