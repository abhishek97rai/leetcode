class Solution {
    public int maximumSwap(int num) {
        int[] bucket = new int[10];
        char[] charArr = Integer.toString(num).toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            bucket[charArr[i]-'0'] = i;
        }
        for (int i = 0; i < charArr.length-1; i++) {
            for (int j = 9; j > charArr[i]-'0'; j--) {
                if (bucket[j] > i) {
                    char temp = charArr[i];
                    charArr[i] = charArr[bucket[j]];
                    charArr[bucket[j]] = temp;
                    return Integer.parseInt(new String(charArr));
                }
            }
        }
        return num;
    }
}
