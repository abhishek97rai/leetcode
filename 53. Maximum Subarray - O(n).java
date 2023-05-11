class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int sum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < len; i++) {
            if (sum < 0)
                sum = 0;
            sum += nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
