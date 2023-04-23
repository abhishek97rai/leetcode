class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;
        String res = "";
        int resLen = 0;
        for (int i = 0; i < len; i++) {
            //odd length
            int l = i;
            int r = i;
            while (l >= 0 && r < len && s.charAt(l) == s.charAt(r)) {
                if (r-l+1 > resLen) {
                    res = s.substring(l, r+1);
                    resLen = r-l+1; 
                }
                l--;
                r++;
            }

            //even length
            l = i;
            r = i+1;
            while (l >= 0 && r < len && s.charAt(l) == s.charAt(r)) {
                if (r-l+1 > resLen) {
                    res = s.substring(l, r+1);
                    resLen = r-l+1; 
                }
                l--;
                r++;
            }
        }
        return res;
    }
}
