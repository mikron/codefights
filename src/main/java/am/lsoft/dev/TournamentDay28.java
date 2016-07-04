package am.lsoft.dev;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

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

    private static int[] bfsDistancesUnweightedGraph(boolean[][] matrix, int startVertex) {
        int[] distances = new int[matrix.length];
        Queue<Integer> queue = new LinkedList<>();
        int number_of_nodes = matrix[startVertex].length - 1;
        boolean[] visited = new boolean[number_of_nodes + 1];
        int i, element;
        visited[startVertex] = true;
        queue.add(startVertex);
        while (!queue.isEmpty()) {
            distances[startVertex]++;
            element = queue.remove();
            i = element;
            System.out.print(i + "\t");
            while (i <= number_of_nodes) {
                if (matrix[element][i] && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
                i++;
            }
        }
        return distances;
    }

    private static String mySubstringByLength(String inputString, int start, int length) {

        char[] result = new char[length];
        int k = 0;
        for (int i = start; i < start + length; i++) {
            result[k++] = inputString.charAt(i);
        }
        return new String(result);
    }

    private static int circleOfNumbers(int n, int firstNumber) {
        return (firstNumber + n / 2) % n;
    }

    private static int toAndFroNaive(int a, int b, int t) {
        int len = Math.abs(b - a);
        t %= (2 * len);
        if (t <= len)
            return Math.min(a, b) + t;
        else {
            t -= len;
            return b + (a - b) / Math.abs(a - b) * t;
        }
    }

    private static String bijectiveBase10(int a) {
        ArrayList<Integer> result = new ArrayList<>();
        StringBuilder strResult = new StringBuilder();
        while (a > 0) {
            result.add(a % 10);
            a /= 10;
        }
        for (int i = 0; i < result.size(); i++) {
            if (i + 1 < result.size() && result.get(i) <= 0) {
                result.set(i, result.get(i) + 10);
                result.set(i + 1, result.get(i + 1) - 1);
            }
        }
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i) == 10) {
                strResult.append('A');
            } else if (result.get(i) != 0) {
                strResult.append(result.get(i));
            }
        }
        strResult.reverse();
        return strResult.toString();
    }

    private static Integer arrayConversion(ArrayList<Integer> inputArray) {

        int operation = 1;
        while (inputArray.size() > 1) {
            ArrayList<Integer> newArray = new ArrayList<>();
            for (int i = 0; i < inputArray.size(); i += 2) {
                if (operation % 2 == 1) {
                    newArray.add(inputArray.get(i) + inputArray.get(i + 1));
                } else {
                    newArray.add(inputArray.get(i) * inputArray.get(i + 1));
                }
            }
            inputArray = newArray;
            operation++;
        }

        return inputArray.get(0);
    }

    private static boolean cyclicSequence(int[] sequence) {
        for (int i = 0; i < sequence.length; i++) {
            ArrayList<Integer> inc = new ArrayList<>();
            for (int j = i; j < sequence.length + i - 1; j++) {
                int k = j;
                if (k >= sequence.length)
                    k = Math.abs(k - sequence.length);

                int p = k - 1;
                if (p < 0)
                    p = sequence.length - 1;

                if (sequence[k] > sequence[p])
                    inc.add(sequence[k]);
            }
            if (inc.size() + 1 == sequence.length)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // System.out.println(differentSubstrings("abac"));
        // System.out.println(semiprimeByNumber(1));
        /*System.out.println(Arrays.toString(bfsDistancesUnweightedGraph(new boolean[][]{{false, false, true},
                {false, false, true},
                {true, true, false}}, 0)));*/
        // System.out.println(mySubstringByLength("abcde", 2, 3));
        // System.out.println(circleOfNumbers(10, 2));
        // System.out.println(circleOfNumbers(10, 7));
        // System.out.println(circleOfNumbers(12, 6));
        // System.out.println(circleOfNumbers(12, 7));
        // System.out.println(toAndFroNaive(2, 4, 3));
        // System.out.println(bijectiveBase10(12345));
        // System.out.println(arrayConversion(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
        System.out.println(cyclicSequence(new int[]{5, 9, 1, 2, 4}));
        System.out.println(cyclicSequence(new int[]{1, 3, 2}));
    }

}
