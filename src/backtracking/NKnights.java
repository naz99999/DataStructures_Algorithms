package backtracking;

public class NKnights {
    public static void main(String[] args) {
        int N = 4;
        int target = 4;
        boolean[][] board =  new boolean[N][N];
        //System.out.println(nKnights2(board, 0, 0, target)); //Kunal Khushwa approach
        nKnights(board, 0,  target);
    }

    private static void nKnights(boolean[][] board, int col, int target) {
        if (target == 0) {
            displayBoard(board);
            System.out.println();
            return;
        }

//        if (row == board.length) {
//            return;
//        }

        for (int row=0; row<board.length; row++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                nKnights(board, col + 1, target - 1);
                board[row][col] = false;
            }
        }
    }

    private static int nKnights2(boolean[][] board, int row, int col, int target) { //Kunal Khushwa approach
        if (target == 0) {
            displayBoard(board);
            System.out.println();
            return 1;
        }

        int count = 0;

        if (row == board.length - 1 && col == board[0].length) {
            return count;
        }

        if (col == board[0].length) {
            count += nKnights2(board, row + 1, 0, target);
            return count;
        }

        if (isSafe(board, row, col)) {
            board[row][col] = true;
            count += nKnights2(board, row, col + 1, target - 1);
            board[row][col] = false;
        }

        count += nKnights2(board, row, col + 1, target);

        return count;
    }


    private static boolean isSafe(boolean[][] board, int row, int col) {
        //checking 1st possible knight move
        if (row - 1 >= 0 && col + 2 <= board[0].length-1) {
            if (board[row - 1][col + 2]) {
                return false;
            }
        }
        //checking 2nd possible knight move
        if (row - 1 >= 0 && col - 2 >= 0) {
            if (board[row - 1][col - 2]) {
                return false;
            }
        }
        //checking 3rd possible knight move
        if (row - 2 >= 0 && col - 1 >= 0) {
            if (board[row - 2][col - 1]) {
                return false;
            }
        }
        //checking 4th possible knight move
        if (row - 2 >= 0 && col + 1 <= board[0].length-1) {
            if (board[row - 2][col + 1]) {
                return false;
            }
        }
        return true;
    }

    private static void displayBoard(boolean[][] board) {
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (board[i][j]) {
                    System.out.print("K ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }
}
