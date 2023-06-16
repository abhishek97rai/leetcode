class Solution {
    public void moveZeroes(int[] nums) {
        int ind = 0;
        for (int num: nums) {
            if (num != 0) {
                nums[ind] = num;
                ind++;
            }
        }
        while (ind != nums.length) {
            nums[ind] = 0;
            ind++;
        }
    }
}
