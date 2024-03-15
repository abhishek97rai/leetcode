class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //first thing we need to verify is:
        //if sum(gas) < sum(cost), it means we'll run out of gas, hence not possible to complete an entire trip - return -1
        //now we can iterate over the arrays once, and keep calculating diff b/w gas and cost
        //if it is negative, it means that cannot be starting position of the trip - reset total to 0, set start to i+1
        //if not, it means it is a possible start position, and we keep adding difference to total
        //and then return start index at the end
        int gasSum = 0;
        for (int g: gas) {
            gasSum += g;
        }

        int costSum = 0;
        for (int c: cost) {
            costSum += c;
        }

        if (gasSum < costSum)
            return -1;

        int total = 0;
        int resIdx = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            if (total < 0) {
                total = 0;
                resIdx = i + 1;
            }
        }
        
        return resIdx;
    }
}
