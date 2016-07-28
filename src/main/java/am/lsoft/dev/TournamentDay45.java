package am.lsoft.dev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Davit on 26/07/16.
 */
public class TournamentDay45 {

    private static int squareInTheLabyrinth(boolean[][] labMap) {

        class Helper {
            boolean[][] labMap;
            int h, w;

            Helper(boolean[][] labMap) {
                this.labMap = labMap;
                this.h = labMap.length;
                this.w = labMap[0].length;
            }

            boolean valid(int x, int y, boolean[][] was, int k) {
                //
                if (x >= was.length || x < 0 || x + k >= labMap.length)
                    return false;
                if (y >= was[x].length || y < 0 || y + k >= labMap.length)
                    return false;
                //
                if (was[x][y]) {
                    return false;
                }
                for (int dx = 0; dx < k; dx++) {
                    for (int dy = 0; dy < k; dy++) {
                        if (!labMap[x + dx][y + dy]) {
                            return false;
                        }
                    }
                }
                return true;
            }

            void dfs(int curX, int curY, boolean[][] was, int k) {
                if (valid(curX, curY, was, k)) {
                    was[curX][curY] = true;
                    for (int dx = -1; dx <= 1; dx++) {
                        for (int dy = -1; dy <= 1; dy++) {
                            if (dx * dy == 0 && dx + dy != 0) {
                                dfs(curX + dx, curY + dy, was, k);
                            }
                        }
                    }
                }
            }
        }

        Helper helper = new Helper(labMap);

        boolean[][] was = new boolean[helper.h][helper.w];
        int maxRes = Math.min(helper.h, helper.w);

        for (int i = 0; i < helper.h; i++) {
            Arrays.fill(was[i], false);
        }

        for (int res = maxRes; res > 0; res--) {
            helper.dfs(0, 0, was, res);
            if (was[helper.h - res][helper.w - res]) {
                return res;
            }
            for (int i = 0; i < helper.h; i++) {
                for (int j = 0; j < helper.w; j++) {
                    was[i][j] = false;
                }
            }
        }

        return 0;
    }

    private static int centuryFromYear(int year) {
        return (year) / 100 + (year % 100 != 0 ? 1 : 0);
    }

    // Returns the greatest Fibonacci Numberr smaller than
    // or equal to n.
    private static int nearestSmallerEqFib(int n) {
        // Corner cases
        if (n == 0 || n == 1)
            return n;

        // Find the greatest Fibonacci Number smaller
        // than n.
        int f1 = 0, f2 = 1, f3 = 1;
        while (f3 <= n) {
            f1 = f2;
            f2 = f3;
            f3 = f1 + f2;
        }
        return f2;
    }

    private static int[] fibonacciSum(int n) {
        ArrayList<Integer> fibSumArr = new ArrayList<>();
        while (n > 0) {
            // Find the greates Fibonacci Number smaller
            // than or equal to n
            int f = nearestSmallerEqFib(n);

            // Print the found fibonacci number
            fibSumArr.add(f);

            // Reduce n
            n = n - f;
        }
        Collections.reverse(fibSumArr);
        return fibSumArr.stream().mapToInt(i -> i).toArray();
    }

    private static int twoArraysNthElement(int[] array1, int[] array2, int n) {

        class Helper {
            int lowerBound(int[] arr, int elem) {
                int l = -1;
                int r = arr.length;
                while (l + 1 < r) {
                    int mid = (l + r) / 2;
                    if (arr[mid] <= elem) {
                        l = mid;
                    } else {
                        r = mid;
                    }
                }
                return l;
            }
        }
        ;

        int l = -1;
        int r = array1.length;

        Helper h = new Helper();

        while (l + 1 < r) {
            int mid = (l + r) / 2;
            int pos = h.lowerBound(array2, array1[mid]);

            if (mid + pos + 1 <= n)
                l = mid;
            else
                r = mid;
        }

        if (l > -1 && l + h.lowerBound(array2, array1[l]) + 1 == n) {
            return array1[l];
        }
        return twoArraysNthElement(array2, array1, n);
    }

    private static int freeTickets(int[] determination, int[] money, int n) {

        class Element {
            int det, money;
            Element next;

            Element(int det, int money) {
                this.det = det;
                this.money = money;
            }
        }

        Element queueEnd = new Element(0, 0);
        for (int i = 0; i < determination.length; i++) {
            Element prev = queueEnd;
            Element cur = new Element(determination[i], money[i]);
            Element next = queueEnd.next;
            while (cur.money >= next.det) {
                cur.money -= next.det;
                next.money += next.det;
                if (next.money >= n * next.det) {
                    next = next.next;
                    prev.next = next;
                } else {
                    next = next.next;
                    prev = prev.next;
                }
            }
            prev.next = cur;
            cur.next = next;
        }

        int answer = 0;
        Element cur = queueEnd;
        while (cur != null) {
            answer += cur.money;
            cur = cur.next;
        }
        return answer;

    }

    private static ArrayList<Integer> concatenateArrays(ArrayList<Integer> a, ArrayList<Integer> b) {
        for (int i = 0; i < b.size(); i++) {
            a.add(b.get(i));
        }
        return a;
    }

    private static int missingNumber(int[] arr) {
        Arrays.sort(arr);
        int s = 0, t = 0;
        for (int i = 0; i < arr.length; i++) {
            s += arr[i];
        }
        for (int i = 1; i <= arr.length + 1; i++) {
            t += i;
        }

        return t - s;
    }

