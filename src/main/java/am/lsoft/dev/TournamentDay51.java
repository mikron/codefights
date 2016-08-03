package am.lsoft.dev;

import java.util.*;

/**
 * Created by Davit on 01/08/16.
 */
public class TournamentDay51 {

    private static boolean areSimilarNumbers(int a, int b, int divisor) {
        if (a % divisor == 0 && b % divisor == 0
                || a % divisor != 0 && b % divisor != 0) {
            return true;
        }
        return false;
    }

    private static int dfsComponentSize(final boolean[][] matrix, int vertex) {

        class Helper {
            int componentSize = 0;

            void dfs(int currentVertex, ArrayList<Boolean> visited) {
                visited.set(currentVertex, true);
                componentSize++;
                for (int nextVertex = 0; nextVertex < matrix.length; nextVertex++) {
                    if (matrix[currentVertex][nextVertex] && !visited.get(nextVertex)) {
                        dfs(nextVertex, visited);
                    }
                }
            }
        }
        Helper h = new Helper();

        ArrayList<Boolean> visited = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            visited.add(false);
        }

        h.dfs(vertex, visited);

        return h.componentSize;
    }

    private static int[] setDifference(int[] A, int[] B) {

        Arrays.sort(A);
        Arrays.sort(B);
        ArrayList<Integer> C = new ArrayList<>();

        int pos_b = 0;
        for (int pos_a = 0; pos_a < A.length; pos_a++) {
            while (pos_b < B.length && B[pos_b] < A[pos_a]) {
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

    private static boolean coolString(String inputString) {

        class Helper {
            boolean isLowercase(char symbol) {
                if ('a' <= symbol && symbol <= 'z') {
                    return true;
                }
                return false;
            }

            boolean isUppercase(char symbol) {
                if ('A' <= symbol && symbol <= 'Z') {
                    return true;
                }
                return false;
            }
        }
        Helper h = new Helper();

        boolean firstIsLowercase = h.isLowercase(inputString.charAt(0));
        boolean firstIsUppercase = h.isUppercase(inputString.charAt(0));

        if (!(firstIsLowercase || firstIsUppercase)) {
            return false;
        }

        for (int i = 1; i < inputString.length(); i++) {
            if (i % 2 == 1) {
                if (h.isLowercase(inputString.charAt(i)) == firstIsLowercase ||
                        h.isUppercase(inputString.charAt(i)) == firstIsUppercase) {
                    return false;
                }
            } else {
                if (h.isLowercase(inputString.charAt(i)) != firstIsLowercase ||
                        h.isUppercase(inputString.charAt(i)) != firstIsUppercase) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean tennisSet(int score1, int score2) {
        int highScore = Math.max(score1, score2);
        int lowScore = Math.min(score1, score2);

        if (highScore == 6 && lowScore < 5)
            return true;
        if (highScore == 7 && lowScore != 7)
            return true;

        return false;

    }

    private static int amicableNumbers(int n) {

        Map<Integer, Integer> divSum = new HashMap<>();
        divSum.put(1, 0);
        for (int i = n; ; i++) {
            int sum = 0;
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    sum += j;
                }
            }
            divSum.put(i, sum);
            if (sum < i && divSum.get(sum) == i) {
                if (sum >= n) {
                    return sum;
                } else if (i >= n) {
                    return i;
                }
            }
        }
    }

    private static int combs(String comb1, String comb2) {

        class Helper {
            int getMask(String comb) {
                int mask = 0;
                for (int i = 0; i < comb.length(); i++) {
                    char c = comb.charAt(i);
                    mask = (mask << 1) + (c == '*' ? 1 : 0);
                }
                return mask;
            }
        }
        Helper h = new Helper();

        int m1 = h.getMask(comb1);
        int m2 = h.getMask(comb2);
        int len1 = comb1.length();
        int len2 = comb2.length();
        int answer = len1 + len2;
        for (int i = -len1; i <= len2; i++) {
            int tmp, length;
            if (i < 0) {
                tmp = m2 << (-i) & m1;
                length = Math.max(-i + len2, len1);
            } else {
                tmp = m1 << i & m2;
                length = Math.max(i + len1, len2);
            }
            if (tmp == 0 && answer > length) {
                answer = length;
            }
        }

        return answer;
    }

    private static int[] makeArrayConsecutive(int[] sequence) {

        ArrayList<Integer> answer = new ArrayList<>();
        int current_position = 0;

        Arrays.sort(sequence);
        for (int i = sequence[0]; i < sequence[sequence.length - 1]; i++) {
            if (sequence[current_position] != i) {
                answer.add(i);
            } else {
                current_position++;
            }
        }

        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }
        return result;
    }

    private static int numberOfAnagrams(String S) {

        class Helper {
            int factorial(int n) {
                int prod = 1;
                for (int i = 2; i <= n; i++) {
                    prod *= i;
                }
                return prod;
            }
        }
        Helper h = new Helper();

        Map<Character, Integer> charCount = new HashMap<>();

        for (int i = 0; i < S.length(); i++) {
            char key = S.charAt(i);
            if (charCount.containsKey(key)) {
                charCount.put(key, charCount.get(key) + 1);
            } else {
                charCount.put(key, 1);
            }
        }

        int Mf = h.factorial(S.length());

        int NFprod = 1;

        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            NFprod *= h.factorial(entry.getValue());
        }

        return Mf / NFprod;
    }

    private static int subarrayCount(int[] a, int k) {

        int s = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                if (a[j] > k)
                    s++;
                else
                    break;

            }
        }
        return s;
    }

    private static char[][] drawRectangle(char[][] canvas, int[] rectangle) {

        for (int i = rectangle[0] + 1; i < rectangle[2]; i++) {
            canvas[rectangle[1]][i] = '-';
            canvas[rectangle[3]][i] = '-';
        }
        for (int i = rectangle[1] + 1; i < rectangle[3]; i++) {
            canvas[i][rectangle[0]] = '|';
            canvas[i][rectangle[2]] = '|';
        }
        for (int i = 0; i < 4; i += 2) {
            for (int j = 1; j < 4; j += 2) {
                canvas[rectangle[j]][rectangle[i]] = '*';
            }
        }
        return canvas;
    }

    private static int segmentCover(int[] A, int L) {

        Arrays.sort(A);
        int segments = 0;
        for (int i = 0; i < A.length; ) {
            segments++;
            int l = i;
            int r = i + 1;
            while (r < A.length && A[r] - A[l] <= L) {
                r++;
            }
            i = r;
        }

        return segments;
    }

    private static int[] throwingBlocks(char[][] field) {
        class Helper {
            boolean isFirstColumnFull(char[][] field) {
                boolean result = true;
                for (int i = 0; i < field.length; i++) {
                    if (field[i][0] != '#')
                        result = false;
                }
                return result;
            }

            void countMoves(char[][] field, int[] result, int moves) {
                if (isFirstColumnFull(field)) {
                    result[0] = Math.min(result[0], moves);
                    result[1] = Math.max(result[1], moves);
                    return;
                }
                for (int i = 0; i < field.length; i++) {
                    if (field[i][0] == '#') {
                        continue;
                    }
                    int j = i;
                    int column = 0;
                    while (column < field[j].length && field[j][column] == '.') {
                        column++;
                    }
                    column--;
                    while (j < field.length && field[j][column] == '.') {
                        j++;
                    }
                    j--;
                    field[j][column] = '#';
                    countMoves(field, result, moves + 1);
                    field[j][column] = '.';
                }
            }
        }

        final int INF = field.length * field[0].length + 1;
        int[] result = new int[]{INF, -INF};
        Helper h = new Helper();
        h.countMoves(field, result, 0);
        return result;
    }

    private static boolean stringsRearrangement(String[] inputArray) {

        class Helper {
            String[] inputArray;

            void swap(int i, int j) {
                String tmp = inputArray[i];
                inputArray[i] = inputArray[j];
                inputArray[j] = tmp;
            }

            boolean bruteForce(int depth) {
                if (depth == inputArray.length) {
                    boolean correct = true;
                    for (int i = 0; i < inputArray.length - 1; i++) {
                        int differences = 0;
                        for (int j = 0; j < inputArray[i].length(); j++) {
                            if (inputArray[i].charAt(j) != inputArray[i + 1].charAt(j)) {
                                differences++;
                            }
                        }
                        if (differences != 1) {
                            correct = false;
                        }
                    }
                    if (correct) {
                        return true;
                    }
                    return false;
                }
                for (int i = depth; i < inputArray.length; i++) {
                    swap(depth, i);
                    if (bruteForce(depth + 1)) {
                        return true;
                    }
                    swap(depth, i);
                }
                return false;
            }
        }
        ;

        Helper h = new Helper();
        h.inputArray = inputArray;

        if (h.bruteForce(0)) {
            return true;
        }
        return false;
    }

    private static boolean regularBracketSequence2(String sequence) {

        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < sequence.length(); i++) {
            if (stack.size() > 0 && stack.getLast() == '(' && sequence.charAt(i) == ')') {
                stack.pollLast();
                continue;
            }
            if (stack.size() > 0 && stack.getLast() == '[' && sequence.charAt(i) == ']') {
                stack.pollLast();
                continue;
            }
            stack.addLast(sequence.charAt(i));
        }

        if (stack.size() != 0) {
            return false;
        }
        return true;
    }

    private static double computeDefiniteIntegral(int l, int r, int[] p) {

        double result = 0;
        int lExp = l,
                rExp = r;

        for (int i = 0; i < p.length; i++) {
            result += p[i] * (double) (rExp - lExp) / (i + 1);
            lExp *= l;
            rExp *= r;
        }

        return result;
    }

    private static char[][] snakeGame(char[][] gameBoard, String commands) {

        class Helper {
            List<int[]> queue;
            char[][] gameBoard;
            int startX = -1;
            int startY = -1;

            Helper(char[][] gameBoard) {
                this.gameBoard = gameBoard;
                queue = new ArrayList<>();
            }

            int[] parseDirection(char symbol) {
                switch (symbol) {
                    case '<':
                        return new int[]{0, -1};
                    case '>':
                        return new int[]{0, 1};
                    case '^':
                        return new int[]{-1, 0};
                    case 'v':
                        return new int[]{1, 0};
                    default:
                        return null;
                }
            }

            int[] findSnakeHead() {
                for (int i = 0; i < gameBoard.length; i++) {
                    for (int j = 0; j < gameBoard[0].length; j++) {
                        if (gameBoard[i][j] != '*' && gameBoard[i][j] != '.') {
                            startX = i;
                            startY = j;
                            return parseDirection(gameBoard[startX][startY]);
                        }
                    }
                }
                return null;
            }

            void findSnakeTail(int x, int y) {
                gameBoard[x][y] = '*';
                for (int dx = -1; dx <= 1; dx++) {
                    for (int dy = -1; dy <= 1; dy++) {
                        if (dx * dy == 0 && dx + dy != 0 && x + dx >= 0 && x + dx < gameBoard.length
                                && y + dy >= 0 && y + dy < gameBoard[0].length) {
                            if (gameBoard[x + dx][y + dy] == '*') {
                                findSnakeTail(x + dx, y + dy);
                            }
                        }
                    }
                }
                queue.add(new int[]{x, y});
            }

            void drawSnake(char bodyCharacter, int snakeLength) {
                for (int k = queue.size() - 1; k >= queue.size() - snakeLength; k--) {
                    gameBoard[queue.get(k)[0]][queue.get(k)[1]] = bodyCharacter;
                }
            }
        }
        ;

        int snakeLength = -1;
        int[] curDir;
        char[][] directionChars = new char[][]{{' ', '^', ' '},
                {'<', ' ', '>'},
                {' ', 'v', ' '}};

        Helper h = new Helper(gameBoard);

        curDir = h.findSnakeHead();
        h.findSnakeTail(h.startX, h.startY);
        snakeLength = h.queue.size();

        for (int i = 0; i < commands.length(); i++) {
            int x = h.queue.get(h.queue.size() - 1)[0];
            int y = h.queue.get(h.queue.size() - 1)[1];
            if (commands.charAt(i) == 'L') {
                curDir = new int[]{-curDir[1], curDir[0]};
                continue;
            }
            if (commands.charAt(i) == 'R') {
                curDir = new int[]{curDir[1], -curDir[0]};
                continue;
            }
            x += curDir[0];
            y += curDir[1];
            if (x < 0 || y < 0 || x >= gameBoard.length || y >= gameBoard[0].length) {
                h.drawSnake('X', snakeLength);
                return gameBoard;
            }
            for (int j = (int) h.queue.size() - 1; j > (int) h.queue.size() - snakeLength; j--) {
                if (h.queue.get(j)[0] == x && h.queue.get(j)[1] == y) {
                    h.drawSnake('X', snakeLength);
                    return gameBoard;
                }
            }
            h.queue.add(new int[]{x, y});
        }

        h.drawSnake('*', snakeLength);

        int startX = h.queue.get(h.queue.size() - 1)[0];
        int startY = h.queue.get(h.queue.size() - 1)[1];
        gameBoard[startX][startY] = directionChars[curDir[0] + 1][curDir[1] + 1];

        return gameBoard;
    }

    private static int countIncreasingSequences(int n, int k) {

  /*
   * vector dp (short for dynamic programming)
   * is used for storing the interim values.
   */
        int[] line = new int[k + 1];
        int[][] dp = new int[n + 1][line.length];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                for (int q = 0; q < j; q++) {
                    dp[i][j] += dp[i - 1][q];
                }
            }
        }

        int sum = 0;
        for (int j = 1; j <= k; j++) {
            sum += dp[n][j];
        }

        return sum;
    }

    private static int greatestCommonPrimeDivisor(int a, int b) {

        int gcd = -1;
        for (int divisor = 2; a > 1 && b > 1; divisor++) {
            if (a % divisor == 0 && b % divisor == 0) {
                gcd = divisor;
            }
            while (a % divisor == 0) {
                a /= divisor;
            }
            while (b % divisor == 0) {
                b /= divisor;
            }
        }

        return gcd;
    }

    private static int divisorsSuperset(int[] superset, int n) {

        class Helper {
            boolean isInSequence(int[] sequence, int elem) {
                for (int i = 0; i < sequence.length; i++) {
                    if (sequence[i] == elem) {
                        return true;
                    }
                }
                return false;
            }
        }
        ;

        int res = 0;
        Helper h = new Helper();

        for (int i = 1; i <= n; i++) {
            boolean correct = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    if (i == j || !h.isInSequence(superset, i / j)) {
                        correct = false;
                        break;
                    }
                }
            }
            if (correct) {
                res++;
            }
        }

        return res;
    }

    private static boolean arePrizesOK(int first, int second, int third) {
        if (first < second) {
            return false;
        }
        if (second < third) {
            return false;
        }
        return true;
    }

    private static boolean isLucky(int n) {

        ArrayList<Integer> digits = new ArrayList<>();
        int sum = 0;

        while (n > 0) {
            digits.add(n % 10);
            n /= 10;
        }

        for (int i = 0; i < digits.size(); i++) {
            if (i < digits.size() / 2) {
                sum += digits.get(i);
            } else {
                sum -= digits.get(i);
            }
        }

        if (sum != 0) {
            return false;
        }
        return true;
    }

    private static int divNumber(int k, int l, int r) {
        int total = 0;
        for (int i = l; i <= r + 1; i++) {
            ArrayList<Integer> divisors = new ArrayList<>();
            for (int j = 1; j < i + 1; j++)
                if (i % j == 0)
                    divisors.add(j);
            if (divisors.size() == k)
                total++;
        }

        return total;
    }

    private static int reverseBits(int n) {
        int res = 0;
        while (n > 0) {
            res = res * 2 + res | (n & 1);
            n /= 2;
        }
        return res;
    }

    private static int[] primeFactors2(int n) {
        ArrayList<Integer> factors = new ArrayList<>();
        int divisor = 2;

        while (n != 1) {
            if (n % divisor == 0) {
                factors.add(divisor);
            }
            while (n % divisor == 0) {
                n /= divisor;
            }
            divisor++;
        }

        int[] ans = new int[factors.size()];
        for (int i = 0; i < ans.length; ++i) {
            ans[i] = factors.get(i);
        }
        return ans;
    }

    private static boolean check(String a, String b, String c) {
        int n = a.length();
        String ans = "";
        for (int i = 0; i < n; i++) {
            if (a.charAt(i) == c.charAt(i)) {
                ans += a.charAt(i);
            } else if (b.charAt(i) == c.charAt(i)) {
                ans += b.charAt(i);
            }
        }
        if (ans.equals(c))
            return true;
        return false;
    }

    private static int stringsCrossover(String[] inputArray, String result) {
        int ans = 0;
        int n = inputArray.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n; j++)
                if (check(inputArray[i], inputArray[j], result))
                    ans += 1;
        return ans;
    }

    private static int appleBoxes(int k) {

        int sum = 0;
        int x = 0;
        do {
            if (x % 2 == 0) {
                sum += x * x;
            } else {
                sum -= x * x;
            }
            x++;
        } while (x <= k);

        return sum;
    }

    private static int countWaysToReachFinish(final boolean[] cells) {

        final int n = cells.length;
        final int MAX_MASK = 1 << n;

        class Helper {
            // dp[m][k] - the number of ways to reach the k-th cell using jumps
            // that are marked in the mask m.
            int[][] dp;
            boolean[][] was;

            Helper() {
                dp = new int[MAX_MASK][n];
                was = new boolean[MAX_MASK][n];
                dp[0][0] = 1;
                was[0][0] = true;
            }

            int get(int m, int k) {
                if (k < 0 || k >= n || !cells[k]) {
                    return 0;
                }
                if (was[m][k]) {
                    return dp[m][k];
                }
                for (int i = 1; i < n; i++) {
                    if ((m >> i & 1) == 1) {
                        dp[m][k] += get(m ^ (1 << i), k - i);
                        dp[m][k] += get(m ^ (1 << i), k + i);
                    }
                }
                was[m][k] = true;
                return dp[m][k];
            }
        }
        Helper h = new Helper();
        int ans = 0;
        for (int m = 0; m < MAX_MASK; m++) {
            ans += h.get(m, n - 1);
        }

        return ans;
    }

    private static boolean reverseToSort(ArrayList<Integer> inputArray) {

        for (int i = 0; i < inputArray.size(); i++) {
            for (int j = i + 1; j <= inputArray.size(); j++) {
                ArrayList<Integer> middle = new ArrayList<>(),
                        result = new ArrayList<>();
                result.addAll(inputArray.subList(0, i));
                middle.addAll(inputArray.subList(i, j));
                Collections.reverse(middle);
                result.addAll(middle);
                result.addAll(inputArray.subList(j, inputArray.size()));

                boolean correct = true;

                for (int k = 1; k < result.size(); k++) {
                    if (result.get(k - 1) >= result.get(k)) {
                        correct = false;
                        break;
                    }
                }
                if (correct) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int concatenateNumbers(int a, int b) {
        return Integer.parseInt(String.valueOf((a) + String.valueOf(b)));
    }

    private static int largestNumber(int n) {

        int res = 0;

        for (int i = 0; i < n; i++) {
            res = res + 9 * (int) Math.pow(10, i);
        }

        return res;
    }

    private static int rightmostRoundNumber(int[] inputArray) {

        int ans = -1;
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] % 10 == 0) {
                ans = i;
            }
        }

        return ans;
    }

    private static String fareySequence(int n, int m) {

        class Fraction implements Comparable<Fraction> {
            int a, b;

            Fraction(int a, int b) {
                this.a = a;
                this.b = b;
            }


            boolean isReduced() {
                return gcd(a, b) == 1;
            }

            int gcd(int a, int b) {
                return a == 0 ? b : gcd(b % a, a);
            }

            public int compareTo(Fraction f) {
                if (a * f.b < b * f.a) {
                    return -1;
                } else {
                    return 1;
                }
            }

            public String toString() {
                return a + "/" + b;
            }
        }

        ArrayList<Fraction> fractions = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                Fraction f = new Fraction(j, i);
                if (f.isReduced()) {
                    fractions.add(f);
                }
            }
        }

        Collections.sort(fractions);
        return fractions.get(m - 1).toString();
    }

    String theFile(String version1, String version2) {

        int len1 = version1.length();
        int len2 = version2.length();
        int[][] maxLen = new int[len1 + 1][len2 + 1];
        boolean[][] take = new boolean[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (version1.charAt(i - 1) == version2.charAt(j - 1)) {
                    maxLen[i][j] = maxLen[i - 1][j - 1] + 1;
                    take[i][j] = true;
                } else {
                    maxLen[i][j] = Math.max(maxLen[i - 1][j], maxLen[i][j - 1]);
                }
            }
        }

        StringBuilder answer = new StringBuilder();
        int i = len1;
        int j = len2;
        while (i > 0 && j > 0) {
            if (take[i][j]) {
                i--;
                j--;
                answer.append(version1.charAt(i));
            } else {
                if (maxLen[i - 1][j] > maxLen[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }

        return answer.reverse().toString();
    }

    private static boolean passwordCheckRegExp(String inputString) {
        char[] ch = inputString.toCharArray();
        if (ch.length < 5)
            return false;
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        for (int i = 0; i < ch.length; i++) {
            if ('A' <= ch[i] && ch[i] <= 'Z')
                hasUpper = true;
            if ('a' <= ch[i] && ch[i] <= 'z')
                hasLower = true;
            if ('0' <= ch[i] && ch[i] <= '9')
                hasDigit = true;
        }
        return hasUpper && hasLower && hasDigit;
    }

    private static boolean boxesPacking(int[] length, int[] width, int[] height) {
        int n = length.length;
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
        for (int it = 0; it < n; it++) {
            for (int i = 0; i < n - 1; i++) {
                int volumeF = length[p[i]] * width[p[i]] * height[p[i]];
                int volumeS = length[p[i + 1]] * width[p[i + 1]] * height[p[i + 1]];
                if (volumeF > volumeS) {
                    int tmp = p[i];
                    p[i] = p[i + 1];
                    p[i + 1] = tmp;
                }
            }
        }
        boolean isCorrectSequence = true;
        for (int i = 0; i < n - 1; i++) {
            int pi = p[i];
            int pj = p[i + 1];
            boolean canSwap = false;
            canSwap |= (length[pi] < length[pj] &&
                    width[pi] < width[pj] &&
                    height[pi] < height[pj]);
            canSwap |= (length[pi] < length[pj] &&
                    width[pi] < height[pj] &&
                    height[pi] < width[pj]);
            canSwap |= (length[pi] < width[pj] &&
                    width[pi] < length[pj] &&
                    height[pi] < height[pj]);
            canSwap |= (length[pi] < width[pj] &&
                    width[pi] < height[pj] &&
                    height[pi] < length[pj]);
            canSwap |= (length[pi] < height[pj] &&
                    width[pi] < length[pj] &&
                    height[pi] < width[pj]);
            canSwap |= (length[pi] < height[pj] &&
                    width[pi] < width[pj] &&
                    height[pi] < length[pj]);
            isCorrectSequence &= canSwap;
        }
        return isCorrectSequence;
    }

    private static int rectanglesUnionArea(int[][] rectangles) {

        int res = 0;
        boolean[][] used = new boolean[50][50];

        for (int i = 0; i < 50; i++) {
            boolean[] line = new boolean[50];
            Arrays.fill(line, false);
            used[i] = line;
        }

        for (int i = 0; i < rectangles.length; i++) {
            for (int x = rectangles[i][0]; x < rectangles[i][2]; x++) {
                for (int y = rectangles[i][1]; y < rectangles[i][3]; y++) {
                    used[x][y] = true;
                }
            }
        }
        for (int x = 0; x < 50; x++) {
            for (int y = 0; y < 50; y++) {
                if (used[x][y]) {
                    res++;
                }
            }
        }
        return res;
    }

    private static void dfs(int u, boolean[][] matrix, boolean[] visited) {
        visited[u] = true;
        for (int v = 0; v < matrix[u].length; u++) {
            if (matrix[u][v])
                if (!visited[v])
                    dfs(v, matrix, visited);
        }
    }

    private static int bfsConnectedComponents(boolean[][] matrix) {
        int v = matrix.length;
        boolean[] visited = new boolean[v];
        //visited = [False for i in range(v)]
        int numCC = 0;
        for (int u = 0; u < v; u++) {
            if (!visited[u]) {
                visited[u] = true;
                numCC++;
                dfs(u, matrix, visited);
            }
        }
        return numCC;
    }

    private static int rangeBitCount(int a, int b) {

        int ans = 0;
        for (int i = a; i <= b; i++) {
            int t = i;
            while (t != 0) {
                ans += t & 1;
                t >>= 1;
            }
        }

        return ans;
    }

    private static boolean isCorrectSentence(String inputString) {
        if ('A' <= inputString.charAt(0) && 'Z' >= inputString.charAt(0) && inputString.charAt(inputString.length() - 1) == '.')
            return true;
        return false;

    }

    private static int[] mergeSort(int[] sequence) {
        class Helper {
            void merge(int[] sequence, int left, int middle, int right) {

                int[] result = new int[right - left];
                int i, j;
                int k = 0;

                for (i = left, j = middle; i < middle && j < right; ) {
                    if (sequence[i] < sequence[j]) {
                        result[k++] = sequence[i];
                        i++;
                    } else {
                        result[k++] = sequence[j];
                        j++;
                    }
                }

                while (i < middle) {
                    result[k++] = sequence[i];
                    i++;
                }

                while (j < right) {
                    result[k++] = sequence[j];
                    j++;
                }

                for (i = left; i < right; i++) {
                    sequence[i] = result[i - left];
                }
            }

            void split(int[] sequence, int left, int right) {

                int middle = (left + right) / 2;

                if (left + 1 == right) {
                    return;
                }
                Arrays.sort(sequence);
                merge(sequence, left, middle, right);
            }
        }
        Helper h = new Helper();

        h.split(sequence, 0, sequence.length);

        return sequence;
    }

    private static int segmentsIntersection(int[] left, int[] right) {

        class Pair implements Comparable<Pair> {
            int first;
            int second;

            Pair(int first, int second) {
                this.first = first;
                this.second = second;
            }

            @Override
            public int compareTo(Pair p) {
                return first != p.first ? Integer.compare(first, p.first) :
                        Integer.compare(second, p.second);
            }
        }

        int answer = 0;
        int opened = 0;
        ArrayList<Pair> events = new ArrayList<>();

        for (int i = 0; i < left.length; i++) {
            events.add(new Pair(left[i], 1));
            events.add(new Pair(right[i], -1));
        }

        Collections.sort(events);

        for (int i = 0; i < events.size(); i++) {
            if (opened == left.length) {
                answer += events.get(i).first - events.get(i - 1).first;
            }
            opened += events.get(i).second;
        }

        return answer;
    }

    private static int niceFractions2(int n) {
        int res = 0;
        for (int i = 0; i * n < (int) 1e5; i++) {
            boolean[] digits = new boolean[10];
            int a = i * n;
            int b = i;
            boolean isNice = true;
            for (int j = 0; j < 5; j++) {
                digits[a % 10] = true;
                a /= 10;
                digits[b % 10] = true;
                b /= 10;
            }
            for (int j = 0; j < 10; j++) {
                if (!digits[j]) {
                    isNice = false;
                    break;
                }
            }
            if (isNice) {
                res++;
            }
        }
        return res;
    }

    private static int equidistantTriples(int[] coordinates) {
        Arrays.sort(coordinates);
        int res = 0;
        for (int i = 0; i < coordinates.length; i++) {
            for (int j = i + 1; j < coordinates.length; j++) {
                for (int k = j + 1; k < coordinates.length; k++) {
                    if (coordinates[k] + coordinates[i] == 2 * coordinates[j])
                        res++;
                }
            }
        }

        return res;

    }

    private static int houseNumbersSum(int[] inputArray) {

        int numberSum = 0,
                i = 0,
                x;
        do {
            x = inputArray[i++];
            numberSum += x;
        } while (x != 0);
        return numberSum;
    }

    private static int numberOfOperations(int a, int b) {

        if (a < b) {
            int t = a;
            a = b;
            b = t;
        }
        if (a % b != 0) {
            return 0;
        }
        return 1 + numberOfOperations(a / b, b);
    }

    // modifies c to next permutation or returns null if such permutation does not exist
    private static int[] nextPermutation(int[] c) {
        // 1. finds the largest k, that c[k] < c[k+1]
        int first = getFirst(c);
        if (first == -1) return null; // no greater permutation
        // 2. find last index toSwap, that c[k] < c[toSwap]
        int toSwap = c.length - 1;
        while (c[first] >= (c[toSwap]))
            --toSwap;
        // 3. swap elements with indexes first and last
        swap(c, first++, toSwap);
        // 4. reverse sequence from k+1 to n (inclusive)
        toSwap = c.length - 1;
        while (first < toSwap)
            swap(c, first++, toSwap--);
        return c;
    }

    // finds the largest k, that c[k] < c[k+1]
    // if no such k exists (there is not greater permutation), return -1
    private static int getFirst(int[] c) {
        for (int i = c.length - 2; i >= 0; --i)
            if (c[i] < (c[i + 1]))
                return i;
        return -1;
    }

    // swaps two elements (with indexes i and j) in array
    private static void swap(int[] c, final int i, final int j) {
        int tmp = c[i];
        c[i] = c[j];
        c[j] = tmp;
    }

    private static int multisetPermutations(int[] multiset) {
        Arrays.sort(multiset);
        int[] firstArray = new int[multiset.length];
        for (int i = multiset.length - 1; i >= 0; i--)
            firstArray[firstArray.length - i - 1] = multiset[i];
        int c = 0;
        do {
            c++;
        } while (!Arrays.equals(nextPermutation(multiset), firstArray));
        return c;
    }

    private static ArrayList<Integer> largestSubsequence(int[] sequence) {
        ArrayList<Integer>[] subsequences = new ArrayList[18];
        int indexLongest = 17;
        for (int i = 0; i < 18; i++) {
            subsequences[i] = new ArrayList<>();
        }
        for (int i = 0; i < sequence.length; i++) {
            int sum = sequence[i] % 10;
            int value = sequence[i];
            while (value > 9) {
                value /= 10;
            }
            sum += value;
            subsequences[sum - 1].add(sequence[i]);
        }
        for (int i = 16; i >= 0; i--) {
            if (subsequences[i].size() > subsequences[indexLongest].size()) {
                indexLongest = i;
            }
        }
        return subsequences[indexLongest];
    }

    private static int[] partialSort(int[] input, int k) {
        int[] answer = new int[input.length];
        int m = 0;
        int infinity = (int) 1e9;

        for (int i = 0; i < k; i++) {
            int index = 0;
            for (int j = 0; j < input.length; j++) {
                if (input[j] < input[index]) {
                    index = j;
                }
            }
            answer[m++] = input[index];
            input[index] = infinity;
        }
        for (int i = 0; i < input.length; i++) {
            if (input[i] != infinity) {
                answer[m++] = input[i];
            }
        }

        return answer;
    }

    private static String strangeCode(int s, int e) {
        char prevSymb = '-';
        String res = "";

        while (s < e - 1) {
            s++;
            e--;
            if (prevSymb == '-') {
                prevSymb = 'a';
                res += String.valueOf(prevSymb);
            } else {
                prevSymb = prevSymb == 'a' ? 'b' : 'a';
                res += String.valueOf(prevSymb);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        // System.out.println(amicableNumbers(1));
        // System.out.println(amicableNumbers(200));
        // System.out.println(amicableNumbers(221));
        // System.out.println(reverseBits(1));
        /*ArrayList<Integer> input = new ArrayList<>();
        input.add(-1);
        input.add(5);
        input.add(4);
        input.add(3);
        input.add(2);
        input.add(8);
        System.out.println(reverseToSort(input));*/
        // System.out.println(multisetPermutations(new int[]{2, 2, 1}));
        System.out.println(strangeCode(4, 8));
    }

}
