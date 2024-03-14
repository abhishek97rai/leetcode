class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hm = new HashMap<>();
        for (String s: strs) {
            //make a key using freq count array
            int[] freq = new int[26];
            for (char ch: s.toCharArray()) {
                freq[ch-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append("#");
                sb.append(freq[i]);
            }
            String key = sb.toString();
            List<String> list = hm.getOrDefault(key, new ArrayList<>());
            list.add(s);
            hm.put(key, list);
        }
        return new ArrayList<>(hm.values());
    }
}
