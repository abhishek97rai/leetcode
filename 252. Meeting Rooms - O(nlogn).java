class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length <= 1)
            return true;
        Arrays.sort(intervals, (i, j) -> Integer.compare(i[0], j[0]));
        int min = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < min)
                return false;
            min = intervals[i][1];
        }
        return true;
    }
}
