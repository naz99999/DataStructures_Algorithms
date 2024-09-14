package backtracking;

import java.util.Arrays;

public class Maze {
    public static void main(String[] args) {
        //int[][] maze = new int[3][3];
        boolean[][] maze =  {
                {true,true,true},
                {true,true,true},
                {true,true,true},
        };
        //System.out.println(countNoOfPaths(maze, 3, 3)); //QUES1
        //displayNoOfPaths(maze, 3, 3, ""); //QUES2
        //maze[1][1] = 1; //Part of QUES3
        //mazeWithObstacles(maze, 0, 0, ""); //QUES3
        //allPaths(maze, 0, 0, "");  //QUES4 (Backtracking introduced)

        int[][] pathMatrix = new int[maze.length][maze[0].length];
        printMatricesAndPaths(maze, 0, 0, "", pathMatrix, 1); //QUES5
    }

    private static void printMatricesAndPaths(boolean[][] maze, int r, int c, String path, int[][] pathMatrix, int step) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(path);

            //adding step to the pathMatrix block in the base case as well
            pathMatrix[r][c] = step;

            for (int[] arr : pathMatrix) {
                System.out.println(Arrays.toString(arr));
            }
        }

        //we have made a river in the pathMatrix which means this block cannot be passed
        if (!maze[r][c]) {
            return;
        }

        //add the step to the pathMatrix and pass step+1 to the further recursive calls
        //step denotes the level of recursive call
        pathMatrix[r][c] = step;
        maze[r][c] = false;

        //DOWN CALL
        if (r < maze.length - 1 && maze[r + 1][c]) {
            printMatricesAndPaths(maze, r + 1, c, path + "D", pathMatrix, step + 1);
        }

        //RIGHT CALL
        if (c < maze[0].length - 1 && maze[r][c + 1]) {
            printMatricesAndPaths(maze, r, c + 1, path + "R", pathMatrix, step + 1);
        }

        //UP CALL
        if (r > 0 && maze[r - 1][c]) {
            printMatricesAndPaths(maze, r - 1, c, path + "U", pathMatrix, step + 1);
        }

        //LEFT CALL
        if (c > 0 && maze[r][c - 1]) {
            printMatricesAndPaths(maze, r, c - 1, path + "L", pathMatrix, step + 1);
        }

        //this function gets returned here
        //so revert the changes made before the function gets returned
        maze[r][c] = true;
        pathMatrix[r][c] = 0;
    }

    private static void allPaths(boolean[][] maze, int r, int c, String path) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(path);
        }

        //we have made a river in the matrix which means this block cannot be passed
        if (!maze[r][c]) {
            return;
        }

        maze[r][c] = false;

        //DOWN CALL
        if (r < maze.length - 1 && maze[r + 1][c]) {
            allPaths(maze, r + 1, c, path + "D");
        }

        //RIGHT CALL
        if (c < maze[0].length - 1 && maze[r][c + 1]) {
            allPaths(maze, r, c + 1, path + "R");
        }

        //UP CALL
        if (r > 0 && maze[r - 1][c]) {
            allPaths(maze, r - 1, c, path + "U");
        }

        //LEFT CALL
        if (c > 0 && maze[r][c - 1]) {
            allPaths(maze, r, c - 1, path + "L");
        }

        //this function gets returned here
        //so revert the changes made before the function gets returned
        maze[r][c] = true;
    }

    private static void mazeWithObstacles(int[][] maze, int r, int c, String path) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(path);
        }

        //DOWN CALL
        if (r < maze.length - 1 && maze[r+1][c]==0) {
            mazeWithObstacles(maze, r + 1, c, path + "D");
        }

        //RIGHT CALL
        if (c < maze[0].length - 1 && maze[r][c+1]==0) {
            mazeWithObstacles(maze, r, c + 1, path + "R");
        }
    }

    private static void displayNoOfPaths(int[][] maze, int r, int c, String path) {
        if (r == 1 && c == 1) {
            System.out.println(path);
        }
        if (r > 1 && c > 1) {
            displayNoOfPaths(maze, r - 1, c - 1, path + "S"); //DIAGONAL
        }
        if (r > 1) {
            displayNoOfPaths(maze, r - 1, c, path + "D"); //DOWN
        }
        if (c > 1) {
            displayNoOfPaths(maze, r, c - 1, path + "R"); //RIGHT
        }
    }

    private static int countNoOfPaths(int[][] maze, int r, int c) {
        if (r == 1 && c == 1) {
            return 1;
        }
        int count = 0;
        if (r > 1 && c > 1) {
            count += countNoOfPaths(maze, r - 1, c - 1); //DIAGONAL
        }
        if (r > 1) {
            count += countNoOfPaths(maze, r - 1, c); //DOWN
        }
        if (c > 1) {
            count += countNoOfPaths(maze, r, c - 1); //RIGHT
        }
        return count;
    }
}
