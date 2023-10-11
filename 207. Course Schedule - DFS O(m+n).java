class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] prerequisite: prerequisites) {
            adjList.get(prerequisite[0]).add(prerequisite[1]);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] inStack = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (dfsHasCycle(i, adjList, visited, inStack)) {
                return false;
            }
        }
        return true;
    }

    public boolean dfsHasCycle(int node, List<List<Integer>> adjList, boolean[] visited, boolean[] inStack) {
        if (inStack[node])
            return true;
        if (visited[node])
            return false;
        inStack[node] = true;
        visited[node] = true;
        List<Integer> neighbors = adjList.get(node);
        for (int nb: neighbors) {
            if (dfsHasCycle(nb, adjList, visited, inStack)) {
                return true;
            }
        }
        inStack[node] = false;
        return false;
    }
}
