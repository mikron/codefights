package am.lsoft.dev;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Davit on 05/08/16.
 */
public class TournamentDay54 {

    private static boolean rowsRearranging(int[][] matrix) {

        class Helper {
            void swapRows(int row1, int row2, int[][] matrix) {
                for (int i = 0; i < matrix[0].length; i++) {
                    int tmp = matrix[row1][i];
                    matrix[row1][i] = matrix[row2][i];
                    matrix[row2][i] = tmp;
                }
            }
        }
        ;

        Helper h = new Helper();

        for (int i = 0; i < matrix.length; i++) {
            int minIndex = i;
            for (int j = i; j < matrix.length; j++) {
                if (matrix[j][0] < matrix[minIndex][0]) {
                    minIndex = j;
                }
            }
            h.swapRows(i, minIndex, matrix);
        }

        boolean answer = true;
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 1; j < matrix.length; j++) {
                if (matrix[j][i] <= matrix[j - 1][i]) {
                    answer = false;
                }
            }
        }

        return answer;
    }

    private static int firstOperationCharacter(String expr) {

        int balance = 0;
        int maxAdditionPriority = -1;
        int maxMultiplicationPriority = -1;
        int additionIndex = -1;
        int multiplicationIndex = -1;

        for (int i = 0; i < expr.length(); i++) {
            if (expr.charAt(i) == '(') {
                balance++;
            }
            if (expr.charAt(i) == ')') {
                balance--;
            }
            if (expr.charAt(i) == '+') {
                if (balance > maxAdditionPriority) {
                    maxAdditionPriority = balance;
                    additionIndex = i;
                }
            }
            if (expr.charAt(i) == '*') {
                if (balance > maxMultiplicationPriority) {
                    maxMultiplicationPriority = balance;
                    multiplicationIndex = i;
                }
            }
        }

        if (maxAdditionPriority > maxMultiplicationPriority) {
            return additionIndex;
        } else {
            return multiplicationIndex;
        }
    }

    private static ArrayList<Integer> sortedIndices(ArrayList<Integer> A) {
        ArrayList<Integer> I = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            I.add(i);
        }
        for (int i = 0; i < A.size() - 1; i++) {
            for (int j = 0; j < A.size() - i - 1; j++) {
                if (A.get(I.get(j)) > A.get(I.get(j + 1))) {
                    int tmp = I.get(j + 1);
                    I.set(j + 1, I.get(j));
                    I.set(j, tmp);
                }
            }
        }
        return I;
    }

    private static int[] eratosthenesSieve(int n) {

        ArrayList<Integer> primes = new ArrayList<>();
        boolean[] mayBePrime = new boolean[n + 1];
        Arrays.fill(mayBePrime, true);
        for (int i = 2; i <= n; i++) {
            if (mayBePrime[i]) {
                primes.add(i);
                for (int j = i; i * j <= n; j++) {
                    mayBePrime[i * j] = false;
                }
            }
        }

        int[] result = new int[primes.size()];
        for (int i = 0; i < primes.size(); ++i) {
            result[i] = primes.get(i);
        }

        return result;
    }

    private static int rangeCollapseRepresentations(int[] a) {

        int ans = 1;
        for (int i = 1; i < a.length; i++) {
            if (a[i] == a[i - 1] + 1) {
                ans *= 2;
            }
        }

        return ans;
    }

    private static int numberOfCarries(int a, int b) {

        int ans = 0;
        int c = 0;
        while (a > 0 || b > 0) {
            c = (a % 10 + b % 10) / 10;
            if (c > 0) {
                ans++;
            }
            a /= 10;
            b /= 10;
        }

        return ans;
    }

    private static int[] verticesDegrees(boolean[][] matrix) {
        int[] c = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            int d = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j]) {
                    d++;
                    if (i == j)
                        d++;
                }
            }
            c[i] = d;
        }
        return c;
    }

    private static int digitSumInverse(int sum, int numberLength) {

        int[][] dp = new int[numberLength + 1][numberLength * 9 + 1];

        if (sum > 9 * numberLength) {
            return 0;
        }

        dp[0][0] = 1;
        for (int i = 0; i < numberLength; i++) {
            for (int j = 0; j <= i * 9; j++) {
                for (int digit = 0; digit < 10; digit++) {
                    dp[i + 1][j + digit] += dp[i][j];
                }
            }
        }

        return dp[numberLength][sum];
    }

    private static int simplifiedSyllable(String word) {
        class Helper {
            boolean isVowel(char letter) {
                return "aeiou".indexOf(letter) != -1;
            }
        }
        ;

        Helper h = new Helper();
        int lastVowel = -1;
        int result = 1;
        for (int i = 0; i < word.length(); i++) {
            if (h.isVowel(word.charAt(i))) {
                if (lastVowel != -1) {
                    result *= i - lastVowel;
                }
                lastVowel = i;
            }
        }
        return result;
    }

    private static String alphabeticShift(String inputString) {

        String res = "";

        for (int i = 0; i < inputString.length(); i++) {
            res += (char) ((inputString.charAt(i) - 'a' + 1) % 26 + 'a');
        }

        return res;

    }

    private static int[][] imageTruncation(int[][] image, int threshold) {

        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                if (image[i][j] > threshold) {
                    image[i][j] = threshold;
                }
            }
        }
        return image;
    }

    public static void main(String[] args) {
        // System.out.println(rowsRearranging(new int[][]{{2, 2, 2}, {1, 1, 1}}));
        // System.out.println(numberOfCarries(543, 3456));
        // System.out.println(numberOfCarries(1927, 6426));
        System.out.println(alphabeticShift("crazy"));
    }

}
