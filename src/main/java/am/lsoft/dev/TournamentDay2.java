package am.lsoft.dev;

import java.util.*;

/**
 * Created by Davit on 31/05/16.
 */
public class TournamentDay2 {

    static int findSquareSide(int[] x, int[] y) {

        class Helper {
            int sqr(int x) {
                return x * x;
            }

            int squareDistance(int[] a, int[] b) {
                return sqr(a[0] - b[0]) + sqr(a[1] - b[1]);
            }

            int[] point(int x, int y) {
                return new int[]{x, y};
            }
        }
        Helper h = new Helper();

        int answer = h.squareDistance(h.point(x[0], y[0]), h.point(x[1], y[1]));
        for (int i = 2; i < 4; i++) {
            answer = Math.min(answer,
                    h.squareDistance(h.point(x[i - 1], y[i - 1]),
                            h.point(x[i], y[i])));
        }
        return answer;
    }

    String longestWord(String text) {

        char[] chars = text.toCharArray();
        String answer = "";
        StringBuilder current = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {
            if ('a' <= chars[i] && chars[i] <= 'z'
                    || 'A' <= chars[i] && chars[i] <= 'Z') {
                current.append(chars[i]);
                if (current.length() > answer.length()) {
                    answer = current.toString();
                }
            } else {
                current = new StringBuilder();
            }
        }

        return answer;
    }

    static int[] mixedFractionToImproper(int[] A) {
        return new int[]{A[0] * A[2] + A[1], A[2]};
    }

    static int divisorsPairs(int[] sequence) {
        int result = 0;

        for (int i = 0; i < sequence.length; i++) {
            for (int j = i + 1; j < sequence.length; j++) {
                if (sequence[i] % sequence[j] == 0 || sequence[j] % sequence[i] == 0) {
                    result++;
                }
            }
        }

        return result;
    }

    static int digitDistanceNumber(int n) {

        int result = 0;
        int lastDigit = n % 10;
        int tenPower = 1;

        n /= 10;

        while (n != 0) {
            result += tenPower * Math.abs(n % 10 - lastDigit);
            tenPower *= 10;
            lastDigit = n % 10;
            n /= 10;
        }

        return result;
    }

    static int differentSubstrings(String inputString) {
        char[] chars = inputString.toCharArray();
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            //hashMap.put(String.valueOf(chars[i]), 1);
            String tmp = "";// = String.valueOf(chars[i]);
            for (int j = i; j < chars.length; j++) {
                //hashMap.put(String.valueOf(chars[j]), 1);
                tmp = tmp + String.valueOf(chars[j]);
                hashMap.put(tmp, 1);
            }
        }
        System.out.println(hashMap);
        return hashMap.size();
    }

    static int segmentsIntersection(int[] left, int[] right) {

        /*
        Set<Integer> s1 = new HashSet<Integer>(Arrays.asList(array1));
        Set<Integer> s2 = new HashSet<Integer>(Arrays.asList(array2));
        s1.retainAll(s2);
        */
        ArrayList<ArrayList<Integer>> hashSet = new ArrayList<>();
        for (int i = 0; i < left.length; i++) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int j = left[i]; j < right[i]; j++) {
                tmp.add(j);
            }
            hashSet.add(tmp);
        }

        Set<Integer> s1 = new HashSet<Integer>(hashSet.get(0));
        for (int i = 1; i < hashSet.size(); i++) {
            Set<Integer> s2 = new HashSet<Integer>(hashSet.get(i));
            s1.retainAll(s2);
        }

        return s1.size();
    }

    public static void main(String[] args) {
        System.out.println(findSquareSide(new int[]{0, 1, 0, 1}, new int[] {0, 1, 1, 0}));
        //System.out.println(mixedFractionToImproper(new int[]{3, 1, 2}));
        //System.out.println(divisorsPairs(new int[]{1, 3, 2}));
        //System.out.println(digitDistanceNumber(2744));
        //System.out.println(differentSubstrings("abac"));
        //System.out.println(segmentsIntersection(new int[]{1, 2, 3}, new int[]{5, 4, 11}));
    }

}
