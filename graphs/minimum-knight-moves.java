// In an infinite chess board with coordinates from -infinity to +infinity, you have a knight at square [0, 0].

public static final DIRS = new int[][]{{1,2}, {1,-2}, {2,1}, {2,-1}, {-1,2}, {-1,-2}, {-2,1}, {-2,-1}};

public int minKnightMoves(int x, int y) {
  Set<int[]> visited = new HashSet();
  Queue<int[]> q = new LinkedList();
  q.offer(new int[]{0, 0});
  visited.add(new int[]{0, 0});
  int moves = 0;
  int currentLevelNodes = 1;
  while (!q.isEmpty()) {
    for (int i = 0; i < currentLevelNodes; i++) {
      int[] curr = q.poll();
      if (!visited.contains(curr)) {
        if (curr[0] == x && curr[1] == y) {
          return moves;
        }
        for (int[] dir : DIRS) {
          int[] next = new int[]{curr[0] + dir[0], curr[1] + dir[1]};
          q.offer(next);
          visited.add(next);
        }
      }
    }
    moves++;
    currentLevelNodes = q.size();
  }
  return -1;
}
