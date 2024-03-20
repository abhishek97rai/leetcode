class Solution {
    public int minStartValue(int[] nums) {
        int sum = 0;
        //replace nums with its prefixSum array values
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            nums[i] = sum;
        }
        int min = Integer.MAX_VALUE;
        for (int prefixSum: nums) {
            min = Math.min(min, prefixSum);
        }
        int res = 1 - min;
        return Math.max(1, res);
    }
}
