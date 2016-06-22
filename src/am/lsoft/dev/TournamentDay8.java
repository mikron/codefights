package am.lsoft.dev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Davit on 07/06/16.
 */
public class TournamentDay8 {

    static boolean isSumOfConsecutive(int n) {
        int sumOfFirstIIntegers = 3;
        for (int i = 2; sumOfFirstIIntegers <= n; i++) {
            if (i % 2 == 0 ? (n % i == i / 2) : (n % i == 0)) {
                return true;
            }
            sumOfFirstIIntegers += i + 1;
        }
        return false;
    }

    static boolean isPowerOfTwo(int n) {
        return n != 0 && (n & (n - 1)) == 0;
    }

    static boolean almostIncreasingSequence(int[] sequence) {
        for (int erasedIndex = 0; erasedIndex < sequence.length; ++erasedIndex) {
            boolean increasing = true;
            int last = 0,
                    start = 1;

            if (erasedIndex == 0) {
                last = 1;
                start = 2;
            }

            for (int j = start; j < sequence.length; ++j) {
                if (j == erasedIndex) {
                    continue;
                }
                if (sequence[j] <= sequence[last]) {
                    increasing = false;
                    break;
                }
                last = j;
            }

            if (increasing) {
                return true;
            }
        }

        return false;
    }

    static String properOrImproper(int[] A) {
        if (Math.abs((double) A[1] / A[0]) < 1) {
            return "Proper";
        }
        return "Improper";
    }

    static int cyclicString(String s) {
        for (int answer = 1; answer < s.length(); answer++) {
            boolean correct = true;
            for (int position = 0; position + answer < s.length(); position++) {
                if (s.charAt(position) != s.charAt(position + answer)) {
                    correct = false;
                    break;
                }
            }
            if (correct) {
                return answer;
            }
        }
        return s.length();
    }

    static int[][] spiralNumbers(int num) {
        int[][] matrix = new int[num][num];

        int n = num, m = num;
        int i, k = 0, l = 0;
        int sum = 1;

        /*  k - starting row index
            m - ending row index
            l - starting column index
            n - ending column index
            i - iterator
        */

        while (k < m && l < n) {
            /* Print the first row from the remaining rows */
            for (i = l; i < n; ++i) {
                matrix[k][i] = sum;
                sum++;
            }
            k++;

            /* Print the last column from the remaining columns */
            for (i = k; i < m; ++i) {
                matrix[i][n - 1] = sum;
                sum++;
            }
            n--;

            /* Print the last row from the remaining rows */
            if (k < m) {
                for (i = n - 1; i >= l; --i) {
                    matrix[m - 1][i] = sum;
                    sum++;
                }
                m--;
            }

            /* Print the first column from the remaining columns */
            if (l < n) {
                for (i = m - 1; i >= k; --i) {
                    matrix[i][l] = sum;
                    sum++;
                }
                l++;
            }
        }
        return matrix;
    }

