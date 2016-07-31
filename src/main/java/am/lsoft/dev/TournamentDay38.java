package am.lsoft.dev;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Davit on 14/07/16.
 */
public class TournamentDay38 {

    private static int houseNumbersSum(int[] inputArray) {
        int sum = 0;
        for (int i = 0; i < inputArray.length; i++) {
            sum += inputArray[i];
            if (inputArray[i] == 0)
                return sum;
        }

        return sum;
    }

    private static String properNounCorrection(String noun) {

        class Helper {
            boolean isLowerCase(char symbol) {
                if ('a' <= symbol && symbol <= 'z') {
                    return true;
                }
                return false;
            }
        }
        ;
        Helper h = new Helper();

        StringBuilder result = new StringBuilder();

        if (h.isLowerCase(noun.charAt(0))) {
            result.append((char) (noun.charAt(0) - 'a' + 'A'));
        } else {
            result.append(noun.charAt(0));
        }

        for (int i = 1; i < noun.length(); i++) {
            if (!h.isLowerCase(noun.charAt(i))) {
                result.append((char) (noun.charAt(i) - 'A' + 'a'));
            } else {
                result.append(noun.charAt(i));
            }
        }

        return result.toString();
    }

    private static boolean rightTriangle(int[] sides) {
        if (Math.max(Math.max(sides[0], sides[1]), sides[2]) == sides[0])
            return sides[0] * sides[0] == sides[1] * sides[1] + sides[2] * sides[2];
        else if (Math.max(Math.max(sides[0], sides[1]), sides[2]) == sides[1])
            return sides[1] * sides[1] == sides[0] * sides[0] + sides[2] * sides[2];
        else if (Math.max(Math.max(sides[0], sides[1]), sides[2]) == sides[2])
            return sides[2] * sides[2] == sides[0] * sides[0] + sides[1] * sides[1];
        return false;
    }

    private static boolean variableName(String name) {

        for (int i = 0; i < name.length(); i++) {
            if (!('a' <= name.charAt(i) && name.charAt(i) <= 'z' ||
                    'A' <= name.charAt(i) && name.charAt(i) <= 'Z' ||
                    '0' <= name.charAt(i) && name.charAt(i) <= '9' ||
                    name.charAt(i) == '_')) {
                return false;
            }
        }

        if ('0' <= name.charAt(0) && name.charAt(0) <= '9') {
            return false;
        }

        return true;
    }

    private static int bfsConnectedComponents(boolean[][] matrix) {
        int givenVertex = 0;
        int vertexCount = matrix.length;
        // Result array.
        boolean[] mark = new boolean[vertexCount];

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(givenVertex);
        mark[givenVertex] = true;

        while (!queue.isEmpty()) {
            Integer current = queue.remove();

            for (int i = 0; i < vertexCount; ++i)
                if (matrix[current][i] && !mark[i]) {
                    mark[i] = true;
                    queue.add(i);
                }
        }

        int len = 0;
        for (boolean m : mark)
            if (m)
                len++;
        return len;
    }

    private static int champernowneDigit(int n) {

        for (int i = 1; ; i++) {
            int number = i;
            ArrayList<Integer> digits = new ArrayList<>();
            while (number != 0) {
                digits.add(number % 10);
                number /= 10;
            }
            Collections.reverse(digits);
            if (n <= digits.size()) {
                return digits.get(n - 1);
            }
            n -= digits.size();
        }
    }

    private static int sumOfPowers(int n, int divisor) {
        int s = 0;
        for (int i = 1; i <= n; i++) {
            int u = 1;
            int c = 0;
            while (true) {
                u *= divisor;
                if (i % u != 0) break;
                c++;
            }
            s += c;
        }
        return s;
    }

    private static String longestString(String[] inputArray) {

        String answer = inputArray[0];
        for (int i = 1; i < inputArray.length; i++) {
            if (inputArray[i].length() > answer.length()) {
                answer = inputArray[i];
            }
        }
        return answer;
    }

    private static int[] bfsDistancesUnweightedGraph(boolean[][] matrix, int startVertex) {
        int[] ans = new int[matrix.length];
        for (int i = 0; i < ans.length; i++) {
            if (matrix[startVertex][i])
                ans[i] = 1;
            else
                ans[i] = -1;
        }
        ans[startVertex] = 0;
        for (int i = 0; i < ans.length; i++) {
            int tempSize = matrix.length;
            for (int j = 0; j < ans.length; j++) {
                if (ans[i] == -1) {
                    if (matrix[i][j] && ans[j] == 1)
                        tempSize = 2;
                } else
                    tempSize = ans[i];
            }
            ans[i] = tempSize;

        }

        return ans;
    }

    private static int arrayEqualization(int[] a, int k) {

        int best = a.length;

        for (int i = 0; i < a.length; i++) {
            int x = a[i];
            int ans = 0;
            int cur = -1;
            for (int j = 0; j < a.length; j++) {
                if (cur == -1 && a[j] != x) {
                    cur = 0;
                }
                if (cur >= 0) {
                    cur++;
                }
                if (cur == k || cur >= 0 && j == a.length - 1) {
                    ans++;
                    cur = -1;
                }
            }
            best = Math.min(best, ans);
        }

        return best;
    }

