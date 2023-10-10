class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> resList = new ArrayList<>();
        backtrack(resList, new ArrayList<>(), candidates, target, 0);
        return resList;
    }

    public void backtrack(List<List<Integer>> resList, List<Integer> tempList, int[] candidates, int target, int start) {
        if (target < 0)
            return;
        if (target == 0)
            resList.add(new ArrayList<>(tempList));
        else {
            for (int i = start; i < candidates.length; i++) {
                tempList.add(candidates[i]);
                backtrack(resList, tempList, candidates, target-candidates[i], i);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}
