class Solution {
    
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int k = m+n-1;
        
        if (m == 0) {
            for (int l = 0; l < n; l++)
                nums1[l] = nums2[l];
        } else {
            while (i >= 0 && j >= 0) {
                if (nums1[i] >= nums2[j]) {
                    nums1[k] = nums1[i];
                    i--;
                } else if (nums1[i] < nums2[j]) {
                    nums1[k] = nums2[j];
                    j--;
                }
                k--;
            }

            if (j >= 0) {
                for (int a = j; a >= 0; a--) {
                    nums1[k] = nums2[a];
                    k--;
                }
            }    
        }
        
    }
}
