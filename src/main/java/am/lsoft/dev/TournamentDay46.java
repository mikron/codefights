package am.lsoft.dev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by Davit on 28/07/16.
 */
public class TournamentDay46 {

    private static int knightLikeChessPiece(int n, int m) {

        class Helper {
            void dfs(int x, int y, int a, int b,
                     int n, int m, boolean[][] visited) {
                if (x >= 0 && x < n && y >= 0 && y < m && !visited[x][y]) {
                    visited[x][y] = true;
                    dfs(x + a, y + b, a, b, n, m, visited);
                    dfs(x + b, y + a, a, b, n, m, visited);
                    dfs(x - a, y + b, a, b, n, m, visited);
                    dfs(x - b, y + a, a, b, n, m, visited);
                    dfs(x - a, y - b, a, b, n, m, visited);
                    dfs(x - b, y - a, a, b, n, m, visited);
                    dfs(x + a, y - b, a, b, n, m, visited);
                    dfs(x + b, y - a, a, b, n, m, visited);
                }
            }
        }
        ;

        Helper h = new Helper();

        int result = 0;
        for (int a = 1; a < Math.min(n, m); a++) {
            for (int b = a; b < Math.max(n, m); b++) {
                boolean[][] visited = new boolean[n][m];
                h.dfs(0, 0, a, b, n, m, visited);
                if (visited[n - 1][m - 1]) {
                    result++;
                }
            }
        }
        return result;
    }

    private static boolean latinLettersSearchRegExp(String input) {

        return java.util.regex.Pattern.compile("[A-Z||a-z]").matcher(input).find();
    }

    private static String findHeapPredicate(int[] heap) {

        boolean allGreater = true, allLess = true;
        for (int i = 0; 2 * i + 1 < heap.length; i++) {
            int sign1 = heap[i] - heap[2 * i + 1];
            int sign2 = 0;
            if (2 * i + 2 < heap.length) {
                sign2 = heap[i] - heap[2 * i + 2];
            }
            allGreater &= sign1 >= 0 && sign2 >= 0;
            allLess &= sign1 <= 0 && sign2 <= 0;
        }

        if (allGreater && allLess) {
            return "?";
        } else if (allGreater) {
            return ">=";
        } else if (allLess) {
            return "<=";
        } else {
            return "!";
        }
    }

    private static int dfsConnectedComponents(final boolean[][] matrix) {

        class Helper {
            void dfs(int currentVertex, boolean[] visited) {
                visited[currentVertex] = true;
                for (int i = 0; i < matrix[0].length; i++) {
                    if (!matrix[currentVertex][i] || visited[i])
                        continue;
                    dfs(i, visited);
                }
            }
        }
        Helper h = new Helper();

        boolean[] visited = new boolean[matrix.length];
        int componentsCount = 0;

        for (int startVertex = 0; startVertex < matrix.length; startVertex++) {
            if (!visited[startVertex]) {
                h.dfs(startVertex, visited);
                componentsCount++;
            }
        }

        return componentsCount;
    }

    private static int arrayChange(int[] inputArray) {
        int lastElem = inputArray[0];
        int step = 0;
        for (int i = 1; i < inputArray.length; i++) {
            while (lastElem >= inputArray[i]) {
                step++;
                inputArray[i]++;
            }
            lastElem = inputArray[i];
        }

        return step;
    }

    private static int arrayChange2(int[] inputArray) {
        int r = 0;
        for (int i = 1; i < inputArray.length; i++) {
            if (inputArray[i] <= inputArray[i - 1]) {
                r += inputArray[i - 1] - inputArray[i] + 1;
                inputArray[i] = inputArray[i - 1] + 1;
            }
        }
        return r;
    }

    private static int permutationShift(int[] permutation) {
        int minShift = 0,
                maxShift = 0;
        for (int i = 0; i < permutation.length; i++) {
            if (permutation[i] - i > maxShift) {
                maxShift = permutation[i] - i;
            }
            if (permutation[i] - i < minShift) {
                minShift = permutation[i] - i;
            }
        }
        return maxShift - minShift;
    }


    private static int[] alternatingSums(int[] a) {
        int team1 = 0,
                team2 = 0;
        for (int i = 0; i < a.length; i += 2) {
            team1 += a[i];
        }
        for (int i = 2; i < a.length; i += 2) {
            team2 += a[i];
        }
        int[] result = {team1, team2};
        return result;
    }

