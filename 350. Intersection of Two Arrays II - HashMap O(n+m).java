class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> hm = new HashMap<>();
        List<Integer> resList = new ArrayList<>();
        for (int num1: nums1) {
            int count = hm.getOrDefault(num1, 0);
            hm.put(num1, count+1);
        }
        for (int num2: nums2) {
            if (hm.containsKey(num2)) {
                int count = hm.get(num2);
                if (count > 0) {
                    resList.add(num2);
                    hm.put(num2, count-1);
                }
            }
        }
        int[] res = new int[resList.size()];
        int i = 0;
        for (int n: resList) {
            res[i] = n;
            i++;
        }
        return res;
    }
}
