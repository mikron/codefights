package am.lsoft.dev;

import java.util.*;

/**
 * Created by Davit on 14/06/16.
 */
public class TournamentDay15 {

    static boolean isEarlier(int[] time1, int[] time2) {
        if (time1[0] * 60 + time1[1] < time2[0] * 60 + time2[1]) {
            return true;
        }
        return false;
    }

    static int countSumOfTwoRepresentations2(int n, int l, int r) {
        int result = 0;

        for (int a = l; a <= r; a++) {
            int b = n - a;
            if (b >= l && b <= r && b >= a) {
                result++;
            }
        }
        return result;
    }

    static boolean isPangram(String sentence) {
        Set<Character> lettersRemaining = new HashSet<>();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            lettersRemaining.add(ch);
        }
        sentence = sentence.toLowerCase();
        for (int i = 0; i < sentence.length(); i++) {
            lettersRemaining.remove(sentence.charAt(i));
        }
        return lettersRemaining.isEmpty();
    }

    static int nextPrime(int n) {

        for (int i = n + 1; ; i++) {
            boolean isPrime = true;
            for (int divisor = 2; divisor * divisor <= i; divisor++) {
                if (i % divisor == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                return i;
            }
        }
    }

    static int[] nextSecond(int[] currentTime) {

        if (currentTime[2] == 59) {
            currentTime[2] = 0;
            if (currentTime[1] == 59) {
                currentTime[1] = 0;
                if (currentTime[0] == 23) {
                    currentTime[0] = 0;
                } else {
                    currentTime[0]++;
                }
            } else {
                currentTime[1]++;
            }
        } else {
            currentTime[2]++;
        }

        return currentTime;
    }

    /*static int maximumSum(int[] A, int[][] Q) {
        class Helper {
            Helper() {
            }

            int arraySum(int[] A, int l, int h) {
                int result = 0;
                for (int i = l; i <= h; i++) {
                    result += A[i];
                }
                return result;
            }

            int arrayMaxSum(int[] A, int range) {
                int i = A.length - 1;
                Arrays.sort(A);
                return arraySum(A, i - range, i);
            }
        }

        Helper h = new Helper();
        int maxSum = 0;
        for (int rows = 0; rows < Q.length; rows++) {
            int arraySum = h.arrayMaxSum(A, Q[rows][Q[rows].length - 1] - Q[rows][0]);
            if (arraySum > maxSum) {
                maxSum = arraySum;
            }
        }

        return maxSum;
    }*/

    static int maximumSum(int[] A, int[][] Q) {
        ArrayList<Integer> inDice = new ArrayList<>();

        for (int i = 0; i < A.length; i++) {
            inDice.add(0);
        }

        for (int[] e : Q) {
            for (int i = e[0]; i <= e[1]; i++) {
                inDice.set(i, inDice.get(i) + 1);
            }
        }

        Collections.sort(inDice);
        Arrays.sort(A);

        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += inDice.get(i) * A[i];
        }

        return sum;
    }

    static int depositProfit(int deposit, int rate, int threshold) {

        int[] fraction = new int[2];
        fraction[0] = deposit;
        fraction[1] = 1;
        int year = 0;

        while (fraction[0] < fraction[1] * threshold) {
            fraction[0] *= 100 + rate;
            fraction[1] *= 100;
            year++;
        }

        return year;
    }

    static int leastSignificantBit(int n) {

        int ans = 1;
        while ((n & 1) == 0) {
            n >>= 1;
            ans *= 2;
        }

        return ans;
    }

    public static void main(String[] args) {
        // System.out.println(isEarlier(new int[]{22, 30}, new int[]{10, 59}));
        // System.out.println(countSumOfTwoRepresentations2(6, 2, 4));
        // System.out.println(isPangram("The quick brown fox jumps over the lazy dog."));
        // System.out.println(isPangram("abcdefghijklmnopqrstuvwxya"));
        // System.out.println(nextPrime(7));
        // System.out.println(nextSecond(new int[]{23, 59, 59}));
        // System.out.println(maximumSum(new int[]{2, 1, 2}, new int[][]{{0, 1}}));
        // System.out.println(maximumSum(new int[]{4, 2, 1, 6, 5, 7, 2, 4}, new int[][]{{1, 6}, {2, 4}, {3, 6}, {0, 7}, {3, 6}, {4, 4}, {5, 6}, {5, 6}, {0, 1}, {3, 4}}));
        // System.out.println(depositProfit(100, 10, 130));
        System.out.println(leastSignificantBit(12));
    }

}
