class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> resList = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n-2; i++) {
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                int a = nums[i];
                int b = nums[l];
                int c = nums[r];
                int sum = a + b + c;
                if (sum < 0)
                    l++;
                else if (sum > 0)
                    r--;
                else {
                    List<Integer> innerList = new ArrayList<>();
                    innerList.add(a);
                    innerList.add(b);
                    innerList.add(c);
                    resList.add(innerList);
                    l++;
                    while (nums[l] == nums[l-1] && l < r)
                        l++;
                }
            }
        }
        return resList;
    }
}
