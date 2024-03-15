class Solution {
    public int maxProfit(int[] prices) {
        //simple greedy funda -- if current day price is more than previous day price, add profit to result
        //if not, do nothing, keep iterating
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1])
                res += prices[i] - prices[i-1];
        }
        return res;
    }
}
