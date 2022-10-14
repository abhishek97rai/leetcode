class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        if (s.length() == 0 || s.length() == 1)
            return s.length();
        for (int i = 0; i < s.length()-1; i++) {
            //if our max length is already greater than max possible length of further possible substrings, then dont iterate further
            if (max >= s.length()-i)
                break;
            Set<Character> set = new HashSet<>();
            set.add(s.charAt(i));
            for (int j = i+1; j < s.length(); j++) {
                int len = set.size();
                set.add(s.charAt(j));
                if (len == set.size())
                    break;
            }
            if (set.size() > max)
                max = set.size();
        }
        return max;
    }
}