    private static int[][] create2DArray(int[] lengths) {

        int[][] result = new int[lengths.length][];

        for (int i = 0; i < lengths.length; i++) {
            result[i] = new int[lengths[i]];
            for (int j = 0; j < lengths[i]; j++) {
                result[i][j] = j;
            }
        }

        return result;
    }

    private static String removeAdjacent(String s) {

        if (s.equals("")) {
            return "";
        }

        StringBuilder ans = new StringBuilder();
        ans.append(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                ans.append(s.charAt(i));
            }
        }

        return ans.toString();
    }

    private static boolean palindromeRearranging(String inputString) {

        int[] count = new int[26];
        for (int i = 0; i < inputString.length(); i++) {
            count[inputString.charAt(i) - 'a']++;
        }

        int odds = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 == 1) {
                odds++;
            }
        }
        return odds % 2 == inputString.length() % 2 && odds < 2;
    }

    private static boolean isSumOfConsecutive(int n) {
        for (int start = 1; start < n; start++) {
            int number = n,
                    subtrahend = start;
            while (number > 0) {
                number -= subtrahend;
                subtrahend++;
            }
            if (number == 0) {
                return true;
            }
        }
        return false;
    }

    private static int maximumSum(int[] A, int[][] Q) {

        int[] sumCount = new int[A.length];
        for (int i = 0; i < Q.length; i++) {
            for (int j = Q[i][0]; j <= Q[i][1]; j++) {
                sumCount[j]++;
            }
        }
        Arrays.sort(A);
        Arrays.sort(sumCount);
        int answer = 0;
        for (int i = 0; i < A.length; i++) {
            answer += A[i] * sumCount[i];
        }

        return answer;
    }

    private static boolean parallelLines(int[] line1, int[] line2) {
        return line1[0] * line2[1] == line1[1] * line2[0];
    }

    private static boolean isPrime(int n) {
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2)
            if (n % i == 0)
                return false;
        return true;
    }

    private static int[] primeFactors2(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (n % i == 0)
                if (isPrime(i))
                    res.add(i);
        }
        return res.stream().mapToInt(i -> i).toArray();
    }


    private static boolean contains(double[][] points, int[] test) {
        int i;
        int j;
        boolean result = false;
        for (i = 0, j = points.length - 1; i < points.length; j = i++) {
            if ((points[i][1] > test[1]) != (points[j][1] > test[1]) &&
                    (test[0] < (points[j][0] - points[i][0]) * (test[1] - points[i][1]) / (points[j][1] - points[i][1])
                            + points[i][0])) {
                result = !result;
            }
        }
        return result;
    }

    private static int rectangleRotation(int a, int b) {
        double c = Math.sqrt(a * a + b * b);
        double alpha = Math.asin(a / c);
        double betta = 90 - alpha;
        double x1 = Math.sin(betta) * c / 2;
        double y1 = Math.cos(betta) * c / 2;

        double[][] points = new double[4][2];
        points[2][0] = x1;
        points[2][1] = y1;

        points[1][0] = y1;
        points[1][1] = x1;

        points[3][0] = -y1;
        points[3][1] = -x1;

        points[0][0] = -x1;
        points[0][1] = -y1;

        int ans = 0;
        for (int i = -a * b; i < a * b; i++)
            for (int j = -a * b; j < a * b; j++)
                if (contains(points, new int[]{i, j}))
                    ans++;

        return ans;
    }

    private static int rectangleRotation2(int a, int b) {
        double c = 1.414;
        a = (int) (a / c);
        b = (int) (b / c);
        c = ~(a ^ b) & 1;
        return (int) (2 * a * b + a + b + c);
    }

    private static boolean isInformationConsistent(int[][] evidences) {

        for (int j = 0; j < evidences[0].length; j++) {
            boolean innocent = false,
                    guilty = false;
            for (int i = 0; i < evidences.length; i++) {
                switch (evidences[i][j]) {
                    case -1:
                        innocent = true;
                        break;
                    case 1:
                        guilty = true;
                        break;
                }
            }

            if (innocent && guilty) {
                return false;
            }
        }

        return true;
    }

    // http://www.geeksforgeeks.org/a-pancake-sorting-question/
    private static boolean reverseToSort(int[] inputArray) {
        return true;
    }

    private static ArrayList<String> generatePalindromes(String charactersSet) {

        class Helper {
            int N;
            char[] palindrome;
            int[] letterCnt;
            ArrayList<String> result = new ArrayList<>();

            Helper(String charactersSet) {
                N = charactersSet.length();
                palindrome = new char[N];
                letterCnt = new int[26];
                for (int i = 0; i < N; i++) {
                    letterCnt[charactersSet.charAt(i) - 'a']++;
                }
                if (N % 2 == 1) {
                    for (int i = 0; i < 26; i++) {
                        if (letterCnt[i] % 2 == 1) {
                            letterCnt[i]--;
                            palindrome[N / 2] = (char) ('a' + i);
                            break;
                        }
                    }
                }
            }

            void generate(int idx) {
                if (idx >= (N) / 2) {
                    result.add(new String(palindrome));
                    return;
                }
                for (int i = 0; i < 26; i++) {
                    if (letterCnt[i] >= 2) {
                        letterCnt[i] -= 2;
                        palindrome[idx] = (char) ('a' + i);
                        palindrome[N - idx - 1] = (char) ('a' + i);
                        generate(idx + 1);
                        letterCnt[i] += 2;
                    }
                }
            }
        }
        Helper h = new Helper(charactersSet);

        h.generate(0);
        return h.result;
    }

    private static int specificSum(int p, int q) {
        int result = 0;
        int apbqValue = 1;
        int lastIncorrect = -1;

        if (p < q) {
            int tmp = p;
            p = q;
            q = tmp;
        }

        while (apbqValue - lastIncorrect <= q) {
            int a = 0;
            boolean correct = false;
            while (a * p <= apbqValue) {
                if ((apbqValue - a * p) % q == 0) {
                    correct = true;
                    break;
                }
                a++;
            }
            if (!correct) {
                result += apbqValue;
                lastIncorrect = apbqValue;
            }
            apbqValue++;
        }

        return result;
    }

    private static int sumUpNumbers(String inputString) {

        int answer = 0,
                currentNumber = 0;

        for (int i = 0; i < inputString.length(); i++) {
            if ('0' <= inputString.charAt(i) && inputString.charAt(i) <= '9') {
                currentNumber = currentNumber * 10 + inputString.charAt(i) - '0';
            } else {
                answer += currentNumber;
                currentNumber = 0;
            }
        }
        answer += currentNumber;

        return answer;
    }

    private static int binaryPower(int n, int k) {

        if (k == 0) {
            return 1;
        }
        if (k % 2 == 0) {
            return (int) Math.pow(n, k);
        }
        return binaryPower(n, k - 1) * n;
    }

    private static String replaceAllDigitsRegExp(String input) {
        return input.replaceAll("\\d", "#");
    }

    private static int countTowers(int n, int m, int height) {

        int[][] dp = new int[height][1 << n * m];
        int result = 0;

        for (int i = 0; i < (1 << n * m); i++) {
            dp[0][i] = 1;
        }

        for (int i = 0; i < height - 1; i++) {
            for (int j = 0; j < (1 << n * m); j++) {
                for (int k = 0; k < (1 << n * m); k++) {
                    if ((j | k) == j) {
                        dp[i + 1][k] += dp[i][j];
                    }
                }
            }
        }

        for (int i = 1; i < (1 << n * m); i++) {
            result += dp[height - 1][i];
        }
        return result;
    }

    private static int countPathsThroughCell(int n, int m, int x, int y) {
  /*
   * Array dp is used to store dynamic programming values.
   */
        int[][] dp = new int[n + 1][m + 1];

        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i + 1][j] += dp[i][j];
                dp[i][j + 1] += dp[i][j];
            }
        }

        return dp[x][y] * dp[n - 1 - x][m - 1 - y];
    }

    private static String swapCase(String text) {

        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isUpperCase(c)) {
                chars[i] = Character.toLowerCase(c);
            } else if (Character.isLowerCase(c))
                chars[i] = Character.toUpperCase(c);
        }

        return new String(chars);

    }

    private static ArrayList<Integer> splitByValue(int k,
                                                   ArrayList<Integer> elements) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i) < k) {
                result.add(elements.get(i));
            }
        }
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i) >= k) {
                result.add(elements.get(i));
            }
        }
        return result;
    }

    private static ArrayList<Integer> domainAuction(String[] websites) {
        ArrayList<String> domains = new ArrayList<>();
        HashMap<String, Integer> domainCount = new HashMap<>();
        for (String website : websites) {
            int i = 0;
            while (!website.substring(i, i + 3).equals("://")) {
                i++;
            }
            i += 3;
            while (i < website.length() && website.charAt(i) != '/') {
                i++;
            }
            int j = i - 1;
            int cnt = 0;
            while (website.charAt(j) != '/') {
                cnt += website.charAt(j) == '.' ? 1 : 0;
                if (cnt == 2) {
                    break;
                }
                j--;
            }
            String domain = website.substring(j + 1, i);
            domains.add(domain);
            if (!domainCount.containsKey(domain)) {
                domainCount.put(domain, 0);
            }
            domainCount.put(domain, domainCount.get(domain) + 1);
        }
        ArrayList<Integer> counts = new ArrayList<>();
        for (String domain : domains) {
            counts.add(domainCount.get(domain));
        }
        return counts;
    }

    private static int[] verticesDegrees(boolean[][] matrix) {
        int[] ans = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                ans[i] += matrix[i][j] ? 1 : 0;

        return ans;
    }

    private static boolean lucky(int s, int n) {
        int result = 0;
        int size = 0;
        while (n != 0) {
            int digit = n % 10;
            size++;
            if (size <= s / 2)
                result += digit;
            else
                result -= digit;
            n /= 10;
        }
        return result == 0;
    }

    private static int countLuckyNumbers(int n) {
        int ans = 0;
        for (int i = (int) Math.pow(10, n - 1); i <= (int) Math.pow(10, n) - 1; i++)
            if (lucky(n, i))
                ans++;
        return ans;
    }

    private static int countWays(int n, int k) {

        ArrayList<ArrayList<Integer>> c_nk = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            c_nk.add(new ArrayList<Integer>());
            for (int j = 0; j <= k; j++) {
                c_nk.get(i).add(0);
            }
        }
        c_nk.get(0).set(0, 1);
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> cur = c_nk.get(i);
            ArrayList<Integer> next = c_nk.get(i + 1);
            for (int j = 0; j <= k; j++) {
                if (i + 1 <= n) {
                    next.set(j, next.get(j) + cur.get(j));
                    if (j + 1 <= k) {
                        next.set(j + 1, next.get(j + 1) + cur.get(j));
                    }
                }
            }
        }

        return c_nk.get(c_nk.size() - 1).get(c_nk.get(c_nk.size() - 1).size() - 1);
    }

    private static int[] mergeKArrays(int[][] arrays) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++)
                arr.add(arrays[i][j]);
        }
        Collections.sort(arr);
        return arr.stream().mapToInt(i -> i).toArray();
    }


    public static void main(String[] args) {
        // System.out.println(knightLikeChessPiece(3, 3));
        // System.out.println(knightLikeChessPiece(7, 2));
        // System.out.println(findHeapPredicate(new int[]{-2, -2, -2, -2, -2}));
        // System.out.println(arrayChange(new int[]{1, 1, 1}));
        // System.out.println(palindromeRearranging("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaabc"));
        // System.out.println(parallelLines(new int[]{1, -1, 0}, new int[]{1, 1, 0}));
        // System.out.println(rectangleRotation2(6, 4));
        // System.out.println(isInformationConsistent(new int[][]{{ 0, 1, 0, 1}, {-1, 1, 0, 0}, {-1, 0, 0, 1}}));
        // System.out.println(isInformationConsistent(new int[][]{{1, -1, 0, 1}, {1, -1, 0, -1}}));
        // System.out.println(isInformationConsistent(new int[][]{{0, 0, -1}, {-1, 1, -1}, {-1, 1, 0}, {0, 1, 0}}));
        // System.out.println(generatePalindromes("ababb"));
        // System.out.println(countTowers(2, 1, 2));
        // System.out.println(countTowers(2, 5, 1));
        /*System.out.println(domainAuction(new String[]{"http://codefights.com",
                "https://uk.domainmaster.com",
                "https://uk.domainmaster.com/websites/website-builder",
                "https://in.domainmaster.com"}));*/
        // System.out.println(Arrays.toString(verticesDegrees(new boolean[][]{{false, true, true}, {true, true, true}, {true, true, false}})));
        // System.out.println(countLuckyNumbers(2));
        System.out.println(countWays(5, 2));
    }

}
