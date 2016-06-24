package am.lsoft.dev;

import java.util.ArrayList;

/**
 * Created by Davit on 23/06/16.
 */
public class TournamentDay23 {

    // https://codefights.com/challenge/iBJCkwKHBdMiuxfHF/solutions
    //  a = 0011 1100
    // ~a = 1100 0011
    private static int pattern(int n) {
        // String s = Integer.toBinaryString(n);
        return (3 << ~-n) - 2;
    }

    /*private static int WordScore(String word) {
        System.out.println(word.chars().sum() - word.length() * 'a' + word.length());
        int sum = 0;
        for (char c : word.toCharArray())
            sum += c - 'a' + 1;
        return sum;
    }*/

    private static int WordScore(String w) {
        return w.chars().map(i -> i - 96).sum();
    }


    private static int zerosAndOnes(String s) {
        int answer = s.length();
        ArrayList<Character> stack = new ArrayList<>();
        int topElem = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                stack.clear();
                topElem = -1;
            } else {
                if (topElem >= 0 && stack.get(topElem) != s.charAt(i)) {
                    topElem--;
                    answer -= 2;
                } else {
                    if (topElem + 1 < stack.size()) {
                        stack.set(++topElem, s.charAt(i));
                    } else {
                        topElem++;
                        stack.add(s.charAt(i));
                    }
                }
            }
        }
        return answer;
    }

    static boolean isSkewSymmetricMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                if (matrix[i][j] != -matrix[j][i])
                    return false;
        return true;
    }

    public static void main(String[] args) {
        // System.out.println(pattern(1));
        // System.out.println(WordScore("skills"));
        // System.out.println(zerosAndOnes("111*000"));
        System.out.println(isSkewSymmetricMatrix(new int[][]{{0, 0, 1}, {0, 0, -2}, {-1, 2, 0}}));
    }

}
