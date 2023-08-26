class Solution {
    public int divide(int dividend, int divisor) {
        boolean isNeg = false;
        if ((dividend < 0 || divisor < 0) && !(dividend < 0 && divisor < 0))
            isNeg = true;
        
        long posDividend = Math.abs((long) dividend);
        long posDivisor = Math.abs((long) divisor);
        
        long posRes = posDivide(posDividend, posDivisor);
        
        int res;
        if (posRes > Integer.MAX_VALUE) {
            if (isNeg) {
                res = Integer.MIN_VALUE;
            } else {
                res = Integer.MAX_VALUE;
            }
        } else {
            if (isNeg) {
                res = (int) -posRes;
            } else {
                res = (int) posRes;
            }
        }
        
        return res;
    }

    public long posDivide(long ldividend, long ldivisor) {
        if (ldividend < ldivisor)
            return 0;
        long multiple = 1;
        long sum = ldivisor;
        while ((sum*2) <= ldividend) {
            sum = sum*2;
            multiple = multiple*2;
        }
        return multiple + posDivide(ldividend - sum, ldivisor);   
    }
}
