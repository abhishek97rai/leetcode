class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int maxLen = 1;
        int currLen = 1;
        int i = 1;
        while (i < nums.length) {
            while (i < nums.length && nums[i] == nums[i-1])
                i++;
            if (i < nums.length && nums[i] == nums[i-1] + 1) {
                currLen++;
            } else {
                maxLen = Math.max(maxLen, currLen);
                currLen = 1;
            }
            i++;
        }
        maxLen = Math.max(maxLen, currLen);
        return maxLen;
    }
}
