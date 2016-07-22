package am.lsoft.dev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Davit on 21/07/16.
 */
public class TournamentDay43 {

    private static int[] arrayReplace(int[] inputArray,
                                      int elemToReplace, int substitutionElem) {

        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] == elemToReplace) {
                inputArray[i] = substitutionElem;
            }
        }
        return inputArray;
    }

    private static int gcm(int a, int b) {
        return b == 0 ? a : gcm(b, a % b);
    }

    private static int[] fractionSum(int[] A, int[] B) {
        int[] sum = new int[]{(A[0] * B[1]) + (B[0] * A[1]), (A[1] * B[1])};
        int gcm = gcm(sum[0], sum[1]);
        return new int[]{sum[0] / gcm, sum[1] / gcm};
    }

    private static boolean symbolsPermutation(String word1, String word2) {
        char[] ch1 = word1.toCharArray();
        Arrays.sort(ch1);
        char[] ch2 = word2.toCharArray();
        Arrays.sort(ch2);
        return Arrays.equals(ch1, ch2);
    }

    private static boolean isLowerTriangularMatrix(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                if (matrix[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int[] splitByValue(int k, int[] elements) {
        ArrayList<Integer> less = new ArrayList<>();
        ArrayList<Integer> grtr = new ArrayList<>();

        for (int a : elements) {
            if (a < k)
                less.add(a);
            else
                grtr.add(a);
        }

        return Stream.concat(less.stream(), grtr.stream()).collect(Collectors.toList())
                .stream().mapToInt(i -> i).toArray();
    }

    private static int differentSymbolsNaive(String s) {

        int result = 0;

        for (int i = 0; i <= 26; i++) {
            boolean found = false;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == 'a' + i) {
                    found = true;
                    break;
                }
            }
            if (found) {
                result++;
            }
        }
        return result;
    }

    private static boolean isoscelesTriangle(int[] sides) {

        Arrays.sort(sides);
        if (sides[2] == sides[1] || sides[1] == sides[0]) {
            return true;
        }
        return false;
    }

    private static int squarePerimeter(int n) {
        return 4 * n;
    }

    private static int knapsackLight(int value1, int weight1,
                                     int value2, int weight2, int maxW) {

        if (weight1 + weight2 <= maxW) {
            return value1 + value2;
        }
        if (Math.min(weight1, weight2) > maxW) {
            return 0;
        }
        if (weight1 <= maxW && (value1 >= value2 || weight2 > maxW)) {
            return value1;
        }
        return value2;
    }

    private static int commonPoints(int l1, int r1, int l2, int r2) {
        int result = Math.min(r1, r2) - Math.max(l1, l2) - 1;
        if (result < 0) {
            result = 0;
        }
        return result;
    }

    private static int sumOfMultiples(int n, int k) {
        int sum = 0;
        for (int i = k; i <= n; i++)
            if (i % k == 0)
                sum += i;
        return sum;
    }

    private static int lastDigit(int a, int b) {
        /*int[][] scale = new int[][]{{0, 0, 0, 0},
                {1, 1, 1, 1},
                {2, 4, 6, 8},
                {3, 9, 7, 1},
                {4, 6, 4, 6},
                {5, 5, 5, 5},
                {6, 6, 6, 6},
                {7, 9, 3, 1},
                {8, 4, 2, 6},
                {9, 1, 9, 1}};
        return scale[a][b];*/
        if (b == 0) return 1;

        //find last digit of a
        int da = a % 10;

        if (da == 0) return 0;
        if (da == 5) return 5;
        switch (b % 4) {
            case 0:
                return da % 2 != 0 ? 1 : 6;
            case 1:
                return da;
            case 2:
                return da * da % 10;
            default:
                return da * da * da % 10;
        }
    }

    private static String reduceString(String inputString) {

        int left = 0;
        while (left * 2 < inputString.length()) {
            int right = inputString.length() - left - 1;
            if (inputString.charAt(left) != inputString.charAt(right)) {
                break;
            } else {
                left++;
            }
        }
        if (left * 2 >= inputString.length()) {
            return "";
        }
        return inputString.substring(left, inputString.length() - left);
    }

    private static int digitsProduct(int product) {
        for (int i = 1; i < product * product + 11; i++) {
            int p = 1;
            int t = i;
            while (t != 0) {
                p *= t % 10;
                t /= 10;
            }
            if (p == product) {
                return i;
            }
        }
        return -1;
    }

    private static int arrayMode(int[] sequence) {
        ArrayList<Integer> count = new ArrayList<>();
        int answer = 0;

        for (int i = 0; i < 10; i++) {
            count.add(0);
        }
        for (int i = 0; i < sequence.length; i++) {
            count.set(sequence[i] - 1, count.get(sequence[i] - 1) + 1);
            if (count.get(sequence[i] - 1) > count.get(answer)) {
                answer = sequence[i] - 1;
            }
        }
        return answer + 1;
    }

    private static int circleGrid(double X, double Y, double R) {
        /*int a = 0;
        for (double i = Math.floor(X - R); i <= Math.ceil(X + R); i++)
            for (double j = Math.floor(Y - R); j <= Math.ceil(Y + R); j++)
                if ((X - i) * (X - i) + (Y - j) * (Y - j) <= R * R)
                    a++;
        return a;*/
        int a = 0;
        for (int i = (int) (X - R); i <= X + R; i++)
            for (int j = (int) (Y - R); j <= Y + R; j++)
                if ((X - i) * (X - i) + (Y - j) * (Y - j) <= R * R)
                    a++;
        return a;
    }

    private static int bfsComponentSize(boolean[][] matrix) {

        ArrayList<Boolean> visited = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>();
        int componentSize = 0;

        for (int i = 0; i < matrix.length; i++) {
            visited.add(false);
        }

        visited.set(1, true);
        queue.add(1);

        while (queue.size() > 0) {
            int currentVertex = queue.pop();
            visited.set(currentVertex, true);
            componentSize++;
            for (int nextVertex = 0; nextVertex < matrix.length; nextVertex++) {
                if (matrix[currentVertex][nextVertex] && !visited.get(nextVertex)) {
                    visited.set(nextVertex, true);
                    queue.add(nextVertex);
                }
            }
        }

        return componentSize;
    }

    private static boolean isPrime(int n) {
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2)
            if (n % i == 0)
                return false;
        return true;
    }

    private static int[] eratosthenesSieve(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 2; i <= n; i++)
            if (isPrime(i))
                res.add(i);

        return res.stream().mapToInt(i -> i).toArray();
    }

    private static int countWaysToChangeDigit(int value) {
        int answer = 0;
        while (value > 0) {
            answer += 9 - value % 10;
            value /= 10;
        }
        return answer;
    }

    private static ArrayList<Integer> nextPermutation(ArrayList<Integer> permutation) {

        for (int i = permutation.size() - 2; i >= 0; i--) {
            if (permutation.get(i) < permutation.get(i + 1)) {
                int index = i + 1,
                        tmp = permutation.get(i + 1);
                for (int j = i + 1; j < permutation.size(); j++) {
                    if (permutation.get(j) < permutation.get(i) && permutation.get(j) < permutation.get(index)) {
                        index = j;
                    }
                }
                permutation.set(i, permutation.get(index));
                permutation.set(index, tmp);
                ArrayList<Integer> suffix = new ArrayList<>(permutation.subList(i + 1, permutation.size()));
                Collections.reverse(suffix);
                permutation.subList(i, permutation.size()).clear();
                permutation.addAll(suffix);
                return permutation;
            }
        }

        Collections.sort(permutation);
        return permutation;
    }

    private static ArrayList<Integer> extractEachKth(ArrayList<Integer> inputArray, int k) {

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < inputArray.size(); i++) {
            if ((i + 1) % k != 0) {
                result.add(0 /*...*/);
            }
        }
        return result;
    }

    private static int divNumber(int k, int l, int r) {
        int ans = 0;
        for (int i = l; i <= r; i++) {
            int n = i;
            int divs = 1;
            for (int j = 2; j * j <= n; j++) {
                int pow = 0;
                while (n % j == 0) {
                    n /= j;
                    pow++;
                }
                divs *= 1 + pow;
                if (divs > k) {
                    break;
                }
            }
            if (n != 1) divs *= 2;
            if (divs == k)
                ans++;
        }
        return ans;
    }

    private static int matrixElementsSum(int[][] matrix) {

        int result = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][i] == 0) {
                    break;
                }
                result += matrix[j][i];
            }
        }

        return result;
    }

    private static int equationSolutions(int L, int R) {
        int ans = 0;
        for (int i = L; i <= R; i++)
            for (int j = L; j <= R; j++)
                if (i * i * i == j * j)
                    ans++;
        return ans;
    }

    private static int smallestNumber(int n) {

        if (n == 1) {
            return 0;
        }

        int res = 1;

        for (int i = 1; i < n; i++) {
            res *= 10;
        }

        return res;
    }

    private static boolean twoPolygons(int[][] p1, int[][] p2) {
        class Helper {
            int doubleSquare(int[][] polygon) {
                int square = 0;
                for (int i = 0; i < polygon.length; i++) {
                    int[] a = polygon[i];
                    int[] b = polygon[(i - 1 + polygon.length) % polygon.length];
                    square += a[0] * b[1] - a[1] * b[0];
                }
                return square;
            }
        }

        Helper h = new Helper();
        return h.doubleSquare(p1) == h.doubleSquare(p2);
    }

    private static int arrayMaximalDifference(int[] inputArray) {
        Arrays.sort(inputArray);
        return inputArray[inputArray.length - 1] - inputArray[0];

    }

    private static int[] myReverse(int[] input) {

        for (int i = 0; i * 2 < input.length; i++) {
            int tmp = input[i];
            input[i] = input[input.length - i - 1];
            input[input.length - i - 1] = tmp;
        }
        return input;
    }

    private static ArrayList<Double> quadraticEquation(int a, int b, int c) {

        int discriminant = b * b - 4 * a * c;
        if (discriminant < 0) {
            ArrayList<Double> empty = new ArrayList<>();
            return empty;
        }
        if (discriminant == 0) {
            ArrayList<Double> answer = new ArrayList<>();
            answer.add(-b / (2.0 * a));
            return answer;
        }
        ArrayList<Double> roots = new ArrayList<>();
        roots.add((-b - Math.sqrt(discriminant)) / (2.0 * a));
        roots.add((-b + Math.sqrt(discriminant)) / (2.0 * a));
        if (roots.get(0) > roots.get(1)) {
            double tmp = roots.get(1);
            roots.set(1, roots.get(0));
            roots.set(0, tmp);
        }
        return roots;
    }

    /*private static int maxXorSum(int[] a) {
        *//*int n = a.length - 1;
        // Number of bits to represent int
        int INT_BITS = 32;
        // Initialize index of chosen elements
        int index = 0;

        // Traverse through all bits of integer starting from
        // the most significant bit (MSB)
        for (int i = INT_BITS - 1; i >= 0; i--) {
            // Initialize index of maximum element and the maximum element
            int maxInd = index, maxEle = Integer.MIN_VALUE;
            for (int j = index; j < n; j++) {
                // If i'th bit of set[j] is set and set[j] is greater
                // than max so far.
                if ((a[j] & (1 << i)) != 0 && a[j] > maxEle) {
                    maxEle = a[j];
                    maxInd = j;
                }
            }

            // If there was no element with i'th bit set, move to smaller i
            if (maxEle == Integer.MIN_VALUE)
                continue;

            // Put maximum element with i'th bit set at index 'index'
            int tmp = a[index];
            a[index] = a[maxInd];
            a[maxInd] = tmp;
            // swap(a[index], a[maxInd]);

            // Update maxInd and increment index
            maxInd = index;

            // Do XOR of set[maxIndex] with all numbers having i'th
            // bit as set.
            for (int j = 0; j < n; j++) {
                // XOR set[maxInd] those numbers which have the i'th
                // bit set
                if ((j != maxInd) && ((a[j] & (1 << i)) != 0))
                    a[j] = a[j] ^ a[maxInd];
            }

            // Increment index of chosen elements
            index++;
        }

        // Final result is XOR of all elements
        int res = 0;
        for (int i = 0; i < n; i++)
            res ^= a[i];
        return res;*//*
        int ans = Integer.MIN_VALUE;     // Initialize result

        // Pick starting points of subarrays
        for (int i = 0; i < a.length; i++) {
            int curr_xor = 0; // to store xor of current subarray

            // Pick ending points of subarrays starting with i
            for (int j = i; j < a.length; j++) {
                curr_xor = curr_xor ^ a[j];
                ans = Math.max(ans, curr_xor);
            }
        }
        return ans;
    }*/

    private static boolean bitOf(char in) {
        return (in == '1');
    }

    private static char charOf(boolean in) {
        return (in) ? '1' : '0';
    }

    private static String xor(String a, String b) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.max(a.length(), b.length()); i++) {
            if (i >= a.length())
                sb.append(charOf(bitOf('0') ^ bitOf(b.charAt(i))));
            else if (i >= b.length())
                sb.append(charOf(bitOf(a.charAt(i)) ^ bitOf('0')));
            else
                sb.append(charOf(bitOf(a.charAt(i)) ^ bitOf(b.charAt(i))));
        }
        return sb.toString();
    }

    private static int maxXorSum(int[] a) {
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < a.length; i++) {
            String curr_xor = Integer.toBinaryString(a[i]);
            for (int j = i; j < a.length; j++) {
                curr_xor = xor(curr_xor, Integer.toBinaryString(a[j]));
                ans = Math.max(ans, Integer.parseInt(curr_xor, 2));
            }
        }
        return ans;
    }

    private static int maxSumProduct(int[] a, int[] b, int k) {

        int best = 0;
        int leftSumA = 0;
        int rightSumA = 0;
        for (int i = 1; i <= Math.min(a.length, k); i++) {
            leftSumA += a[i - 1];
            rightSumA += a[a.length - i];

            int leftSumB = 0;
            int rightSumB = 0;
            for (int j = 1; j <= Math.min(b.length, k - i); j++) {
                leftSumB += b[j - 1];
                rightSumB += b[b.length - j];

                best = Math.max(best,
                        Math.max(leftSumA * leftSumB, rightSumA * rightSumB));
            }
        }

        return best;
    }

    public static void main(String[] args) {
        // System.out.println(Arrays.toString(fractionSum(new int[]{3, 5}, new int[]{7, 5})));
        // System.out.println(isLowerTriangularMatrix(new int[][]{{1, 0, 0}, {4, 0, 0}, {0, 3, 3}}));
        // System.out.println(isLowerTriangularMatrix(new int[][]{{0, -1, 0}, {0, 0, 0}, {0, 0, 0}}));
        // System.out.println(Arrays.toString(splitByValue(5, new int[]{1, 3, 5, 7, 6, 4, 2})));
        // System.out.println(differentSymbolsNaive("cabca"));
        // System.out.println(lastDigit(2, 5));
        // System.out.println(digitsProduct(12));
        // System.out.println(circleGrid(3.9, 2.35, 2.4));
        /*ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(3);
        arr.add(2);
        arr.add(4);
        System.out.println(nextPermutation(arr).toString());*/
        // System.out.println(divNumber(3, 2, 49));
        // System.out.println(matrixElementsSum(new int[][]{{0, 1, 1, 2}, {0, 5, 0, 0}, {2, 0, 3, 3}}));
        // System.out.println(matrixElementsSum(new int[][]{{1, 1, 1, 0}, {0, 5, 0, 1}, {2, 1, 3, 10}}));
        // System.out.println(equationSolutions(1, 4));
        // System.out.println(twoPolygons(new int[][]{{0, 0}, {1, 0}, {0, 2}}, new int[][]{{2, 0}, {2, 2}, {0, 2}}));
        System.out.println(maxXorSum(new int[]{1, 2, 3, 4}));
    }

}
