class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n+1];
        int res = climbStairs(n, memo);
        return res; 
    }

    public int climbStairs(int n, int[] memo) {
        int result;
        if (memo[n] != 0)
            return memo[n];
        if (n == 1)
            result = 1;
        else if (n == 2)
            result = 2;
        else
            result = climbStairs(n-1, memo) + climbStairs(n-2, memo);
        memo[n] = result;
        return result;
    }
}
