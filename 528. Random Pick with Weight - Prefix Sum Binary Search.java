class Solution {

    Random rnd;
    int[] weightSums;

    public Solution(int[] w) {
        this.rnd = new Random();
        for (int i = 1; i < w.length; i++) {
            w[i] = w[i-1] + w[i];
        }
        this.weightSums = w;
    }
    
    public int pickIndex() {
        int index = 0;
        int rndNum = rnd.nextInt(weightSums[weightSums.length-1]) + 1; //+1 so that (0, ind-1) becomes (1, ind)
        index = binarySearch(weightSums, rndNum);
        return index;
    }

    public int binarySearch(int[] nums, int val) {
        int l = 0;
        int r = nums.length-1;
        while (l < r) {
            int mid = (l+r)/2;
            if (nums[mid] == val)
                return mid;
            if (nums[mid] < val) {
                l = mid+1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
