class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                sum = nums[j];
                maxSum = Math.max(sum, maxSum);
                for (int k = j+1; k < len; k++) {
                    sum += nums[k];
                    maxSum = Math.max(sum, maxSum);
                }
            }
        }
        return maxSum;
    }
}
