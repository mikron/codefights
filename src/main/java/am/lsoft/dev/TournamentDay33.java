package am.lsoft.dev;

import java.util.ArrayList;

/**
 * Created by Davit on 08/07/16.
 */
public class TournamentDay33 {

    private static int trailingZeros(int n) {
        int answer = 0;
        while (n % 2 == 0) {
            n /= 2;
            answer++;
        }
        return answer;
    }

    private static int toDecimal(int k, String n) {

        int result = 0;
        int power = 1;
        for (int i = n.length() - 1; i >= 0; i--) {
            result += (n.charAt(i) - '0') * power;
            power *= k;
        }

        return result;
    }

    private static int nearestRoundNumber(int value) {
        while (true) {
            if (value % 10 == 0)
                return value;
            value++;
        }
    }

    private static int deleteDigit(int n) {
        int answer = 0;
        ArrayList<Integer> digits = new ArrayList<>();
        while (n != 0) {
            digits.add(n % 10);
            n /= 10;
        }
        int number = 0;
        for (int deletedIndex = 0; deletedIndex < digits.size(); deletedIndex++) {
            number = 0;
            for (int i = digits.size() - 1; i > -1; i--) {
                if (i != deletedIndex) {
                    number = number * 10 + digits.get(i);
                }
            }
            answer = Math.max(number, answer);
        }
        return answer;
    }

    private static String caseUnification(String inputString) {
        int lowerCount = 0, upperCount = 0;
        for (char ch : inputString.toCharArray()) {
            if (ch >= 'a' && ch <= 'z')
                lowerCount++;
            else
                upperCount++;
        }
        if (lowerCount >= upperCount)
            return inputString.toLowerCase();
        else
            return inputString.toUpperCase();

    }

    private static int differentValuesInMultiplicationTable(int n, int m) {
        int result = 0;
        for (int value = 1; value <= n * m; value++) {
            for (int i = 1; i <= Math.min(n, m); i++) {
                if ( value / i <= Math.max(n, m) && value % i == 0 ) {
                    result++;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // System.out.println(trailingZeros(8));
        // System.out.println(toDecimal(2, "1101"));
        // System.out.println(nearestRoundNumber(122));
        // System.out.println(deleteDigit(152));
        // System.out.println(caseUnification("Aba"));
        // System.out.println(caseUnification("ABa"));
        System.out.println(differentValuesInMultiplicationTable(3, 2));
    }

}
