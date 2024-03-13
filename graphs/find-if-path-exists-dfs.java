class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
      boolean[] visited = new boolean[n];
      Map<Integer, List<Integer>> graph = buildGraph(edges);
      return dfs(graph, visited, source, destination);
    }
    
    private boolean dfs(Map<Integer, List<Integer>> graph, boolean[] visited, int node, int destination) {
      if (node == destination) return true;
      if (visited[node]) {
        return false;
      }
      visited[node] = true;
      for (int neighbor : graph.get(node)) {
        if (dfs(graph, visited, neighbor, destination)) {
            return true;
        }
      }
      return false;
    }

    private Map<Integer, List<Integer>> buildGraph(int[][] edges) {
      Map<Integer, List<Integer>> graph = new HashMap<>();
      for (int[] edge : edges) {
        int a = edge[0], b = edge[1];
        if (graph.containsKey(a)) {
            graph.get(a).add(b);
        } else {
            List<Integer> newList = new ArrayList();
            newList.add(b);
            graph.put(a, newList);
        }
        if (graph.containsKey(b)) {
            graph.get(b).add(a);
        } else {
            List<Integer> newList = new ArrayList();
            newList.add(a);
            graph.put(b, newList);
        }
      }
      return graph;
    }
}
