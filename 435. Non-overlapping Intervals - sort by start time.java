class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 1)
            return 0;
        Arrays.sort(intervals, (i, j) -> Integer.compare(i[0], j[0]));
        int i = 0;
        int j = 1;
        int count = 0;
        while (i < intervals.length && j < intervals.length) {
            if (intervals[j][0] >= intervals[i][1]) {
                i = j;
                j++;
            } else {
                count++;
                if (intervals[i][1] < intervals[j][1]) {
                    j++;
                } else {
                    i = j;
                    j++;
                }
            }
        }
        return count;
    }
}
