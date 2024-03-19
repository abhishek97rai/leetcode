class Solution {
    public int longestMountain(int[] arr) {
        if (arr.length < 3)
            return 0;
        int l = 0;
        int r = 1;
        int max = 0;
        while (r < arr.length) {
            if (arr[l] >= arr[r]) {
                l = r;
                r++;
            } else {
                int count = 0;
                boolean isRising = false;
                while (r < arr.length && arr[l] < arr[r]) {
                    isRising = true;
                    count++;
                    l++;
                    r++;
                }
                boolean isFalling = false;
                while (r < arr.length && arr[l] > arr[r]) {
                    isFalling = true;
                    count++;
                    l++;
                    r++;
                }
                if (isRising && isFalling) {
                    max = Math.max(max, count+1);
                }
            }
        }
        return max;
    }
}
