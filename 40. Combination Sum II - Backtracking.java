class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> resList = new ArrayList<>();
        Arrays.sort(candidates);
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
                if (i > start && candidates[i] == candidates[i-1])
                    continue;
                tempList.add(candidates[i]);
                backtrack(resList, tempList, candidates, target-candidates[i], i+1);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}
