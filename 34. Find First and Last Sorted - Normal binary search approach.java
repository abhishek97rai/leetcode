class Solution {
    public int[] searchRange(int[] nums, int target) {
        int loc = binarySearch(nums, 0, nums.length-1, target);
        if (loc == -1)
            return new int[]{-1,-1};
        else {
            int[] res = new int[2];
            res[0] = res[1] = loc;
            int min = loc-1;
            int max = loc+1;
            while (min >=0 && nums[min] == target) {
                res[0] = min;
                min--;
            }
            while (max <= nums.length-1 && nums[max] == target) {
                res[1] = max;
                max++;
            }
            return res;
        }
    }
    
    int binarySearch(int[] nums, int start, int end, int target) {
        if (start <= end) {
            int mid = (start+end)/2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                return binarySearch(nums, mid+1, end, target);
            else
                return binarySearch(nums, start, mid-1, target);
        }
        return -1;
    }
}
