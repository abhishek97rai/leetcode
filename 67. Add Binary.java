class Solution {
    public String addBinary(String a, String b) {
        int p1 = a.length();
        int p2 = b.length();
        int resLen = Math.max(p1, p2);
        int sum = 0;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = resLen-1; i >= 0; i--) {
            int part1 = 0;
            int part2 = 0;
            if (p1 > 0)
                part1 = a.charAt(p1-1) - '0';
            if (p2 > 0)
                part2 = b.charAt(p2-1) - '0';
            p1--;
            p2--;
            sum = part1 + part2 + carry;
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry > 0)
            sb.append(carry);
        return sb.reverse().toString();
    }
}
