package am.lsoft.dev;

import java.util.*;

/**
 * Created by Davit on 03/08/16.
 */
public class TournamentDay52 {

    private static int finalizeColoring(int[][] board) {
        int i, c = 0, j;
        Set<Integer> x = new HashSet<>(), y = new HashSet<>();
        for (i = 0; i < board.length; i++) {
            for (j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) c++;
                if (board[i][j] == 1) {
                    x.add((i + j) % 2);
                }
                if (board[i][j] == 2) {
                    y.add((i + j) % 2);
                }
            }
        }
        if (x.size() > 1 || y.size() > 1) return 0;
        if (x.size() == 0 && y.size() == 0) return 2;
        if (x.size() == 0 || y.size() == 0) return 1;
        if (x.size() == 1 && y.size() == 1) {
            int xBegin = x.iterator().next();
            int yBegin = y.iterator().next();
            if (xBegin == yBegin)
                return 0;
            else
                return 1;
        }
        return -1;
    }

    private static int sequencePeakElement(int[] sequence) {
        int left = 1;
        int right = sequence.length - 2;
        while (left < right) {
            int middle = (left + right) / 2;
            if (sequence[middle] > Math.max(sequence[middle - 1], sequence[middle + 1])) {
                left = right = middle;
                break;
            }
            if (sequence[middle - 1] < sequence[middle]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return sequence[left];
    }

    private static int longestSequence(int[] A) {

        int best = 1;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int diff = A[j] - A[i];
                if (diff == 0) {
                    continue;
                }
                int cur = 1;
                int last = A[i];
                for (int k = j; k < A.length; k++) {
                    if (A[k] - last == diff) {
                        cur++;
                        last = A[k];
                    }
                }
                if (cur > best) {
                    best = cur;
                }
            }
        }

        return best;
    }

    /*ERROR*/
    private static int squarePermutations(int n) {
        int num = 1;

        /*while (true) {
            int counter = 0;
            int[] ara = new int[10];
            int pos = 0, N = num;
            int S = (int) Math.sqrt(N);
            if (S * S != N) {
                num++;
                continue;
            }
            while (N > 0) {
                int r = N % 10;
                ara[pos++] = r;
                N /= 10;
            }
            Arrays.sort(ara, ara + pos);
            do {
                if (ara[0] == 0) continue;
                int x = 0;
                for (int i = 0; i < pos; i++) {
                    x = x * 10 + ara[i];
                }
                int sq = Math.sqrt(x);
                if (sq * sq == x && x != num) {
                    counter++;
                }
                if (counter == n) return num;

            } while (std::next_permutation (ara, ara + pos));
            num++;
        }*/
        return 0;
    }

    private static int constructSquare(String s) {

        int[] letterCnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            letterCnt[s.charAt(i) - 'a']++;
        }
        Arrays.sort(letterCnt);

        int best = -1;
        int minNumber = (int) Math.pow(10, s.length() - 1);
        for (int k = (int) Math.sqrt(minNumber); k <= Math.pow(10, (s.length() + 1) / 2); k++) {
            int n = k * k;
            int[] digitCnt = new int[26];
            while (n > 0) {
                digitCnt[n % 10]++;
                n /= 10;
            }
            Arrays.sort(digitCnt);
            if (Arrays.equals(letterCnt, digitCnt)) {
                best = k * k;
            }
        }

        return best;
    }

    private static boolean bettingGame(int[] L) {

        int s = 0;
        for (int i = 0; i < L.length; i++) {
            s += L[i];
        }
        if (s == 0) {
            return false;
        }

        return s % L.length == 0;
    }

    private static int chessKnightMoves(String cell) {

        class Helper {
            boolean isValid(int pos) {
                if (0 <= pos && pos < 8) {
                    return true;
                }
                return false;
            }

            int getX(String pos) {
                return pos.charAt(0) - 'A';
            }

            int getY(String pos) {
                return pos.charAt(0) - '1';
            }
        }
        Helper h = new Helper();

        int current_x = h.getX(cell.substring(0, 1));
        int current_y = h.getY(cell.substring(1, 2));
        int result = 0;

        for (int dx = -2; dx <= 2; dx++) {
            for (int dy = -2; dy <= 2; dy++) {
                if (Math.abs(dx * dy) == 2) {
                    if (h.isValid(current_x + dx) && h.isValid(current_y + dy)) {
                        result++;
                    }
                }
            }
        }
        return result;

    }

    private static boolean isPowerOfTwo(int n) {

        while (n % 2 == 0) {
            n >>= 1;
        }

        if (n == 1) {
            return true;
        }

        return false;
    }

    private static int permutationCycles(int[] permutation) {

        boolean[] inCycle = new boolean[permutation.length];
        int result = 0;

        for (int i = 0; i < permutation.length; i++) {
            if (!inCycle[i]) {
                int position = i;
                while (!inCycle[position]) {
                    inCycle[position] = true;
                    position = permutation[position] - 1;
                }
                result++;
            }
        }

        return result;
    }

    private static String[] removeDuplicateStrings(String[] inputArray) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < inputArray.length; i++) {
            if (i + 1 < inputArray.length && inputArray[i].equals(inputArray[i + 1])) {
                continue;
            }
            result.add(inputArray[i]);
        }
        return result.toArray(new String[0]);
    }

    private static int countWaysToDecorate(int[][] boxes) {

        final int MOD = (int) 1e9 + 7;
        final int MAX_MASK = 1 << 10;

        int[] boxMasks = new int[boxes.length];
        for (int i = 0; i < boxes.length; i++) {
            for (int j = 0; j < boxes[i].length; j++) {
                boxMasks[i] |= 1 << boxes[i][j];
            }
        }

        int[] dp = new int[MAX_MASK];
        dp[0] = 1;
        for (int i = 0; i < boxes.length; i++) {
            int[] dpNext = Arrays.copyOf(dp, dp.length);
            for (int mask = 0; mask < MAX_MASK; mask++) {
                int newMask = mask ^ boxMasks[i];
                dpNext[newMask] = (dpNext[newMask] + dp[mask]) % MOD;
            }
            dp = dpNext;
        }

        return dp[0];
    }

    public static void main(String[] args) {
        /*System.out.println(finalizeColoring(new int[][]{{2, 1, 2, 0},
                {0, 2, 1, 2},
                {0, 0, 0, 0}}));
        System.out.println(finalizeColoring(new int[][]{{0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}}));*/
        // System.out.println(longestSequence(new int[]{1, 7, 3, 5, 4, 2}));
        System.out.println(isPowerOfTwo(64));
    }

}
