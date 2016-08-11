package am.lsoft.dev;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Davit on 09/08/16.
 */
public class TournamentDay56 {

    private static int countBlackCells(int n, int m) {
        int answer = 0;
        for (int x = 1; x <= n; x++) {
            int L = (int) (m * 1L * (x - 1) / n);
            if (m * 1L * (x - 1) % n == 0) {
                L--;
            }
            int R = (int) (m * 1L * x / n);
            L = Math.max(0, L);
            R = Math.min(R, m - 1);
            answer += R - L + 1;
        }
        return answer;
    }

    private static int[][] spiralNumbers(int n) {
        int[][] m = new int[n][n];
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int currentDirectionIndex = 0;
        int currentRow = 0;
        int currentColumn = 0;
        int currentNum = 1;
        int tmpRow;
        int tmpColumn;
        for (int i = n * n; i > 0; i--) {
            m[currentRow][currentColumn] = currentNum;
            currentNum++;
            if (i > 1) {
                // Determine the next cell
                while (true) {
                    tmpRow = currentRow + directions[currentDirectionIndex][0];
                    tmpColumn = currentColumn + directions[currentDirectionIndex][1];
                    if (tmpRow < 0 || tmpRow >= n || tmpColumn < 0 || tmpColumn >= n ||
                            m[tmpRow][tmpColumn] != 0) {
                        currentDirectionIndex = (currentDirectionIndex + 1) % 4;
                    } else {
                        currentRow = tmpRow;
                        currentColumn = tmpColumn;
                        break;
                    }
                }
            }
        }
        return m;
    }

    private static int[][] boxBlur(int[][] image) {
        int[][] answer = new int[image.length - 2][image[0].length - 2];
        for (int x = 1; x < image.length - 1; x++) {
            for (int y = 1; y < image[0].length - 1; y++) {
                int sum = 0;
                for (int dx = -1; dx <= 1; dx++) {
                    for (int dy = -1; dy <= 1; dy++) {
                        sum += image[x + dx][y + dy];
                    }
                }
                answer[x - 1][y - 1] = sum / 9;
            }
        }
        return answer;
    }

    private static ArrayList<Integer> gravitation(String[] rows) {

        int minTimer = rows.length;
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < rows[0].length(); i++) {
            int finish = rows.length - 1,
                    timer = 0;
            for (int j = rows.length - 1; j >= 0; j--) {
                if (rows[j].charAt(i) == '#') {
                    timer = finish - j;
                    finish--;
                }
            }
            if (timer == minTimer) {
                answer.add(i);
            }
            if (timer < minTimer) {
                minTimer = timer;
                answer = new ArrayList<>();
                answer.add(i);
            }
        }

        return answer;
    }

    private static int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 16; i++) {
            res += res + n % 2;
            n /= 2;
        }
        return res;
    }

    private static boolean checkIncreasingSequence(int[] seq) {

        for (int i = 1; i < seq.length; i++) {
            if (seq[i] <= seq[i - 1]) {
                return false;
            }
        }

        return true;
    }

    private static int[] quickSort(int[] a, int l, int r) {

        if (l >= r) {
            return a;
        }

        int x = a[l];
        int i = l;
        int j = r;

        while (i <= j) {
            while (a[i] < x) {
                i++;
            }
            while (a[j] > x) {
                j--;
            }
            if (i <= j) {
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
                i++;
                j--;
            }
        }

        quickSort(a, l, j);
        quickSort(a, i, r);

        return a;
    }

    private static int[] borderSums(int[][] matrix) {

        int[] result = new int[matrix.length / 2];
        Arrays.fill(result, 0);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                int border = Math.min(i, j);
                border = Math.min(border, matrix.length - i - 1);
                border = Math.min(border, matrix.length - j - 1);
                result[border] += matrix[i][j];
            }
        }

        return result;
    }

    private static String buildPalindrome(String str) {
        boolean canConvert;
        for (int i = str.length(); ; i++) {
            canConvert = true;
            for (int j = 0; j < i - j - 1; j++) {
                if (i - j - 1 < str.length() && str.charAt(j) != str.charAt(i - j - 1)) {
                    canConvert = false;
                    break;
                }
            }
            if (canConvert) {
                for (int j = str.length(); j < i; j++) {
                    str += str.charAt(i - j - 1);
                }
                return str;
            }
        }
    }

    private static int caesarBoxCipherEncoding2(String inputString) {

        class Helper {
            String encode(String s, int n) {
                StringBuilder res = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < s.length() / n; j++) {
                        res.append(s.charAt(j * n + i));
                    }
                }
                return res.toString();
            }
        }
        ;
        Helper h = new Helper();

        int res = 0;
        int len = inputString.length();
        int sqrt_len = (int) Math.sqrt(len);
        for (int n = 2; n < sqrt_len + 1; n++) {
            if (len % n == 0) {
                if (h.encode(h.encode(inputString, n), n).equals(h.encode(inputString, n))) {
                    res += 2;
                }
            }
        }

        if (sqrt_len * sqrt_len == len) {
            res--;
        }

        return res;
    }

    public static void main(String[] args) {
        // System.out.println(countBlackCells(3, 4));
        System.out.println(gravitation(new String[]{"#..#.", ".##..", ".#...", ".#..."}));
    }

}
