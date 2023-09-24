class SparseVector {
    
    List<int[]> list;

    SparseVector(int[] nums) {
        this.list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                list.add(new int[]{i, nums[i]});
            }
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int result = 0;
        int p = 0;
        int q = 0;
        while (p < this.list.size() && q < vec.list.size()) {
            if (this.list.get(p)[0] == vec.list.get(q)[0]) {
                result += this.list.get(p)[1] * vec.list.get(q)[1];
                p++;
                q++;
            } else if (this.list.get(p)[0] < vec.list.get(q)[0]) {
                p++;
            } else {
                q++;
            }
        }
        return result;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);
