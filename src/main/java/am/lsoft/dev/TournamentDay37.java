package am.lsoft.dev;

import java.util.Arrays;

/**
 * Created by Davit on 13/07/16.
 */
public class TournamentDay37 {

    private static int[][] neighboringCells(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i > 0) {
                    matrix[i][j]++;
                }
                if (j > 0) {
                    matrix[i][j]++;
                }
                if (i + 1 < matrix.length) {
                    matrix[i][j]++;
                }
                if (j + 1 < matrix[0].length) {
                    matrix[i][j]++;
                }
            }
        }
        return matrix;
    }

    private static boolean validTime(String time) {

        class Helper {
            int charToInt(char symbol) {
                return symbol - '0';
            }
        }
        Helper h = new Helper();

        int hours = h.charToInt(time.charAt(0)) * 10 + h.charToInt(time.charAt(1)),
                minutes = h.charToInt(time.charAt(3)) * 10 + h.charToInt(time.charAt(4));

        if (hours < 24 && minutes < 60) {
            return true;
        }
        return false;
    }

    private static int[] maximalAllowableSubarrays(int[] inputArray, int maxSum) {
        for (int i = 0; i < inputArray.length; i++) {
            int sum = inputArray[i];
            for (int j = i + 1; j < inputArray.length; j++) {
                sum += inputArray[j];
                if (sum > maxSum) {
                    inputArray[i] = j - 1;
                    break;
                }
            }
            if (sum <= maxSum)
                inputArray[i] = inputArray.length - 1;
        }

        return inputArray;
    }

    private static boolean arithmeticExpression(int A, int B, int C) {

        if (A + B == C || A * B == C || B * C == A || A - B == C) {
            return true;
        }
        return false;
    }

    private static int[] zFunctionNaive(String s) {
        int[] Z = new int[s.length()];
        int n = s.length();
        int L, R, k;

        // [L,R] make a window which matches with prefix of s
        L = R = 0;
        for (int i = 1; i < n; ++i) {
            // if i>R nothing matches so we will calculate.
            // Z[i] using naive way.
            if (i > R) {
                L = R = i;

                // R-L = 0 in starting, so it will start
                // checking from 0'th index. For example,
                // for "ababab" and i = 1, the value of R
                // remains 0 and Z[i] becomes 0. For string
                // "aaaaaa" and i = 1, Z[i] and R become 5
                while (R < n && s.charAt(R - L) == s.charAt(R))
                    R++;
                Z[i] = R - L;
                R--;
            } else {
                // k = i-L so k corresponds to number which
                // matches in [L,R] interval.
                k = i - L;

                // if Z[k] is less than remaining interval
                // then Z[i] will be equal to Z[k].
                // For example, str = "ababab", i = 3, R = 5
                // and L = 2
                if (Z[k] < R - i + 1)
                    Z[i] = Z[k];

                    // For example str = "aaaaaa" and i = 2, R is 5,
                    // L is 0
                else {
                    //  else start from R  and check manually
                    L = i;
                    while (R < n && s.charAt(R - L) == s.charAt(R))
                        R++;
                    Z[i] = R - L;
                    R--;
                }
            }
        }
        Z[0] = n; // CodeFights test are passed
        return Z;
    }

    public static void main(String[] args) {
        // System.out.println(neighboringCells(new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}));
        // System.out.println(validTime("03:58"));
        // System.out.println(Arrays.toString(maximalAllowableSubarrays(new int[]{2, 3, 0, 1, 2}, 4)));
        System.out.println(Arrays.toString(zFunctionNaive("acacbab")));
    }

}
