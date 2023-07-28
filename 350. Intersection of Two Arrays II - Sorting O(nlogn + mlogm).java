class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int size = Math.min(len1, len2);
        int i = 0;
        int j = 0;
        int k = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while (i < len1 && j < len2) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                nums1[k] = nums1[i];
                i++;
                j++;
                k++;
            }
        }
        return Arrays.copyOf(nums1, k);
    }
}
