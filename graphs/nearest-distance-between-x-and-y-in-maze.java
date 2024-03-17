//    OOOOOSYOO
//    OOOOOXSOO
//    OOOOOOOYO
//    OXOOOOOOO
//    OOOOOOYOO

// map: M x N, K 'X's in the map

// find the neareast distance between any X and Y

// O: empty slot
// X: start points
// Y: destinations
// S: obstacles
    private static final int[][] DIRECTIONS = new int[][]{
            {-1,  0},
            { 1,  0},
            { 0, -1},
            { 0,  1}
    };

    public int nearestDistance(Character[][] map) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[map.length][map[0].length];
        // find out the starting points
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                // insert all the starting points into the queue
                if (map[i][j] == 'X') {
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        int currentLevelQueueSize = q.size();
        int distance = 0;

        while (!q.isEmpty()) {
            for (int i = 0; i < currentLevelQueueSize; ++i) {
                int[] cur = q.poll();
                boolean isValid = cur[0] >= 0 && cur[1] > 0 && cur[0] < map.length
                        && cur[1] < map[0].length && map[cur[0]][cur[1]] != 'S' && visited[cur[0]][cur[1]];

                if (isValid) {
                    if (map[cur[0]][cur[1]] == 'Y') {
                        return distance + 1;
                    }
                    
                    visited[cur[0]][cur[1]] = true;
                    for (int[] direction : DIRECTIONS) {
                        int coordX = cur[0] + direction[0];
                        int coordY = cur[1] + direction[1];
                        
                        q.offer(new int[]{coordX, coordY});
                    }
                }
            }
            currentLevelQueueSize = q.size();
            distance++;
        }
        return -1;
    }
