class Solution {
    public boolean isAnagram(String s, String t) {
        
        if (s.length() != t.length())
            return false;
        
        int[] buckets = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            buckets[s.charAt(i) - 'a']++;
            buckets[t.charAt(i) - 'a']--;
        }
        
        for (int i: buckets) {
            if (i != 0)
                return false;
        }
        
        return true;
    }
}
