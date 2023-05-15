class Solution {
    public int mySqrt(int x) {
        if (x == 0)
            return 0;
        int left = 1;
        int right = x;
        int mid = 1;
        while (left <= right) {
            mid = left + (right-left)/2;
            if (mid <= x/mid && (mid+1) > x/(mid+1))
                return mid;
            else if (mid < x/mid)
                left = mid+1;
            else
                right = mid-1;
        }
        return mid;
    }
}
