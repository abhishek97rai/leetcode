class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }
        int maxLen = 1;
        int currLen = 1;
        for (int num: set) {
            if (!set.contains(num-1)) {
                while (set.contains(num+1)) {
                    currLen++;
                    num = num+1;
                }
                maxLen = Math.max(maxLen, currLen);
                currLen = 1;
            }
        }
        return maxLen;
    }
}
