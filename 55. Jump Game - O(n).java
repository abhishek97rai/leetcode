class Solution {
    public boolean canJump(int[] nums) {
        int max = 0;
        int i = 0;
        for (i = 0; i < nums.length; i++) {
            if (i > max)
                return false;
            max = Math.max(max, i+nums[i]);
        }
        return (i == nums.length);
    }
}
