class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        if (s.length() == 0 || s.length() == 1)
            return s.length();
        int lPtr = 0;
        Map<Character, Integer> hm = new HashMap<>();
        for (int rPtr = 0; rPtr < s.length(); rPtr++) {
            //if our max length is already greater than max possible length of further possible substrings, then dont iterate further
            if (max >= s.length()-lPtr)
                break;
            if (hm.containsKey(s.charAt(rPtr)))
                lPtr = Math.max(lPtr, hm.get(s.charAt(rPtr))+1);
            hm.put(s.charAt(rPtr), rPtr);
            max = Math.max(max, rPtr-lPtr+1);
        }
        return max;
    }
}
