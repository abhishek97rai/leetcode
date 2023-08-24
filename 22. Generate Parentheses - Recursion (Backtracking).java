class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(0, 0, "", n, res);
        return res;
    }

    public void backtrack(int openC, int closeC, String curStr, int n, List<String> res) {
        if (curStr.length() == n*2) {
            res.add(curStr);
        } else {
            if (openC < n) {
                backtrack(openC+1, closeC, curStr+"(", n, res);
            }
            if (closeC < openC) {
                backtrack(openC, closeC+1, curStr+")", n, res);
            }
        }
    }
}
