class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // collision takes place only in one condition - when next asteroid < 0 and its prev asteroid > 0
        // so we use stack to make use of this fact
        // use a flag to keep track of whether we need to push current asteroid into stack or not
        Stack<Integer> stack = new Stack<>();
        for (int asteroid: asteroids) {
            boolean pushAsteroid = true;
            while (!stack.isEmpty() && (stack.peek() > 0 && asteroid < 0)) {
                // 3 cases
                // case 1 - size of incoming asteroid greater than stack top asteroid
                if (Math.abs(asteroid) > Math.abs(stack.peek())) {
                    // stack top destroyed, consider next stack top, ie continue within while loop
                    stack.pop();
                    continue;
                }
                // case 2 - size of stack top and incoming asteroids are same
                else if (Math.abs(asteroid) == Math.abs(stack.peek())) {
                    // both destroyed
                    stack.pop();
                    pushAsteroid = false;
                    break;
                }
                // case 3 - size of stack top is bigger
                else {
                    // incoming destroyed
                    pushAsteroid = false;
                    break;
                }
            }
            if (pushAsteroid)
                stack.push(asteroid);
        }

        int[] res = new int[stack.size()];
        for (int i = res.length-1; i >= 0; i--) {
            res[i] = stack.pop();
        }

        return res;
    }
}
