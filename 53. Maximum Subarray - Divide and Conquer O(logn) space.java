class Solution {
    public int maxSubArray(int[] nums) {
        return dnc(nums, 0, nums.length-1);       
    }

    public int dnc(int[] nums, int l, int r) {
        //base case
        if (l > r)
            return Integer.MIN_VALUE;
        int mid = (l+r)/2;
        int leftBestSum = 0;
        int rightBestSum = 0;
        int currSum = 0;
        for (int i = mid-1; i >= l; i--) {
            currSum += nums[i];
            leftBestSum = Math.max(leftBestSum, currSum);
        }
        currSum = 0;
        for (int i = mid+1; i <= r; i++) {
            currSum += nums[i];
            rightBestSum = Math.max(rightBestSum, currSum);
        }
        int combinedBestSum = nums[mid] + leftBestSum + rightBestSum;
        int leftSum = dnc(nums, l, mid-1);
        int rightSum = dnc(nums, mid+1, r);
        return Math.max(combinedBestSum, Math.max(leftSum, rightSum));
    }
}
