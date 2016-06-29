package am.lsoft.dev;

import com.sun.corba.se.impl.orbutil.graph.Graph;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Davit on 04/06/16.
 */
public class TournamentDay6 {

    static boolean hangman(String word, String letters) {

        boolean[] neededLetters = new boolean[26];
        int need = 0;
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if (!neededLetters[c]) {
                neededLetters[c] = true;
                need++;
            }
        }

        int missed = 0;
        for (int i = 0; i < letters.length() && missed < 6 && need > 0; i++) {
            int c = letters.charAt(i) - 'a';
            if (neededLetters[c]) {
                neededLetters[c] = false;
                need--;
            } else {
                missed++;
            }
        }

        return missed < 6 && need == 0;
    }

    static int[][] segmentSumsMatrix1(int[] inputArray) {

        int[][] answer = new int[inputArray.length][inputArray.length];

        for (int i = 0; i < inputArray.length; i++) {
            for (int j = i; j >= 0; j--) {
                for (int k = i; k < inputArray.length; k++) {
                    answer[j][k] += inputArray[i];
                    answer[k][j] += inputArray[i];
                }
            }
            answer[i][i] -= inputArray[i];
        }

        return answer;
    }

    static int maxSubmatrixSum(int[][] matrix, int n, int m) {
        class Helper {
            Helper() {
            }

            int matrixSum(int[][] matrix) {
                int sum = 0;
                for (int[] aMatrix : matrix)
                    for (int j = 0; j < matrix[0].length; j++)
                        sum += aMatrix[j];
                return sum;
            }
        }

        Helper helper = new Helper();

        int numRows = matrix.length;
        int numCols = matrix[0].length;

        int maxSum = 0;

        boolean firstRow = true;
        for (int rows = 0; rows < numRows; rows++) {
            for (int col = 0; col < numCols; col++) {
                boolean isSubMatrix = false;
                int[][] subMatrix = new int[n][m];
                for (int subRows = 0; subRows < n; subRows++) {
                    for (int subCols = 0; subCols < m; subCols++) {
                        if (rows + subRows < numRows && col + subCols < numCols) {
                            subMatrix[subRows][subCols] = matrix[rows + subRows][col + subCols];
                            if (subRows == n - 1 && subCols == m - 1)
                                isSubMatrix = true;
                        }
                    }
                }
                if (isSubMatrix) {
                    int sum = helper.matrixSum(subMatrix);
                    if (firstRow) {
                        maxSum = sum;
                    } else if (sum > maxSum) {
                        maxSum = sum;
                    }
                    firstRow = false;

                }

            }
        }
        return maxSum;
    }

    static int dfsComponentSize(boolean[][] matrix, int vertex) {
        int ans = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][vertex])
                ans++;
        }
        return ans + 1;
    }

    static int[][] neighboringCells(int[][] matrix) {

        class Helper {
            Helper() {
            }

            int getElement(int[][] matrix, int i, int j) {
                try {
                    int dummy = matrix[i][j];
                    return 1;
                } catch (IndexOutOfBoundsException e) {
                    return 0;
                }
            }

            int neighbors(int[][] matrix, int row, int col) {
                int rows = matrix.length;
                int cols = matrix[0].length;
                return getElement(matrix, row, col + 1) + getElement(matrix, row, col - 1) + getElement(matrix, row + 1, col) + getElement(matrix, row - 1, col);
            }
        }

        Helper helper = new Helper();
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        int[][] newMatrix = new int[rowNum][colNum];
        for (int rows = 0; rows < rowNum; rows++) {
            for (int cols = 0; cols < colNum; cols++) {
                newMatrix[rows][cols] = helper.neighbors(matrix, rows, cols);
            }
        }
        return newMatrix;
    }

    static boolean gasPrediction(double[] driveDistances, double currentGasLevel,
                          double avgMileage) {

        double totalDistance = 0;
        for (int i = 0; i < driveDistances.length; i++) {
            totalDistance += driveDistances[i];
        }
        double gasConsumed = totalDistance / avgMileage;

        return  currentGasLevel - gasConsumed < 0 ;
    }

    public static void main(String[] args) {
        // System.out.println(hangman("hangman", "ehadngvpz"));
        // System.out.println(segmentSumsMatrix1(new int[]{1, 2, 3}));
        // System.out.println(maxSubmatrixSum(new int[][]{{1, 12, 11, 10}, {4, 3, 2, 9}, {5, 6, 7, 8}}, 2, 1));
        // System.out.println(dfsComponentSize(new boolean[][]{{false, true, false}, {true, false, false}, {false, false, false}}, 0));
        // System.out.println(neighboringCells(new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}));
        System.out.println(gasPrediction(new double[] {12, 6, 17, 5, 20}, 0.25, 25));
    }

}

