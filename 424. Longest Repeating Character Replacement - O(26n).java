class Solution {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        if (len < 2)
            return len;
        int result = 1;
        Map<Character, Integer> hm = new HashMap<>();
        int l = 0;
        int r = 0;
        while (r < len) {
            hm.put(s.charAt(r), hm.getOrDefault(s.charAt(r), 0) + 1);
            int max = Collections.max(hm.values());
            if ((r-l+1) - max <= k) {
                result = Math.max(result, r-l+1);
            } else {
                hm.put(s.charAt(l), hm.get(s.charAt(l)) - 1);
                l++;
            }
            r++;
        }
        return result;
    }
}
