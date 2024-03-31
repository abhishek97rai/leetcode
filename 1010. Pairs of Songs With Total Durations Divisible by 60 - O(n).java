class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        //2 cases need to be covered
        //1. when a%60==0 && b%60==0
        //2. when a%60+b%60 == 60
        //to achieve this in O(n), maintain remainder[60] array, which will hold t%60 counts
        int[] remainder = new int[60];
        int res = 0;
        for (int t: time) {
            //a%60==0 && b%60==0
            if (t % 60 == 0) {
                res += remainder[0];
            } else {
                //a%60+b%60 == 60
                res += remainder[60 - (t % 60)];
            }
            remainder[t % 60]++;
        }
        return res;
    }
}
