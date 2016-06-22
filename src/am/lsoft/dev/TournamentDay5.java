package am.lsoft.dev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

/**
 * Created by Davit on 03/06/16.
 */
public class TournamentDay5 {

    static String replaceFirstDigitRegExp(String input) {
        return input.replaceFirst("[1-9]", "#");
    }

    static int[] maxSumSegments(int[] inputArray) {

        int[] result = new int[inputArray.length];
        for (int i = 1; i <= inputArray.length; i++) {
            int sum = 0,
                    mxSum = 0,
                    index = -1;
            for (int j = 0; j < inputArray.length; j++) {
                sum += inputArray[j];
                if (j >= i) {
                    sum -= inputArray[j - i];
                }
                if (j >= i - 1 && (index == -1 || sum > mxSum)) {
                    mxSum = sum;
                    index = j - i + 1;
                }
            }
            result[i - 1] = index;
        }
        return result;
    }

    static boolean regularBracketSequence1(String sequence) {
        if (sequence.charAt(0) == ')')
            return false;
        Stack<Character> stack = new Stack<>();
        char c;
        for (int i = 0; i < sequence.length(); i++) {
            c = sequence.charAt(i);

            if (c == '(')
                stack.push(c);
            else if (c == ')')
                if (stack.empty())
                    return false;
                else if (stack.peek() == '(')
                    stack.pop();
                else
                    return false;
        }
        return stack.empty();
    }

