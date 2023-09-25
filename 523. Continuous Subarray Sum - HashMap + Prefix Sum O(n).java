class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        Map<Integer, Integer> hm = new HashMap<>();
        hm.put(0,0);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (!hm.containsKey(sum % k)) {
                hm.put(sum % k, i+1);
            } else {
                int index = hm.get(sum % k);
                if ((i+1) - index > 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
