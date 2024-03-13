class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // find smaller length array, so that TC is O(log(min(m,n)))
        // our left and right pointers for binary search would be operating on the smaller array
        // calculate partitionA based on these l and r ptrs, and partitionB based on totalLen/2 - partitionA
        // run a loop till l <= r
        // keep updating l or r based on the comparisons between ALeftMax, BLeftMax, ARightMin, BRightMin
        
        //this will ensure smaller array is kept in nums1
        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);
        int m = nums1.length;
        int n = nums2.length;
        int half = (m+n+1)/2;
        int l = 0;
        int r = m;
        while (l <= r) {
            //partitionA and partitionB point to the beginning of right halves in the respective arrays
            int partitionA = (l+r)/2;
            int partitionB = half - partitionA;
            int aLeftMax = (partitionA <= 0) ? Integer.MIN_VALUE : nums1[partitionA - 1];
            int bLeftMax = (partitionB <= 0) ? Integer.MIN_VALUE : nums2[partitionB - 1];
            int aRightMin = (partitionA >= m) ? Integer.MAX_VALUE : nums1[partitionA];
            int bRightMin = (partitionB >= n) ? Integer.MAX_VALUE : nums2[partitionB];
            if (aLeftMax <= bRightMin && bLeftMax <= aRightMin) {
                //this means we have the correct partitions and thus can return median based on even or odd total elements
                if ((m+n)%2 != 0) {
                    //odd elements, single value will be median
                    return (double) Math.max(aLeftMax, bLeftMax);
                } else {
                    //even elements, calculate avg of middle 2 elements
                    int max = Math.max(aLeftMax, bLeftMax);
                    int min = Math.min(aRightMin, bRightMin);
                    return (double) (max+min)/2;
                }
            } else if (aLeftMax > bRightMin) {
                //this means we need to reduce right ptr
                r = partitionA - 1;
            } else {
                //this means we need to increase left ptr
                l = partitionA + 1;
            }
        }
        return 0d;
    }
}
