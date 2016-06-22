package am.lsoft.dev;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Davit on 02/06/16.
 */
public class TournamentDay4 {

    static int neighbouringElements(int[][] a) {
        int[][] di = {{1, 0}, {0, 1}};

        int answer = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                for (int k = 0; k < di.length; k++) {
                    if (i + di[k][0] < a.length && j + di[k][1] < a[0].length
                            && a[i][j] == a[i + di[k][0]][j + di[k][1]]) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    /* lis() returns the length of the longest increasing
       subsequence in arr[] of size n */
    static int lis(int arr[], int n) {
        int lis[] = new int[n];
        int i, j, max = 0;

          /* Initialize LIS values for all indexes */
        for (i = 0; i < n; i++)
            lis[i] = 1;

           /* Compute optimized LIS values in bottom up manner */
        for (i = 1; i < n; i++)
            for (j = 0; j < i; j++)
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1)
                    lis[i] = lis[j] + 1;

           /* Pick maximum of all LIS values */
        for (i = 0; i < n; i++)
            if (max < lis[i])
                max = lis[i];

        return max;
    }

    // http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/

    static int CeilIndex(int A[], int l, int r, int key) {
        while (r - l > 1) {
            int m = l + (r - l) / 2;
            if (A[m] >= key)
                r = m;
            else
                l = m;
        }

        return r;
    }

    static int LongestIncreasingSubsequenceLength(int A[], int size) {
        // Add boundary case, when array size is one
        int[] tailTable = new int[size];
        int len; // always points empty slot

        tailTable[0] = A[0];
        len = 1;
        for (int i = 1; i < size; i++) {
            if (A[i] < tailTable[0])
                // new smallest value
                tailTable[0] = A[i];

            else if (A[i] > tailTable[len - 1])
                // A[i] wants to extend largest subsequence
                tailTable[len++] = A[i];

            else
                // A[i] wants to be current end candidate of an existing
                // subsequence. It will replace ceil value in tailTable
                tailTable[CeilIndex(tailTable, -1, len - 1, A[i])] = A[i];
        }

        return len;
    }

    static int longestSubSeq(int[] chart) {
        int[] DP = new int[chart.length], prev = new int[chart.length];
        int maxLength = 1, bestEnd = 0;
        DP[0] = 1;
        prev[0] = -1;

        for (int i = 1; i < chart.length; i++) {
            DP[i] = 1;
            prev[i] = -1;

            for (int j = i - 1; j >= 0; j--)
                if (DP[j] + 1 > DP[i] && chart[j] < chart[i]) {
                    DP[i] = DP[j] + 1;
                    prev[i] = j;
                }

            if (DP[i] > maxLength) {
                bestEnd = i;
                maxLength = DP[i];
            }
        }

        int k = bestEnd;
        while (prev[k] != -1) {
            System.out.print(prev[k]);
            k--;
        }
        System.out.println();

        return maxLength;
    }

    static int chartFix(int[] chart) {
        int[] DP = new int[chart.length];
        int maxLength = 1;
        DP[0] = 1;

        for (int i = 1; i < chart.length; i++) {
            DP[i] = 1;

            for (int j = i - 1; j >= 0; j--)
                if (DP[j] + 1 > DP[i] && chart[j] < chart[i]) {
                    DP[i] = DP[j] + 1;
                }

            if (DP[i] > maxLength) {
                maxLength = DP[i];
            }
        }

        return chart.length - maxLength;
    }

    static String decipher(String cipher) {

        String result = "";
        for (int i = 0; i < cipher.length(); ) {
            int len;
            if (cipher.charAt(i) < '9') {
                len = 3;
            } else {
                len = 2;
            }
            int code = Integer.parseInt(cipher.substring(i, i + len));
            result += (char) code;
            i += len;
        }

        return result;
    }

    static String queuePhoto(int[] times, char[] colors) {
        int next = 0;
        int queueStart = 0;
        int queueEnd = 0;
        int indexLeft = -1;
        int res = 0;
        int lastOut = 0;

        while (next < times.length) {
            if (queueStart == queueEnd || lastOut + 5 > times[next]) {
                lastOut = times[next] / 5 * 5;
                queueEnd++;
                next++;
                if (queueEnd - queueStart > res) {
                    res = queueEnd - queueStart;
                    indexLeft = queueStart;
                }
            } else {
                lastOut += 5;
                queueStart++;
            }
        }

        String resStr = "";
        for (int i = indexLeft; i < indexLeft + res; i++) {
            resStr += colors[i];
        }
        return resStr;
    }

    static int largestDistance(int[] A) {
        class Helper {
            public Helper() {
            }

            public int[] point(int x, int y) {
                return new int[]{x, y};
            }

            public int getDistance(int[] A, int[] B) {
                return Math.max(Math.abs(A[0] - B[0]), Math.abs(A[1] - B[1]));
            }
        }
        Helper helper = new Helper();

        ArrayList<int[]> points = new ArrayList<>();
        for (int i = 1; i < A.length; i = i + 2) {
            points.add(helper.point(A[i - 1], A[i]));
        }

        int max = 0;
        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {
                int distance = helper.getDistance(points.get(i), points.get(j));
                if (distance > max) {
                    max = distance;
                }
            }
        }

        return max;
    }

