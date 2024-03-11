OOOOOSYOO
OOOOOXSOO
OOOOOOOYO
OXOOOOOOO
OOOOOOYOO

map: M x N, K 'X's in the map 

find the neareast distance between any X and Y

// O: empty slot
// X: start points
// Y: destinations
// S: obstacles
public int nearestDistance(Character[][] map) {
    int minDistance = Integer.MAX_VALUE;
  	for (int i = 0; i < map.length; i++) {
      	for (int j = 0; j < map[0].length; j++) {   // MxN iterations
          	if (map[i][j] == 'X') {
                Queue<int[]> q = new LinkedList();
                boolean[][] visited = new int[map.length][map.[0].length];
              	q.add({i + 1, j, 1});
                q.add({i - 1, j, 1});
                q.add({i, j + 1, 1});
                q.add({i, j - 1, 1});
              	while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    boolean isValid = cur[0] >= 0 && cur[1] > 0 && cur[0] < map.length && cur[1] < map[0].length;
                  	if (isValid) {
                      	if (map[cur[0]][cur[1]] == 'Y') {
                        	  minDistance = Math.min(minDistance, cur[2]);
                        }
                        if (map[cur[0]][cur[1]] == 'S' || visited[cur[0]][cur[1]]) {
                        	  continue;
                        }
                      	if (map[cur[0]][cur[1]] == 'O') {
                            visited[cur[0]][cur[1]] = true;
                        	q.add({cur[0] + 1, cur[1], cur[2] + 1});
                    		q.add({cur[0] - 1, cur[1], cur[2] + 1});
                   	 		q.add({cur[0], cur[1] + 1, cur[2] + 1});
                    		q.add({cur[0], cur[1] - 1, cur[2] + 1});
                        }
                    }
                }
            }
        }
    }
    return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
}
