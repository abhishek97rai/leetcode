class Solution {
    public int strStr(String haystack, String needle) {
        int hayLen = haystack.length();
        int neeLen = needle.length();
        if (neeLen > hayLen)
            return -1;
        for (int i = 0; i <= hayLen-neeLen; i++) {
            int j = 0;
            while (j < neeLen && haystack.charAt(i+j) == needle.charAt(j)) {
                j++;
            }
            if (j == neeLen)
                return i;
        }
        return -1;
    }
}
