# Graphs


### How to build a graph if only edges are provided
`edges = [[0,1],[1,2],[2,0]]`
```java
        Map<Integer, List<Integer>> graph = new HashMap<>();
        boolean[] seen = new boolean[n];

        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            graph.computeIfAbsent(a, val -> new ArrayList<Integer>()).add(b);
            graph.computeIfAbsent(b, val -> new ArrayList<Integer>()).add(a); // if bi-directional edges
        }
```

## Problems

1. [Find the nearest distance between Xs and Ys in a maze](https://github.com/LenarBad/interview-questions/blob/main/graphs/nearest-distance-between-x-and-y-in-maze.java)
