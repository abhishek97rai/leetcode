class Solution {

    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        return say(countAndSay(n-1));
    }

    public String say(String num) {
        int count = 0;
        int len = num.length();
        String res = "";
        int i = 0;
        for (i = 0; i < len; i++) {
            char ch1 = num.charAt(i);
            if (i == 0) {
                count++;
            } else {
                char ch2 = num.charAt(i-1);
                if (ch1 == ch2) {
                    count++;
                } else {
                    //create string with count+ch2 and append to result string
                    String temp = String.valueOf(count) + ch2;
                    res += temp;
                    count = 1;
                }
            }
        }
        res += String.valueOf(count) + num.charAt(i-1);
        return res;
    }
}
