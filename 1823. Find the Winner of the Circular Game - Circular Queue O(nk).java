class Solution {
    public int findTheWinner(int n, int k) {
        // logic is - use a circular queue kind of implementation
        // we can do this by using linked list implementation of queue
        // just use queue.add(queue.poll()) to make a circular queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < k-1; j++) {
                queue.add(queue.poll());
            }
            queue.poll();
        }
        return queue.poll();
    }
}
