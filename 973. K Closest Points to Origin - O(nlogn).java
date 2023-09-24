class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[] distances = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            distances[i] = calcDistance(points[i]);
        }
        Arrays.sort(distances);
        int distK = distances[k-1];
        int[][] res = new int[k][2];
        int j = 0;
        for (int i = 0; i < points.length; i++) {
            if (calcDistance(points[i]) <= distK) {
                res[j] = points[i];
                j++;
            }
        }
        return res;
    }

    public int calcDistance(int[] point) {
        int x = point[0];
        int y = point[1];
        return x*x + y*y;
    }
}
