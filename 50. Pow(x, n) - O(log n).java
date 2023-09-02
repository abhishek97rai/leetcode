class Solution {
    public double myPow(double x, int n) {
        if (x == 1 || n == 0)
            return 1;
        boolean isNeg = false;
        if (n < 0) {
            isNeg = true;
            n = -n;
        }
        double res = 1;
        while (n != 0) {
            if (n % 2 != 0) {
                res = res * x;
            }
            x = x * x;
            n = n / 2;
        }
        if (isNeg)
            return 1/res;
        return res;
    }
}
