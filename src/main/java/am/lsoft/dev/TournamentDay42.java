package am.lsoft.dev;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Davit on 18/07/16.
 */
public class TournamentDay42 {

    private static int percentageGreen(int green, int total) {
        return 100 * green / total;
    }

    private static String[] repeatedSubstring(String inputString, int k) {

        List<String> result = new ArrayList<>();
        boolean[] used = new boolean[inputString.length()];

        for (int i = 0; i + k <= inputString.length(); i++) {
            if (!used[i]) {
                used[i] = true;
                boolean found = false;
                for (int j = i + 1; j + k <= inputString.length(); j++) {
                    boolean equal = true;
                    for (int p = 0; p < k; p++) {
                        if (inputString.charAt(i + p) != inputString.charAt(j + p)) {
                            equal = false;
                            break;
                        }
                    }
                    if (equal) {
                        found = true;
                        used[j] = true;
                    }
                }
                if (found) {
                    StringBuilder occurence = new StringBuilder();
                    for (int l = i; l < i + k; l++)
                        occurence.append(inputString.charAt(l));
                    result.add(occurence.toString());
                }
            }
        }

        Collections.sort(result);
        return result.toArray(new String[result.size()]);
    }

    private static boolean isPrime(int n) {
        int divisor = 2;
        while (n > divisor) {
            if (n % divisor == 0) {
                return false;
            } else {
                divisor++;
            }
        }
        return true;
    }


