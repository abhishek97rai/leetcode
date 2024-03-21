class Solution {
    public int countSubstrings(String s) {
        //use center expand technique, and for each index, check for even and odd length palindromes
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            //odd length palindromes
            res += getPalCountFromCenter(s, i, i);
            //even length palindromes
            res += getPalCountFromCenter(s, i, i+1);
        }
        return res;
    }

    public int getPalCountFromCenter(String s, int l, int r) {
        int res = 0;
        while (l >= 0 && r < s.length()) {
            if (s.charAt(l) != s.charAt(r))
                break;
            res++;
            l--;
            r++;
        }
        return res;
    }
}
