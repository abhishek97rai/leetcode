class Solution {
    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        //calculate gcd
        int gcd = 0;
        if (divisor1 > divisor2)
            gcd = calculateGcd(divisor1, divisor2);
        else
            gcd = calculateGcd(divisor2, divisor1);

        //calculate lcm
        long lcm = ((long) divisor1 * divisor2) / gcd;

        long l = 0;
        long r = Integer.MAX_VALUE;

        while (l < r) {
            long mid = l + (r-l)/2;
            if (uniqueCnt1 <= mid - mid/divisor1 &&
                uniqueCnt2 <= mid - mid/divisor2 &&
                uniqueCnt1 + uniqueCnt2 <= mid - mid/lcm) {
                    r = mid;
                } else {
                    l = mid+1;
                }
        }
        return (int) l;
    }

    public int calculateGcd(int num1, int num2) {
        //num1 is always greater than equal to num2 before arriving in this method
        int rem = Integer.MAX_VALUE;
        while (rem > 0) {
            rem = num1 % num2;
            num1 = num2;
            num2 = rem;
        }
        return num1;
    }
}
