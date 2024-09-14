package backtracking;

public class Nqueens {
    public static void main(String[] args) {
        int N = 4;
        boolean[][] board =  new boolean[N][N];
        System.out.println(nQueens(board, 0));
    }

    private static int nQueens(boolean[][] board, int row) {
        if (row == board.length) {
            displayBoard(board);
            System.out.println();
            return 1;
        }

        int count = 0;
        for (int col=0; col<board[0].length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                count += nQueens(board, row + 1);
                board[row][col] = false;
            }
        }
        return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        //checking vertical line
        if (row>0) {
            for (int i=0; i<row; i++) {
                if (board[i][col]) {
                    return false;
                }
            }
        }
        //checking left diagonal line
        int leftDiagonal = Math.min(row, col);
        for (int i=1; i<=leftDiagonal; i++) {
            if (board[row-i][col-i]) {
                return false;
            }
        }
        //checking right diagonal line
        int rightDiagonal = Math.min(row, board.length - col - 1);
        for (int i=1; i<=rightDiagonal; i++) {
            if (board[row-i][col+i]) {
                return false;
            }
        }
        return true;
    }

    private static void displayBoard(boolean[][] board) {
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (board[i][j]) {
                    System.out.print("Q ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
