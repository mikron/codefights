package am.lsoft.dev;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Davit on 15/07/16.
 */
public class TournamentDay39 {

    private static String[] splitAddress(String address) {
        String protocol = "",
                domain = "",
                context = "";
        String[] result = address.split("://");

        protocol = result[0];
        result = result[1].split("\\.com");
        domain = result[0];
        if (result.length > 1) {
            context = result[1].substring(1);
            return new String[]{protocol, domain, context};
        }
        return new String[]{protocol, domain};
    }

    private static int numberGuessingNaive(int n) {

        int[] pay = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            pay[i] = i;
            for (int m = 1; m < i; m++) {
                pay[i] = Math.max(pay[i], m);
            }
        }

        return pay[n];
    }

    private static ArrayList<Integer> arrayCenter(ArrayList<Integer> A) {

        int n = A.size();
        int sumA = A.get(0),
                minA = A.get(0);
        for (int i = 1; i < n; i++) {
            sumA += A.get(i);
            minA = Math.min(minA, A.get(i));
        }

        ArrayList<Integer> B = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (Math.abs(n * A.get(i) - sumA) < n * minA) {
                B.add(A.get(i));
            }
        }

        return B;
    }

    private static int numberOfOperations(int a, int b) {
        int ans = 0;
        while (true) {
            if (a % b == 0) {
                a = a / b;
                ans++;
            }

            if (b % a == 0) {
                b = b / a;
                ans++;
            }

            if (a % b != 0 && b % a != 0)
                break;
        }
        return ans;
    }

    private static int countDistantPairs(String inputString, int distance) {

        int answer = 0;

        for (int i = 0; i + distance + 1 < inputString.length(); i++) {
            if (inputString.substring(i, i + 1).equals(inputString.substring(i + distance + 1, i + distance + 2))) {
                answer++;
            }
        }

        return answer;
    }

    private static String htmlEndTagByStartTag(String startTag) {

        String result = "</";
        int position = 1;
        while (position < startTag.length() - 1 && startTag.charAt(position) != ' ') {
            result += startTag.charAt(position++);
        }
        result += '>';
        return result;
    }

    private static String integerToStringOfFixedWidth(int number, int width) {

        StringBuffer result = new StringBuffer();

        for (int i = 0; i < width; i++) {
            result.append('0');
        }

        int position = width - 1;
        while (number != 0 && position >= 0) {
            result.replace(position, position + 1, Integer.toString(number % 10));
            number /= 10;
            position--;
        }

        return result.toString();
    }

    private static boolean isDiagonalMatrix(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] != 0 && i != j) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int maxZeros(int n) {
        int answer = 0,
                maxZeros = 0;
        for (int k = 2; k <= n; k++) {
            int numZeros = 0,
                    value = n;
            while (value != 0) {
                if (value % k == 0) {
                    numZeros++;
                }
                value /= k;
            }
            if (numZeros > maxZeros) {
                maxZeros = numZeros;
                answer = k;
            }
        }
        return answer;
    }

    private static int digitsProduct(int product) {
        class Helper {
            Helper() {
            }

            int digitProd(int n) {
                if (n == 1)
                    return 1;
                int product = 1;
                while (n != 0) {
                    product *= n % 10;
                    n /= 10;
                }
                return product;
            }
        }
        if (product == 0)
            return 10;
        Helper h = new Helper();
        for (int i = 1; i <= product * product; i++) {
            if (h.digitProd(i) == product)
                return i;
        }
        return -1;

    }

    private static int summaryProficiency(int[] a, int n, int m) {

        int result = 0;
        for (int i = 0; n > 0; i++) {
            if (a[i] >= m) {
                result += a[i];
                n--;
            }
        }

        return result;
    }

    private static int smallestMultiple(int left, int right) {

        for (int candidate = 1; ; candidate++) {
            boolean correct = true;
            for (int divisor = left; divisor <= right; divisor++) {
                if (candidate % divisor != 0) {
                    correct = false;
                    break;
                }
            }
            if (correct) {
                return candidate;
            }
        }
    }

    private static int countDigitsInNumber(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            n /= 10;
        }
        return count;
    }

    private static int pagesNumberingWithInk(int current, int numberOfDigits) {
        int digitsInCurrent = countDigitsInNumber(current);
        while (numberOfDigits >= digitsInCurrent) {
            numberOfDigits -= digitsInCurrent;
            current++;
            digitsInCurrent = countDigitsInNumber(current);
        }
        return current - 1;
    }

    private static int minDistance(int dist[], Boolean sptSet[]) {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < dist.length; v++)
            if (!sptSet[v] && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }

    private static int[] dijkstraDistances(int[][] matrix, int startVertex) {
        int V = matrix.length;
        int dist[] = new int[V]; // The output array. dist[i] will hold
        // the shortest distance from src to i

        // sptSet[i] will true if vertex i is included in shortest
        // path tree or shortest distance from src to i is finalized
        Boolean sptSet[] = new Boolean[V];

        // Initialize all distances as INFINITE and stpSet[] as false
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        // Distance of source vertex from itself is always 0
        dist[startVertex] = 0;

        // Find shortest path for all vertices
        for (int count = 0; count < V - 1; count++) {
            // Pick the minimum distance vertex from the set of vertices
            // not yet processed. u is always equal to src in first
            // iteration.
            int u = minDistance(dist, sptSet);

            // Mark the picked vertex as processed
            sptSet[u] = true;

            // Update dist value of the adjacent vertices of the
            // picked vertex.
            for (int v = 0; v < V; v++)

                // Update dist[v] only if is not in sptSet, there is an
                // edge from u to v, and total weight of path from src to
                // v through u is smaller than current value of dist[v]
                if (!sptSet[v] && matrix[u][v] != -1 &&
                        dist[u] != Integer.MAX_VALUE &&
                        dist[u] + matrix[u][v] < dist[v])
                    dist[v] = dist[u] + matrix[u][v];
        }

        // print the constructed distance array
        return dist;
    }

    public static void main(String[] args) {
        // System.out.println(splitAddress("http://codefights.com"));
        // System.out.println(numberGuessingNaive(3));
        // System.out.println(countDistantPairs("abacaba", 1));
        // System.out.println(digitsProduct(1));
        // System.out.println(summaryProficiency(new int[]{4, 2, 3, 6, 2, 5, 4}, 3, 4));
        System.out.println(Arrays.toString(dijkstraDistances(new int[][]{{-1, 3, 2}, {2, -1, 0}, {-1, 0, -1}}, 0)));
        System.out.println(Arrays.toString(dijkstraDistances(new int[][]{{-1, 1, 2}, {0, -1, 3}, {0, 0, -1}}, 1)));
        System.out.println(Arrays.toString(dijkstraDistances(new int[][]{{-1, 0, 0, 0}, {-1, -1, -1, -1}, {1, 1, -1, 1}, {2, 2, 0, -1}}, 3)));
    }

}