    private static String compareIntegers(String a, String b) {

        if (a.length() > b.length()) {
            return "greater";
        }
        if (a.length() < b.length()) {
            return "less";
        }
        if (a.compareTo(b) < 0) {
            return "less";
        }
        if (a.compareTo(b) > 0) {
            return "greater";
        }
        return "equal";
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x <= 7 && y >= 0 && y <= 7;
    }

    private static int chessKnightMoves(String cell) {
        int x = cell.charAt(0) % 65,
                y = +cell.charAt(1) - '0' - 1;
        // console.log(x, y);
        int c = 0;
        for (int dx = -2; dx <= 2; dx++)
            for (int dy = -2; dy <= 2; dy++) {
                if (Math.abs(dx * dy) == 2)
                    if (isValid(x + dx, y + dy))
                        c++;
            }
        return c;

    }

    private static int chessBoardSquaresUnderQueenAttack(int a, int b) {

        class Helper {
            int a, b;

            int go(int x, int y, int dx, int dy) {
                if ((x < 0 || x >= a) || (y < 0 || y >= b)) {
                    return 0;
                }
                return go(x + dx, y + dy, dx, dy) + 1;
            }
        }
        ;

        int res = 0;

        Helper h = new Helper();
        h.a = a;
        h.b = b;

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                for (int dx = -1; dx <= 1; dx++) {
                    for (int dy = -1; dy <= 1; dy++) {
                        if (dx != 0 || dy != 0) {
                            res += h.go(i + dx, j + dy, dx, dy);
                        }
                    }
                }
            }
        }

        return res;
    }

    private static ArrayList<ArrayList<String>> permute(String[] fragments) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        //start from an empty list
        result.add(new ArrayList<String>());

        for (int i = 0; i < fragments.length; i++) {
            //list of list in current iteration of the array num
            ArrayList<ArrayList<String>> current = new ArrayList<>();

            for (ArrayList<String> l : result) {
                // # of locations to insert is largest index + 1
                for (int j = 0; j < l.size() + 1; j++) {
                    // + add num[i] to different locations
                    l.add(j, fragments[i]);

                    ArrayList<String> temp = new ArrayList<>(l);
                    current.add(temp);

                    // - remove num[i] add
                    l.remove(j);
                }
            }

            result = new ArrayList<>(current);
        }

        return result;
    }

    private static int leastFactorial(int n) {

        int factorial = 1,
                k = 2;
        while (factorial < n) {
            factorial *= k;
            k++;
        }
        return factorial;
    }

    private static int[] setUnion(int[] A, int[] B) {

        ArrayList<Integer> C = new ArrayList<>();
        int pos_b = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for (int pos_a = 0; pos_a < A.length; pos_a++) {
            while (pos_a > pos_b/*...*/) {
                C.add(B[pos_b]);
                pos_b++;
            }
            C.add(A[pos_a]);
            if (pos_b < B.length && A[pos_a] == B[pos_b]) {
                pos_b++;
            }
        }
        while (pos_b < B.length) {
            C.add(B[pos_b]);
            pos_b++;
        }

        int[] res = new int[C.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = C.get(i);
        }

        return res;
    }

    private static int quotientKthDigitAfterDecimalPoint(int a, int b, int k) {
        return 0;
    }

    private static float sign(int[] p1, int[] p2, int[] p3) {
        return (p1[0] - p3[0]) * (p2[1] - p3[1]) - (p2[0] - p3[0]) * (p1[1] - p3[1]);
    }

    private static boolean inTriangle(int[] A, int[] B, int[] C, int[] P) {
        boolean b1, b2, b3;

        b1 = sign(P, A, B) < 0.0f;
        b2 = sign(P, B, C) < 0.0f;
        b3 = sign(P, C, A) < 0.0f;

        return ((b1 == b2) && (b2 == b3));
    }

    private static boolean subsetsSequence(int[][] sets) {

        class Helper {
            boolean isSubset(int[] setA, int[] setB) {
                int j = 0;
                for (int i = 0; i < setB.length; i++) {
                    if (j < setA.length && setB[i] == setA[j]) {
                        j++;
                    }
                }
                if (j == setA.length) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        ;

        Helper h = new Helper();

        int[] supersets = new int[sets.length];

        for (int i = 0; i < sets.length; i++) {
            Arrays.sort(sets[i]);
        }

        for (int i = 0; i < sets.length; i++) {
            for (int j = i + 1; j < sets.length; j++) {
                if (h.isSubset(sets[i], sets[j])) {
                    supersets[i]++;
                }
                if (h.isSubset(sets[j], sets[i])) {
                    supersets[j]++;
                }
            }
        }

        Arrays.sort(supersets);

        for (int i = 0; i < sets.length; i++) {
            if (supersets[i] < i) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        /*System.out.println(squareInTheLabyrinth(new boolean[][]{{true, true, true, true},
                {true, true, false, true},
                {true, true, true, true},
                {true, true, true, true}}));*/
        // System.out.println(centuryFromYear(100));
        // System.out.println(Arrays.toString(fibonacciSum(10)));
        // System.out.println(freeTickets(new int[]{1, 2, 3}, new int[]{1, 2, 3}, 3));
        // System.out.println(missingNumber(new int[]{5, 2, 1, 6, 3}));
        // System.out.println(missingNumber(new int[]{8, 0, 2, 9}));
        // System.out.println(chessKnightMoves("A1"));
        // System.out.println(chessBoardSquaresUnderQueenAttack(2, 2));
        // System.out.println(chessBoardSquaresUnderQueenAttack(3, 2));
        System.out.println(subsetsSequence(new int[][]{{1, 3, 2}, {2}, {1, 2}, {2, 1}}));
    }

}
