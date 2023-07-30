class Solution {
    public int reverse(int x) {
        int len = String.valueOf(Math.abs(x)).length();
        int res = 0;
        int rem = 0;
        while (x != 0) {
            rem = x % 10;
            res += rem * Math.pow(10, len-1);
            x /= 10;
            len--;
        }
        if (res >= Math.pow(2, 31) - 1 || res <= -Math.pow(2, 31))
            return 0;
        return res;
    }
}
