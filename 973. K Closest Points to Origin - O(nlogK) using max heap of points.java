class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(k, (a,b) -> ((b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1])));
        for (int i = 0; i < points.length; i++) {
            int[] dist = points[i];
            maxHeap.add(dist);
            if (maxHeap.size() > k) {
                maxHeap.remove();
            }
        }
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i] = maxHeap.remove();
        }
        return res;
    }
}
