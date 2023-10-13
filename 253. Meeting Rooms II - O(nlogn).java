class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 1)
            return 1;
        Arrays.sort(intervals, (i, j) -> Integer.compare(i[0], j[0]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            int minEndTime = minHeap.peek();
            if (intervals[i][0] >= minEndTime) {
                minHeap.remove();
            }
            minHeap.add(intervals[i][1]);
        }
        return minHeap.size();
    }
}
