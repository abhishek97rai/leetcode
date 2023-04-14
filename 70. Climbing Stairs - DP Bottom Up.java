class Solution {
    public int climbStairs(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        int[] bottom_up = new int[n+1];
        bottom_up[1] = 1;
        bottom_up[2] = 2;
        for (int i = 3; i <= n; i++) {
            bottom_up[i] = bottom_up[i-1] + bottom_up[i-2];
        }
        return bottom_up[n];
    }
}
