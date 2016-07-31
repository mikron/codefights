package am.lsoft.dev;

import java.util.*;

/**
 * Created by Davit on 30/07/16.
 */
public class TournamentDay48 {

    // TODO BUGFIX
    private static int countVisibleTowerPairs(int[] position, int[] height) {

        int result = 0;

        for (int i = 0; i < position.length; i++) {
            for (int j = i + 1; j < position.length; j++) {
                int A = height[j] - height[i],
                        B = position[i] - position[j],
                        C = -A * position[i] - B * height[i];
                boolean visible = true;

                int leftBound = Math.min(position[i], position[j]);
                int rightBound = Math.max(position[i], position[j]);
                for (int k = 0; k < position.length; k++) {
                    if (leftBound < position[k] &&
                            (A * position[k] + B * height[k] + C) * C < 0) {
                        visible = false;
                    }
                }

                if (visible) {
                    result++;
                }
            }
        }

        return result;
    }

    private static boolean isInsideTheCircle(int xa, int ya, int xc, int yc, int rc) {
        int dist = (xa - xc) * (xa - xc) + (ya - yc) * (ya - yc);
        rc *= rc;
        if (dist < rc) {
            return true;
        }
        return false;
    }

    private static int countInversionsNaive(int[] inputArray) {

        int result = 0;

        for (int i = 0; i < inputArray.length; i++) {
            for (int j = i + 1; j < inputArray.length; j++) {
                if (inputArray[i] > inputArray[j]) {
                    result++;
                }
            }
        }
        return result;
    }

    private static int growingPlant(int upSpeed, int downSpeed, int desiredHeight) {

        int currentHeight = 0,
                dayIndex = 1;

        while (currentHeight + upSpeed < desiredHeight) {
            currentHeight += upSpeed - downSpeed;
            dayIndex++;
        }

        return dayIndex;
    }

    private static int cubeVolume(int n) {
        return n * n * n;
    }

    private static ArrayList<Integer> mergeKArrays(int[][] arrays) {
        int[] firstUnused = new int[arrays.length];
        ArrayList<Integer> result = new ArrayList<>();
        int n = 0;
        for (int i = 0; i < arrays.length; i++) {
            n += arrays[i].length;
        }
        for (int i = 0; i < n; i++) {
            int minIndex = -1,
                    minValue = 0;
            for (int j = 0; j < arrays.length; j++) {
                if (firstUnused[j] < arrays[j].length) {
                    if (minIndex == -1 || minValue > arrays[j][firstUnused[j]]) {
                        minIndex = j;
                        minValue = arrays[j][firstUnused[j]];
                    }
                }
            }
            result.add(minValue);
            firstUnused[minIndex]++;
        }
        return result;
    }

    private static int threeGlasses(int[] cap) {

        final boolean[][][] was = new boolean[cap[0] + 1][cap[1] + 1][cap[2] + 1];
        final Set<Integer> wasCnt = new HashSet<>();
        final LinkedList<int[]> queue = new LinkedList<>();

        class Helper {

            int[] copy(int[] a) {
                return new int[]{a[0], a[1], a[2]};
            }

            void tryAdd(int[] a) {
                if (!was[a[0]][a[1]][a[2]]) {
                    was[a[0]][a[1]][a[2]] = true;
                    wasCnt.add(a[0] + a[1] + a[2]);
                    queue.addLast(a);
                }
            }
        }
        Helper h = new Helper();

        h.tryAdd(h.copy(cap));
        while (!queue.isEmpty()) {
            int[] cur = queue.pollFirst();
            for (int i = 0; i < 3; i++) {
                int[] next = h.copy(cur);
                next[i] = 0;
                h.tryAdd(next);

                for (int j = 0; j < 3; j++) {
                    if (i != j && cur[i] + cur[j] > cap[j]) {
                        next = h.copy(cur);
                        next[i] -= cap[j] - cur[j];
                        next[j] = cap[j];
                        h.tryAdd(next);
                    } else if (i != j) {
                        next = h.copy(cur);
                        next[j] += next[i];
                        next[i] = 0;
                        h.tryAdd(next);
                    }
                }
            }
        }

        return wasCnt.size() - 1;
    }

    private static int maxDivisor(int left, int right, int divisor) {

        for (int i = right; i >= left; i--) {
            if (i % divisor == 0) {
                return i;
            }
        }
        return -1;
    }

