package am.lsoft.dev;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Davit on 28/06/16.
 */
public class TournamentDay27 {

    private static boolean increaseNumberRoundness(int n) {

        boolean gotToSignificant = false;
        while (n > 0) {
            if (n % 10 == 0 && gotToSignificant) {
                return true;
            } else if (n % 10 != 0) {
                gotToSignificant = true;
            }
            n /= 10;
        }

        return false;
    }

    private static int squareDigitsSequence(int n) {

        int cur = n;
        Set<Integer> was = new HashSet<>();

        while (!was.contains(cur)) {
            was.add(cur);
            int next = 0;
            while (cur > 0) {
                next += (cur % 10) * (cur % 10);
                cur /= 10;
            }
            cur = next;
        }

        return was.size() + 1;
    }

    private static boolean isFriend(int[] divisors, int a, int b) {
        for (int i = 0; i < divisors.length; i++)
            if (!(a % divisors[i] == 0 && b % divisors[i] == 0)
                    && !(a % divisors[i] != 0 && b % divisors[i] != 0))
                return false;
        return true;
    }

    private static int numberOfClans(int[] divisors, int k) {
        int clans = 0;
        boolean[] hasFriend = new boolean[k];
        for (int i = 1; i <= k; i++)
            for (int j = i + 1; j <= k; j++)
                if (isFriend(divisors, i, j)) {
                    System.out.println("A = " + i + " / B = " + j);
                    hasFriend[i - 1] = true;
                    hasFriend[j - 1] = true;
                    clans++;
                }

        for (int i = 0; i < k; i++)
            if (!hasFriend[i] && isFriend(divisors, i + 1, i + 1)) {
                System.out.println("A = " + (i + 1));
                clans++;
            }

        return clans;
    }

    private static int kthDigit(int n, int k) {

        int numDigits = 0, number = n;
        while (number != 0) {
            numDigits++;
            number /= 10;
        }

        int indexFromLast = numDigits - k + 1;

        while (n != 0) {
            if (--indexFromLast == 0) {
                return n % 10;
            }
            n /= 10;
        }

        return -1;
    }

    public static void main(String[] args) {
        // System.out.println(increaseNumberRoundness(902200100));
        // System.out.println(increaseNumberRoundness(902200100));
        // System.out.println(numberOfClans(new int[]{2, 3}, 6));
        System.out.println(numberOfClans(new int[]{1, 3}, 10));
    }

}
