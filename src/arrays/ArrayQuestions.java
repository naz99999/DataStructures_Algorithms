package arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ArrayQuestions {

    //https://leetcode.com/problems/set-matrix-zeroes/
    public void setZeroes(int[][] matrix) {
        int len = matrix.length;
        HashSet<Integer> rows = new HashSet<>();
        HashSet<Integer> cols = new HashSet<>();

        for(int i=0; i<len; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for(int row : rows) {
            for(int i=0; i<matrix[0].length; i++) {
                matrix[row][i] = 0;
            }
        }

        for(int col : cols) {
            for(int i=0; i<matrix.length; i++) {
                matrix[i][col] = 0;
            }
        }
    }

    //https://leetcode.com/problems/pascals-triangle/
    public static List<List<Integer>> generate(int numRows) {
        int n = numRows;
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            ans.add(i, new ArrayList<>());
            for(int j = 0; j < i + 1; j++) {
                if(j == 0 || j == i) {
                    ans.get(i).add(1);
                } else {
                    ans.get(i).add(0);
                }
            }
        }

        for(int i = 2; i < n; i++) {
            for (int j = 1; j < i; j++) {
                int val = ans.get(i-1).get(j-1) + ans.get(i-1).get(j);
                ans.get(i).set(j, val);
            }
        }


        return ans;
    }
}
