class Solution {
    public int getSum(int a, int b) {
        //thing to note is that sum is given by x^y and carry is given by x&y>>1
        int res = 0;
        int carry = 0;
        while (b != 0) {
            res = a ^ b;
            carry = (a & b) << 1;
            a = res;
            b = carry;
        }
        return a;
    }
}
