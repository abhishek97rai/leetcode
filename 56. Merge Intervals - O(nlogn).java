class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;

        List<List<Integer>> resList = new ArrayList<>();
        int n = intervals.length;
        int i = 0;

        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        int num1 = intervals[0][0];
        int num2 = intervals[0][1];
        for (i = 1; i < n; i++) {
            int num3 = intervals[i][0];
            int num4 = intervals[i][1];
            boolean isMerged = false;
            if (num2 >= num3) {
                intervals[i][1] = Math.max(num2, num4);
                intervals[i][0] = num1;
                isMerged = true;
            }
            if (!isMerged) {
                resList.add(new ArrayList<>(List.of(num1, num2)));
            }
            num1 = intervals[i][0];
            num2 = intervals[i][1];
        }
        resList.add(new ArrayList<>(List.of(intervals[i-1][0], intervals[i-1][1])));
        
        int len = resList.size();
        int[][] res = new int[len][2];
        for (i = 0; i < len; i++) {
            List<Integer> subList = resList.get(i);
            res[i][0] = subList.get(0);
            res[i][1] = subList.get(1);
        }

        return res;
    }
}
