class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.trim().equalsIgnoreCase(""))
            return res;
        Map<Character, String> hm = new HashMap<>();
        hm.put('2', "abc");
        hm.put('3', "def");
        hm.put('4', "ghi");
        hm.put('5', "jkl");
        hm.put('6', "mno");
        hm.put('7', "pqrs");
        hm.put('8', "tuv");
        hm.put('9', "wxyz");

        backtrack(0, "", digits, hm, res);
        return res;
    }

    public void backtrack(int i, String curStr, String digits, Map<Character, String> hm, List<String> res) {
        if (curStr.length() == digits.length()) {
            res.add(curStr);
        } else {
            char ch = digits.charAt(i);
            String numSt = hm.get(ch);
            for (char c: numSt.toCharArray()) {
                backtrack(i+1, curStr + c, digits, hm, res);
            }
        }
    }
}
