class Solution {
    public boolean isAnagram(String s, String t) {
        //unicode character solution - use hashmap instead of fixed size counter array to store frequency
        Map<Character, Integer> hm = new HashMap<>();
        int sLen = s.length();
        int tLen = t.length();
        if (sLen != tLen)
            return false;
        for (int i = 0; i < sLen; i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            hm.put(sc, hm.getOrDefault(sc, 0) + 1);
            hm.put(tc, hm.getOrDefault(tc, 0) - 1);
        }
        for (char ch: hm.keySet()) {
            if (hm.get(ch) != 0)
                return false;
        }
        return true;
    }
}
