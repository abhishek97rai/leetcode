class Solution {
    public int findDuplicate(int[] nums) {
        // use floyd's algorithm
        // start with slow and fast pointers
        // find intersection
        // once reached intersection point, reset slow to 0
        // now both slow and fast will move one step at a time until they meet
        // this is the starting point of the cycle in the linked list
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
