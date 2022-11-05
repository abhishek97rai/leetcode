class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        int j = 0;
        int prev = nums[0];
        while (index < nums.length) {
            int curr = nums[index];
            while (index < nums.length && nums[index] == curr)
                index++;
            nums[j++] = curr;
        }
        return j;
    }
}
