class Solution {
    public int maxProfit(int[] prices) {
        
        int max = 0;
        int len = prices.length;
        
        if (len == 1)
            return 0;
        
        int l = 0;
        int r = 1;
        
        while (r < len) {
            if (prices[l] > prices[r]) {
                l = r;
            } else {
                if ((prices[r] - prices[l]) > max)
                    max = prices[r] - prices[l];
            }
            r++;
        }
        
        return max;
        
    }
}
