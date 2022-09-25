class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] res = new int[m+n];
        
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                res[k] = nums1[i];
                i++;
            } else if (nums1[i] > nums2[j]) {
                res[k] = nums2[j];
                j++;
            }
            k++;
        }
        
        if (i < m) {
            for (int a = i; a < m; a++) {
                res[k] = nums1[a];
                k++;
            }
        }
        
        if (j < n) {
            for (int b = j; b < n; b++) {
                res[k] = nums2[b];
                k++;
            }
        }
        
        for (int c = 0; c < (m+n); c++) {
            nums1[c] = res[c];
        }
    }
}
