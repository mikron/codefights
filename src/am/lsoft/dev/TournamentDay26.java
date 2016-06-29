package am.lsoft.dev;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Davit on 27/06/16.
 */
public class TournamentDay26 {

    private static String wordAbbreviation2(String a) {
        int sum = 0;
        int power = 0;
        int twoRaisedToPower = 1;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            sum += 1 << (a.charAt(i) - 'a');
        }
        while (twoRaisedToPower * 2 <= sum) {
            twoRaisedToPower *= 2;
            power++;
        }
        while (sum > 0) {
            if (twoRaisedToPower <= sum) {
                sum -= twoRaisedToPower;
                result.append((char) ('a' + power));
            }
            power--;
            twoRaisedToPower /= 2;
        }
        return result.reverse().toString();
    }

    private static int segmentCover(int[] A, int L) {
        Arrays.sort(A);
        int tot = 1;
        int piv = A[0];

        for (int x = 1; x < A.length; x++) {
            if (A[x] - piv > L) {
                piv = A[x];
                tot++;
            }
        }

        return tot;
    }

    private static boolean whitespaceSearchRegExp(String input) {

        return java.util.regex.Pattern.compile(" ").matcher(input).find();
    }

    private static int divideAsLongAsPossible(int n, int d) {
        while (n % d == 0) {
            n /= d;
        }
        return n;
    }

    private static int gcm(int a, int b) {
        return b == 0 ? a : gcm(b, a % b);
    }

    private static int[] fractionReducing(int[] fraction) {
        int gcm = gcm(fraction[0], fraction[1]);
        return new int[]{fraction[0] / gcm, fraction[1] / gcm};

    }

    private static int[] fractionMultiplication(int[] A, int[] B) {
        return fractionReducing(new int[]{A[0] * B[0], A[1] * B[1]});
    }

    private static int evenNumbersBeforeFixed(int[] sequence, int fixedElement) {

        int result = 0;

        for (int i = 0; i < sequence.length; i++) {
            if (sequence[i] % 2 == 0 && sequence[i] != fixedElement) {
                result++;
            }
            if (sequence[i] == fixedElement) {
                return result;
            }
        }

        return -1;
    }

    private static boolean noAdjacentBits(int a) {

        int lastBit = 0,
                idx = 0;
        while ((1 << idx) <= a) {
            int curBit = (a >> idx) & 1;
            if (lastBit == 1 && curBit == 1) {
                return false;
            }
            lastBit = curBit;
            idx++;
        }

        return true;
    }

    private static boolean isLuckyNumber(int n) {
        while (n > 0) {
            int digit = n % 10;
            if (digit != 4 && digit != 7)
                return false;
            n /= 10;
        }
        return true;
    }

    private static int validRoute(int[] travelTimes, int[] readyTimes, int[] cancelTimes) {

        int earliestStartTime = 0;
        int latestStartTime = 24 * 60 * 60;
        int totalWorkTime = 0;
        for (int i = 0; i < readyTimes.length; i++) {
            if (earliestStartTime + totalWorkTime > cancelTimes[i]) {
                return -1;
            }
            latestStartTime = Math.min(latestStartTime,
                    cancelTimes[i] - totalWorkTime);
            if (latestStartTime + totalWorkTime < readyTimes[i]) {
                totalWorkTime = readyTimes[i] - latestStartTime;
            }
            earliestStartTime = Math.max(earliestStartTime,
                    readyTimes[i] - totalWorkTime);

            totalWorkTime += travelTimes[i];
        }

        return totalWorkTime;
    }

    private static int uberPool(int[] A, int[] B, int[] C, int[] X, int[] Y) {

        class Helper {
            private int distance(int[] P, int[] Q) {
                return Math.abs(P[1] - Q[1]) + Math.abs(P[0] - Q[0]);
            }
        }
        Helper h = new Helper();

        int initialDist = h.distance(A, B);
        int travelledDist = h.distance(A, C);
        int[][] D = new int[][]{X, Y};
        int[] remainingDist = new int[2];
        for (int i = 0; i < 2; i++) {
            remainingDist[i] = h.distance(C, D[i]) + h.distance(D[i], B);
        }

        int best = 1;
        if (remainingDist[0] > remainingDist[1]) {
            best = 2;
        }

        if (travelledDist + remainingDist[best - 1] > 2 * initialDist) {
            best = -1;
        }

        return best;
    }

    private static boolean regularBracketSequence1(String sequence) {

        int balance = 0;
        for (int i = 0; i < sequence.length(); i++) {
            if (sequence.charAt(i) == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        if (balance != 0) {
            return false;
        }
        return true;
    }

    private static String[] fileNaming(String[] names) {
        ArrayList<String> res = new ArrayList<>(names.length);
        int k;
        for (String s : names) {
            k = 1;
            for (int i = 0; i < res.size(); i++) {
                if (res.get(i).equals(s)) {
                    if (!res.contains(s + "(" + k + ")")) {
                        res.add(s + "(" + k + ")");
                        k++;
                    } else {
                        while(true) {
                            k++;
                            if (!res.contains(s + "(" + k + ")")) {
                                res.add(s + "(" + k + ")");
                                break;
                            }
                        }
                    }
                }
            }
            if (k == 1)
                res.add(s);
        }
        String[] result = new String[res.size()];
        for (int i = 0; i < res.size(); i++)
            result[i] = res.get(i);
        return result;
    }

    public static void main(String[] args) {
        // System.out.println(wordAbbreviation2("aaaaa"));
        // System.out.println(wordAbbreviation2("abcabc"));
        // System.out.println(segmentCover(new int[]{1, 3, 4, 5, 8}, 3));
        // System.out.println(divideAsLongAsPossible(36, 3));
        // System.out.println(fractionMultiplication(new int[]{3, 2}, new int[]{2, 5}));
        // System.out.println(evenNumbersBeforeFixed(new int[]{1, 4, 2, 6, 3, 1}, 6));
        // System.out.println(noAdjacentBits(22));
        // System.out.println(isLuckyNumber(47));
        // System.out.println(validRoute(new int[]{500, 500}, new int[]{1000, 3000}, new int[]{2000, 4000}));
        // System.out.println(regularBracketSequence1("()()"));
        System.out.println(fileNaming(new String[]{"doc", "doc", "image", "doc(1)", "doc"}));
    }

}
