class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>> resList = new ArrayList<>();
        
        int i = 0;
        while (i < intervals.length && newInterval[0] > intervals[i][1]) {
            resList.add(new ArrayList<>(List.of(intervals[i][0], intervals[i][1])));
            i++;
        }

        while (i < intervals.length && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        resList.add(new ArrayList<>(List.of(newInterval[0], newInterval[1])));
        while (i < intervals.length) {
            resList.add(new ArrayList<>(List.of(intervals[i][0], intervals[i][1])));
            i++;
        }

        int[][] res = new int[resList.size()][2];
        for (int j = 0; j < res.length; j++) {
            res[j][0] = resList.get(j).get(0);
            res[j][1] = resList.get(j).get(1);
        }
        return res;
    }
}
