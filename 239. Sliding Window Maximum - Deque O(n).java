class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        int j = 0;
        //Insert index in deque
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            //remove element that is out of window
            if (!q.isEmpty() && q.peekFirst() == i - k) {
                q.pollFirst();
            }
            //if new number to be checked is greater than number at rear end of queue
            //remove that number from rear end
            //keep repeating until queue is empty or rear end element is >= curr element
            while (!q.isEmpty() && nums[i] > nums[q.peekLast()]) {
                q.pollLast();
            }
            //add current index to deque
            q.offer(i);
            //update res with value from front end of the queue, which is the max window element
            if (i >= k - 1) {
                ans[j++] = nums[q.peekFirst()];
            }
        }
        return ans;
    }
}
