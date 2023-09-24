class Solution {
    public int[] findBuildings(int[] heights) {
        int max = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = heights.length-1; i >= 0; i--) {
            if (heights[i] > max) {
                res.add(i);
                max = heights[i];
            }
        }
        int i = 0;
        int[] ind = new int[res.size()];
        for (int j = res.size()-1; j >= 0; j--) {
            ind[i] = res.get(j);
            i++;
        }
        return ind;
    }
}
