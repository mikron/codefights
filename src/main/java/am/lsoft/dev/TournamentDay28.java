package am.lsoft.dev;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Davit on 29/06/16.
 */
public class TournamentDay28 {

    private static int differentSubstrings(String inputString) {

        ArrayList<String> substrings = new ArrayList<>();
        int result = 1;

        for (int i = 0; i < inputString.length(); i++) {
            for (int j = i + 1; j <= inputString.length(); j++) {
                substrings.add(inputString.substring(i, j));
            }
        }
        Collections.sort(substrings);
        for (int i = 1; i < substrings.size(); i++) {
            if (!substrings.get(i).equals(substrings.get(i - 1))) {
                result++;
            }
        }

        return result;
    }

    private static int semiprimeByNumber(int n) {

        class Helper {
            ArrayList<Integer> generatePrimes(int n) {
                int current = 2;
                ArrayList<Integer> primes = new ArrayList<>();

                while (primes.size() < n) {
                    boolean isPrime = true;
                    for (int i = 2; i * i <= current; i++) {
                        if (current % i == 0) {
                            isPrime = false;
                            break;
                        }
                    }
                    if (isPrime) {
                        primes.add(current);
                    }
                    current++;
                }
                return primes;
            }
        }
        Helper h = new Helper();

        ArrayList<Integer> semiprimes = new ArrayList<>();
        ArrayList<Integer> primes = h.generatePrimes(n);

        for (int i = 0; i < primes.size(); i++) {
            for (int j = i; j < primes.size(); j++) {
                semiprimes.add( primes.get(i) * primes.get(j) );
            }
        }
        Collections.sort(semiprimes);

        return semiprimes.get(n - 1);
    }

    public static void main(String[] args) {
        // System.out.println(differentSubstrings("abac"));
        System.out.println(semiprimeByNumber(1));
    }

}
