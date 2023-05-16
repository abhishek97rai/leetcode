class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        char leftChar;
        int leftAsc;
        char rightChar;
        int rightAsc;
        while (left <= right) {
            leftChar = s.charAt(left);
            if (leftChar == ' ') {
                left++;
                continue;
            }
            leftAsc = (int) leftChar;
            if (leftAsc >= 65 && leftAsc <= 90) {
                leftChar = Character.toLowerCase(leftChar);
                leftAsc = (int) leftChar;
            }
            if (!((leftAsc >= 48 && leftAsc <= 57) ||
            (leftAsc >= 97 && leftAsc <= 122))) {
                left++;
                continue;
            }
            rightChar = s.charAt(right);
            if (rightChar == ' ') {
                right--;
                continue;
            }
            rightAsc = (int) rightChar;
            if (rightAsc >= 65 && rightAsc <= 90) {
                rightChar = Character.toLowerCase(rightChar);
                rightAsc = (int) rightChar;
            }
            if (!((rightAsc >= 48 && rightAsc <= 57) ||
            (rightAsc >= 97 && rightAsc <= 122))) {
                right--;
                continue;
            }
            if (leftChar != rightChar)
                return false;
            else {
                left++;
                right--;
            }
        }
        return true;
    }
}
