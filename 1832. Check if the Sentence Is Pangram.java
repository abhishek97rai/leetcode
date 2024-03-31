class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] freq = new int[26];
        for (char ch: sentence.toCharArray()) {
            freq[ch-'a']++;
        }
        for (int f: freq) {
            if (f == 0)
                return false;
        }
        return true;
    }
}
