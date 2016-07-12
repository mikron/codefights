package am.lsoft.dev;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Davit on 11/07/16.
 */
public class TournamentDay35 {

    private static int arrayMinimumAboveBound(int[] inputArray, int bound) {

        int best = Integer.MAX_VALUE;
        for (int anInputArray : inputArray) {
            if (anInputArray > bound &&
                    (anInputArray < best)) {
                best = anInputArray;
            }
        }

        return best;
    }

    private static int rounders(int n) {
        int p = 10;
        while (n > p) {
            if ((n % p) / (p / 10) < 5)
                n = (n / p) * p;
            else
                n = (n / p + 1) * p;
            p *= 10;
        }
        return n;
    }

    private static String[] isDivisibleBy6(String inputString) {

        int digitSum = 0;
        char leftBound = '0',
                rightBound = '9';
        ArrayList<String> answer = new ArrayList<>();
        char[] mask = inputString.toCharArray();
        int asteriskPos = -1;

        for (int i = 0; i < mask.length; i++) {
            if (leftBound <= mask[i] &&
                    mask[i] <= rightBound) {
                digitSum += mask[i] - leftBound;
            } else {
                asteriskPos = i;
            }
        }

        for (int i = 0; i < 10; i++) {
            if ((digitSum + i) % 3 == 0) {
                mask[asteriskPos] = (char) (leftBound + i);
                if ((mask[mask.length - 1] - leftBound) % 2 == 0) {
                    answer.add(String.valueOf(mask));
                }
            }
        }

        return answer.toArray(new String[0]);
    }

    private static int sumOfCubes(int n) {
        int k = (n * (n + 1)) / 2;
        return k * k;
    }

    private static int countPathsThroughCell(int n, int m, int x, int y) {

        /*// Create a 2D table to store results of subproblems
        int[][] count = new int[m][n];

        // Count of paths to reach any cell in first column is 1
        for (int i = x; i < n; i++)
            count[i][0] = 1;

        // Count of paths to reach any cell in first column is 1
        for (int j = y; j < m; j++)
            count[0][j] = 1;

        // Calculate count of paths for other cells in bottom-up manner using
        // the recursive solution
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++)

                // By uncommenting the last part the code calculatest he total
                // possible paths if the diagonal Movements are allowed
                count[i][j] = count[i - 1][j] + count[i][j - 1]; //+ count[i-1][j-1];

        }
        return count[n - 1][m - 1];*/
       /* int p = 1;
        for (int i = 0; i < Math.min(n - x - 1, m - y - 1); p /= ++i)
            p *= (n - x + m - y - i);
        return p;*/

        /*
     * Array dp is used to store dynamic programming values.
     */
        int r = 0;
        if (x == 0) {
            r++;
        } else if (y == 0) {
            r++;
        } else {
            r += x + y;
        }

        if (x == n - 1 || y == m - 1) {
            return r;
        } else {
            r *= (n - x + m - y - 2);
            return r;
        }
    }

    public static void main(String[] args) {
        // System.out.println(arrayMinimumAboveBound(new int[]{1, 3, 5, 4, 2, 6}, 3));
        // System.out.println(rounders(15));
        // System.out.println(sumOfCubes(3));
        System.out.println(countPathsThroughCell(3, 3, 1, 1));
    }

    private static void test(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        scan.nextLine();
        double d = scan.nextDouble();
        scan.nextLine();
        String s = scan.nextLine();

        // Write your code here.

        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
    }

    private static void test2(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("================================");
        for (int i = 0; i < 3; i++) {
            String s1 = sc.next();
            int x = sc.nextInt();
            //Complete this line
            System.out.printf("%-15s%03d", s1, x);
            System.out.println();
        }
        System.out.println("================================");
    }

    private static void print(int a, int b, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.pow(2, i) * b;
            System.out.print(a + sum);
            System.out.print(' ');
        }
        System.out.println();
    }

    public static void test3(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[][] input = new int[t][3];
        for (int i = 0; i < t; i++) {
            input[i][0] = sc.nextInt();
            input[i][1] = sc.nextInt();
            input[i][2] = sc.nextInt();
            // System.out.println(i + " ; " + input[i][0] + " ; " + input[i][1] + " ; " + input[i][2]);
        }

        for (int i = 0; i < t; i++) {
            print(input[i][0], input[i][1], input[i][2]);
        }

    }

    public static void test4(String[] argh) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {

            try {
                long x = sc.nextLong();
                System.out.println(x + " can be fitted in:");
                if (x >= -128 && x <= 127) System.out.println("* byte");
                //Complete the code
                if (x >= -128 && x <= 127) System.out.println("* byte");
                if (x >= -Math.pow(2, 15) && x <= Math.pow(2, 15) - 1) System.out.println("* short");
                if (x >= -Math.pow(2, 31) && x <= Math.pow(2, 31) - 1) System.out.println("* int");
                if (x >= -Math.pow(2, 63) && x <= Math.pow(2, 63) - 1) System.out.println("* long");
            } catch (Exception e) {
                System.out.println(sc.next() + " can't be fitted anywhere.");
            }

        }
    }

}
