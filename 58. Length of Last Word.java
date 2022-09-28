class Solution {
    public int lengthOfLastWord(String s) {
        int count = 0;
        s = s.trim();
        int len = s.length();
        int i = len-1;
        while (i >= 0 && s.charAt(i) != ' ') {
            count++;
            i--;
        }
        return count;
    }
}
