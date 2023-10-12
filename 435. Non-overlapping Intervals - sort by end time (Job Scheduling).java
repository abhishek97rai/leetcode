class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (i, j) -> Integer.compare(i[1], j[1]));
        int min = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] >= min) {
                min = intervals[i][1];
            } else {
                count++;
            }
        }
        return count;
    }
}
