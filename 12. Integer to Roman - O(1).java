class Solution {
    public String intToRoman(int num) {
        int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        //iterate over values and keep subtracting from num while appending corresponding roman to result string
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num > 0 && num >= values[i]) {
                sb.append(roman[i]);
                num = num - values[i];
            }
        }
        return sb.toString();
    }
}
