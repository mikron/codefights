package am.lsoft.dev;

import java.util.ArrayList;

/**
 * Created by Davit on 11/06/16.
 */
public class TournamentDay12 {

    static int smallestMultiple(int left, int right) {
        int result = right;
        int k = 0;
        while (k < right * left) {
            for (int i = left; i <= right; i++) {
                if (result % i != 0) {
                    result++;
                    break;
                } else {
                    k++;
                }
            }
        }
        return result;
    }

    static String[] isDivisibleBy6(String inputString) {

        ArrayList<String> ar = new ArrayList();
        for (char c = '0'; c <= '9'; c++) {

            String s = inputString.replace('*', c);
            try {
                if (Long.parseLong(s) % 6 == 0) {
                    ar.add(s);
                }
            } catch (Exception e) {

            }
        }

        return ar.toArray(new String[0]);
    }

    public static void main(String[] args) {
        // System.out.println(smallestMultiple(2, 4));
        System.out.println(isDivisibleBy6("1*0"));
    }

}
