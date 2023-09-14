class Solution {
    public boolean validPalindrome(String s) {
        int left, right;
        for (left = 0, right = s.length()-1; left < right; left++, right--) {
            if (s.charAt(left) != s.charAt(right)) {
                boolean isLeftError = isSubstringPalindrome(s, left+1, right);
                boolean isRightError = isSubstringPalindrome(s, left, right-1);
                return (isLeftError || isRightError);
            }
        }
        return true;
    }

    public boolean isSubstringPalindrome(String s, int i, int j) {
        int left, right;
        for (left = i, right = j; left < right; left++, right--) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
        }
        return true;
    }
}
