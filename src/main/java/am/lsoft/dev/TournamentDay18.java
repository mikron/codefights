package am.lsoft.dev;

/**
 * Created by Davit on 17/06/16.
 */
public class TournamentDay18 {

    static boolean evenDigitsOnly(int n) {

        if (n == 0) {
            return true;
        }
        if (n % 2 != 0) {
            return false;
        }
        return evenDigitsOnly(n / 10);
    }

    static boolean shefferStroke(boolean a, boolean b) {
        return !a || !b;
    }

    static int howManySundays(int n, String startDay) {

        String[] week = {"Monday", "Tuesday", "Wednesday",
                "Thursday", "Friday", "Saturday", "Sunday"};
        int startIndex = 0;

        for (int i = 0; i < week.length; i++) {
            if (week[i].equals(startDay)) {
                startIndex = i;
                break;
            }
        }

        return (n + startIndex) / week.length;
    }

    static String angleType(int measure) {
        if (measure > 0 && measure < 90)
            return "acute";
        else if (measure == 90)
            return "rightChild";
        else if (measure > 90 && measure < 180)
            return "obtuse";
        else if (measure == 180 || measure == 0)
            return "straight";
        return "";
    }

    static int maxGCD(int[] sequence) {
        class Helper {
            int gcd(int a, int b) {
                if (b == 0) {
                    return a;
                }
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

    static int crossingSum(int[][] matrix, int row, int column) {

        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            result += matrix[i][column];
        }
        for (int i = 0; i < matrix[0].length; i++) {
            result += matrix[row][i];
        }
        result -= matrix[row][column];

        return result;
    }

    static boolean arithmeticExpression(int A, int B, int C) {
        if (A + B == C)
            return true;
        else if (A - B == C)
            return true;
        else if (A / B == C && A % B == 0)
            return true;
        else if (A * B == C)
            return true;
        return false;
    }

    static int myMaxOfThree(int a, int b, int c) {
        if (a > b) {
            if (a > c) {
                return a;
            }
            return c;
        }
        if (b > a && b > c) {
            return b;
        }
        return c;
    }

    static String replaceFirstDigitRegExp(String input) {
        return input.replaceFirst("[0-9]", "#");
    }

    static boolean areIsomorphic(int[][] array1, int[][] array2) {
        if (array1.length != array2.length)
            return false;
        for (int i = 0; i < array1.length; i++) {
            if (array1[i].length != array2[i].length)
                return false;
        }
        return true;
    }


    public static void main(String[] args) {
        // System.out.println(evenDigitsOnly(248622));
        // System.out.println(shefferStroke(true, false));
        // System.out.println(howManySundays(9, "Saturday"));
        // System.out.println(angleType(125));
        // System.out.println(maxGCD(new int[]{8, 60, 12, 3}));
        // System.out.println(crossingSum(new int[][]{{1, 1, 1, 1}, {2, 2, 2, 2}, {3, 3, 3, 3}}, 1, 3));
        // System.out.println(crossingSum(new int[][]{{1, 1, 1, 1}, {2, 2, 2, 2}, {3, 3, 3, 3}}, 1, 3));
        // System.out.println(arithmeticExpression(2, 3, 5));
        // System.out.println(myMaxOfThree(2, 3, 5));
        System.out.println(replaceFirstDigitRegExp("There are 12 points"));
    }

}
