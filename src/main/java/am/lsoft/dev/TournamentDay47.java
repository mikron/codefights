package am.lsoft.dev;

import java.util.*;

/**
 * Created by Davit on 29/07/16.
 */
public class TournamentDay47 {

    private static int arrayMinimumAboveBound(int[] inputArray, int bound) {

        int best = -1;
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] > bound &&
                    (best == -1 || inputArray[i] < best)) {
                best = inputArray[i];
            }
        }

        return best;
    }

    private static int sumOfDivisors(int n) {
        int result = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                result += i;
            }
        }

        return result;
    }

    private static boolean isPermutation(int n, int[] inputArray) {

        int[] countOccurences = new int[n];

        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] - 1 < 0 || inputArray[i] - 1 >= n) {
                return false;
            }
            countOccurences[inputArray[i] - 1]++;
        }

        for (int i = 0; i < n; i++) {
            if (countOccurences[i] != 1) {
                return false;
            }
        }
        return true;
    }

    private static int arrayMaximalAdjacentDifference(int[] inputArray) {

        int answer = 0;
        for (int i = 1; i < inputArray.length; i++) {
            if (Math.abs(inputArray[i] - inputArray[i - 1]) > answer) {
                answer = Math.abs(inputArray[i] - inputArray[i - 1]);
            }
        }
        return answer;
    }

    private static int countTriangles(int[] X, int[] Y) {

        int result = 0;
        for (int i = 0; i < X.length; i++) {
            for (int j = i + 1; j < X.length; j++) {
                for (int k = j + 1; k < X.length; k++) {
                    int doubleArea = (X[i] - X[j]) * (Y[i] - Y[k])
                            - (X[i] - X[k]) * (Y[i] - Y[j]);
                    if (doubleArea != 0) {
                        result++;
                    }
                }
            }
        }
        return result;
    }

    private static int[] switchLights(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1) {
                for (int j = 0; j <= i; j++) {
                    a[j] = 1 - a[j];
                }
            }
        }
        return a;
    }

    private static int bitCount(int n) {
        int answer = 0;
        while (n > 0) {
            if ((n & 1) != 0) {
                answer++;
            }
            n >>= 1;
        }
        return answer;
    }

    private static int absoluteValuesSumMinimization(int[] A) {
        return A[A.length / 2 - (A.length % 2 == 0 ? 1 : 0)];
    }

    private static String[] textJustification(String[] words, int L) {

        ArrayList<String> text = new ArrayList<>();
        int currentWord = 0;

        while (currentWord < words.length) {
            int left = currentWord;
            int right = left;
            int currentSum = words[left].length();

            while (right + 1 < words.length && currentSum + words[right + 1].length() + 1 <= L) {
                currentSum += words[right + 1].length() + 1;
                right++;
            }

            if (left == right) {
                String line = words[left];
                for (int i = 0; i < L - words[left].length(); i++) {
                    line += " ";
                }
                text.add(line);
            } else {
                int freeSpace = L - currentSum;
                int minimalSpaceLen = 1 + freeSpace / (right - left);
                int extraSpaces = freeSpace % (right - left);
                String minimalSpace = "";
                for (int i = 0; i < minimalSpaceLen; i++) {
                    minimalSpace += " ";
                }

                String line = "";
                for (int i = left; i < right; i++) {
                    line += words[i] + minimalSpace;
                    if (extraSpaces > 0) {
                        line += " ";
                        extraSpaces--;
                    }
                }

                text.add(line + words[right]);
            }
            currentWord = right + 1;
        }

        return text.toArray(new String[text.size()]);
    }

    private static int subsetForArithmeticProgression(int[] inputArray) {

        int result = 1;

        for (int i = 0; i < inputArray.length; i++) {
            for (int j = i + 1; j < inputArray.length; j++) {
                int dif = Math.abs(inputArray[i] - inputArray[j]);
                for (int divisor = 1; divisor * divisor <= dif; divisor++) {
                    if (dif % divisor == 0) {
                        int cnt = 0;
                        int pair_divisor = dif / divisor;

                        if (divisor > 1) {
                            for (int k = 0; k < inputArray.length; k++) {
                                if (Math.abs(inputArray[i] - inputArray[k]) % divisor == 0) {
                                    cnt++;
                                }
                            }
                            result = Math.max(result, cnt);
                        }

                        cnt = 0;
                        if (pair_divisor > 1) {
                            for (int k = 0; k < inputArray.length; k++) {
                                if (Math.abs(inputArray[i] - inputArray[k]) % pair_divisor == 0) {
                                    cnt++;
                                }
                            }
                            result = Math.max(result, cnt);
                        }
                    }
                }
            }
        }

        return result;
    }

    private static boolean isUnstablePair(String filename1, String filename2) {

        class Helper {
            boolean compare(String filename1, String filename2) {
                int len = Math.min(filename1.length(), filename2.length());
                for (int i = 0; i < len; i++) {
                    if (filename1.charAt(i) < filename2.charAt(i)) {
                        return true;
                    }
                    if (filename2.charAt(i) < filename1.charAt(i)) {
                        return false;
                    }
                }
                if (filename1.length() < filename2.length()) {
                    return true;
                }
                return false;
            }

            String toLowercase(String filename) {
                String lowercased = "";
                for (int i = 0; i < filename.length(); i++) {
                    if ('A' <= filename.charAt(i) && filename.charAt(i) <= 'Z') {
                        lowercased += (char) ((int) filename.charAt(i) - (int) 'A' + (int) 'a');
                    } else {
                        lowercased += filename.charAt(i);
                    }
                }
                return lowercased;
            }
        }

        Helper h = new Helper();
        boolean firstComparison = h.compare(filename1, filename2);
        filename1 = h.toLowercase(filename1);
        filename2 = h.toLowercase(filename2);

        return firstComparison ^ h.compare(filename1, filename2);
    }

    private static String concatenationProcess(String[] init) {

        List<String> vector = new ArrayList<>(Arrays.asList(init));

        while (vector.size() > 1) {
            int minInd1 = 0,
                    minInd2 = vector.size() - 1;

            for (int i = 1; i < vector.size(); i++) {
                if (vector.get(i).length() < vector.get(minInd1).length()) {
                    minInd1 = i;
                }
            }

            if (minInd2 == minInd1) {
                minInd2--;
            }

            for (int i = vector.size() - 2; i >= 0; i--) {
                if (vector.get(i).length() < vector.get(minInd2).length()
                        && i != minInd1) {
                    minInd2 = i;
                }
            }

            vector.add(vector.get(minInd1) + vector.get(minInd2));
            vector.remove(vector.get(Math.max(minInd1, minInd2)));
            vector.remove(vector.get(Math.min(minInd1, minInd2)));
        }

        return vector.get(0);
    }

    private static String pawnRace(String white, String black, char toMove) {
        int wHor = white.charAt(1) - '0';
        int wVert = white.charAt(0) - 'a';
        int bHor = black.charAt(1) - '0';
        int bVert = black.charAt(0) - 'a';
        if (wVert == bVert && wHor < bHor) {
            return "draw";
        }
        if (Math.abs(wVert - bVert) != 1 || wHor >= bHor) {
            int wRest = Math.min(8 - wHor, 5);
            int bRest = 8 - bHor; // ... ???
            if (wRest < bRest || wRest == bRest && toMove == 'w') {
                return "white";
            }
            return "black";
        }
        int[][] winningPairs = {{2, 5}, {2, 6}, {3, 6}, {4, 7}};
        if (toMove == 'w') {
            for (int i = 0; i < 4; i++) {
                if (wHor == winningPairs[i][0] && bHor == winningPairs[i][1]) {
                    return "white";
                }
            }
            if (wHor + 1 == bHor) {
                return "white";
            }
            return "black";
        } else {
            for (int i = 0; i < 4; i++) {
                if (wHor == 9 - winningPairs[i][1] && bHor == 9 - winningPairs[i][0]) {
                    return "black";
                }
            }
            if (wHor + 1 == bHor) {
                return "black";
            }
            return "white";
        }
    }

    private static int fact(int n) {
        if (n == 0)
            return 1;
        return fact(n - 1) * n;
    }

    private static boolean checkFactorial(int n) {
        for (int i = 0; i < n; i++)
            if (n == fact(i))
                return true;
        return false;
    }

    private static int treeLCA(int[] parent, int v1, int v2) {
        HashSet<Integer> S = new HashSet<>();
        while (v1 != 0) {
            S.add(v1);
            v1 = parent[v1];
        }
        while (v2 != 0) {
            if (S.contains(v2)) {
                return v2;
            }
            v2 = parent[v2];
        }
        return 0;
    }

    private static int secretCode(final boolean[] a) {

        class Helper {

            int combCnt = 0;
            boolean[] used = new boolean[10];

            void calcCombinations(int curIndex) {

                int needToPlace = 0;
                for (int i = 0; i < 10; i++) {
                    if (a[i] && !used[i]) {
                        needToPlace++;
                    }
                }
                if (needToPlace > 8 - curIndex) {
                    return;
                }
                if (curIndex == 8) {
                    combCnt++;
                    return;
                }

                int first = curIndex == 0 ? 1 : 0;
                for (int i = first; i < 10; i++) {
                    if (a[i]) {
                        boolean old = used[i];
                        used[i] = true;
                        calcCombinations(curIndex + 1);
                        used[i] = old;
                    }
                }
            }
        }
        Helper h = new Helper();
        h.calcCombinations(0);
        return h.combCnt;
    }

    private static boolean shareAnApple(int a, int b) {
        if (--a == ++b) {
            return true;
        }
        return false;
    }

    private static int firstNotDivisible(int[] divisors, int start) {
        int l = divisors.length;
        int i;

        while (true) {
            for (i = 0; i < l; i++) {
                if (start % divisors[i] == 0) break;
            }
            if (i == l) return start;
            else start++;
        }
    }

    private static int largestDistance(int[] A) {

        int[] mx = new int[]{A[0], A[1]};
        int[] mn = new int[]{A[0], A[1]};
        for (int i = 0; i < A.length; i++) {
            int k = i % 2;
            if (A[i] > mx[k]) {
                mx[k] = A[i];
            } else if (A[i] < mn[k]) {
                mn[k] = A[i];
            }
        }
        return Math.max(mx[0] - mn[0], mx[1] - mn[1]);
    }

    private static String smallestPalindrome(String s0) {

        char[] s = s0.toCharArray();

        int i = s.length / 2;
        while (i < s.length && s[i] == s[s.length - i - 1]) {
            i++;
        }
        if (i == s.length) {
            return s0;
        }

        if (s[i] < s[s.length - i - 1]) {
            while (i < s.length) {
                s[i] = s[s.length - i - 1];
                i++;
            }
            return String.valueOf(s);
        } else {
            i = (s.length - 1) / 2;
            while (s[i] == 'z') {
                i--;
            }
            s[i]++;
            i++;
            while (2 * i < s.length) {
                s[i] = 'a';
                i++;
            }
            while (i < s.length) {
                s[i] = s[s.length - i - 1];
                i++;
            }
            return String.valueOf(s);
        }
    }

    private static int segmentsUnion(int[] left, int[] right) {

        int ans = 0;
        ArrayList<int[]> evn = new ArrayList<>();
        int opened = 0;

        for (int i = 0; i < left.length; i++) {
            evn.add(new int[]{left[i], 1});
            evn.add(new int[]{right[i], -1});
        }

        evn.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                }

                if (a[1] != b[1]) {
                    return a[1] - b[1];
                }

                return 0;
            }
        });

        for (int i = 0; i < evn.size(); i++) {
            if (opened > 0) {
                ans += evn.get(i)[0] - evn.get(i - 1)[0];
            }

            opened += evn.get(i)[1];
        }

        return ans;
    }

    private static boolean dfsCheckTree(final boolean[][] matrix) {

        class Helper {

            int componentSize = 0;
            boolean cyclesFound = false;
            boolean[] visited;

            Helper() {
                visited = new boolean[matrix.length];
            }

            void dfs(int currentVertex, int parentVertex) {
                visited[currentVertex] = true;
                componentSize++;
                for (int nextVertex = 0; nextVertex < matrix.length; nextVertex++) {
                    if (matrix[currentVertex][nextVertex]
                            && nextVertex != parentVertex) {
                        if (!visited[nextVertex]) {
                            dfs(nextVertex, currentVertex);
                        } else {
                            cyclesFound = true;
                        }
                    }
                }
            }
        }
        Helper h = new Helper();

        h.dfs(0, -1);

        if (h.componentSize == matrix.length && !h.cyclesFound) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        // System.out.println(absoluteValuesSumMinimization(new int[]{2, 4, 7}));
        // System.out.println(absoluteValuesSumMinimization(new int[]{1, 1, 3, 4}));
        // System.out.println(absoluteValuesSumMinimization(new int[]{23}));
        /*System.out.println(Arrays.toString(textJustification(new String[]{"This",
                "is",
                "an",
                "example",
                "of",
                "text",
                "justification."}, 3)));*/
        // System.out.println(secretCode(new boolean[]{false, true, false, false, false, false, false, false, false, false}));
        // System.out.println(firstNotDivisible(new int[]{2, 3, 4}, 14));
        // System.out.println(segmentsUnion(new int[]{1, 2, 5}, new int[]{3, 4, 6}));
        System.out.println(dfsCheckTree(new boolean[][]{{false, true, false}, {true, false, false}, {false, false, false}}));
    }

}
