package am.lsoft.dev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by Davit on 26/06/16.
 */
public class TournamentDay25 {

    private static int magicalWell(int a, int b, int n) {
        int money = 0;
        while (n-- != 0) {
            money += a++ * b++;
        }
        return money;
    }

    private static double arrayMedian(int[] sequence) {
        int len = sequence.length;
        Arrays.sort(sequence);

        if (len % 2 == 0) {
            return (sequence[len / 2] + sequence[len / 2 - 1]) / 2.0;
        } else {
            return sequence[len / 2];
        }
    }

    private static int fact(int n) {
        if (n == 0)
            return 1;
        return fact(n - 1) * n;
    }

    private static int countWays(int n, int k) {
        return fact(n) / (fact(k) * fact(n - k));
    }

    private static String addDigits(int a, int b, int n) {

        int rem = a % b;

        StringBuilder result = new StringBuilder();
        result.append(a);

        for (int i = 0; i < n; i++) {
            int best = -1;
            for (int digit = 9; digit >= 0; digit--) {
                if ((rem * 10 + digit) % b == 0) {
                    best = digit;
                    break;
                }
            }
            if (best == -1) {
                break;
            }
            result.append(best);
            rem = (rem * 10 + best) % b;
        }

        return result.toString();
    }

    private static int[] clockDigitsCount(int[] startTime, int[] finishTime) {
        int start = startTime[0] * 60 * 60 + startTime[1] * 60 + startTime[2],
                finish = finishTime[0] * 60 * 60 + finishTime[1] * 60 + finishTime[2];

        int[] occurences = new int[10];

        for (int current = start; current <= finish; current++) {
            int[] values = {current % 60,
                    (current / 60) % 60,
                    current / (60 * 60)};
            for (int i = 0; i < values.length; i++) {
                occurences[values[i] % 10]++;
                occurences[(values[i] / 10) % 10]++;
            }
        }

        return occurences;
    }

    private static int factorialTrailingZeros(int n) {
        int result = 0;
        for (int i = 5; i <= n; i += 5) {
            int number = i;
            while (number % 5 == 0) {
                number /= 5;
                result++;
            }
        }
        return result;
    }

    private static int stringsConstruction(String A, String B) {

        class Helper {
            int[] countLetters(String s) {
                int[] cnt = new int[26];
                for (int i = 0; i < s.length(); i++) {
                    cnt[s.charAt(i) - 'a']++;
                }
                return cnt;
            }
        }
        Helper h = new Helper();

        int[] cntA = h.countLetters(A);
        int[] cntB = h.countLetters(B);
        int best = -1;
        for (int i = 0; i < 26; i++) {
            if (cntA[i] == 0) {
                continue;
            }
            int cur = cntB[i] / cntA[i];
            if (best == -1 || cur < best) {
                best = cur;
            }
        }

        return best;
    }

   /* private static int countAfterIntersection(String str1, String str2) {
        ArrayList<Character> arg1 = new ArrayList<>(str1.length());
        for (char c : str1.toCharArray()) {
            arg1.add(c);
        }
        ArrayList<Character> arg2 = new ArrayList<>(str2.length());
        for (char c : str2.toCharArray()) {
            arg2.add(c);
        }
        for (Iterator<Character> it1 = arg1.iterator(); it1.hasNext(); ) {
            Character ch1 = it1.next();
            for (Iterator<Character> it2 = arg2.iterator(); it2.hasNext(); ) {
                Character ch2 = it2.next();
                if (ch1 == ch2) {
                    it1.remove();
                    it2.remove();
                    break;
                }
            }
        }
        return Math.max(arg1.size(), arg2.size());
    }

    private static boolean stringsRearrangement(String[] inputArray) {
        for (int i = 1; i < inputArray.length; i++)
            if (countAfterIntersection(inputArray[i - 1], inputArray[i]) != 1)
                return false;
        return true;
    }*/

    private static int diff(String str1, String str2) {
        int t = 0;
        for (int i = 0; i < str1.length(); i++)
            if (str1.charAt(i) != str2.charAt(i))
                t++;
        return t;
    }

    private static void go(boolean[] vs, int v, int len, boolean[][] m) {
        if (vs[v])
            return;
        vs[v] = true;
        for (int i = 0; i < len; i++)
            if (! vs[i] && m[i][v])
                go(vs, i, len, m);
    }

    private static boolean all(boolean[] vs) {
        for (boolean i : vs)
            if (!i)
                return false;
        return true;
    }


    private static boolean stringsRearrangement(String[] inputArray) {
        int l = inputArray.length;

        // m = [[False for i in range(l)] for j in range(l)]
        boolean[][] m = new boolean[l][l];



        for (int i = 0; i < l; i++)
            for (int j = 0; j < Math.min(i + 1, l); j++)
                if (diff(inputArray[i], inputArray[j]) == 1) {
                    m[i][j] = true;
                    m[j][i] = true;
                }

        boolean[] vs;


        for (int start = 0; start < l; start++) {
            vs = new boolean[l];
            go(vs, start, l, m);
            if (all(vs))
                return true;

        }
        return false;
    }


    public static void main(String[] args) {
        // System.out.println(magicalWell(1, 2, 2));
        // System.out.println(addDigits(12, 11, 2));
        // System.out.println(clockDigitsCount(new int[]{23, 59, 58}, new int[]{23, 59, 59}));
        // System.out.println(factorialTrailingZeros(10));
        // System.out.println(stringsConstruction("abc", "abccba"));
        // System.out.println(stringsRearrangement(new String[]{"aba", "bbb", "bab"}));
        // System.out.println(stringsRearrangement(new String[]{"ab", "bb", "aa"}));
        System.out.println(stringsRearrangement(new String[]{"q", "q"}));
    }

}
