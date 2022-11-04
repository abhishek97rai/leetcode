class Solution {
    public int compress(char[] chars) {
        int index = 0;
        int count = 0;
        int res = 0;
        while (index < chars.length) {
            char ch = chars[index];
            while (index < chars.length && chars[index] == ch) {
                index++;
                count++;
            }
            chars[res++] = ch;
            if (count > 1) {
                char[] digits = Integer.toString(count).toCharArray();
                for (char d: digits)
                    chars[res++] = d;
            }
            count = 0;
        }
        return res;
    }
}