    static boolean isLucky(int n) {

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

    static int squaresSumMinimization(int[] A) {
        class Helper {
            Helper() {
            }

            int sum(int[] A, int x) {
                int sum = 0;
                for (int i = 0; i < A.length; i++) {
                    sum += Math.pow(A[i] - x, 2);
                }
                return sum;
            }
        }
        Helper helper = new Helper();
        int minSum = helper.sum(A, 0);
        int result = 0;
        for (int i = -10; i < 10; i++) {
            if (helper.sum(A, i) < minSum) {
                minSum = helper.sum(A, i);
                result = i;
            }
        }
        return result;
    }

    static int holiday(int x, String weekDay, String month, int yearNumber) {
        final List<String> months = new ArrayList<String>(
                Arrays.asList(new String[]{
                        "January", "February", "March", "April",
                        "May", "June", "July", "August",
                        "September", "October", "November", "December"
                }));
        final List<String> daysInWeek = new ArrayList<String>(
                Arrays.asList(new String[]{
                        "Monday", "Tuesday", "Wednesday",
                        "Thursday", "Friday", "Saturday", "Sunday"
                }));
        final int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        class Helper {
            boolean isLeap(int year) {
                return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
            }

            int countLeap(int yearLeft, int yearRight) {
                int result = 0;
                for (int i = yearLeft; i <= yearRight; i++) {
                    if (isLeap(i)) {
                        result++;
                    }
                }
                return result;
            }

            int getDaysInMonth(int month, int year) {
                int result = days[month];
                if (isLeap(year) && month == 1) {
                    result++;
                }
                return result;
            }
        }

        int weekDayInt = daysInWeek.indexOf(weekDay);
        int monthInt = months.indexOf(month);

        /*01 January 2015 is Thursday*/
        Helper h = new Helper();
        int leaps = h.countLeap(2015, yearNumber - 1);
        int newWeekDay = (daysInWeek.indexOf("Thursday") + leaps * 366 +
                (yearNumber - 2015 - leaps) * 365) % 7;
        for (int i = 0; i < monthInt; i++) {
            newWeekDay = (newWeekDay + h.getDaysInMonth(i, yearNumber)) % 7;
        }
        int daysCount = 0;
        int daysInMonth = h.getDaysInMonth(monthInt, yearNumber);
        for (int i = 1; i <= daysInMonth; i++) {
            if (newWeekDay == weekDayInt) {
                daysCount++;
            }
            if (daysCount == x) {
                return i;
            }
            newWeekDay = (newWeekDay + 1) % 7;
        }
        return -1;
    }

    static int maxGCD(int[] sequence) {
        class Helper {
            int gcd(int a, int b) {
                if (b == 0)
                    return a;
                return gcd(b, a % b);
            }
        }
        ;

        Helper h = new Helper();
        int bestRes = 0;

        for (int i = 0; i < sequence.length; i++) {
            int result = sequence[0];
            if (i == 0) {
                result = sequence[1];
            }
            for (int j = 0; j < sequence.length; j++) {
                if (i == j) {
                    continue;
                }
                result = h.gcd(result, sequence[j]);
            }
            if (result > bestRes) {
                bestRes = result;
            }
        }

        return bestRes;
    }

    /*
    static int minCoins(int coins[], int m, int V) {
        // base case
        if (V == 0) return 0;

        // Initialize result
        int res = Integer.MAX_VALUE;

        // Try every coin that has smaller value than V
        for (int i=0; i<m; i++) {
            if (coins[i] <= V) {
                int sub_res = minCoins(coins, m, V-coins[i]);
                // Check for INT_MAX to avoid overflow and see if
                // result can minimized
                if (sub_res != Integer.MAX_VALUE && sub_res + 1 < res)
                    res = sub_res + 1;
            }
        }
        return res;
    }
    */

    static int minCoins(int coins[], int m, int V) {
        // table[i] will be storing the minimum number of coins
        // required for i value.  So table[V] will have result
        int[] table = new int[V + 1];

        // Base case (If given value V is 0)
        table[0] = 0;

        // Initialize all table values as Infinite
        for (int i = 1; i <= V; i++)
            table[i] = Integer.MAX_VALUE;

        // Compute minimum coins required for all
        // values from 1 to V
        for (int i = 1; i <= V; i++) {
            // Go through all coins smaller than i
            for (int j = 0; j < m; j++)
                if (coins[j] <= i) {
                    int sub_res = table[i - coins[j]];
                    if (sub_res != Integer.MAX_VALUE && sub_res + 1 < table[i])
                        table[i] = sub_res + 1;
                }
        }
        return table[V];
    }

    static int minimalNumberOfCoins(int[] coins, int price) {
        int m = coins.length / coins[0];
        // m is size of coins array (number of different coins)
        return minCoins(coins, m, price);
    }

    /*static int countTriangles(int[] X, int[] Y) {
        class Helper {
            Helper() {
            }

            int[] point(int x, int y) {
                return new int[]{x, y};
            }

            int fact(int n) {
                if (n == 0)
                    return 1;
                return n * fact(n - 1);
            }
            boolean collinear(int[] p1, int[] p2, int[] p3) {
                return (p1[1] - p2[1]) * (p1[0] - p3[0]) == (p1[1] - p3[1]) * (p1[0] - p2[0]);
                // return (y1 - y2) * (x1 - x3) == (y1 - y3) * (x1 - x2);
            }
        }
        Helper h = new Helper();
        HashSet<int[]> hashset = new HashSet<>();
        for (int i = 0; i < X.length; i++) {
            hashset.add(h.point(X[i], Y[i]));
        }
        int pointNumber = hashset.size();
        HashSet<int[]> substractNumber = new HashSet<>();
        for (int[] p1 : hashset) {
            for (int[] p2 : hashset) {
                for (int[] p3 : hashset) {
                    if (h.collinear(p1, p2, p3)) {
                        substractNumber.add(p1);
                        substractNumber.add(p2);
                        substractNumber.add(p3);
                    }
                }
            }

        }
        return pointNumber == 3 ? 1 : (h.fact(pointNumber) / (h.fact(3) * h.fact(pointNumber - 3)) - 0);
    }*/

    static int d(int[] a, int[] b) {
        return (int) Math.sqrt((Math.pow(a[0] - b[0], 2) + Math.pow(a[1] - b[1], 2)));
    }

    static boolean areAlined(int[] a, int[] b, int[] c) {
        return Math.max(Math.max(d(a, b), d(a, c)), d(b, c)) * 2 - (d(a, b) + d(a, c) + d(b, c)) < 0;
    }

    static int countTriangles(int[] X, int[] Y) {
        int o = 0;
        for (int i = 0; i < X.length; i++) {
            for (int j = i + 1; j < X.length; j++) {
                for (int k = j + 1; k < X.length; k++) {
                    if (areAlined(new int[]{X[i], Y[i]}, new int[]{X[j], Y[j]}, new int[]{X[k], Y[k]})) {
                        o++;
                    }
                }
            }
        }
        return o;
    }

    static int josephusProblem(int n, int k) {
        /*List<Integer> p = new LinkedList<Integer>();
        for (int i = 0; i < n; i++)
            p.add(i+1);
        List<Integer> r = new LinkedList<Integer>();
        int i = (1 - 2) % n;
        for (int j = n; j > 0; j--) {
            i = (i + 1) % n--;
            r.add(p.remove(i--));
        }
        return r.get(r.size() - 1);*/
        int removeIdx = 0;
        ArrayList<Integer> people = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            people.add(i);
        }
        System.out.println("People removed in order:");
        while (people.size() > 1) {
            removeIdx = (removeIdx + k - 1) % people.size();
            System.out.print(people.get(removeIdx) + " ");
            people.remove(removeIdx);
        }
        System.out.println();
        return people.get(0);
    }

    public static void main(String[] args) {
        // System.out.println(isSumOfConsecutive(8));
        // System.out.println(isPowerOfTwo(16));
        // System.out.println(almostIncreasingSequence(new int[] {1, 3, 2}));
        // System.out.println(properOrImproper(new int[] {7, 2}));
        // System.out.println(cyclicString("cabca"));
        // System.out.println(spiralNumbers(3));
        // System.out.println(isLucky(1230));
        // System.out.println(squaresSumMinimization(new int[]{2, 4, 7}));
        System.out.println(holiday(3, "Wednesday", "November", 2016));
        // System.out.println(maxGCD(new int[]{8, 60, 12, 3}));
        // System.out.println(minimalNumberOfCoins(new int[]{1, 2, 10}, 28));
        // System.out.println(countTriangles(new int[]{0, 0, 1, 1}, new int[]{0, 1, 1, 0}));
        // System.out.println(countTriangles(new int[]{0, -1, -2}, new int[]{0, -2, -4}));
        // System.out.println(countTriangles(new int[]{0, 0, 0, 0}, new int[]{1, 2, 3, 4}));
        //System.out.println(josephusProblem(3, 2));
    }

}