    private static int digitSumsDifference(int n) {

        int result = 0;
        while (n != 0) {
            int digit = n % 10;
            if (digit % 2 == 1) {
                result -= digit;
            } else {
                result += digit;
            }
            n /= 10;
        }

        return result;
    }

    private static int getClosestOddSquare(int num) {
        int closestSquare = (int) Math.ceil(Math.sqrt(num));

        if (closestSquare % 2 == 0) {
            closestSquare++;
        }

        return closestSquare;
    }

    private static int[][] spiralNumbers(int n) {
        int A[][] = new int[n][n];
        int k = 1, c1 = 0, c2 = n - 1, r1 = 0, r2 = n - 1;

        while (k <= n * n) {
            for (int i = c1; i <= c2; i++) {
                A[r1][i] = k++;
            }

            for (int j = r1 + 1; j <= r2; j++) {
                A[j][c2] = k++;
            }

            for (int i = c2 - 1; i >= c1; i--) {
                A[r2][i] = k++;
            }

            for (int j = r2 - 1; j >= r1 + 1; j--) {
                A[j][c1] = k++;
            }

            c1++;
            c2--;
            r1++;
            r2--;
        }

            /* Printing the Circular matrix */
        System.out.println("The Circular Matrix is:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(A[i][j] + "\t");
            }
            System.out.println();
        }
        return A;
    }

    private static boolean passwordCheck(String inputString) {

        boolean containsDigits = false,
                containsCapitals = false,
                containsSmallLetters = false;

        for (int i = 0; i < inputString.length(); i++) {
            if ('0' <= inputString.charAt(i) && inputString.charAt(i) <= '9') {
                containsDigits = true;
            }
            if ('A' <= inputString.charAt(i) && inputString.charAt(i) <= 'Z') {
                containsCapitals = true;
            }
            if ('a' <= inputString.charAt(i) && inputString.charAt(i) <= 'z') {
                containsSmallLetters = true;
            }
        }
        return containsDigits && containsCapitals
                && containsSmallLetters && inputString.length() >= 5;
    }

    private static int specialNumbers(int l, int r) {
        class Helper {
            Helper() {
            }

            boolean special(int num) {
                ArrayList<Integer> digits = new ArrayList<>();
                int digit = Integer.MAX_VALUE, oldNumber = num;
                while (num != 0) {
                    digit = num % 10;
                    if (digit == 6)
                        digits.add(9);
                    else if (digit == 8)
                        digits.add(8);
                    else if (digit == 9)
                        digits.add(6);
                    else if (digit == 0)
                        digits.add(0);
                    if (digit == 1 || digit == 2 || digit == 3 || digit == 4 ||
                            digit == 5 || digit == 7)
                        return false;
                    num /= 10;
                }
                Collections.reverse(digits);
                int newNumber = 0;
                int k = 1;
                for (int i = 0; i < digits.size(); i++) {
                    newNumber += digits.get(i) * k;
                    k *= 10;
                }

                return newNumber == oldNumber;
            }
        }
        int ans = 0;
        Helper h = new Helper();
        for (int i = l; i <= r; i++)
            if (h.special(i))
                ans++;
        return ans;


    }

    private static int specialNumbers2(int l, int r) {
        int count = 0;
        for (int i = l; i <= r; i++) {
            String ans = "";
            String rev = "" + i;
            boolean possible = true;

            for (int j = rev.length() - 1; j >= 0; j--) {
                char c = rev.charAt(j);

                if (c == '0')
                    ans += '0';
                else if (c == '6')
                    ans += '9';
                else if (c == '8')
                    ans += '8';
                else if (c == '9')
                    ans += '6';
                else {
                    possible = false;
                    break;
                }


            }

            if (possible && Integer.parseInt(ans) == Integer.parseInt(rev))
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        // System.out.println(houseNumbersSum(new int[]{5, 1, 2, 3, 0, 1, 5, 0, 2}));
        // System.out.println(variableName("var_1__Int"));
        // System.out.println(bfsConnectedComponents(new boolean[][]{{false, true, false}, {true, false, false}, {false, false, false}}));
        // System.out.println(bfsConnectedComponents(new boolean[][]{{false, false, false}, {false, false, false}, {false, false, false}}));
        // System.out.println(champernowneDigit(11));
        // System.out.println(sumOfPowers(6, 2));
        // System.out.println(longestString(new String[]{"a", "ab", "c"}));
        // System.out.println(Arrays.toString(bfsDistancesUnweightedGraph(new boolean[][]{{false, false, true}, {false, false, true}, {true, true, false}}, 0)));
        // System.out.println(arrayEqualization(new int[]{1, 2, 2, 1, 2, 1, 2, 2, 2, 1, 1, 1}, 2));
        // System.out.println(Arrays.toString(spiralNumbers(3)));
        // System.out.println(specialNumbers(66, 96));
        System.out.println(specialNumbers(1, 10000));
    }

}
