class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n-1)
            return false;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge: edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        dfs(adjList, visited, 0);
        for (int i = 0; i < n; i++) {
            if (!visited[i])
                return false;
        }
        return true;
    }

    public void dfs(List<List<Integer>> adjList, boolean[] visited, int node) {
        if (visited[node])
            return;
        visited[node] = true;
        List<Integer> neighbors = adjList.get(node);
        for (int nb: neighbors) {
            dfs(adjList, visited, nb);
        }
    }

}
