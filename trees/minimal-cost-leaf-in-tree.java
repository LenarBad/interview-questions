public class Node {
  List<Edge> edges;
}

public class Edge {
  int cost;
  Node target;
}

private Node result = null;
private int minSum = Integer.MAX_VALUE;

Node minCostLeaf(Node root) {
  dfs(root, 0);
  return result;
}

private void dfs(Node node, int sum) {
  if (node.edges == null || node.edges.isEmpty()) {
    if (sum < minSum) {
      minSum = sum;
      result = node;
  }
  for (Edge edge : node.edges) {
    dfs(edge.target, sum + edge.cost);
  }
}
