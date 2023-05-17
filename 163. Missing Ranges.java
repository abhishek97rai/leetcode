class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            List<Integer> range = new ArrayList<>();
            range.add(lower);
            range.add(upper);
            res.add(range);
            return res;
        }
        //handle lower limit to first num range
        if (nums[0]-lower >= 1) {
            List<Integer> range = new ArrayList<>();
            range.add(lower);
            range.add(nums[0]-1);
            res.add(range);
        }
        int i;
        for (i = 0; i < nums.length-1; i++) {
            int first = nums[i];
            int second = nums[i+1];
            if (second-first > 1) {
                List<Integer> range = new ArrayList<>();
                range.add(first+1);
                range.add(second-1);
                res.add(range);
            }
        }
        //handle last num to upper limit range
        if (upper-nums[i] >= 1) {
            List<Integer> range = new ArrayList<>();
            range.add(nums[i]+1);
            range.add(upper);
            res.add(range);
        }
        return res;
    }
}