    private static String[] repeatedSubstring2(String inputString, int k) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < inputString.length() - k + 1; i++) {
            String t = inputString.substring(i, i + k);
            for (int j = 0; j < inputString.length() - k + 1; j++) {
                if (inputString.substring(j, j + k).equals(t) && j != i && !ans.contains(t))
                    ans.add(t);
            }
        }

        return ans.toArray(new String[ans.size()]);
    }

    private static int countSumOfTwoRepresentations3(int n, int l, int r) {
        int result = 0;

        for (int i = 1; i <= n - i; i++) {
            if (l <= i && n - i <= r) {
                result++;
            }
        }

        return result;
    }

    private static boolean isBeautifulString(String inputString) {

        int len = inputString.length();
        for (char sym = 'a'; sym < 'z'; sym++) {
            int balance = 0;
            for (int i = 0; i < len; i++) {
                if (inputString.charAt(i) == sym) {
                    balance++;
                }
                if (inputString.charAt(i) == sym + 1) {
                    balance--;
                }
            }
            if (balance < 0) {
                return false;
            }
        }
        return true;
    }

    private static int uniqueChars(String s) {

        boolean[] was = new boolean[26];
        int best = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            int c = s.charAt(right) - 'a';
            while (was[c]) {
                was[s.charAt(left) - 'a'] = false;
                left++;
            }
            /// ...
        }

        return best;
    }

    private static boolean isArithmeticProgression(int[] sequence) {
        int distance = sequence[1] - sequence[0];
        for (int i = 2; i < sequence.length; i++)
            if (distance != sequence[i] - sequence[i - 1])
                return false;
        return true;
    }

    private static int firstMultiple2(int[] divisors, int start) {

        for (int answer = start; ; answer++) {
            for (int i = 0; i < divisors.length; i++) {
                if (answer % divisors[i] == 0) {
                    return answer;
                }
            }
        }
    }

    private static String knapsackLight2(int weight1, int weight2, int maxW) {

        if (weight1 + weight2 <= maxW) {
            return "both";
        }
        if (Math.min(weight1, weight2) > maxW) {
            return "none";
        }
        if (Math.max(weight1, weight2) <= maxW) {
            return "either";
        }
        if (weight1 <= maxW) {
            return "first";
        }
        return "second";
    }

    private static String lookAndSaySequenceNextElement(String inputString) {

        int consecutiveEqual = 1;
        StringBuilder result = new StringBuilder();
        inputString += '#';
        for (int i = 1; i < inputString.length(); i++) {
            if (inputString.charAt(i) != inputString.charAt(i - 1)) {
                result.append(consecutiveEqual);
                result.append(inputString.charAt(i - 1));
                consecutiveEqual = 1;
            } else {
                consecutiveEqual++;
            }
        }

        return result.toString();
    }

    private static int fixedPointsPermutation(int[] permutation) {

        int result = 0;

        for (int i = 0; i < permutation.length; i++) {
            if (permutation[i] == i + 1) {
                result++;
            }
        }

        return result;
    }

    private static int phoneCall(int min1, int min2_10, int min11, int S) {

        if (S < min1) {
            return 0;
        }
        for (int i = 2; i <= 10; i++) {
            if (S < min1 + min2_10 * (i - 1)) {
                return i - 1;
            }
        }
        return 10 + (S - min1 - min2_10 * 9) / min11;
    }

    private static boolean countOccur(int n) {
        int[] digits = new int[10];
        while (n != 0) {
            digits[n % 10]++;
            n /= 10;
        }
        for (int i : digits)
            if (i > 1)
                return false;
        return true;
    }

    private static int differentDigitsNumberSearch(int[] inputArray) {
        for (int i = 0; i < inputArray.length; i++)
            if (countOccur(inputArray[i]))
                return inputArray[i];

        return -1;
    }

    private static int pagesNumbering(int n) {

        int tenPower = 1,
                digitsPerPage = 1,
                result = 0;

        while (tenPower * 10 <= n) {
            result += tenPower * 10 * digitsPerPage;
            tenPower *= 10;
            digitsPerPage++;
        }
        result += (n - tenPower + 1) * digitsPerPage;

        return result;
    }

    private static int arithmeticProgression(int element1, int element2, int n) {
        return element2 < element1 ? 0 : element1 + (n - 1) * Math.abs(element2 - element1);
    }

    private static int alphabeticShiftEncoding(String inputString, String encodedString) {

        int result = inputString.length();
        for (int i = 0; i < inputString.length(); i++) {
            int mistakes = 0,
                    k = encodedString.charAt(i) - inputString.charAt(i);
            if (k < 0) {
                k += 26;
            }
            for (int j = i + 1; j < inputString.length(); j++) {
                if ((inputString.charAt(j) - 'a' + k) % 26 !=
                        encodedString.charAt(j) - 'a') {
                    mistakes++;
                }
            }
            result = Math.min(mistakes, result);
        }
        return result;
    }

    private static char firstDigit(String inputString) {

        java.util.regex.Pattern re = java.util.regex.Pattern.compile("[0-9]");
        java.util.regex.Matcher match = re.matcher(inputString);
        match.find();
        return inputString.charAt(match.start());
    }

    private static int firstMultiple(int[] divisors, int start) {
        for (int answer = start; ; answer++) {
            boolean found = true;
            for (int div : divisors)
                if (answer % div != 0)
                    found = false;
            if (found)
                return answer;
        }
    }

    private static int sumUpNumbers(String inputString) {
        int sum = 0;
        String num = "";
        for (int i = 0; i < inputString.length(); i++) {
            if ('0' <= inputString.charAt(i) && inputString.charAt(i) <= '9') {
                num += inputString.charAt(i);
            } else {
                if (!num.equals(""))
                    sum += Integer.parseInt(num);
                num = "";
            }
        }
        if (!num.equals(""))
            sum += Integer.parseInt(num);
        return sum;
    }


    public static void main(String[] args) {
        // System.out.println(Arrays.toString(repeatedSubstring("abacabadabacaba", 6)));
        // System.out.println(Arrays.toString(repeatedSubstring2("abacabadabacaba", 6)));
        // System.out.println(countSumOfTwoRepresentations3(6, 2, 4));
        // System.out.println(uniqueChars("abcabba"));
        // System.out.println(lookAndSaySequenceNextElement("1"));
        // System.out.println(differentDigitsNumberSearch(new int[]{22, 111, 101, 124, 33, 30}));
        // System.out.println(pagesNumbering(11));
        // System.out.println(alphabeticShiftEncoding("xyza", "abdd"));
        System.out.println(firstDigit("var_1__Int"));
    }

}
