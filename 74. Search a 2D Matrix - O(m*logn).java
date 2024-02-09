class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] row: matrix) {
            if (target >= row[0] && target <= row[row.length-1]) {
                //perform binary search
                int lo = 0;
                int hi = row.length-1;
                while (lo <= hi) {
                    int mid = (lo+hi)/2;
                    if (row[mid] == target) {
                        return true;
                    } else if (row[mid] < target) {
                        lo = mid+1;
                    } else {
                        hi = mid-1;
                    }
                }
                //break if not found, because then the target surely doesnt exist in the matrix
                break;
            }
        }
        return false;
    }
}