    private static boolean isGeometricProgression(int[] sequence) {
        int prog = sequence[1] / sequence[0];
        for (int i = 2; i < sequence.length; i++) {
            if (sequence[i] / sequence[i - 1] != prog || sequence[i] % sequence[i - 1] != 0)
                return false;
        }
        return true;
    }

    private static int chipMoving(int[][] grid) {

        final int MAX_COST = (int) 1e7;

        int n = grid.length,
                m = grid[0].length;

        int[][][] dp = new int[n][m][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 2; k++) {
                    dp[i][j][k] = MAX_COST;
                }
            }
        }

        dp[0][0][0] = 0;
        dp[0][0][1] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i < n - 1) {
                    dp[i + 1][j][0] = Math.min(Math.min(dp[i + 1][j][0],
                            dp[i][j][0] + grid[i + 1][j]),
                            dp[i][j][1] + grid[i + 1][j] + 10);
                }
                if (j < m - 1) {
                    dp[i][j + 1][1] = Math.min(Math.min(dp[i][j + 1][1],
                            dp[i][j][1] + grid[i][j + 1]),
                            dp[i][j][0] + grid[i][j + 1] + 10);
                }
            }
        }

        return Math.min(dp[n - 1][m - 1][0], dp[n - 1][m - 1][1]);
    }

    private static boolean pairOfShoes(int[][] shoes) {
        ArrayList<Integer> leftShoes = new ArrayList<>();
        ArrayList<Integer> rightShoes = new ArrayList<>();
        for (int i = 0; i < shoes.length; i++) {
            if (shoes[i][0] == 0) {
                leftShoes.add(shoes[i][1]);
            } else {
                rightShoes.add(shoes[i][1]);
            }
        }
        Collections.sort(leftShoes);
        Collections.sort(rightShoes);
        if (leftShoes.size() != rightShoes.size()) {
            return false;
        }
        for (int i = 1; i < leftShoes.size(); i++) {
            if (leftShoes.get(i) != rightShoes.get(i)) {
                return false;
            }
        }
        return true;
    }

    private static int sequenceElement(int[] a, int n) {

        final int MOD = (int) 1e5;
        List<Integer> seq = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            seq.add(a[i]);
        }

        int lastFive = a[0] * (int) 1e4 + a[1] * (int) 1e3 +
                a[2] * (int) 1e2 + a[3] * 10 + a[4];
        Map<Integer, Integer> was = new HashMap<>();
        was.put(lastFive, 4);

        for (int i = 5; ; i++) {
            seq.add((seq.get(i - 1) + seq.get(i - 2) +
                    seq.get(i - 3) + seq.get(i - 4) + seq.get(i - 5)) % 10);
            lastFive = (lastFive * 10 + seq.get(i)) % MOD;
            if (was.containsKey(lastFive)) {
                int last = was.get(lastFive);
                return seq.get(n % (i - last));
            } else {
                was.put(lastFive, i);
            }
        }
    }

    private static boolean isPangram(String sentence) {
        boolean[] found = new boolean[26];
        boolean result = true;
        for (int i = 0; i < sentence.length(); i++) {
            int code = (int) sentence.charAt(i);
            if ((int) 'A' <= code && code <= (int) 'Z') {
                code += -'A' + 'a';
            }
            if ((int) 'a' <= code && code <= (int) 'z') {
                found[code - (int) 'a'] = true;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (!found[i]) {
                result = false;
            }
        }

        return result;
    }

    private static int eulersTotientFunction(int n) {
        int tot = n; //this will be the totient at the end of the sample
        for (int p = 2; p * p <= n; p++) {
            if (n % p == 0) {
                tot /= p;
                tot *= (p - 1);
                while (n % p == 0)
                    n /= p;
            }
        }
        if (n > 1) { // now n is the largest prime divisor
            tot /= n;
            tot *= (n - 1);
        }
        return tot;
    }

    private static boolean alphabetSubstring(String s) {

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1) + 1) {
                return false;
            }
        }
        return true;
    }

    private static int arrayElementsProduct(int[] inputArray) {

        int result = inputArray[0];

        for (int i = 1; i < inputArray.length; i++) {
            result *= inputArray[i];
        }
        return result;
    }

    private static int balancedBinaryTreeDiameter(int n) {

        class Helper {
            int maxDepth(int n) {
                if (n == 0) {
                    return 0;
                }
                if (n == 1) {
                    return 1;
                }
                return maxDepth(n / 2) + 1;
            }
        }
        ;

        Helper h = new Helper();

        return h.maxDepth((n - 1) / 2)
                + h.maxDepth(n / 2);
    }

    private static int divisorsSubset(int[] subset, int n) {
        int c = 0;
        for (int i = 1; i <= n; i++) {
            boolean ch = true;
            for (int aSubset : subset) {
                if (i % aSubset != 0)
                    ch = false;
            }
            if (ch) c++;
        }
        return c;
    }

    private static int eulersTotientFunction2(int n) {
        int divisor = 2,
                result = n;

        while (divisor * divisor <= n) {
            if (n % divisor == 0) {
                while (n % divisor == 0) {
                    n /= divisor;
                }
                result -= result / divisor;
            }
            divisor++;
        }
        if (n > 1) {
            result -= result / n;
        }

        return result;
    }

    private static int maxDigit(int n) {
        int max = n % 10;
        n /= 10;
        while (n != 0) {
            int digit = n % 10;
            if (max < digit)
                max = digit;
            n /= 10;
        }

        return max;

    }

    private static String formatString(String inputString) {

        StringBuilder formattedString = new StringBuilder();
        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) == ' ') {
                if (formattedString.length() > 0
                        && formattedString.charAt(formattedString.length() - 1) != ' ') {
                    formattedString.append(inputString.charAt(i));
                }
            } else {
                formattedString.append(inputString.charAt(i));
            }
        }
        if (formattedString.charAt(formattedString.length() - 1) == ' ') {
            formattedString.deleteCharAt(formattedString.length() - 1);
        }

        return formattedString.toString();
    }

    private static boolean ortogonalLines(int[] line1, int[] line2) {

        if (line1[0] * line2[0] + line1[1] * line2[1] == 0) {
            return true;
        }
        return false;
    }

    private static int countLuckyNumbers(int n) {

  /*
   * array dp (short for dynamic programming)
   * is used for storing the interim values.
   */
        int[][] dp = new int[n / 2 + 1][];
        int result = 0;

        for (int i = 0; i <= n / 2; i++) {
            dp[i] = new int[i * 9 + 1];
        }
        dp[0][0] = 1;

        for (int i = 0; i < n / 2; i++) {
            for (int sum = 0; sum <= i * 9; sum++) {
                for (int nextDigit = 0; nextDigit < 10; nextDigit++) {
                    dp[i + 1][sum + nextDigit] += dp[i][sum];
                }
            }
        }

        for (int sum = 0; sum <= (n / 2 ) * 9; sum++) {
            result += dp[n / 2][sum] * dp[n / 2][sum];
        }
        return result;
    }

    public static void main(String[] args) {
        // System.out.println(mergeKArrays(new int[][]{{1, 3, 5}, {2, 3}, {2, 3, 5, 8}}));
        // System.out.println(threeGlasses(new int[]{16, 5, 3}));
        // System.out.println(isGeometricProgression(new int[]{2, 4, 8, 17, 34}));
        // System.out.println(chipMoving(new int[][]{{0, 0, 99, 99, 99}, {99, 0, 0, 0, 99}, {99, 99, 99, 0, 99}, {99, 99, 99, 0, 99}, {99, 99, 99, 0, 0}}));
        /*System.out.println(chipMoving(new int[][]{{4, 11, 6, 16, 6, 9, 3, 2, 10, 14}, {1, 7, 8, 11, 16, 3, 18, 13, 5, 12}, {10, 12, 10, 2, 15, 0, 18, 11, 13, 7}, {14, 15, 15, 15, 9, 5, 11, 11, 7, 4}, {5, 9, 15, 19, 4, 4, 11, 4, 14, 8},
                {5, 5, 15, 2, 15, 15, 14, 10, 19, 19}, {8, 9, 2, 3, 18, 12, 15, 10, 10, 3}, {8, 2, 1, 11, 4, 3, 16, 7, 8, 13}, {17, 2, 17, 10, 17, 13, 16, 14, 8, 5}, {10, 4, 9, 3, 13, 10, 5, 4, 3, 10}}));*/
        // System.out.println(chipMoving(new int[][]{{19, 11, 13, 0, 8, 1, 18, 12}}));
        // System.out.println(pairOfShoes(new int[][]{{0, 23}, {1, 22}}));
        // System.out.println(sequenceElement(new int[]{1, 2, 3, 4, 5}, 9));
        // System.out.println(alphabetSubstring("efghi"));
        // System.out.println(divisorsSubset(new int[]{2, 3}, 13));
        // System.out.println(divisorsSubset(new int[]{1}, 62));
        // System.out.println(formatString(" abc   a aa  a a "));
        System.out.println(countLuckyNumbers(2));
        System.out.println(countLuckyNumbers(4));
    }

}
