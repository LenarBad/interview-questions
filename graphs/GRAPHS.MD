# Graphs

## BFS (Breadth First Search) Algorythm

s - is the start vertex;

```java
    for each vertex u {
        state[u] = UNDISCOVERED; parent[u] = null; distance[u] = Integer.MAX_VALUE;
    }
    state[s] = DISCOVERED; distance[s] = 0; parent[u] = null;
    create queue
    queue.add(s)
    while (!queue.isEmpty()) {
        u = queue.remove();
        // Any additional processing if needed here or after the for loop
        for each v adjacent to u {
            if (state[v] == UNDISCOVERED) {
                state[v] = DISCOVERED; parent[v] = u; distance[v] = distance[u] + 1;
                queue.add(v);
            }
        }
        state[u] = PROCESSED;
    }
```

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

<ol>
    <li><a href="https://github.com/LenarBad/interview-questions/blob/main/graphs/nearest-distance-between-x-and-y-in-maze.java">Find the nearest distance between Xs and Ys in a maze</a></li>
    <li><a href="https://github.com/LenarBad/interview-questions/blob/main/graphs/find-if-path-exists-dfs.java">Find if path exists. DFS</a> - <a href="https://github.com/LenarBad/interview-questions/blob/main/graphs/find-if-path-exists-bfs.java">Find if path exists. BFS</a></li>
    <li><a href="https://github.com/LenarBad/interview-questions/blob/main/graphs/minimum-knight-moves.java">Minimum Knight Moves</a></li>
    <li><a href="https://github.com/LenarBad/interview-questions/blob/main/graphs/word-search.java">Word Search</a> - <a href="https://leetcode.com/problems/word-search">79. Leetcode</a></li>
</ol>
