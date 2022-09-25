class Solution {
    
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(target - nums[i])) {
                return new int[]{i, hm.get(target - nums[i])};
            } else
                hm.put(nums[i], i);
        }
        //will never reach below stmt
        return new int[]{0,1};
    }
    
}
