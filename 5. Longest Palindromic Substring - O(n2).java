class Solution {
    public String longestPalindrome(String s) {
        int l = 0;
        int r = 0;
        for (int i = 0; i < s.length(); i++) {
            //odd case length
            int oddLen = expand(s, i, i);
            if (oddLen > (r-l+1)) {
                int mid = oddLen/2;
                l = i-mid;
                r = i+mid;
            }
            
            //even case length
            int evenLen = expand(s, i, i+1);
            if (evenLen > (r-l+1)) {
                int mid = evenLen/2 - 1;
                l = i-mid;
                r = i+1+mid;
            }
        }
        return s.substring(l, r+1);
    }

    public int expand(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r-l-1;
    }
    
}
