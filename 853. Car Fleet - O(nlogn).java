class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // create a combined array including both position and speed,
        // because we need to sort based on the position and then refer the corresponding speeds
        // once we have that, we will iterate that array in reverse order
        // we calculate the time for each car, and push it into stack if its empty or 
        // if that time is greater than stack top's time (because that means it'll reach later than the car ahead of it)
        // finally we return stack size, which represents the count of total car fleets
        int[][] combined = new int[speed.length][2];
        for (int i = 0; i < speed.length; i++) {
            combined[i][0] = position[i];
            combined[i][1] = speed[i];
        }
        // sort based on position
        Arrays.sort(combined, Comparator.comparingInt(arr -> arr[0]));
        Stack<Double> stack = new Stack<>();
        for (int i = combined.length-1; i >= 0; i--) {
            // calculate T = D / S
            double currTime = (double) (target - combined[i][0]) / combined[i][1];
            if (stack.isEmpty() || currTime > stack.peek()) {
                stack.push(currTime);
            }
        }
        return stack.size();
    }
}
