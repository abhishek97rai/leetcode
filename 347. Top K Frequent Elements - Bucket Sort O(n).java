class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num: nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        List<Integer>[] bucket = new ArrayList[nums.length+1];
        for (Map.Entry<Integer, Integer> set: countMap.entrySet()) {
            if (bucket[set.getValue()] == null) {
                bucket[set.getValue()] = new ArrayList<Integer>();
            }
            bucket[set.getValue()].add(set.getKey());
        }
        
        List<Integer> resList = new ArrayList<>(k);
        for (int j = bucket.length-1; j >= 0 && resList.size() < k; j--) {
            if (bucket[j] != null) {
                resList.addAll(bucket[j]);
            }
        }
        
        int[] res = new int[k];
        //copy from resList to res
        for (int j = 0; j < resList.size(); j++) {
            res[j] = resList.get(j);
        }
        return res;
    }
}
