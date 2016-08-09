package am.lsoft.dev;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Davit on 08/08/16.
 */
public class TournamentDay55 {

    private static int[] cutArray(int[] a, int idx) {
        int[] res = new int[a.length - idx];
        int j = 0;
        for (int i = idx; i < a.length; i++) {
            res[j] = a[i];
            j++;
        }
        return res;

    }

    private static int fndMx(int[] a, int[] b, int r) {
        if (a.length == 0 || b.length == 0) {
            if (a.length == 0)
                return r;
            return Integer.MAX_VALUE;
        }

        int f = fndMx(a, cutArray(b, 1), r);
        int s = fndMx(cutArray(a, 1), cutArray(b, 1), r + Math.abs(a[0] - b[0]));
        return Math.min(f, s);
    }

    private static int closestSequence(int[] a, int[] b) {
        return fndMx(a, b, 0);

    }

    private static boolean isMAC48Address(String inputString) {

        for (int i = 0; i < inputString.length(); i++) {
            if (i % 3 == 2) {
                if (inputString.charAt(i) != '-') {
                    return false;
                }
            } else {
                char sym = inputString.charAt(i);
                if (!('0' <= sym && sym <= '9' || 'A' <= sym && sym <= 'F')) {
                    return false;
                }
            }
        }

        return inputString.length() == 17;
    }

