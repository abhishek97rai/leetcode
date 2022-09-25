class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        Arrays.sort(strs);
        String firstString = strs[0];
        String lastString = strs[strs.length-1];
        int minLen = (firstString.length() < lastString.length()) ? firstString.length() : lastString.length();
        
        int cnt = 0;
        for (int i = 0; i < minLen; i++) {
            if (firstString.charAt(i) == lastString.charAt(i))
                cnt++;
            else
                break;
        }
        
        if (cnt == 0)
            return "";
        else
            return firstString.substring(0, cnt);
        
    }
}
