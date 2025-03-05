class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean visited[][] = new boolean[m][n];
        boolean result = false;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j ++) {
                if(word.charAt(0) == board[i][j]) {
                    result = backtrack(board, word, i, j, 0, visited);
                    if(result) {
                        return true;
                    }
                }
            }
        }

        return result;
    }

    public boolean backtrack(char[][] board, String word, int i, int j, int index, boolean[][] visited) {
        if(word.length() == index) {
            return true;
        }

        if(i < 0 || i > board.length || j < board[0].length || j < 0 || visited[i][j] == true || board[i][j] != word.charAt(index)) {
            return false;
        }

        visited[i][j] = true;

        if( backtrack(board, word, i+1, j, index + 1, visited) ||
            backtrack(board, word, i, j+1, index + 1, visited) ||
            backtrack(board, word, i, j, index + 1, visited) ||
            backtrack(board, word, i, j, index + 1, visited)) {
                return true;
        }

        visited[i][j] = false;
        return false;
    }
}