class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int kLen = String.valueOf(k).length();
        int numLen = num.length;
        int resLen = Math.max(numLen, kLen);
        int sum = 0;
        int carry = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = resLen-1; i >= 0; i--) {
            int part1 = 0;
            int part2 = 0;
            if (numLen > 0)
                part1 = num[numLen-1];
            if (k > 0)
                part2 = k % 10;
            sum = part1 + part2 + carry;
            res.add(sum % 10);
            carry = sum / 10;
            k /= 10;
            numLen--;
        }
        if (carry > 0)
            res.add(carry);
        Collections.reverse(res);
        return res;
    }
}