    private static String findEmailDomain(String address) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            if (i > address.lastIndexOf('@'))
                result.append(address.charAt(i));
        }
        return result.toString();
    }

    private static int[] theJanitor(String word) {
        int[] arr = new int[26];
        ArrayList<Character> newArr = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            if (newArr.indexOf(word.charAt(i)) == -1)
                newArr.add(word.charAt(i));
        }


        for (Character aNewArr : newArr) {
            int tmp = aNewArr - 'a';
            arr[tmp] = word.lastIndexOf(aNewArr) - word.indexOf(aNewArr) + 1;
        }

        return arr;
    }

    private static int trapRooms(final char[][] museum) {
        int trapsNumber = 0;

        class Helper {
            boolean[][] visited;
            boolean[][] answer;
            int componentSize;

            Helper(int h, int w) {
                visited = new boolean[h][];
                answer = new boolean[h][];
                for (int i = 0; i < h; i++) {
                    visited[i] = new boolean[w];
                    answer[i] = new boolean[w];
                }
            }

            boolean dfs(int x, int y) {
                if (x < 0 || x >= museum.length ||
                        y < 0 || y >= museum[0].length) {
                    return true;
                }
                if (visited[x][y]) {
                    return answer[x][y];
                }
                visited[x][y] = true;
                componentSize++;
                switch (museum[x][y]) {
                    case 'L':
                        answer[x][y] = dfs(x, y - 1);
                        break;
                    case 'U':
                        answer[x][y] = dfs(x - 1, y);
                        break;
                    case 'R':
                        answer[x][y] = dfs(x, y + 1);
                        break;
                    case 'D':
                        answer[x][y] = dfs(x + 1, y);
                        break;
                }
                return answer[x][y];
            }
        }
        ;

        Helper h = new Helper(museum.length, museum[0].length);

        for (int i = 0; i < museum.length; i++) {
            for (int j = 0; j < museum[0].length; j++) {
                if (!h.visited[i][j]) {
                    h.componentSize = 0;
                    if (!h.dfs(i, j)) {
                        trapsNumber += h.componentSize;
                    }
                }
            }
        }

        return trapsNumber;
    }

    private static int dotProduct(int[] v1, int[] v2) {
        int res = 0;
        for (int i = 0; i < v1.length; i++) {
            res += v1[i] * v2[i];
        }

        return res;

    }

    private static int constructSquare(String s) {

        int[] letterCnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            letterCnt[s.charAt(i) - 'a']++;
        }
        Arrays.sort(letterCnt);

        int best = -1;
        int minNumber = (int) Math.pow(10, s.length() - 1);
        for (int k = (int) Math.sqrt(minNumber); k * k < 10 * minNumber; k++) {
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

    private static int levenshteinDistance(String string1, String string2) {

        int len1 = string1.length();
        int len2 = string2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (string1.charAt(i - 1) == string2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                    continue;
                }
                dp[i][j] = 1 + Math.min(dp[i - 1][j - 1],
                        Math.min(dp[i][j - 1], dp[i - 1][j]));
            }
        }

        return dp[len1][len2];
    }

    private static int josephusProblem(int n, int k) {

        boolean[] removed = new boolean[n];
        int currentPerson = 0;

        for (int i = 1; i < n; i++) {
            int skipped = 0;
            while (skipped < k - 1) {
                if (!removed[currentPerson]) {
                    skipped++;
                }
                currentPerson = (currentPerson + 1) % n;
            }
            while (removed[currentPerson]) {
                currentPerson = (currentPerson + 1) % n;
            }
            removed[currentPerson] = true;
        }

        for (int i = 0; i < n; i++) {
            if (!removed[i]) {
                return i + 1;
            }
        }
        return 0;
    }

    private static String mySubstring(String inputString, int l, int r) {
        return inputString.substring(l, r + 1);
    }

    private static int polygonPerimeter(boolean[][] matrix) {
        int perimeter = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i - 1 < 0 && matrix[i][j]) {
                    perimeter++;
                }
                if (i + 1 == matrix.length && matrix[i][j]) {
                    perimeter++;
                }
                if (j - 1 < 0 && matrix[i][j]) {
                    perimeter++;
                }
                if (j + 1 == matrix[0].length && matrix[i][j]) {
                    perimeter++;
                }
                if (matrix[i][j] && 0 <= i - 1) {
                    if (!matrix[i - 1][j]) {
                        perimeter++;
                    }
                }
                if (matrix[i][j] && i + 1 < matrix.length) {
                    if (!matrix[i + 1][j]) {
                        perimeter++;
                    }
                }
                if (matrix[i][j] && 0 <= j - 1) {
                    if (!matrix[i][j - 1]) {
                        perimeter++;
                    }
                }
                if (matrix[i][j] && j + 1 < matrix[0].length) {
                    if (!matrix[i][j + 1]) {
                        perimeter++;
                    }
                }
            }
        }
        return perimeter;
    }

    private static String lineEncoding(String s) {

        s += "#";
        int cnt = 1;
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                cnt++;
            } else {
                if (cnt > 1) {
                    result.append(cnt);
                }
                cnt = 1;
                result.append(s.charAt(i - 1));
            }
        }

        return result.toString();
    }

    private static String wordSubtraction(String a, String b) {
        int[] countLetters = new int[26];
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            countLetters[i] = 0;
        }
        for (int i = 0; i < a.length(); i++) {
            countLetters[(int) a.charAt(i) - (int) 'a']++;
        }
        for (int i = 0; i < b.length(); i++) {
            countLetters[(int) b.charAt(i) - (int) 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (countLetters[i] < 0) {
                countLetters[i] += 2;
                countLetters[i + 1]--;
            }
            if (countLetters[i] == 1) {
                result.append((char) (i + 'a'));
            }
        }
        return result.toString();
    }

    private static int sameElementsNaive(int[] a, int[] b) {
        int ans = 0;
        for (int ai : a)
            for (int bi : b)
                if (ai == bi)
                    ans++;
        return ans;

    }

    private static String insertDashes(String inputString) {
        String[] words = inputString.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = "-" + String.join("-", words[i].split("")) + "-";
            if (words[i].length() > 2) {
                words[i] = words[i].substring(1, words[i].length() - 1);
            }
        }
        String ans = "";
        for (int i = 0; i < words.length - 1; i++) {
            ans += words[i] + " ";
        }
        return ans + words[words.length - 1];
    }

    private static String[] sortByLength(String[] inputArray) {

        for (int i = 0; i < inputArray.length; i++) {
            int minIndex = i;
            String tmp = inputArray[i];
            for (int j = i + 1; j < inputArray.length; j++) {
                if (inputArray[j].length() < inputArray[minIndex].length()) {
                    minIndex = j;
                }
            }
            inputArray[i] = inputArray[minIndex];
            inputArray[minIndex] = tmp;
        }

        return inputArray;
    }

    private static int[] dijkstraDistances(int[][] matrix, int startVertex) {

        boolean[] used = new boolean[matrix.length];
        int[] distance = new int[matrix.length];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[startVertex] = 0;

        for (int i = 0; i < matrix.length; i++) {
            int chosenIndex = -1;
            for (int j = 0; j < matrix.length; j++) {
                if (!used[j] && (chosenIndex == -1 ||
                        distance[chosenIndex] > distance[j])) {
                    chosenIndex = j;
                }
            }
            used[chosenIndex] = true;
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[chosenIndex][j] != -1 &&
                        distance[j] > distance[chosenIndex] + matrix[chosenIndex][j]) {
                    distance[j] = distance[chosenIndex] + matrix[chosenIndex][j];
                }
            }
        }

        return distance;
    }

    private static int thueMorseSequence(int n) {

        int currentLength = 1;
        boolean needComplement = false;

        while (currentLength < n) {
            currentLength *= 2;
        }
        while (currentLength > 1) {
            if (n > currentLength / 2) {
                n -= currentLength / 2;
                needComplement = !needComplement;
            }
            currentLength /= 2;
        }

        if (needComplement) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        // System.out.println(closestSequence(new int[]{1, 2, 6}, new int[]{0, 1, 3, 4, 5}));
        // System.out.println(Arrays.toString(theJanitor("abacaba")));
        /*System.out.println(trapRooms(new char[][]{{'U', 'L'},
                {'R', 'L'}}));*/
        // System.out.println(dotProduct(new int[]{1, 1, 1}, new int[]{0, 1, -1}));
        // System.out.println(mySubstring("abcde", 2, 3));
        // System.out.println(mySubstring("abcdef", 0, 2));
        // System.out.println(polygonPerimeter(new boolean[][]{{false, true, true}, {true, true, false}, {true, false, false}}));
        System.out.println(insertDashes("aba caba"));
    }

}
