class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        //use two pointers technique along with prefix sum
        //as soon as sum becomes >= target, start incrementing left ptr and removing those elements from the sum
        //and check if the sum is still >= target, and keep updating new minimum length
        int res = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                res = Math.min(res, i+1-left);
                sum = sum - nums[left];
                left++;
            }
        }
        return (res == Integer.MAX_VALUE) ? 0 : res;
    }
}
