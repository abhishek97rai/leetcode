class Solution {
    public boolean isPowerOfThree(int n) {
        if (n < 1)
            return false;
        if (1162261467 % n == 0)
            return true;
        else
            return false;
    }
}
