package am.lsoft.dev;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Davit on 15/06/16.
 */
public class TournamentDay16 {

    /*15/06/2016*/

    static int countNeighbouringPairs(String inputString) {

        int answer = 0;

        for (int i = 1; i < inputString.length(); i++) {
            if (inputString.charAt(i) == inputString.charAt(i - 1)) {
                answer++;
            }
        }

        return answer;
    }

    static int swapNeighbouringDigits(int n) {

        int result = 0,
                tenPower = 1;
        while (n != 0) {
            int digit1 = n % 10,
                    digit2 = ((n - digit1) / 10) % 10;
            result += tenPower * (10 * digit1 + digit2);
            n /= 100;
            tenPower *= 100;
        }
        return result;
    }

    /*static int ballsDistribution(int colors, int ballsPerColor, int boxSize) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        int answer = 0;
        int ballsRemaining = 0;
        int colorIdx = 0;
        int row = 0;
        while (colorIdx < colors) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < boxSize; j++) {
                if (ballsRemaining >= ballsPerColor) {
                    colorIdx++;
                    ballsRemaining = 1;
                } else {
                    ballsRemaining++;
                }
                tmp.add(j, colorIdx == colors ? colorIdx - 1 : colorIdx);
                // matrix[row][j] = colorIdx == colors ? colorIdx - 1 : colorIdx;
                if (j - 1 > 0 && tmp.get(j - 1) != tmp.get(j))
                    answer++;
            }
            matrix.add(tmp);
            row++;
        }


        *//*for (int i = 0; i < matrix.length; i++)
            for (int j = 1; j < matrix[0].length; j++)
                if (matrix[i][j] != matrix[i][j - 1])
                    answer++;*//*

        return answer;
    }*/

    static int ballsDistribution(int colors, int ballsPerColor, int boxSize) {
        int cur = 0,
                cap = boxSize,
                res = 0;

        for (int i = 0; i < colors; i++) {
            int start = cur;
            for (int j = 0; j < ballsPerColor; j++) {
                cap--;
                if (cap == 0) {
                    cur++;
                    cap = boxSize;
                }
            }

            if (start < cur && cap < boxSize || start + 1 < cur)
                res++;
        }
        return res;
    }

    static String simplifyPath(String path) {

        String[] parts = path.split("/");
        String[] simplified = new String[parts.length];
        int length = 0;
        for (String part : parts) {
            if (part.equals(".") || part.equals("") || part.equals("..")) {
                if (part.equals("..") && length > 0) {
                    length--;
                }
                continue;
            }
            simplified[length] = part;
            length++;
        }

        if (length == 0) {
            return "/";
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            result.append("/" + simplified[i]);
        }

        return result.toString();
    }

    static int niceFractions(int n) {
        class Helper {
            Helper() {
            }

            ArrayList<Integer> toArray(int n) {
                ArrayList<Integer> num = new ArrayList<>();
                while (n != 0) {
                    n /= 10;
                    num.add(n);
                }
                return num;
            }

            boolean isFine(int n1, int n2) {
                boolean hasZero = false;
                ArrayList<Integer> digits = new ArrayList<>(5);
                ArrayList<Integer> digits2 = new ArrayList<>(5);

                while (n1 != 0) {
                    for (int i = 0; i < digits.size(); i++) {
                        if (n1 % 10 == digits.get(i))
                            return false;
                    }
                    if (n1 % 10 == 0)
                        hasZero = true;
                    digits.add(n1 % 10);
                    n1 /= 10;
                }

                while (n2 != 0) {
                    for (int j = 0; j < digits2.size(); j++) {
                        if (n2 % 10 == digits2.get(j))
                            return false;
                    }
                    if (n2 % 10 == 0)
                        hasZero = true;
                    digits2.add(n2 % 10);
                    n2 /= 10;
                }

                if (digits2.size() == 4 && hasZero)
                    return false;
                else if (digits2.size() < 4)
                    return false;

                for (int i = 0; i < digits.size(); i++) {
                    for (int j = 0; j < digits2.size(); j++) {
                        if (digits.get(i) == digits2.get(j)) {
                            return false;
                        }
                    }
                }
                return true;
            }
        }
        Helper h = new Helper();
        int result = 0;
        for (int i = 12345; i <= 98765; i++) {
            if (i % n == 0 && h.isFine(i, i / n))
                result++;
        }
        return result;
    }

    public static void main(String[] args) {
        // System.out.println(countNeighbouringPairs("aaa"));
        // System.out.println(swapNeighbouringDigits(12345678));
        // System.out.println(ballsDistribution(3, 5, 6));
        // System.out.println(ballsDistribution(10, 10, 9));
        System.out.println(niceFractions(8));
    }

}
