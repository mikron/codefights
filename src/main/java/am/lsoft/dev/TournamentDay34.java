package am.lsoft.dev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Davit on 10/07/16.
 */
public class TournamentDay34 {

    private static int[] arrayPreviousLess(int[] items) {

        int[] result = new int[items.length];
        for (int i = 0; i < items.length; i++) {
            int substitute = -1;
            for (int j = 0; j < i; j++) {
                if (items[j] < items[i]) {
                    substitute = items[j];
                }
            }
            result[i] = substitute;
        }

        return result;
    }

    private static boolean isIPv4Address(String inputString) {

        int currentNumber = 0;
        boolean emptyField = true;
        int countNumbers = 0;

        inputString += '.';

        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) == '.') {
                if (emptyField) {
                    return false;
                }
                countNumbers++;
                currentNumber = 0;
                emptyField = true;
            } else {
                int digit = inputString.charAt(i) - '0';
                if (digit < 0 || digit > 9) {
                    return false;
                }
                emptyField = false;
                currentNumber = currentNumber * 10 + digit;
                if (currentNumber > 255) {
                    return false;
                }
            }
        }
        return countNumbers == 4;
    }

    private static int[][] matrixMultiplication(int[][] matrix1, int[][] matrix2) {

        int[][] result = new int[matrix1.length][matrix2[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                result[i][j] = 0;
                for (int k = 0; k < matrix1[0].length; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }

    private static int minimalNumberOfCoins(int[] coins, int price) {

        int result = 0;

        for (int i = coins.length - 1; i >= 0; i--) {
            result += price / coins[i];
            price %= coins[i];
        }

        if (price != 0) {
            return -1;
        }
        return result;
    }

    private static int extraNumber(int A, int B, int C) {

        if (A == B) {
            return C;
        }
        if (B != C) {
            return B;
        }
        return A;
    }

    private static int countLineColorings(int points, int colors) {
        int result = colors;
        for (int i = 1; i < points; i++) {
            result *= (colors - 1);
        }
        return result;
    }

    private static int sumOfCoprimes(int m) {

        int ans = 0;
        for (int p = 2; p <= m; p++) {
            int a = p;
            int b = m;
            while (a > 0) {
                int tmp = b % a;
                b = a;
                a = tmp;
            }

            if (b == 1) {
                ans += p;
            }
        }

        return ans;
    }

    private static int[] suffixSums(int[] A) {

        ArrayList<Integer> B = new ArrayList<>();
        B.add(A[A.length - 1]);
        for (int i = A.length - 2; i >= 0; i--) {
            B.add(B.get(B.size() - 1) + A[i]);
        }
        Collections.reverse(B);

        int[] res = new int[B.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = B.get(i);
        }

        return res;
    }

    private static int[] easyAssignmentProblem(int[][] skills) {
        int ma = Math.max(skills[0][0], skills[0][1]);
        ma = Math.max(skills[1][0], ma);
        ma = Math.max(skills[1][1], ma);
        ArrayList<Integer> v = new ArrayList<>();
        for (int i = 0; i < 2; i++)
            if (ma == skills[i][0]) {
                v.add(i + 1);
                v.add((i ^ 1) + 1);
                break;
            } else if (ma == skills[i][1]) {
                v.add((i ^ 1) + 1);
                v.add(i + 1);
                break;
            }
        return v.stream().mapToInt(i -> i).toArray();
    }

    private static boolean pepEight2(String line) {
        return line.length() <= 79;
    }

    public static void main(String[] args) {
        // System.out.println(Arrays.toString(arrayPreviousLess(new int[]{3, 5, 2, 4, 5})));
        // System.out.println(isIPv4Address("172.16.254.1"));
        // System.out.println(Arrays.toString(matrixMultiplication(new int[][]{{1, 1, 1}, {0, 0, 0}},
        //                new int[][]{{2, 1}, {1, 2}, {2, 1}})));
        // System.out.println(minimalNumberOfCoins(new int[]{1, 2, 10}, 28));
        // System.out.println(extraNumber(2, 4, 2));
        // System.out.println(countLineColorings(3, 2));
        //System.out.println(sumOfCoprimes(5));
        // System.out.println(Arrays.toString(suffixSums(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(easyAssignmentProblem(new int[][]{{1, 3}, {2, 3}})));
    }

}
