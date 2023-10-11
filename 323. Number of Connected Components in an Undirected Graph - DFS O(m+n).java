class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge: edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(adjList, visited, i);
            }
        }
        return count;
    }

    public void dfs(List<List<Integer>> adjList, boolean[] visited, int node) {
        visited[node] = true;
        List<Integer> neighbors = adjList.get(node);
        for (int nb: neighbors) {
            if (!visited[nb]) {
                dfs(adjList, visited, nb);
            }
        }
    }
}
