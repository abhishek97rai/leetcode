class Solution {

    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        String res = "1";
        for (int i = 1; i < n; i++) {
            res = say(res);
        }
        return res;
    }

    public String say(String num) {
        int len = num.length();
        StringBuilder res = new StringBuilder();
        char ch = num.charAt(0);
        int count = 1;
        for (int i = 1; i < len; i++) {
            char ch1 = num.charAt(i);
            if (ch1 == ch) {
                count++;
            } else {
                res.append(count);
                res.append(ch);
                ch = ch1;
                count = 1;
            }
        }
        res.append(count);
        res.append(ch);
        return res.toString();
    }
    
}
