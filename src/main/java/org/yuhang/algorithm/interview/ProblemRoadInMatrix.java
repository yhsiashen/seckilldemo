package org.yuhang.algorithm.interview;

/**
 * 矩阵中的路径
 */
public class ProblemRoadInMatrix {


    public boolean exist(char[][] board, String word) {
        if(board.length == 0 || board[0].length == 0 || "".equals(word)) return false;
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(board[i][j] == word.charAt(0) && dfs(board,visited,i,j,word)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, boolean[][] visited, int i, int j, String word) {
        if("".equals(word)) return true;
        if(i<0 || i>=board.length || j<0 || j>=board[0].length|| visited[i][j] || board[i][j] != word.charAt(0)) return false;
        visited[i][j] = true;
        if(dfs(board, visited, i + 1, j, word.substring(1)) ||
                dfs(board, visited, i - 1, j, word.substring(1)) ||
                dfs(board, visited, i, j + 1, word.substring(1)) ||
                dfs(board, visited, i, j - 1, word.substring(1)))
            return true;
        visited[i][j] = false;//回溯
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'a','b'},{'c','d'}};
        System.out.println(new ProblemRoadInMatrix().exist(board,"cdba"));
    }
}
