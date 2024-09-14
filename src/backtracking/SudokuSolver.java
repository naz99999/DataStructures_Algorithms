package backtracking;

public class SudokuSolver {
    public static void main(String[] args) {
        int[][] board = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        sudokuSolver(board, 0, 0);
    }

    private static void sudokuSolver(int[][] board, int row, int col) {
        if (row == board.length - 1 && col == board.length) {
            System.out.println("Base");
            displayBoard(board);
            return;
        }

        if (col == board.length) {
            sudokuSolver(board, row + 1, 0);
            return;
        }

        if (board[row][col] != 0) {
            sudokuSolver(board, row, col + 1);
            return;
        }

        for (int number = 1; number <= 9; number++) {
            if (isSafe(board, row, col, number)) {
                board[row][col] = number;
                sudokuSolver(board, row, col + 1);
                board[row][col] = 0;
            }
        }
    }

    private static boolean isSafe(int[][] board, int row, int col, int number) {
        //check rows
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == number) {
                return false;
            }
        }

        //check columns
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == number) {
                return false;
            }
        }

        //check boxes
        int sqrt = (int) (Math.sqrt(board.length));
        int boxRowStart = row - (row % sqrt);
        int boxColStart = col - (col % sqrt);

        for (int i = boxRowStart; i < boxRowStart + sqrt; i++) {
            for (int j = boxColStart; j < boxColStart + sqrt; j++) {
                if (board[i][j] == number) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void displayBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
