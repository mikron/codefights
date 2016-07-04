package am.lsoft.dev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by Davit on 04/07/16.
 */
public class TournamentDay29 {

    private static int toAndFroNaive(int a, int b, int t) {

        int position = a,
                dx;

        if (a < b) {
            dx = 1;
        } else {
            dx = -1;
        }

        for (int i = 0; i < t; i++) {
            position += dx;
            if (position == a || position == b) {
                dx = -1 * dx;
            }
        }

        return position;
    }

    private static boolean isSum(int value) {
        long calc_num = 8 * value + 1;
        long t = (long) Math.sqrt(calc_num);
        if (t * t == calc_num) {
            return true;
        }
        return false;
    }

    private static int electionsWinners(int[] votes, int k) {
        int ma = 0;
        for (int i = 0; i < votes.length; i++)
            ma = Math.max(ma, votes[i]);
        int cnt = 0;
        for (int i = 0; i < votes.length; i++)
            if (votes[i] + k > ma)
                cnt++;
        if (cnt == 0) {
            for (int i = 0; i < votes.length; i++)
                if (votes[i] == ma)
                    cnt++;
            if (cnt > 1)
                cnt = 0;
        }
        return cnt;
    }

    private static int arraySumAdjacentDifference(int[] inputArray) {

        int answer = 0;
        for (int i = 1; i < inputArray.length - 1; i++) {
            answer += Math.abs(inputArray[i] - inputArray[i - 1]);
        }
        return answer;
    }

    private static String[] allLongestStrings(String[] inputArray) {

        ArrayList<String> answer = new ArrayList<>(Arrays.asList(inputArray[0]));
        for (int i = 1; i < inputArray.length; i++) {
            if (inputArray[i].length() == answer.get(0).length()) {
                answer.add(inputArray[i]);
            }
            if (inputArray[i].length() > answer.get(0).length()) {
                answer = new ArrayList<>(Arrays.asList(inputArray[i]));
            }
        }
        return answer.toArray(new String[0]);
    }

    private static int sumUpDigits(String inputString) {

        int answer = 0;

        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) >= '0' && inputString.charAt(i) <= '9') {
                answer += inputString.charAt(i) - '0';
            }
        }

        return answer;
    }

    private static int makeArrayConsecutive2(int[] sequence) {
        Arrays.sort(sequence);
        HashSet<Integer> fullArray = new HashSet<>(sequence.length);
        for (int i = sequence[0]; i <= sequence[sequence.length - 1]; i++)
            fullArray.add(i);
        return fullArray.size() - sequence.length;
    }


    public static void main(String[] args) {
        // System.out.println(toAndFroNaive(2, 4, 5));
        // System.out.println(isSum(10));
        // System.out.println(isSum(11));
        // System.out.println(electionsWinners(new int[]{2, 3, 5, 2}, 3));
        // System.out.println(electionsWinners(new int[]{1, 1, 1, 1}, 0));
        // System.out.println(electionsWinners(new int[]{1, 1, 1, 1}, 1));
        // System.out.println(allLongestStrings(new String[]{"aba", "aa", "ad", "vcd", "aba"});
        System.out.println(makeArrayConsecutive2(new int[]{6, 2, 3, 8}));
    }

}
