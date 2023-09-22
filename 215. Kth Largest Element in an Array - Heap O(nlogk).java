class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, (a, b) -> b - a);
        for (int num: nums) {
            heap.add(num);
        }
        int i = 1;
        while (i != k) {
            i++;
            heap.remove();
        }
        return heap.peek();
    }
}
