class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int num = i+1;
            if (num%3 == 0 && num%5 == 0) {
                res.add(i, "FizzBuzz");
            } else if (num%3 == 0) {
                res.add(i, "Fizz");
            } else if (num%5 == 0) {
                res.add(i, "Buzz");
            } else {
                res.add(i, String.valueOf(num));
            }
        }
        return res;
    }
}
