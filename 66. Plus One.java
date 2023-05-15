class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        if (digits[len-1] < 9) {
            digits[len-1] += 1;
            return digits;
        } else {
            int i = len-1;
            while (i >= 0 && digits[i] == 9) {
                digits[i] = 0;
                i--;
            }
            if (i >= 0) {
                digits[i] += 1;
                return digits;
            } else {
                //9,99,999,etc cases
                int[] overflow = new int[len+1];
                Arrays.fill(overflow, 0);
                overflow[0] = 1;
                return overflow;
            }
        }
    }
}
