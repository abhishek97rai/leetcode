class Solution {
    public boolean isAnagram(String s, String t) {
        
        if (s.length() != t.length())
            return false;
        
        Map<Character, Integer> hm1 = new HashMap<>();
        for (char c: s.toCharArray()) {
            if (!hm1.containsKey(c))
                hm1.put(c, 1);
            else
                hm1.put(c, hm1.get(c)+1);
        }
        
        Map<Character, Integer> hm2 = new HashMap<>();
        for (char c: t.toCharArray()) {
            if (!hm2.containsKey(c))
                hm2.put(c, 1);
            else
                hm2.put(c, hm2.get(c)+1);
        }
        
        return hm1.equals(hm2);
    }
}
