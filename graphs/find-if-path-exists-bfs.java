class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
      boolean[] visited = new boolean[n];
      Map<Integer, List<Integer>> graph = buildGraph(edges);
      Queue<Integer> q = new LinkedList();
      q.add(source);
      visited[source] = true;
      
      while (!q.isEmpty()) {
        int node = q.remove();
        if (node == destination) return true;

        for (int neighbor : graph.get(node)) {
            if (neighbor == destination) return true;
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                q.add(neighbor);
            }
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
