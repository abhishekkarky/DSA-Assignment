import java.util.Arrays;
import java.util.Stack;

/*Question 8
a)
Given 2D matrix of 1 and 0s. Using stack, find maximum area of square made by 0s.
INPUT: 1 0 1 0 0
0 1 1 1 1
0 0 0 0 1
0 0 0 1 1
0 1 0 1 1
OUTPUT: 4
*/

//Initialize variables n and m to be the number of rows and columns in the matrix, respectively.
//Initialize a 2D array dp of size n x m with all elements set to 0.
//Initialize variable maxArea to be 0.
//Iterate over each element (i,j) in the matrix:
//a. If the element is 0, set dp[i][j] to 1 and set maxArea to 1.
//Iterate over each element (i,j) in the matrix:
//a. If the element is 0, set dp[i][j] to the minimum of dp[i-1][j-1], dp[i-1][j], and dp[i][j-1] plus 1.
//b. Update maxArea to be the maximum of maxArea and dp[i][j].
//Return maxArea squared as the maximum area of a square made of 0s in the matrix.
class MaxAreaOf0 {
    public static int max(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    dp[i][j] = 1;
                    maxArea = 1;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    maxArea = Math.max(maxArea, dp[i][j]);
                }
            }
        }

        return maxArea * maxArea;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 1, 0, 0},
                {0, 1, 1, 1, 1},
                {0, 0, 0, 0, 1},
                {0, 0, 0, 1, 1},
                {0, 1, 0, 1, 1}};
        int maxArea = max(matrix);
        System.out.println("Maximum area of square made by 0s: " + maxArea);
    }

}