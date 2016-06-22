package am.lsoft.dev;

import java.util.ArrayList;

/**
 * Created by Davit on 06/06/16.
 */
public class TournamentDay7 {

    static boolean bishopAndPawn(String cell1, String cell2) {
        class Parser {
            int getX(char pos) {
                return pos - 'A';
            }

            int getY(char pos) {
                return pos - '1';
            }
        }
        Parser p = new Parser();

        int x1 = p.getX(cell1.charAt(0)),
                y1 = p.getY(cell1.charAt(1)),
                x2 = p.getX(cell2.charAt(0)),
                y2 = p.getY(cell2.charAt(1));

        if (x1 + y1 == x2 + y2 || x1 - y1 == x2 - y2) {
            return true;
        }

        return false;
    }

    static int[] robotPath(String instructions, int bound) {
        class Helper {
            Helper() {
            }

            int[] point(int x, int y) {
                return new int[]{x, y};
            }

            void takeStep(int[] point, Character step, int bound) {
                switch (step) {
                    case 'L': {
                        if (point[0] - 1 < -1 * bound) {
                            break;
                        } else {
                            point[0] = point[0] - 1;
                            break;
                        }
                    }
                    case 'R': {
                        if (point[0] + 1 > bound) {
                            break;
                        } else {
                            point[0] = point[0] + 1;
                            break;
                        }
                    }
                    case 'U': {
                        if (point[1] + 1 > bound) {
                            break;
                        } else {
                            point[1] = point[1] + 1;
                            break;
                        }
                    }
                    case 'D': {
                        if (point[1] - 1 < -1 * bound) {
                            break;
                        } else {
                            point[1] = point[1] - 1;
                            break;
                        }
                    }
                }
            }
        }
        Helper helper = new Helper();
        int[] currentPos = helper.point(0, 0);
        for (int i = 0; i < instructions.length(); i++) {
            helper.takeStep(currentPos, instructions.charAt(i), bound);
        }
        return currentPos;
    }

    static int[] powersOfTwo(int n) {

        ArrayList<Integer> ans = new ArrayList<>();
        int cur = 1;
        while (n > 0) {
            if ((n & 1) != 0) {
                ans.add(cur);
            }
            n >>= 1;
            cur <<= 1;
        }

        int[] a = new int[ans.size()];
        for (int i = 0; i < a.length; i++) {
            a[i] = ans.get(i);
        }

        return a;
    }

    static int arrayMaxConsecutiveSum(int[] inputArray, int k) {

        int result = 0,
                currentSum = 0;

        for (int i = 0; i < k - 1; i++) {
            currentSum += inputArray[i];
        }
        for (int i = k - 1; i < inputArray.length; i++) {
            currentSum += inputArray[i];
            if (currentSum > result) {
                result = currentSum;
            }
            currentSum -= inputArray[i - k + 1];
        }

        return result;
    }

    static int factorialsProductTrailingZeros(int l, int r) {

        class Helper {
            Helper() {
            }

            int trailingZeroCount(int n) {
                int answer = 0;
                int power = 1;
                while ((int) Math.pow(5, power) <= n) {
                    answer += n / (int) Math.pow(5, power);
                    power++;
                }
                return answer;
            }
        }

        Helper helper = new Helper();
        int count = 0;
        for (int i = l; i <= r; i++) {
            count += helper.trailingZeroCount(i);
        }
        return count;
    }

    static int sequenceElement(int[] a, int n) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return ((n * (n + 1)) / 2) % 10 - sum;

        /*int[] result = new int[5];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i];
        }
        int a1, a2, a3, a4, a5;
        for (int i = 0; i <= n - 5; i++) {
            a1 = result[0];
            a2 = result[1];
            a3 = result[2];
            a4 = result[3];
            a5 = result[4];
            result[4] = (a1 + a2 + a3 + a4 + a5) % 10;
            result[3] = a5;
            result[2] = a4;
            result[1] = a3;
            result[0] = a2;
        }
        return result[4];*/
    }

    static int parabole(int a, int b, int c, int x) {
        return (int) (a * Math.pow(x, 2) + b * x + c);
    }

    public static void main(String[] args) {
        // System.out.println(bishopAndPawn("A1", "C3"));
        // System.out.println(robotPath("LLLLUUUUDR", 2));
        // System.out.println(powersOfTwo(5));
        // System.out.println(arrayMaxConsecutiveSum(new int[]{2, 3, 5, 1, 6}, 2));
        // System.out.println(factorialsProductTrailingZeros(4, 10));
        // System.out.println(sequenceElement(new int[]{1, 2, 3, 4, 5}, 9));
        System.out.println(parabole(1, 2, 3, -1));
    }

}

