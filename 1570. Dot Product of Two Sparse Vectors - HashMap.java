class SparseVector {
    
    Map<Integer, Integer> hm;

    SparseVector(int[] nums) {
        hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                hm.put(i, nums[i]);
            }
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int result = 0;
        for (Map.Entry<Integer, Integer> set: vec.hm.entrySet()) {
            if (this.hm.containsKey(set.getKey())) {
                result += set.getValue() * hm.get(set.getKey());
            }
        }
        return result;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);
