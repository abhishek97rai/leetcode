class Solution {
    public boolean isIsomorphic(String s, String t) {
        Set<Character> setS = new HashSet<>();
        Set<Character> setT = new HashSet<>();
        Map<Character, Character> hm = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            setS.add(s.charAt(i));
            setT.add(t.charAt(i));
            if (!hm.containsKey(s.charAt(i))) {
                hm.put(s.charAt(i), t.charAt(i));
            } else {
                char tChar = hm.get(s.charAt(i));
                if (t.charAt(i) != tChar)
                    return false;
            }
        }
        
        if (setS.size() != setT.size())
            return false;
        
        return true;
    }
}
