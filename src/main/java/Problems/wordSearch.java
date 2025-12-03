package Problems;

public class WordSearch {

    public static void main(String [] args){
        boolean res= exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}},"ABCCED");
        System.out.println(res);
    }
        public static boolean exist(char[][] board, String word) {
            int rows = board.length;
            int cols = board[0].length;

            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    if (dfs(board, r, c, word, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }
        private static boolean dfs(char[][] board, int r, int c, String word, int idx) {
            if (idx == word.length()) return true;
            if (r < 0 || c < 0 || r >= board.length || c >= board[0].length) return false;
            if (board[r][c] != word.charAt(idx)) return false;

            char temp = board[r][c];
            board[r][c] = '#';

            boolean found = dfs(board, r+1, c, word, idx+1) ||
                    dfs(board, r-1, c, word, idx+1) ||
                    dfs(board, r, c+1, word, idx+1) ||
                    dfs(board, r, c-1, word, idx+1);

            board[r][c] = temp; // backtrack
            return found;
        }

}
