class Solution {
    public String addStrings(String num1, String num2) {
        int p1 = num1.length();
        int p2 = num2.length();
        int resLen = Math.max(p1, p2);
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int sum = 0;
        for (int i = resLen-1; i >= 0; i--) {
            int part1 = 0;
            int part2 = 0;
            if (p1 > 0)
                part1 = num1.charAt(p1-1) - '0';
            if (p2 > 0)
                part2 = (int) num2.charAt(p2-1) - '0';
            p1--;
            p2--;
            sum = part1 + part2 + carry;
            sb.append(sum % 10);
            carry = sum/10; 
        }
        if (carry > 0)
            sb.append(carry);
        return sb.reverse().toString();
    }
}
