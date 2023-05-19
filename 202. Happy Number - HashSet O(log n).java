class Solution {
    public boolean isHappy(int n) {
        Set<Integer> hs = new HashSet<>();
        while (true) {
            String num = String.valueOf(n);
            int len = num.length();
            int sum = 0;
            for (int i = 0; i < len; i++) {
                int val = num.charAt(i) - '0';
                int valSq = val*val;
                sum += valSq;
            }
            if (sum == 1)
                return true;
            else {
                boolean isNew = hs.add(sum);
                if (!isNew)
                    return false;
                else {
                    n = sum;
                }
            }
        }
    }
}
