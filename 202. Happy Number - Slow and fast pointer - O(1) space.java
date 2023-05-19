class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getSum(n);
        while (fast != 1 && slow != fast) {
            slow = getSum(slow);
            fast = getSum(getSum(fast));
        }
        if (fast == 1)
            return true;
        else
            return false;
    }

    public int getSum(int num) {
        int sum = 0;
        int rem = 0;
        while (num > 0) {
            rem = num % 10;
            sum += rem*rem;
            num /= 10;
        }
        return sum;
    }
}
