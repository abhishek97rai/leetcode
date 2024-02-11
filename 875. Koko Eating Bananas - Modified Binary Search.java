class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // we will use a modified binary search technique
        // since k can be anything from 1 to 10^9, we will use those as l and r ptr
        // calculate mid, use that as k, and check for all piles, to calculate and 
        // see if time needed to finish all piles is less than or equal to h
        // if thats the case, keep reducing the search space to find minimum k
        int l = 1;
        int r = (int) Math.pow(10,9);
        while (l <= r) {
            int mid = l + (r-l)/2; //doing this to avoid integer overflow
            if (canFinishAllBananas(piles, mid, h)) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        // return l since we need minimum k
        return l;
    }

    public boolean canFinishAllBananas(int[] piles, int k, int h) {
        // need to define totalTime as long since sum of all piles for k=1 can overflow
        long totalTime = 0;
        for (int pile: piles) {
            int hrs = (int) Math.ceil((double) pile/k);
            totalTime += hrs;
        }
        if (totalTime <= h)
            return true;
        else
            return false;
    }
}
