package am.lsoft.dev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Davit on 20/06/16.
 */
public class TournamentDay20 {

    static boolean triangleExistence(int[] sides) {

        class MyComparator implements Comparator<Integer> {
            @Override
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        }
        Comparator<Integer> comparator = new MyComparator();

        ArrayList<Integer> sortedSides = new ArrayList<>(Arrays.asList(sides[0], sides[1], sides[2]));
        Collections.sort(sortedSides, comparator);

        if (sortedSides.get(0) + sortedSides.get(1) > sortedSides.get(2)) {
            return true;
        }
        return false;
    }

    static int periodicSequence(int S0, int A, int B, int M) {
        int[] occurrence = new int[M];
        int currentValue = S0;

        for (int i = 0; i < M; i++) {
            occurrence[i] = -1;
        }
        occurrence[S0] = 0;

        for (int i = 1; ; i++) {
            currentValue =  (currentValue * A + B) % M ;
            if (occurrence[currentValue] != -1) {
                return i - occurrence[currentValue];
            }
            occurrence[currentValue] = i;
        }
    }

    static String wordAbbreviation2(String a) {
        int[] letters = new int[26];
        String result = "";
        for (int i = 0; i < 26; i++) {
            letters[i] = 0;
        }
        for (int i = 0; i < a.length(); i++) {
            letters[(int) a.charAt(i) - (int) 'a']++;
        }
        for (int i = 0; i < 25; i++) {
            if (letters[i] % 2 == 1) {
                result += (char) ((int) 'a' + i);
            }
            letters[i + 1] += letters[i] / 2;
        }
        return result;
    }

    public static void main(String[] args) {
        // System.out.println(triangleExistence(new int[]{1, 2, 10}));
        // System.out.println(periodicSequence(11, 2, 6, 12));
        System.out.println(wordAbbreviation2("abcabc"));
    }

}
