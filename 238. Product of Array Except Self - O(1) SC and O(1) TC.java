class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        int prefixProd = 1;
        for (int i = 0; i < nums.length-1; i++) {
            prefixProd *= nums[i];
            res[i+1] = prefixProd;
        }
        int suffixProd = 1;
        for (int i = nums.length-1; i > 0; i--) {
            suffixProd *= nums[i];
            res[i-1] *= suffixProd;
        }
        return res;
    }
}
