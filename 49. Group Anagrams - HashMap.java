class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hm = new HashMap<>();
        for (String st: strs) {
            char[] temp = st.toCharArray();
            Arrays.sort(temp);
            String key = new String(temp);
            List<String> valueList = hm.getOrDefault(key, new ArrayList<String>());
            valueList.add(st);
            hm.put(key, valueList);
        }
        return new ArrayList<>(hm.values());
    }
}
