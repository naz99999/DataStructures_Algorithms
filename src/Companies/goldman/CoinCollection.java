package Companies.goldman;

public class CoinCollection {
    public static void main(String[] args) {
        // Sample test grids
        int[][] grid1 = {
                {0, 3, 1, 1},
                {2, 0, 0, 4},
                {1, 5, 3, 1}
        };

        System.out.println("Grid 1 Max Coins:");
        int maxCoins1 = maxCoinsPathClaudeMemoization(grid1);
        System.out.println("Maximum coins collected: " + maxCoins1);

        // Another test grid
        int[][] grid2 = {
                {1, 3, 1, 5},
                {2, 2, 4, 1},
                {5, 0, 2, 3},
                {0, 6, 1, 2}
        };

        System.out.println("\nGrid 2 Max Coins:");
        int maxCoins2 = maxCoinsPathClaudeMemoization(grid2);
        System.out.println("Maximum coins collected: " + maxCoins2);
    }

    // Method to find the maximum number of coins that can be collected
    // Only allowed to move North (up) or East (right)
    public static int maxCoinsPathNamanMemoization(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] memo = new int[n][m];
        memo[n - 1][0] = grid[n - 1][0];
        maxCoinsRecursive(grid, n - 1, 0, memo);
        return memo[0][m - 1];
    }

    // Optional helper methods you might want to implement
    // 1. Recursive solution with memoization
    private static void maxCoinsRecursive(int[][] grid, int row, int col, int[][] memo) {
        // TODO: Implement recursive solution
        if (row == 0 && col == grid[0].length - 1) {
            return;
        }

        if (row - 1 >= 0 && memo[row - 1][col] < memo[row][col] + grid[row - 1][col]) {
            memo[row - 1][col] = memo[row][col] + grid[row - 1][col];
            maxCoinsRecursive(grid, row - 1, col, memo);
        }

        if (col + 1 < grid[0].length && memo[row][col + 1] < memo[row][col] + grid[row][col + 1]) {
            memo[row][col + 1] = memo[row][col] + grid[row][col + 1];
            maxCoinsRecursive(grid, row, col + 1, memo);
        }
    }

    public static int maxCoinsPathClaudeMemoization(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] memo = new int[n][m];
        return maxCoinsRecursive2(grid, n - 1, 0, memo);
    }

    // Optional helper methods you might want to implement
    // 1. Recursive solution with memoization
    private static int maxCoinsRecursive2(int[][] grid, int row, int col, int[][] memo) {
        // TODO: Implement recursive solution
        if (row == 0 && col == grid[0].length - 1) {
            return grid[row][col];
        }

        if (memo[row][col] != 0) {
            return memo[row][col];
        }

        int north = Integer.MIN_VALUE;
        int east = Integer.MIN_VALUE;

        if (row - 1 >= 0) {
            north = maxCoinsRecursive2(grid, row - 1, col, memo);
        }

        if (col + 1 < grid[0].length) {
            east = maxCoinsRecursive2(grid, row, col + 1, memo);
        }

        memo[row][col] = grid[row][col] + Math.max(north, east);
        return memo[row][col];
    }



    // 2. Dynamic Programming solution
    private static int maxCoinsDynamicProgramming(int[][] grid) {
        // TODO: Implement DP solution
        return 0;
    }
}












