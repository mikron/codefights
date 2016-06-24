package am.lsoft.dev;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * Created by Davit on 16/06/16.
 */
public class TournamentDay17 {

    static String wordAbbreviation(String a) {
        int[] countLetters = new int[26];
        String result = new String();
        for (int i = 0; i < 26; i++) {
            countLetters[i] = 0;
        }
        for (int i = 0; i < a.length(); i++) {
            countLetters[(int) a.charAt(i) - (int) 'a']++;
        }
        for (int i = 0; i < 25; i++) {
            if (countLetters[i] % 2 == 1) {
                result += (char) ((int) 'a' + i);
            }
            countLetters[i + 1] += countLetters[i] / 2;
        }
        return result;
    }

    static int waterTubes(int[] water, int[] flowPerMinute) {
        int result = 0;

        for (int i = 0; i < water.length; i++) {
            int minutes = water[i] / flowPerMinute[i];
            if (water[i] % flowPerMinute[i] != 0) {
                minutes++;
            }
            if (result < minutes) {
                result = minutes;
            }
        }
        return result;
    }

    /*static int sign(int a) {
        if (a == 0) return 0;
        return a / Math.abs(a);
    }

    static int zigzag(int[] a) {
        if (a.length == 1) return 1;
        if (a.length == 2) return 2;
        int[] diff = new int[a.length - 1];

        for (int i = 1; i < a.length; i++) {
            diff[i - 1] = a[i] - a[i - 1];
        }
        int prevsign = sign(diff[0]);
        int count = 0;
        if (prevsign != 0)
            count = 1;
        for (int i = 1; i < diff.length; i++) {
            int sign = sign(diff[i]);
            if (prevsign * sign == -1) {
                prevsign = sign;
                count++;
            }
        }
        return count + 1;
    }*/

    /*static int zigzag(int[] a) {
        //dp[i, 0] = maximum length subsequence ending at i such that the difference between the
        // last two elements is positive
        // dp[i, 1] = same, but difference between the last two is negative
        int[][] dp = new int[a.length][2];
        int res = 0;
        for (int i = 0; i < a.length; i++) {
            dp[i][0] = 1;
            dp[i][1] = 1;

            for (int j = 0; j < i; j++) {
                if (a[i] > a[j])
                    dp[i][0] = Math.max(dp[j][1] + 1, dp[i][0]);
                else if (a[i] < a[j])
                    dp[i][1] = Math.max(dp[j][0] + 1, dp[i][1]);
            }

            if (res < Math.max(dp[i][0], dp[i][1]))
                res = Math.max(dp[i][0], dp[i][1]);

        }
        return res;
    }*/

    static int zigzag(int[] a) {
        ArrayList<ArrayList<Integer>> zigzags = new ArrayList<>();
        ArrayList<Integer> a0 = new ArrayList<>();
        a0.add(a[0]);
        zigzags.add(a0);

        for (int i = 1; i < a.length; i++) {
            if ((i == a.length - 1 && a[i] != a[i - 1])
                    || (a[i] > a[i - 1] && a[i] > a[i + 1])
                    || (a[i] < a[i - 1] && a[i] < a[i + 1])) {
                zigzags.get(zigzags.size() - 1).add(a[i]);
            } else {
                if (i != a.length - 1)
                    zigzags.get(zigzags.size() - 1).add(a[i]);
                ArrayList<Integer> ai = new ArrayList<>();
                ai.add(a[i]);
                zigzags.add(ai);
            }
        }

        int result = 0;
        for (ArrayList<Integer> arr : zigzags) {
            if (arr.size() > result)
                result = arr.size();
        }
        return result;//zigzags.Max(m = > m.Count());
    }

    static String fancyRide(int l, double[] fares) {
        String[] cars = {"UberX", "UberXL", "UberPlus", "UberBlack", "UberSUV"};
        String answer = "";
        for (int i = 0; i < 5; i++) {
            if (fares[i] * l <= 20) {
                answer = cars[i];
            }
        }
        return answer;
    }

