class Solution {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int currInd = queue.poll();
            if (arr[currInd] == 0)
                return true;
            else if (arr[currInd] == -1)
                continue;
            else {
                if (currInd + arr[currInd] < arr.length) {
                    queue.add(currInd + arr[currInd]);
                }
                if (currInd - arr[currInd] >= 0) {
                    queue.add(currInd - arr[currInd]);
                }
                //mark as visited
                arr[currInd] = -1;
            }
        }
        return false;
    }
}
