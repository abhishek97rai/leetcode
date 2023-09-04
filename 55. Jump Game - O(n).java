class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1)
            return true;
        int max = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if (max >= i) {
                if ((i + nums[i]) >= nums.length-1)
                    return true;
            }
            if ((max <= i && nums[i] == 0))
                return false;
            max = Math.max(max, i + nums[i]);
        }
        return false;
    }
}
