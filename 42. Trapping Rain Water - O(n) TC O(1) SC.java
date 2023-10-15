class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length-1;
        int result = 0;
        while (left < right) {
            if (height[left] <= height[right]) {
                int curr = height[left];
                left++;
                while (height[left] < curr) {
                    result += curr - height[left];
                    left++;
                }
            } else {
                int curr = height[right];
                right--;
                while (height[right] < curr) {
                    result += curr - height[right];
                    right--;
                }
            }
        }
        return result;
    }
}
