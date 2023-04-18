class Solution {
    public int maxProfit(int[] prices) {
        return dfs(prices, 0, true, new HashMap<String, Integer>());
    }

    public int dfs(int[] prices, int index, boolean buying, Map<String, Integer> dp) {
        //base case 1 - outside array profit would be zero
        if (index >= prices.length)
            return 0;
        //base case 2 - fetch from cache if already present there
        if (dp.containsKey(index + "-" + buying))
            return dp.get(index + "-" + buying);

        if (buying) {
            int buy = dfs(prices, index+1, !buying, dp) - prices[index];
            int cooldown = dfs(prices, index+1, buying, dp);
            int maxProfit = Math.max(buy, cooldown);
            dp.put((index + "-" + buying), maxProfit);
        } else {
            int sell = dfs(prices, index+2, !buying, dp) + prices[index];
            int cooldown = dfs(prices, index+1, buying, dp);
            int maxProfit = Math.max(sell, cooldown);
            dp.put((index + "-" + buying), maxProfit);
        }

        return dp.get(index + "-" + buying);
    }
}
