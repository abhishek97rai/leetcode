class Solution {
    public int myAtoi(String s) {
        int len = s.length();
        if (len == 0)
            return 0;
        int i = 0;
        while (i < len && s.charAt(i) == ' ')
            i++;
        if (i == len)
            return 0;
        char ch = s.charAt(i);
        int sign = 1;
        if (ch == '+' || ch == '-') {
            if (ch == '-')
                sign = -1;
            i++;
        }
        int res = 0;
        for (int j = i; j < len; j++) {
            int digit = s.charAt(j) - '0';
            if (digit < 0 || digit > 9)
                break;
            if (res > Integer.MAX_VALUE/10 || (digit > Integer.MAX_VALUE%10 && res == Integer.MAX_VALUE/10)) {
                if (sign == 1) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }
            res = res*10 + digit;
        }
        return res*sign;
    }
}
