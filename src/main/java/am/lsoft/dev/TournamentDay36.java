package am.lsoft.dev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Davit on 12/07/16.
 */
public class TournamentDay36 {

    private static int factorSum(int n) {

        int prevValue = 0,
                currentValue = 0,
                nextValue = n;

        do {
            int divisor = 2;
            currentValue = nextValue;
            prevValue = nextValue;
            nextValue = 0;
            while (divisor * divisor <= currentValue) {
                if (currentValue % divisor == 0) {
                    currentValue /= divisor;
                    nextValue += divisor;
                } else {
                    divisor++;
                }
            }
            nextValue += currentValue;
        }
        while (nextValue != prevValue);

        return nextValue;
    }

    private static String compareIntegers(String a, String b) {
        int ia = Integer.parseInt(a), ib = Integer.parseInt(b);
        if (ia < ib)
            return "less";
        else if (ia > ib)
            return "greater";
        else
            return "equal";
    }

    private static int countNeighbouringPairs(String inputString) {

        int answer = 0;

        for (int i = 0; i + 1 < inputString.length(); i++) {
            if (inputString.substring(i, i + 1).equals(inputString.substring(i + 1, i + 2))) {
                answer++;
            }
        }

        return answer;
    }

    private static boolean isIdentityMatrix(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] != 1 && i == j
                        || matrix[i][j] != 0 && i != j) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int halvingSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n;
            n /= 2;
        }
        return sum;
    }

    private static boolean checkEqualFrequency(int[] inputArray) {

        int numberOfEqual = 1;

        Arrays.sort(inputArray);

        while (numberOfEqual < inputArray.length
                && inputArray[numberOfEqual - 1] == inputArray[numberOfEqual]) {
            numberOfEqual++;
        }

        if (inputArray.length % numberOfEqual != 0) {
            return false;
        }

        for (int i = 0; i < inputArray.length; i += numberOfEqual) {
            if (i != 0 && inputArray[i] == inputArray[i - 1]) {
                return false;
            }
            for (int j = i + 1; j < i + numberOfEqual; j++) {
                if (inputArray[j] != inputArray[j - 1]) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean areSimilar(int[] A, int[] B) {

        for (int i = 0; i < A.length; i++) {
            for (int j = i; j < A.length; j++) {
                boolean equal = true;
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
                for (int k = 0; k < A.length; k++) {
                    if (A[k] != B[k]) {
                        equal = false;
                        break;
                    }
                }
                if (equal) {
                    return true;
                }
                A[j] = A[i];
                A[i] = tmp;
            }
        }
        return false;
    }

    private static int[] sumOfBigNumbers(int base, int[] a, int[] b) {
        ArrayList<Integer> al = new ArrayList<>(a.length);
        for (int ai : a)
            al.add(ai);
        ArrayList<Integer> bl = new ArrayList<>(b.length);
        for (int bi : b)
            bl.add(bi);
        Collections.reverse(al);
        Collections.reverse(bl);

        while (al.size() < bl.size()) al.add(0);
        while (bl.size() < al.size()) bl.add(0);
        // vector<int> c;
        ArrayList<Integer> c = new ArrayList<>();
        int k = 0;
        for (int i = 0; i < al.size(); i++) {
            int u = (al.get(i) + bl.get(i) + k);
            c.add(u % base);
            k = u / base;
        }
        c.add(k);
        while (c.size() > 1 && c.get(c.size() - 1) == 0) c.remove(c.size() - 1);
        Collections.reverse(c);
        return c.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        // System.out.println(factorSum(24));
        // System.out.println(factorSum(156));
        // System.out.println(countNeighbouringPairs("aabaa"));
        // System.out.println(isIdentityMatrix(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}));
        // System.out.println(halvingSum(25));
        // System.out.println(checkEqualFrequency(new int[]{1, 2, 2, 1}));
        // System.out.println(areSimilar(new int[]{1, 2, 3}, new int[]{2, 1, 3}));
        System.out.println(Arrays.toString(sumOfBigNumbers(10, new int[]{1, 2, 3, 4, 5}, new int[]{9, 8, 7, 6, 5})));
    }

}
