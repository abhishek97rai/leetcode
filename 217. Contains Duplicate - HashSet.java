class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hs = new HashSet<>();
        for (int num: nums) {
            boolean added = hs.add(num);
            if (!added)
                return true;
        }
        return false;
    }
}