    static String longestDigitsPrefix(String inputString) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) >= '0' && inputString.charAt(i) <= '9') {
                result.append(inputString.charAt(i));
            } else {
                break;
            }
        }
        return result.toString();
    }

    static boolean regularBracketSequence2(String s) {
        Stack<Character> q = new Stack<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (ch == '(' || ch == '[') {
                q.push(ch);
            } else if (ch == ')' && !q.empty() && q.peek() == '(') {
                q.pop();
            } else if (ch == ']' && !q.empty() && q.peek() == '[') {
                q.pop();
            } else {
                return false;
            }
        }
        return q.size() == 0;
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

    static int oddNumbersBeforeZero(int[] sequence) {
        int count = 0;
        for (int i = 0; i < sequence.length; i++) {
            if (sequence[i] == 0)
                return count;
            if (sequence[i] % 2 != 0)
                count++;
        }
        return count;
    }

    static int axisAlignedCirclesBoundingBox(int[] x, int[] y, int[] r) {

        int minX = x[0] - r[0],
                maxX = x[0] + r[0],
                minY = y[0] - r[0],
                maxY = y[0] + r[0];

        for (int i = 1; i < x.length; i++) {
            minX = Math.min(x[i] - r[i], minX);
            maxX = Math.max(x[i] + r[i], maxX);
            minY = Math.min(y[i] - r[i], minY);
            maxY = Math.max(y[i] + r[i], maxY);
        }

        return (maxX - minX) * (maxY - minY);
    }

    static int otherElementPosition(int x, int[] arr, int l, int h) {
        for (int i = l; i < Math.min(h + 1, arr.length); i++) {
            if (x != arr[i])
                return i;
        }
        return -1;
    }


    /*static int arrayEqualization(int[] a, int k) {
        int minTransForm = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            int[] tmp = a.clone();
            int x = a[i];
            int transfrom = 0;
            for (int j = 0; j < a.length; j = j + k) {
                boolean found = false;
                int otherElementPos = otherElementPosition(x, tmp, j, j + k);
                if (otherElementPos >= 0) {
                    for (int l = 0; l < k; l++) {
                        if (otherElementPos + l < a.length && x != tmp[otherElementPos + l]) {
                            tmp[otherElementPos + l] = x;
                            found = true;
                        }
                    }
                    if (found)
                        transfrom++;
                }
            }
            if (transfrom < minTransForm) {
                minTransForm = transfrom;
            }
        }
        return minTransForm;
    }*/

    static int arrayEqualization(int[] a, int k) {
        int minTransform = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            int[] tmp = a.clone();
            int x = a[i];
            int transform = 0;
            for (int j = 0; j < a.length; j = j + k) {
                boolean found = false;
                int otherElementPos = otherElementPosition(x, tmp, j, j + k);
                if (otherElementPos >= 0) {
                    for (int l = 0; l < k; l++) {
                        if (otherElementPos + l < a.length && x != tmp[otherElementPos + l]) {
                            tmp[otherElementPos + l] = x;
                            found = true;
                        }
                    }
                    if (found)
                        transform++;
                }
            }
            if (transform < minTransform)
                minTransform = transform;
        }
        return minTransform;

    }


    public static void main(String[] args) {
        // System.out.println(wordAbbreviation("aaaaa"));
        // System.out.println(waterTubes(new int[]{1, 2, 5}, new int[]{1, 1, 2}));
        // System.out.println(zigzag(new int[]{9, 8, 8, 5, 3, 5, 3, 2, 8, 6}));
        // System.out.println(fancyRide(20, new double[]{0.3, 0.5, 0.7, 1, 1.3}));
        // System.out.println(longestDigitsPrefix("123aa1"));
        // System.out.println(regularBracketSequence2("[()()]]"));
        // System.out.println(maxSumSegments(new int[] {-1, 2, 1, 3, -2}));
        // System.out.println(oddNumbersBeforeZero(new int[] {1, 2, 3, 0, 4, 5, 6, 0, 1}));
        // System.out.println(axisAlignedCirclesBoundingBox(new int[]{1, 0, 4}, new int[]{-1, 2, 2}, new int[]{3, 5, 4}));
        System.out.println(arrayEqualization(new int[]{1, 2, 2, 1, 2, 1, 2, 2, 2, 1, 1, 1}, 2));
        System.out.println(arrayEqualization(new int[]{5, 2, 3, 5, 2, 2, 3, 5, 1, 2, 5, 1, 2, 5, 3}, 7));
    }

}
