package am.lsoft.dev;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Davit on 01/06/16.
 */
public class TournamentDay3 {

    static int avoidObstacles(int[] inputArray) {

        for (int i = 1; ; i++) {
            for (int j = 0; j < inputArray.length; j++) {
                if (inputArray[j] % i == 0) {
                    break;
                }
                if (j == inputArray.length - 1) {
                    return i;
                }
            }
        }
    }

    static boolean isTandemRepeat(String inputString) {

        int len = inputString.length();
        if (len % 2 == 1) {
            return false;
        }
        for (int i = 0; i < len / 2; i++) {
            if (inputString.charAt(i) != inputString.charAt(i + len / 2)) {
                return false;
            }
        }

        return true;
    }

    static int maxFraction(int[] numerators, int[] denominators) {

        Double max = numerators[0] * 1.0 / denominators[0];
        int idx = 0;
        for (int i = 1; i < numerators.length; i++) {
            if (max <= numerators[i] * 1.0 / denominators[i]) {
                max = numerators[i] * 1.0 / denominators[i];
                idx = i;
            }
        }
        return idx;
    }

    static int[] multiplicationOfBigNumbers(int base, int[] a, int[] b) {

        ArrayList<Integer> c = new ArrayList<>();
        int next = 0;
        for (int k = 0; k < a.length + b.length - 1; k++) {
            int cur = next;
            int i, j;
            if (k < a.length) {
                i = a.length - 1 - k;
                j = b.length - 1;
            } else {
                i = 0;
                j = a.length + b.length - 1 - 1 - k;
            }
            while (i < a.length && j >= 0) {
                cur += a[i] * b[j];
                i++;
                j--;
            }
            c.add(cur % base);
            next = cur / base;
        }
        if (next > 0) {
            c.add(next);
        }

        Collections.reverse(c);
        int[] result = new int[c.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = c.get(i);
        }
        return result;
    }

    static String integerToStringOfFixedWidth(int number, int width) {
        ArrayList<Integer> digits = new ArrayList<>();
        int n = number;
        while (n > 0) {
            digits.add(n % 10);
            n = n / 10;
        }

        String res = "";
        for (int i = 0; i < Math.max(digits.size(), width); i++) {
            if (i < width && i >= digits.size()) {
                res = "0" + res;
            } else if (i < width) {
                res = digits.get(i) + res;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        // System.out.println(avoidObstacles(/*new int[]{5, 3, 6, 7, 9}*/new int[]{2, 3}));
        // System.out.println(maxFraction(new int[] {5, 2, 5}, new int[]{6, 3, 4}));
        // System.out.println(multiplicationOfBigNumbers(10, new int[] {9, 8, 7, 6}, new int[]{7, 6, 5}));
        System.out.println(integerToStringOfFixedWidth(1234, 2));
    }

}
