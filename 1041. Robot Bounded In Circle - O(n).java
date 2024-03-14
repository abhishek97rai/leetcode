class Solution {
    public boolean isRobotBounded(String instructions) {
        // it is bounded only in 2 cases:
        // 1. when it is not facing north, OR
        // 2. it is still at origin
        // use directions 2d array to track both direction and coordinates
        int[][] directions = new int[][]{{0,1},{-1,0},{0,-1},{1,0}};
        int dir = 0; //north
        int x = 0;
        int y = 0;
        for (char ch: instructions.toCharArray()) {
            if (ch == 'L') {
                dir = (dir + 1) % 4;
            } else if (ch == 'R') {
                dir = (dir + 3) % 4;
            } else {
                x += directions[dir][0];
                y += directions[dir][1];
            }
        }
        return (dir != 0) || (x == 0 && y == 0);
    }
}
