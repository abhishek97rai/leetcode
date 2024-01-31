class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int l = 0;
        int r = numbers.length-1;
        int sum = 0;
        while (l < r) {
            sum = numbers[l] + numbers[r];
            if (sum < target) {
                l++;
            } else if (sum > target) {
                r--;
            } else {
                res[0] = l+1;
                res[1] = r+1;
                break;
            }
        }
        return res;
    }
}
