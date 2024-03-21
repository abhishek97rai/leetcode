class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int maxWeight = Integer.MIN_VALUE;
        int totalWeight = 0;
        for (int weight: weights) {
            if (weight > maxWeight) {
                maxWeight = weight;
            }
            totalWeight += weight;
        }

        int l = maxWeight;
        int r = totalWeight;
        while (l < r) {
            int minCapacity = l + (r-l)/2;
            //calculate reqDays here
            int reqDays = 1;
            int currCapacity = 0;
            for (int i = 0; i < weights.length; i++) {
                if (currCapacity + weights[i] > minCapacity) {
                    reqDays++;
                    currCapacity = 0;
                }
                currCapacity += weights[i];
            }
            if (reqDays > days) {
                l = minCapacity + 1;
            } else {
                r = minCapacity;
            }
        }
        return l;
    }
}