    static String insertDashes(String inputString) {
        String result = inputString.charAt(0) + "-";
        for (int i = 1; i < inputString.length(); i++) {
            if (inputString.charAt(i) != ' ') {
                result += inputString.charAt(i);
                if (i != inputString.length() - 1) {
                    result += "-";
                }
            } else {
                result = result.substring(0, result.length() - 1);
                result += " ";
            }
        }
        //result = result.substring(0, result.length() - 1);
        return result;
    }

    static int[][] constructSubmatrix(int[][] matrix, int[] rowsToDelete, int[] columnsToDelete) {

        int[][] res = new int[matrix.length - rowsToDelete.length][matrix[0].length - columnsToDelete.length];
        boolean[] useRow = new boolean[matrix.length];
        boolean[] useColumn = new boolean[matrix[0].length];
        Arrays.fill(useRow, true);
        Arrays.fill(useColumn, true);

        for (int i = 0; i < rowsToDelete.length; i++) {
            useRow[rowsToDelete[i]] = false;
        }
        for (int i = 0; i < columnsToDelete.length; i++) {
            useColumn[columnsToDelete[i]] = false;
        }

        for (int i = 0, i2 = 0; i < matrix.length; i++) {
            if (useRow[i]) {
                for (int j = 0, j2 = 0; j < matrix[0].length; j++) {
                    if (useColumn[j]) {
                        res[i2][j2] = matrix[i][j];
                        j2++;
                    }
                }
                i2++;
            }
        }

        return res;
    }

    static int crossingSum(int[][] matrix, int a, int b) {
        int sum = 0;
        for (int i = 0; i < matrix[a].length; i++) {
            sum += matrix[a][i];
        }
        for (int i = 0; i < matrix.length; i++) {
            if (i != a)
                sum += matrix[i][b];
        }
        return sum;
    }

    static int gcdNaive(int a, int b) {
        int gcd = 1;
        for (int divisor = 2; divisor <= Math.min(a, b); divisor++) {
            if ( gcd < divisor && a % divisor == 0 && b % divisor == 0) {
                gcd = divisor;
            }
        }

        return gcd;
    }

    static int correctEmails(String pattern) {
        class Helper {
            int count(String s, char c) {
                int result = 0;
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == c) {
                        result++;
                    }
                }
                return result;
            }

            boolean isSymbol(char c) {
                return 'a' <= c && c <= 'e';
            }

            boolean isCorrectEmail(String email) {
                return count(email, '@') == 1 &&
                        count(email, '.') >= 1 &&
                        email.lastIndexOf('.') > email.lastIndexOf('@') &&
                        !email.contains("..") &&
                        !email.contains(".@") &&
                        !email.contains("@.") &&
                        isSymbol(email.charAt(0)) &&
                        isSymbol(email.charAt(email.length() - 1));
            }

            int countCorrectEmails(char[] pattern, int position) {
                if (position == pattern.length) {
                    return isCorrectEmail(String.valueOf(pattern)) ? 1 : 0;
                }
                if (pattern[position] != '?') {
                    return countCorrectEmails(pattern, position + 1);
                }
                int answer = 0;
                pattern[position] = '@';
                answer += countCorrectEmails(pattern, position + 1);
                pattern[position] = '.';
                answer += countCorrectEmails(pattern, position + 1);
                pattern[position] = 'a';
                answer += countCorrectEmails(pattern, position + 1) * 5;
                pattern[position] = '?';
                return answer;
            }
        }

        Helper h = new Helper();
        return h.countCorrectEmails(pattern.toCharArray(), 0);
    }

    static String findHyperlink(String text) {
        char[] chars = text.toCharArray();
        String result = "";
        int firstPos = -1;
        int lastPos = -1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '<') {
                if (firstPos == -1) {
                    firstPos = i;
                }
            }
            if (chars[i] == '>') {
                if (lastPos == -1) {
                    lastPos = i;
                }
            }
            if (i - firstPos >= 8 && lastPos == -1 && firstPos != -1) {
                result += chars[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // System.out.println(neighbouringElements(new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}}));
        // System.out.println(neighbouringElements(new int[][]{{0, 1, 2, 3}, {1, 2, 3, 0}, {2, 3, 1, 0}}));
        // System.out.println(longestSubSeq(new int[]{3, 2, 6, 4, 5, 1, 7}));
        // System.out.println(decipher("10197115121"));
        // System.out.println(queuePhoto(new int[]{0, 3, 5, 7, 16}, new char[]{'r', 'g', 'b', 'w', 'y'}));
        // System.out.println(largestDistance(new int[]{7, 2, 3, 8, 2, 10, 9, 7}));
        //System.out.println(insertDashes("aba caba"));
        // System.out.println(constructSubmatrix(new int[][]{{1, 0, 0, 2}, {0, 5, 0, 1}, {0, 0, 3, 5}}, new int[]{1}, new int[]{0, 2}));
        // System.out.println(crossingSum(new int[][]{{1, 1, 1, 1}, {2, 2, 2, 2}, {3, 3, 3, 3}}, 1, 3));
        // System.out.println(gcdNaive(4, 6));
        // System.out.println(correctEmails("abcd@?bcd.ca"));
        System.out.println(findHyperlink("<a href=\"http://www.example.org\">Example1</a>"));
        System.out.println(findHyperlink("a href=\"http://www.wrong.org\"<a href=\"correct\">Example2 a href /a</a> URL"));

    }

}
