package am.lsoft.dev;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Davit on 17/07/16.
 */
public class TournamentDay41 {

    private static boolean whoseTurn(String p) {

        class Helper {

            int color(int r, int c) {
                return (r + c) % 2;
            }
        }
        Helper h = new Helper();

        int s = 0;
        for (int i = 0; i < 4; i++) {
            int c = p.charAt(i * 3) - 'a';
            int r = p.charAt(i * 3 + 1) - '0';
            s += h.color(r, c);
        }

        return s % 2 == 0;
    }

    private static boolean isAdult(int age, int adulthoodAge) {
        boolean answer = false;
        if (age >= adulthoodAge) {
            answer = true;
        } else {
            answer = false;
        }
        return answer;
    }

    private static String truncateString(final String s) {

        class Helper {
            private String truncate(int l, int r) {
                if (l >= r) {
                    return "";
                }
                int newL = l;
                int newR = r;
                int left = s.charAt(l) - '0';
                int right = s.charAt(r - 1) - '0';
                if (left % 3 == 0) {
                    newL++;
                } else if (right % 3 == 0) {
                    newR--;
                } else if ((left + right) % 3 == 0) {
                    newL++;
                    newR--;
                } else {
                    return s.substring(l, r);
                }

                return truncate(newL, newR);
            }
        }
        Helper h = new Helper();

        return h.truncate(0, s.length());
    }

    private static boolean perfectArray(int[] A) {

        for (int i = 0; i < A.length; i++) {
            if (A[i] != A.length) {
                return false;
            }
        }
        return true;
    }

    private static int[] setDifference(int[] A, int[] B) {

        Arrays.sort(A);
        Arrays.sort(B);
        ArrayList<Integer> C = new ArrayList<>();

        int pos_b = 0;
        for (int pos_a = 0; pos_a < A.length; pos_a++) {
            while (A[pos_a] > B[pos_b]) {
                pos_b++;
            }
            if (pos_b == B.length || A[pos_a] != B[pos_b]) {
                C.add(A[pos_a]);
            }
        }

        int[] res = new int[C.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = C.get(i);
        }

        return res;
    }

    private static boolean isSubSequence(char[] str1, char[] str2, int m, int n) {
        if (m == 0) return true;
        if (n == 0) return false;

        if (str1[m - 1] == str2[n - 1])
            return isSubSequence(str1, str2, m - 1, n - 1);

        return isSubSequence(str1, str2, m, n - 1);
    }

    private static boolean alphabetSubsequence(String s) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        return isSubSequence(s.toCharArray(), alphabet.toCharArray(),
                s.length(), alphabet.length());
    }

    private static boolean alphabetSubsequence2(String s) {
        for (int i = 1; i < s.length(); i++)
            if (s.charAt(i) - s.charAt(i - 1) <= 0)
                return false;
        return true;
    }

    private static int[] prefixSums(int[] A) {

        ArrayList<Integer> B = new ArrayList<>();
        B.add(A[0]);
        for (int i = 1; i < A.length; i++) {
            B.add(B.get(i - 1) + A[i]);
        }

        int[] b = new int[B.size()];
        for (int i = 0; i < b.length; ++i) {
            b[i] = B.get(i);
        }

        return b;
    }

    private static int[] howManyLines(int[] X, int[] Y) {

        int[] result = new int[X.length - 1];
        Arrays.fill(result, 0);

        for (int i = 0; i < X.length; i++) {
            for (int j = i + 1; j < X.length; j++) {
                int A = Y[i] - Y[j],
                        B = X[j] - X[i],
                        C = -A * X[i] - B * Y[i],
                        countPoints = 0;
                for (int k = 0; k < X.length; k++) {
                    if (A * X[k] + B * Y[k] + C == 0) {
                        countPoints++;
                    }
                }
                result[countPoints - 2]++;
            }
        }
        for (int i = 0; i < X.length - 1; i++) {
            result[i] /= i * 2 + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        // System.out.println(whoseTurn("b1;g1;b8;g8"));
        // System.out.println(whoseTurn("b1;g1;b8;g8"));
        System.out.println(alphabetSubsequence2("effg"));
        System.out.println(alphabetSubsequence2("ace"));
    }

}
