class Solution {
    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length-1, target);        
    }
    
    public int binarySearch(int[] arr, int low, int high, int target) {
        int mid = (int) Math.ceil((low+high)/2);
        if (low < high) {
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] > target) {
                if (low == mid-1) {
                    if (arr[low] >= target)
                        return mid-1;
                    else
                        return mid;
                }
                else
                    return binarySearch(arr, low, mid-1, target);
            }
            else {
                if (mid+1 == high) {
                    if (arr[high] >= target)
                        return high;
                    else
                        return high+1;
                }
                else
                    return binarySearch(arr, mid+1, high, target);
            }
        } else {
            if (arr[mid] >= target)
                return mid;
            else
                return mid+1;
        }
    }
}
