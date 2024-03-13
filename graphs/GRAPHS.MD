# Graphs


### How to build a graph if only edges are provided
`edges = [[0,1],[1,2],[2,0]]`
```java
Map<Integer, List<Integer>> graph = new HashMap<>();
for (int[] edge : edges) {
    int a = edge[0], b = edge[1];
    if (graph.containsKey(a)) {
        graph.get(a).add(b);
    } else {
        graph.put(a, Arrays.asList(b));
    }
    // do the same for a<->b if edges are bi-directional
}
```

## Problems

1. [Find the nearest distance between Xs and Ys in a maze](https://github.com/LenarBad/interview-questions/blob/main/graphs/nearest-distance-between-x-and-y-in-maze.java)
2. [Find if path exists - DFS](https://github.com/LenarBad/interview-questions/blob/main/graphs/find-if-path-exists-dfs.java) [Find if path exists - BFS](https://github.com/LenarBad/interview-questions/blob/main/graphs/find-if-path-exists-bfs.java)
