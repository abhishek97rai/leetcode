class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> hm = new HashMap<>();
        hm.put('I', 1);
        hm.put('V', 5);
        hm.put('X', 10);
        hm.put('L', 50);
        hm.put('C', 100);
        hm.put('D', 500);
        hm.put('M', 1000);
        int result = 0;
        for (int i = 0; i < s.length()-1; i++) {
            int num1 = hm.get(s.charAt(i));
            int num2 = hm.get(s.charAt(i+1));
            if (num1 >= num2) {
                result += num1;
            } else {
                result -= num1;
            }
        }
        result += hm.get(s.charAt(s.length()-1));
        return result;
    }
}
