package am.lsoft.dev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Davit on 22/07/16.
 */
public class TournamentDay44 {

    private static int chessKnight(String cell) {
        int row = Integer.parseInt("" + cell.charAt(1)),
                column = cell.charAt(0) - 'a' + 1;
        int[][] steps = {
                {-2, -1}, {-1, -2}, {1, -2}, {2, -1},
                {2, 1}, {1, 2}, {-1, 2}, {-2, 1}
        };
        int answer = 0;

        for (int i = 0; i < steps.length; i++) {
            int tmpRow = row + steps[i][0];
            int tmpColumn = column + steps[i][1];
            if (tmpRow >= 1 && tmpRow <= 8 &&
                    tmpColumn >= 1 && tmpColumn <= 8) {
                answer++;
            }
        }

        return answer;
    }

    private static int zigzag(int[] a) {

        int best = 1;
        int left = 0;
        while (left < a.length) {
            int right = left + 1;
            while (right < a.length) {
                if (right == left + 1) {
                    if (a[left] == a[right]) {
                        break;
                    }
                } else {
                    if ((a[right - 1] - a[right - 2]) * (a[right - 1] - a[right]) <= 0) {
                        break;
                    }
                }
                right++;
            }
            if (right - left > best)
                best = right - left;
            left = right;
            if (left < a.length && a[left - 1] != a[left]) {
                left--;
            }
        }

        return best;
    }

    private static int increasingNumber(int X, int N) {
        for (int i = 1; i <= N; i++) {
            while (X % i != 0) {
                X++;
            }
        }
        return X;
    }

    private static int sumOfTheAngles(int n) {
        int result = 180 * n;
        result -= 180 * 2;
        return result;
    }

    private static boolean higherVersion(String ver1, String ver2) {

        String[] a = ver1.split("\\.");
        String[] b = ver2.split("\\.");
        for (int i = 0; i < a.length; i++) {
            int cmp = Integer.parseInt(a[i]) - Integer.parseInt(b[i]);
            if (cmp > 0) {
                return true;
            } else if (cmp < 0) {
                return false;
            }
        }

        return false;
    }

    private static int[] robotPath(String instructions, int bound) {

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int x = 0, y = 0;

        String directions = "LURD";

        for (int i = 0; i < instructions.length(); i++) {
            int dirIndex = 0;
            for (int j = 1; j < 4; j++) {
                if (instructions.charAt(i) == directions.charAt(j)) {
                    dirIndex = j;
                }
            }
            if (Math.abs(x + dx[dirIndex]) <= bound
                    && Math.abs(y + dy[dirIndex]) <= bound) {
                x += dx[dirIndex];
                y += dy[dirIndex];
            }
        }

        int[] res = new int[2];
        res[0] = x;
        res[1] = y;
        return res;
    }

    private static int[][] matrixSum(int[][] matrix1, int[][] matrix2) {
        int[][] result = new int[matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrix1.length; i++)
            for (int j = 0; j < matrix1[i].length; j++)
                result[i][j] = matrix1[i][j] + matrix2[i][j];
        return result;
    }

    private static String oneTwoMany(int n) {
        String answer = "";
        if (n == 1) {
            answer = "one";
        } else if (n == 2) {
            answer = "two";
        } else {
            answer = "many";
        }
        return answer;
    }

    private static int[] nextSecond(int[] currentTime) {

        if (currentTime[2] == 59) {
            currentTime[2] = 0;
            if (currentTime[1] == 59) {
                currentTime[1] = 0;
                currentTime[0] = (currentTime[0] + 1) % 24;
            } else {
                currentTime[1]++;
            }
        } else {
            currentTime[2]++;
        }

        return currentTime;
    }

    private static int[] onlyEvenNumbers(int left, int right) {
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = left; i <= right; i++)
            if (i % 2 == 0)
                a.add(i);

        return a.stream().mapToInt(i -> i).toArray();

    }

    private static int leastCommonPrimeDivisor(int a, int b) {

        for (int divisor = 2; a > 1 && b > 1; divisor++) {
            if (a % divisor == 0 && b % divisor == 0) {
                return divisor;
            }
            while (a % divisor == 0) {
                a /= divisor;
            }
            while (b % divisor == 0) {
                b /= divisor;
            }
        }

        return -1;
    }

    private static boolean charactersRearrangement(String string1, String string2) {
        boolean correct = true;

        char[] characters1 = string1.toCharArray();
        char[] characters2 = string2.toCharArray();

        Arrays.sort(characters1);
        Arrays.sort(characters2);

        for (int i = 0; i < Math.max(characters1.length, characters2.length); i++) {
            if (i >= characters1.length || i >= characters2.length || characters1[i] != characters2[i]) {
                correct = false;
                break;
            }
        }

        return correct;
    }

    private static boolean robotWalk(int[] a) {
        int minX = 0;
        int minY = -1;
        int maxX = Integer.MAX_VALUE;
        int maxY = Integer.MAX_VALUE;

        int x = 0;
        int y = 0;

        for (int i = 0; i < a.length; i++) {
            switch (i % 4) {

                case 0:
                    y += a[i];
                    if (y >= maxY) {
                        return true;
                    }
                    maxY = y;
                    break;

                case 1:
                    x += a[i];
                    if (x >= maxX) {
                        return true;
                    }
                    maxX = x;
                    break;

                case 2:
                    y -= a[i];
                    if (y <= minY) {
                        return true;
                    }
                    minY = y;
                    break;

                case 3:
                    x -= a[i];
                    if (x <= minX) {
                        return true;
                    }
                    minX = x;
                    break;
            }
        }

        return false;
    }

    private static int countSumOfTwoRepresentations(int n, int l, int r) {
        int result = 0;

        for (int a = l; a <= r; a++) {
            for (int b = a; b <= r; b++) {
                if (a + b == n) {
                    result++;
                }
            }
        }

        return result;
    }

    private static int squarePermutations(int n) {

        Map<String, Integer> lowest = new HashMap<>();
        Map<String, Integer> counts = new HashMap<>();

        for (int i = 1; ; i++) {
            char[] digits = String.valueOf(i * i).toCharArray();
            Arrays.sort(digits);
            String sortedDigits = String.valueOf(digits);

            int currentCount = 0;

            /*
            auto it = counts.find(sortedDigits);
            if (it != counts.end()) {
                currentCount = it->second + 1;

            } else {
                currentCount=1;
                lowest[sortedDigits] = i * i;
            }
            */
            counts.put(sortedDigits, currentCount);

            if (String.valueOf(i * i).length() < String.valueOf((i + 1) * (i + 1)).length()) {
                int best = 0;
                for (String key : counts.keySet()) {
                    if (counts.get(key) > n) {
                        if (best == 0 || best > lowest.get(key)) {
                            best = lowest.get(key);
                        }
                    }
                }
                if (best != 0) {
                    return best;
                }

                lowest.clear();
                counts.clear();
            }
        }
    }

    public static void main(String[] args) {
        // System.out.println(zigzag(new int[]{9, 8, 8, 5, 3, 5, 3, 2, 8, 6}));
        // System.out.println(robotWalk(new int[]{10, 3, 10, 2, 5, 1, 2}));
        // System.out.println(robotWalk(new int[]{4, 4, 3, 2, 2, 3}));
        System.out.println(squarePermutations(1));
    }

}
