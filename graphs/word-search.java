// Given an m x n grid of characters board and a string word, return true if word exists in the grid.

// The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. 
// The same letter cell may not be used more than once.

public boolean exist(char[][] board, String word) {
    char[] chars = word.toCharArray();
    boolean[][] visited = new boolean[board.length][board[0].length];
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[0].length; j++) {
                if (wordExists(board, i, j, chars, 0, visited)) {
                    return true;
                }
        }
    }
    return false;
}
private boolean wordExists(char[][] board, int i, int j, char[] chars, int index, boolean[][] visited) {
    if (index == chars.length) {
        return true;
    }
    boolean isValid = i >=0 && j >= 0 && i < board.length && j < board[0].length && !visited[i][j];
    if (isValid && chars[index] == board[i][j]) {
        visited[i][j] = true;
        boolean exists =  wordExists(board, i, j+1, chars, index + 1, visited) ||
               wordExists(board, i, j-1, chars, index + 1, visited) ||
               wordExists(board, i+1, j, chars, index + 1, visited) ||
               wordExists(board, i-1, j, chars, index + 1, visited);
        visited[i][j] = false; // if word doesn't exists for change all visited back to false;
        return exists;
    } else {
        return false;
    }

}
