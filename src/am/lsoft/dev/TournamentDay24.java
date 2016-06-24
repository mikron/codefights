package am.lsoft.dev;

/**
 * Created by Davit on 24/06/16.
 */
public class TournamentDay24 {

    private static int[] extractMatrixColumn(int[][] matrix, int column) {
        int[] result = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            result[i] = matrix[i][column];
        }
        return result;
    }

    /*private static String negate(String bt1) {
        return bt1.replace("1", "x").replace("-", "1").replace("x", "-");
    }
    private static String BalancedTernary(int num) {
        int remainder = 0;
        String ternString = "";
        // If negative, treat like positive, then multiply by -1 when finished.
        if (num < 0)
            return negate(BalancedTernary(-num));
        else if (num > 0) {
            while (num >= 0) {
                if ((num == 0) && (remainder == 1))
                    break;
                remainder = num % 3;
                num = num / 3;
                if (remainder == 2) {
                    ternString += "-";
                    num += 1;
                } else
                    ternString += remainder;
            }
            return new StringBuilder(ternString).reverse().toString();
        } else
            return "0";
    }*/

    private static String BalancedTernary(int num) {
        int r = 0;
        String t = "";
        if (num < 0)
            return BalancedTernary(-num).replace("1", "x").replace("-", "1").replace("x", "-");
        else if (num > 0) {
            while (num >= 0) {
                if (num == 0 && r == 1)
                    break;
                r = num % 3;
                num /= 3;
                if (r == 2) {
                    t += "-";
                    num += 1;
                } else
                    t += r;

            }
            return new StringBuilder(t).reverse().toString();
        } else
            return "0";
    }

    public static void main(String[] args) {
        // System.out.println(extractMatrixColumn(new int[][]{{1, 1, 1, 2}, {0, 5, 0, 4}, {2, 1, 3, 6}}, 2));
        // System.out.println(BalancedTernary(10));
        System.out.println(BalancedTernary(-293827361));
    }

}