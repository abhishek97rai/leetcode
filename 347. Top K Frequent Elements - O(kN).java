class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num: nums) {
            if (!countMap.containsKey(num)) {
                countMap.put(num, 1);
            } else {
                countMap.put(num, countMap.get(num) + 1);
            }
        }
        
        int[] res = new int[k];
        k--;
        while (k >= 0) {
            int val = 0;
            int max = Integer.MIN_VALUE;
            for (Map.Entry<Integer, Integer> set: countMap.entrySet()) {
                if (set.getValue() > max) {
                    max = set.getValue();
                    val = set.getKey();
                }
            }
            countMap.remove(val);
            res[k] = val;
            k--;
        }
        return res;
    }
}
