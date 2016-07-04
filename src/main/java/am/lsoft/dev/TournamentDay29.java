package am.lsoft.dev;

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

    public static void main(String[] args) {
        // System.out.println(toAndFroNaive(2, 4, 5));
        // System.out.println(isSum(10));
        // System.out.println(isSum(11));
        System.out.println(electionsWinners(new int[]{2, 3, 5, 2}, 3));
        System.out.println(electionsWinners(new int[]{1, 1, 1, 1}, 0));
        System.out.println(electionsWinners(new int[]{1, 1, 1, 1}, 1));
    }

}
