class Solution {
    public int titleToNumber(String columnTitle) {
        int res = 0;
        int exp = 0;
        for (int i = columnTitle.length()-1; i >= 0; i--) {
            char ch = columnTitle.charAt(i);
            int val = ch - 'A' + 1;
            res += val * Math.pow(26, exp);
            exp++;
        }
        return res;
    }
}
