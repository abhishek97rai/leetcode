class Solution {
    public int rob(int[] nums) {
        int r1 = 0;
        int r2 = 0;
        int temp = 0;
        for (int n: nums) {
            temp = Math.max(n+r1, r2);
            r1 = r2;
            r2 = temp;
        }
        return r2;
    }
}
