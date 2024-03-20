class Solution {
    public boolean backspaceCompare(String s, String t) {
        //maintain 2 pointers to iterate both strings from reverse side
        //maintain 2 counters to track how many characters need to be skipped
        int p1 = s.length()-1;
        int p2 = t.length()-1;
        int skip1 = 0;
        int skip2 = 0;
        while (p1 >= 0 || p2 >= 0) {
            while (p1 >= 0) {
                if (s.charAt(p1) == '#') {
                    skip1++;
                    p1--;
                } else if (skip1 > 0) {
                    skip1--;
                    p1--;
                } else {
                    break;
                }
            }
            while (p2 >= 0) {
                if (t.charAt(p2) == '#') {
                    skip2++;
                    p2--;
                } else if (skip2 > 0) {
                    skip2--;
                    p2--;
                } else {
                    break;
                }
            }
            if (p1 >= 0 && p2 >= 0 && s.charAt(p1) != t.charAt(p2))
                return false;
            if ((p1 >= 0 && p2 < 0) || (p1 < 0 && p2 >= 0))
                return false;
            p1--;
            p2--;
        }
        return true;
    }
}