    static boolean checkSameElementExistence(int[] arr1, int[] arr2) {

        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] == arr2[j]) {
                return true;
            }
            if (arr1[i] < arr2[j]) {
                i++;
            } else {
                j++;
            }
        }

        return false;
    }

    static int chessBoardSquaresUnderQueenAttack2(int a, int b) {
        if (a == 1 || b == 1) {
            if (a == 1 && b == 1)
                return 0;
            else if (a > 1)
                return (a - 1) * b;
            else if (b > 1)
                return a * (b - 1);
        }
        return chessBoardSquaresUnderQueenAttack2(a - 1, b - 1) + 3;
    }

    /*static int chessBoardSquaresUnderQueenAttackR(int a, int b) {
        return a * b * chessBoardSquaresUnderQueenAttack2(a, b) + Math.abs(a - b) * 2;
    }*/

    /*static int chessBoardSquaresUnderQueenAttack(int a, int b) {
        int[][] chessBoard = new int[a][b];

        int sum = 0;
        for (int k = 0; k < a * b; k++) {
            // clear the matrix
            for (int i = 0; i < a; i++) {
                for (int j = 0; j < b; j++) {
                    chessBoard[i][j] = 0;
                }
            }

            for (int i = 0; i < a; i++) {
                for (int j = 0; j < b; j++) {
                    if ((i == k && j != k) || (i != k && j == k)) {
                        if (chessBoard[i][j] == 0) {
                            chessBoard[i][j] = 1;
                            sum++;
                        }
                    }
                    if (i > 0 && j > 0) {
                        if (k + j < a && k + j < b) {
                            if (chessBoard[k + j][k + j] == 0) {
                                chessBoard[k + j][k + j] = 1;
                                sum++;
                            }
                        }
                        if (k - j > 0 && k - j > 0 && k - j < b) {
                            if (chessBoard[k - j][k - j] == 0) {
                                chessBoard[k - j][k - j] = 1;
                                sum++;
                            }
                        }
                        if (k + j < a && k - j > 0 && k - j < b) {
                            if (chessBoard[k + j][k - j] == 0) {
                                chessBoard[k + j][k - j] = 1;
                                sum++;
                            }
                        }
                        if (k - j > 0 && k + j < b && k - j < b) {
                            if (chessBoard[k - j][k + j] == 0) {
                                chessBoard[k - j][k + j] = 1;
                                sum++;
                            }
                        }
                    }
                }
            }
        }

        return sum;
    }*/

    static int chessBoardSquaresUnderQueenAttack(int a, int b) {
        int ret = 0;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                for (int x = 0; x < a; x++) {
                    for (int y = 0; y < b; y++) {
                        if (i == x || y == j || Math.abs(i - x) == Math.abs(j - y)) ret++;
                    }
                }
            }
        }
        return ret - a * b;
    }

    static int imagesOverlapping(boolean[][] largeImg, boolean[][] smallImg) {
        int A = largeImg.length, B = largeImg[0].length;
        int C = smallImg.length, D = smallImg[0].length;
        int ans = 0;
        for (int i = 0; i <= A - C; i++) {
            for (int j = 0; j <= B - D; j++) {
                int ok = 1;
                for (int x = 0; x < C; x++) {
                    for (int y = 0; y < D; y++) {
                        if (largeImg[i + x][j + y] && smallImg[x][y])
                            ok = 0;
                    }
                }
                if (ok == 1)
                    ans++;
            }
        }
        return ans;
    }

    static boolean isMAC48Address(String inputString) {

        for (int i = 0; i < inputString.length(); i++) {
            if (i % 3 == 2) {
                if (inputString.charAt(i) != '-' || (inputString.charAt(i) == '-' && i == inputString.length() - 1)) {
                    return false;
                }
            } else {
                char sym = inputString.charAt(i);
                if (!('0' <= sym && sym <= '9' || 'A' <= sym && sym <= 'F' || sym == '-')) {
                    return false;
                }
            }
        }

        return true;
    }

    static int toAndFro(int a, int b, int t) {

        int len = Math.abs(b - a);
        t %= (2 * len);
        if (t <= len) {
            return Math.min(a, b) + t;
        } else {
            t -= len;
            return b + (a - b) / Math.abs(a - b) * t;
        }
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
        Helper h = new Helper();
        int bestRes = 0;
        for (int i = 0; i < sequence.length; i++) {
            int result = sequence[0];
            //
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

    static int kthDivisor(int n, int k) {
        int nth = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                nth++;
                if (nth == k) {
                    return i;
                }
            }
        }
        return -1;
    }

    static int alphabeticShiftEncoding(String inputString, String encodedString) {

        class Helper {
            Helper() {
            }

            int commonChars(String s1, String s2) {
                HashSet<Character> h1 = new HashSet<>(),
                        h2 = new HashSet<>();
                for (int i = 0; i < s1.length(); i++) {
                    h1.add(s1.charAt(i));
                }
                for (int i = 0; i < s2.length(); i++) {
                    h2.add(s2.charAt(i));
                }
                h1.retainAll(h2);
                return h1.size();
                /*Character[] res = h1.toArray(new Character[0]);
                return res.length;*/
            }

            String cipher(String msg, int shift) {
                String s = "";
                int len = msg.length();
                for (int x = 0; x < len; x++) {
                    if (shift < 0) {
                        char c = (char) (msg.charAt(x) + shift);
                        if (c < 'a')
                            s += (char) (msg.charAt(x) + (26 + shift));
                        else
                            s += (char) (msg.charAt(x) + shift);
                    } else {
                        char c = (char) (msg.charAt(x) + shift);
                        if (c > 'z')
                            s += (char) (msg.charAt(x) - (26 - shift));
                        else
                            s += (char) (msg.charAt(x) + shift);
                    }
                }
                return s;
            }
        }

        Helper helper = new Helper();
        int min = inputString.length();
        for (int i = 0; i < 26; i++) {
            String cipher = helper.cipher(inputString, i);
            String cipherMinus = helper.cipher(inputString, -1 * i);
            int matches = 0;

            int commonChars = helper.commonChars(cipher, encodedString);
            if (commonChars > 0) {
                matches = commonChars;
            } else {
                commonChars = helper.commonChars(cipherMinus, encodedString);
                if (commonChars > 0) {
                    matches = commonChars;
                }
            }

            int errorLen = inputString.length() - matches;
            if (errorLen < min) {
                min = errorLen;
            }
        }
        return min;
    }

    static int alphabeticShiftEncoding2(String s, String t) {
        int a[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char cc = t.charAt(i);
            if (cc < s.charAt(i))
                cc += 26;
            a[cc - s.charAt(i)]++;
        }
        Arrays.sort(a);
        return s.length() - a[25];
    }


    public static void main(String[] args) {
        // System.out.println(replaceFirstDigitRegExp("There are 12 points"));
        // System.out.println(maxSumSegments(new int[]{-1, 2, 1, 3, -2}));
        // System.out.println(regularBracketSequence1("(())()()()"));
        // System.out.println(checkSameElementExistence(new int[]{1000, 2000, 3000, 4000, 5000},
        //                new int[]{5000, 6000, 7000, 8000}));
        //System.out.println(chessBoardSquaresUnderQueenAttack(3, 2));
        //System.out.println(imagesOverlapping(new boolean[][]{{false, true, false}, {true, false, true}}, new boolean[][]{{true, false}}));
        //System.out.println(isMAC48Address("02-03-04-05-06-07-"));
        // System.out.println(toAndFro(1, 10, 8));
        //System.out.println(maxGCD(new int[]{5, 3, 9}));
        // System.out.println(kthDivisor(16, 5));
        // System.out.println(alphabeticShiftEncoding("xyza", "abdd"));
        System.out.println(alphabeticShiftEncoding2("xyza", "abdd"));
    }

}
