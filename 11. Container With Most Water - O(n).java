class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int l = 0;
        int r = height.length-1;
        while (l < r) {
            int min = Math.min(height[l], height[r]);
            max = Math.max(max, min*(r-l));
            if (height[l] > height[r])
                r--;
            else
                l++;
        }
        return max;
    }
}
