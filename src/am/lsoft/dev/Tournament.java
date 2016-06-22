package am.lsoft.dev;

import java.util.*;

/**
 * Created by Davit on 30/05/16.
 */
public class Tournament {

    static boolean parkingSpot(int[] carDimensions, int[][] parkingLot,
                               int[] luckySpot) {
        int L = carDimensions[0], W = carDimensions[1];
        int x1 = luckySpot[0], y1 = luckySpot[1];
        int x2 = luckySpot[2], y2 = luckySpot[3];
        boolean ok;
        if (x2 - x1 + 1 == W) {
            ok = true;
            for (int i = x1; i <= x2; i++) {
                for (int j = 0; j <= y2; j++) {
                    if (parkingLot[i][j] == 1) {
                        ok = false;
                    }
                }
            }
            if (ok) {
                return true;
            }
            ok = true;
            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j < parkingLot[0].length; j++) {
                    if (parkingLot[i][j] == 1) {
                        ok = false;
                    }
                }
            }
            if (ok) {
                return true;
            }
        } else {
            ok = true;
            for (int i = 0; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    if (parkingLot[i][j] == 1) {
                        ok = false;
                    }
                }
            }
            if (ok) {
                return true;
            }
            ok = true;
            for (int i = x1; i < parkingLot.length; i++) {
                for (int j = y1; j <= y2; j++) {
                    if (parkingLot[i][j] == 1) {
                        ok = false;
                    }
                }
            }
            if (ok) {
                return true;
            }
        }
        return false;
    }

    static int boxPiles(int[] a) {

        Arrays.sort(a);
        boolean[] used = new boolean[a.length];
        int usedNum = 0;
        int answer = 0;
        while (usedNum < used.length) {
            int height = 0;
            for (int i = 0; i < a.length; i++) {
                if (a[i] >= height && !used[i]) {
                    height++;
                    used[i] = true;
                    usedNum++;
                }
            }
            answer++;
        }

        return answer;
    }

    static String[] isDivisibleBy6(String inputString) {
        if (inputString.equals("*")) {
            return new String[]{"0", "6"};
        }
        ArrayList<Integer> nums = new ArrayList<>(inputString.length());
        int sum = 0;
        int asteriskPos;
        for (int i = 0; i < inputString.length(); i++) {
            if ((inputString.charAt(i) == '*')) {
                asteriskPos = i;
            } else {
                nums.add(((int) inputString.charAt(i) - 48));
                sum += ((int) inputString.charAt(i) - 48);
            }
        }
        ArrayList<Integer> needed = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if ((sum + i) % 3 == 0) {
                needed.add(i);
            }
        }
        ArrayList<String> res = new ArrayList<>();
        String tmp = "";
        for (Integer i : needed) {
            tmp = inputString.replace("*", String.valueOf(i));
            if (Double.parseDouble(tmp) % 2 == 0) {
                res.add(tmp);
            }
        }

        String[] stockArr = new String[res.size()];
        stockArr = res.toArray(stockArr);
        return stockArr;
        //return (String[]) res.toArray();

    }

    static boolean isMonotonous(int[] sequence) {
        if (sequence.length == 1) {
            return true;
        }
        int direction = sequence[1] - sequence[0];
        for (int i = 0; i < sequence.length - 1; i++) {
            if (direction * (sequence[i + 1] - sequence[i]) <= 0) {
                return false;
            }
        }
        return true;
    }

    static int factorizedGCD(int[] a, int[] b) {
        int j = 0,
                result = 1;
        for (int i = 0; i < a.length; i++) {
            while (j < b.length && a[i] > b[j]) {
                j++;
            }
            if (j < b.length && a[i] == b[j]) {
                result *= a[i];
                j++;
            }
        }
        return result;
    }

    static int[] videoPart(String part, String total) {

        class Helper {

            int getSeconds(String time) {
                int h = Integer.parseInt(time.substring(0, 2)),
                        m = Integer.parseInt(time.substring(3, 5)),
                        s = Integer.parseInt(time.substring(6, 8));
                return h * 60 * 60 + m * 60 + s;
            }

            int gcd(int a, int b) {
                while (a > 0) {
                    int tmp = a;
                    a = b % a;
                    b = tmp;
                }
                return b;
            }
        }
        Helper h = new Helper();

        int partTime = h.getSeconds(part);
        int totalTime = h.getSeconds(total);
        int divisor = h.gcd(partTime, totalTime);
        return new int[]{partTime / divisor, totalTime / divisor};
    }

    private static int[] convertIntegers(List<Integer> integers) {
        int[] ret = new int[integers.size()];
        Iterator<Integer> iterator = integers.iterator();
        for (int i = 0; i < ret.length; i++) {
            ret[i] = iterator.next().intValue();
        }
        return ret;
    }

    static int[][] blackAndWhiteBoard(int h, int w, String[] queries) {
        int[][] board = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                board[i][j] = 0;
            }
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> defValues = new ArrayList<>();
        defValues.add(-1);
        defValues.add(-1);
        String cmd;
        int x, y;
        for (int k = 0; k < queries.length; k++) {
            cmd = queries[k].substring(0, 1);
            x = Integer.parseInt(queries[k].substring(2, 3));
            y = Integer.parseInt(queries[k].substring(4, 5));
            if (cmd.equals("x")) {
                board[x][y] = 1;
            } else if (cmd.equals(">")) {
                boolean found = false;
                outerloop:
                for (int j = y + 1; j < w; j++) {
                    if (0 == board[x][j]) {
                        ArrayList<Integer> tmp = new ArrayList<>();
                        tmp.add(x);
                        tmp.add(j);
                        res.add(tmp);
                        found = true;
                        break outerloop;
                    }
                }
                if (!found) {
                    res.add(defValues);
                }
            } else if (cmd.equals("<")) {
                boolean found = false;
                outerloop:
                for (int j = y - 1; j >= 0; j--) {
                    if (0 == board[x][j]) {
                        ArrayList<Integer> tmp = new ArrayList<>();
                        tmp.add(x);
                        tmp.add(j);
                        res.add(tmp);
                        found = true;
                        break outerloop;
                    }
                }
                if (!found) {
                    res.add(defValues);
                }
            } else if (cmd.equals("v")) {
                boolean found = false;
                outerloop:
                for (int i = x + 1; i < h; i++) {
                    if (0 == board[i][y]) {
                        ArrayList<Integer> tmp = new ArrayList<>();
                        tmp.add(i);
                        tmp.add(y);
                        res.add(tmp);
                        found = true;
                        break outerloop;
                    }
                }
                if (!found) {
                    res.add(defValues);
                }
            } else if (cmd.equals("^")) {
                boolean found = false;
                outerloop:
                for (int i = x - 1; i >= 0; i--) {
                    if (0 == board[i][y]) {
                        ArrayList<Integer> tmp = new ArrayList<>();
                        tmp.add(i);
                        tmp.add(y);
                        res.add(tmp);
                        found = true;
                        break outerloop;
                    }
                }
                if (!found) {
                    res.add(defValues);
                }
            }
        }

        int[][] result = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            result[i] = convertIntegers(res.get(i));
        }


        return result;
    }


    public static void main(String[] args) {

        // System.out.println(blackAndWhiteBoard(3, 5, new String[]{"v 1 2", "x 2 2", "v 1 2", "> 2 1", "x 2 3", "> 2 1", "< 2 0"}));
        System.out.println(blackAndWhiteBoard(3, 3, new String[]{"> 1 0",
                "v 0 1",
                "< 1 2",
                "^ 2 1",
                "x 1 1",
                "> 1 0",
                "v 0 1",
                "< 1 2",
                "^ 2 1"}));

        // Uber parking
        /*int[] carDimensions = {2, 1};
        int[][] parkingLot = {{1,0,1},
                {1,0,1},
                {1,1,1}};
        int[] luckySpot = {0, 1, 1, 1};

        boolean res = parkingSpot(carDimensions, parkingLot, luckySpot);
        System.out.println(res);*/

        /*int[] boxes = {4, 3, 1, 1, 0, 0};
        System.out.println(boxPiles(boxes));*/

        //System.out.println(isMonotonous(new int[]{1, 4, 5, 7, 9}));
        //System.out.println(isMonotonous(new int[]{3, 3}));

        //System.out.println(factorizedGCD(new int[]{2, 3, 3, 3, 5}, new int[]{2, 2, 2, 2, 3, 3}));

        //System.out.println(videoPart("02:20:00", "07:00:00"));
        //System.out.println(videoPart("00:02:20", "00:10:00"));

    }

}

