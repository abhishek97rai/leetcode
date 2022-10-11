class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = findFirst(nums, target);
        res[1] = findLast(nums, target);
        return res;
    }
    
    int findFirst(int[] nums, int target) {
        int first = -1;
        int start = 0;
        int end = nums.length-1;
        while (start <= end) {
            int mid = (start+end)/2;
            if (nums[mid] >= target)
                end = end-1;
            else
                start = start+1;
            if (nums[mid] == target)
                first = mid;
        }
        return first;
    }
    
    int findLast(int[] nums, int target) {
        int last = -1;
        int start = 0;
        int end = nums.length-1;
        while (start <= end) {
            int mid = (start+end)/2;
            if (nums[mid] <= target)
                start = start+1;
            else
                end = end-1;
            if (nums[mid] == target)
                last = mid;
        }
        return last;
    }
}
