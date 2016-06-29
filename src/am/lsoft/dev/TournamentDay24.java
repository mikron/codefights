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

   /* private static String BalancedTernary(int num) {
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
*/

    private static String BalancedTernary(int n)
    {
        String r = "";
        do
            r = "1-01-".charAt(2 + n % 3) + r;
        while ((n = n / 3 + n % 3 / 2) != 0);
        return r;
    }

    static boolean isOneSwapEnough(String inputString) {

        char[][] badPairs = new char[2][];
        int badPairsCnt = 0;
        for (int i = 0; i < inputString.length() / 2 ; i++) {
            char a = inputString.charAt(i);
            char b = inputString.charAt(inputString.length() - i - 1);
            if (a != b) {
                if (badPairsCnt == 2) {
                    return false;
                }
                if (a > b) {
                    char t = a;
                    a = b;
                    b = t;
                }
                badPairs[badPairsCnt++] = new char[]{a, b};
            }
        }
        if (badPairsCnt == 0) {
            return true;
        } else if (badPairsCnt == 1) {
            if (inputString.length() % 2 == 0) {
                return false;
            }
            char c = inputString.charAt(inputString.length() / 2);
            return badPairs[0][0] == c || badPairs[0][1] == c;
        } else {
            return badPairs[0][0] == badPairs[1][0] && badPairs[0][1] == badPairs[1][1];
        }
    }

    private static int arrayKthGreatest(int[] inputArray, int k) {

        for (int i = 0; i < k; i++) {
            int indexOfMaximum = i,
                    tmp = inputArray[i];

            for (int j = i + 1; j < inputArray.length; j++) {
                if (inputArray[j] > inputArray[indexOfMaximum]) {
                    indexOfMaximum = j;
                }
            }

            inputArray[i] = inputArray[indexOfMaximum];
            inputArray[indexOfMaximum] = tmp;
        }

        return inputArray[k - 1];
    }

    private static int gcm(int a, int b) {
        return b == 0 ? a : gcm(b, a % b);
    }

    private static int[] fractionReducing(int[] fraction) {
        int gcm = gcm(fraction[0], fraction[1]);
        return new int[] {fraction[0] / gcm, fraction[1] / gcm};

    }

    public static void main(String[] args) {
        // System.out.println(extractMatrixColumn(new int[][]{{1, 1, 1, 2}, {0, 5, 0, 4}, {2, 1, 3, 6}}, 2));
        // System.out.println(BalancedTernary(10));
        // System.out.println(BalancedTernary(-293827361));
        // System.out.println(isOneSwapEnough("abab"));
        // System.out.println(arrayKthGreatest(new int[]{19, 32, 11, 23}, 3));
        System.out.println(fractionReducing(new int[]{2, 6}));
    }

}