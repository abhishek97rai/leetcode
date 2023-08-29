class Solution {
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), res);
        return res;
    }

    public void backtrack(int[] nums, List<Integer> temp, List<List<Integer>> res) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (temp.contains(nums[i]))
                    continue;
                temp.add(nums[i]);
                backtrack(nums, temp, res);
                temp.remove(temp.size() - 1);
            }
        }
    }

}
