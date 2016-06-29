package am.lsoft.dev;

/**
 * Created by Davit on 21/06/16.
 */
public class TournamentDay21 {

    static int depositProfit(int deposit, int rate, int threshold) {

        int[] fraction = new int[2];
        fraction[0] = deposit;
        fraction[1] = 1;
        int year = 0;

        while (fraction[0] > threshold) {
            fraction[0] *= 100 + rate;
            fraction[1] *= 100;
            year++;
        }

        return year;
    }

    static int visitsOnCircularRoad(int N, int[] visitsOrder) {

        int current = 1,
                res = 0;
        for (int i = 0; i < visitsOrder.length; i++) {
            res += Math.min(Math.abs(visitsOrder[i] - current),
                    N - Math.abs(visitsOrder[i] - current));
            current = visitsOrder[i];
        }
        return res;
    }

    public static void main(String[] args) {
        // System.out.println(depositProfit(100, 10, 130));
        System.out.println(visitsOnCircularRoad(4, new int[]{1, 3, 2, 3, 1}));
    }

}
