class Solution {
    public int minAddToMakeValid(String s) {
        int count = 0;
        int balance = 0;
        for (char ch: s.toCharArray()) {
            if (ch == '(') {
                balance++;
            } else {
                if (balance == 0) {
                    count++;
                } else {
                    balance--;
                }
            }
        }
        return count + balance;
    }
}
