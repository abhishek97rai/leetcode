class Solution {
    public int[][] highFive(int[][] items) {
        //create a TreeMap that will have id as its key and a MinHeap (PriorityQueue) as its value
        //The MinHeap will contain the top 5 scores for corresponding id
        //we will use a TreeMap because we need to maintain order of id as well, specifically in increasing order
        //once we have the treemap ready, we will iterate its keyset and get the top 5 scores by 
        //popping the corresponding minheaps 5 times and then calculate its avg and store in result array

        Map<Integer, Queue<Integer>> tm = new TreeMap<>();
        for (int[] item: items) {
            int id = item[0];
            int score = item[1];
            if (!tm.containsKey(id)) {
                tm.put(id, new PriorityQueue<Integer>());
            }
            tm.get(id).add(score);
            if (tm.get(id).size() > 5)
                tm.get(id).remove();
        }

        int[][] res = new int[tm.size()][2];
        int j = 0;
        for (int id: tm.keySet()) {
            int sum = 0;
            Queue<Integer> minHeap = tm.get(id);
            for (int k = 0; k < 5; k++) {
                sum += minHeap.poll();
            }
            int avg = sum/5;
            res[j][0] = id;
            res[j][1] = avg;
            j++;
        }
        return res;
    }
}
