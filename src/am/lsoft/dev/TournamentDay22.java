package am.lsoft.dev;

/**
 * Created by Davit on 22/06/16.
 */
public class TournamentDay22 {

    static int additionWithoutCarrying(int param1, int param2) {
        int result = 0,
                tenPower = 1;
        while (param1 > 0 || param2 > 0) {
            result += tenPower * ((param1 + param2) % 10);
            param1 /= 10;
            param2 /= 10;
            tenPower *= 10;
        }
        return result;
    }

    /*static int[] borderSums(int[][] matrix) {
        class Helper {
            int sum;

            int getSum() {
                return sum;
            }

            int[][] borderSum(int[][] matrix) {
                int len = matrix.length, newRow = 0, newCol;
                int[][] resMatrix = new int[len / 2][len / 2];
                sum = 0;
                for (int i = 0; i < len; i++) {
                    newCol = 0;
                    for (int j = 0; j < len; j++) {
                        if (i == 0 || j == 0 || i == len - 1 || j == len - 1) {
                            sum += matrix[i][j];
                        } else {
                            resMatrix[newRow][newCol] = matrix[i][j];
                            newCol++;
                        }
                    }
                    if (i != 0 && i != len - 1)
                        newRow++;
                }
                return resMatrix;
            }
        }

        Helper h = new Helper();
        int[] result = new int[matrix.length / 2];
        int i = 0;
        while (matrix.length != 1) {
            matrix = h.borderSum(matrix);
            result[i] += h.getSum();
            i++;
        }
        return result;
    }*/

    static int[] borderSums(int[][] matrix) {
        int len = matrix.length;
        int[] result = new int[len / 2];
        for (int k = 0; k < len / 2; k++) {
            for (int i = k; i < len - k; i++) {
                for (int j = k; j < len - k; j++) {
                    if (i == k || j == k || i == len - k - 1 || j == len - k - 1) {
                        result[k] += matrix[i][j];
                    }
                }
            }
        }
        return result;
    }

    static int divNumber(int k, int l, int r) {

        int ans = 0;
        for (int i = l; i <= r; i++) {
            int n = i;
            int divs = 1;
            for (int j = 2; j * j <= n; j++) {
                int pow = 0;
                while (n % j == 0) {
                    n /= j;
                    pow++;
                }
                divs *= 1 + pow;
                if (divs > k) {
                    break;
                }
            }
            if (n >= 1) {
                divs *= 2;
            }
            if (divs == k) {
                ans++;
            }
        }

        return ans;
    }

    static boolean subtractionGame(int n) {

        class Helper {
            boolean checkFirstWins(int n, int move) {
                if (n <= 0) {
                    return true;
                }
                for (int i = 1; i <= move; i++) {
                    if (!checkFirstWins(n - i, move + 1)) {
                        return true;
                    }
                }
                return false;
            }
        }

        Helper h = new Helper();
        return h.checkFirstWins(n, 1);
    }

    static int leastCommonMultiple(int a, int b) {

        int gcd = 1;
        for (int divisor = 2; divisor < Math.max(a, b); divisor++) {
            if (a % divisor == 0 && b % divisor == 0) {
                gcd = divisor;
            }
        }

        return a * b / gcd;
    }

    static String digitalNumber(int k) {

        StringBuilder ans = new StringBuilder();
        int M = 20;
        int sum = 0;
        while (k >= M) {
            ans.append('1');
            k -= 2;
            sum++;
        }
        sum %= 3;

        int[] seg = new int[]{6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
  /*
   * dp[i][j] - the largest number that is obtainable from j segments
   * and that has i as a remainder after division by 3.
   */
        long[][] dp = new long[3][M];
        dp[0][0] = 0;
        dp[1][0] = dp[2][0] = -1;
        for (int i = 1; i < M; i++) {
            for (int j = 0; j < 3; j++) {
                dp[j][i] = -1;
                for (int d = 0; d < 10; d++) {
                    int pSum = (j - d + 9) % 3;
                    int pSegmCnt = i - seg[d];
                    if (pSegmCnt < 0 || dp[pSum][pSegmCnt] == -1) {
                        continue;
                    }
                    int cur = dp[pSum][pSegmCnt] == 0 ? d :
                            Integer.parseInt(d + "" + dp[pSum][pSegmCnt]);
                    dp[j][i] = dp[j][i] != -1 ? Math.max(dp[j][i], cur) : cur;
                }
            }
        }

        return "";
    }

    public static void main(String[] args) {
        // System.out.println(additionWithoutCarrying(456, 1734));
        // System.out.println(borderSums(new int[][]{{1, 2, 2, 3}, {0, 1, 0, 2}, {4, -1, -1, -3}, {4, -1, -1, 3}}));
        // System.out.println(borderSums(new int[][]{{1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}}));
        System.out.println(divNumber(3, 2, 49));
    }

}
