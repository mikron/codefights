package am.lsoft.dev;

import java.util.ArrayList;

/**
 * Created by Davit on 12/06/16.
 */
public class TournamentDay13 {

    static int squaresSumMinimization(int[] A) {

        int indexOfMinimum = -1,
                minimalSum = -1;

        for (int x = A[0]; x <= A[A.length - 1]; x++) {
            int sum = 0;
            for (int j = 0; j < A.length; j++) {
                sum += (A[j] - x) * (A[j] - x);
            }
            if (sum < minimalSum || indexOfMinimum == -1) {
                minimalSum = sum;
                indexOfMinimum = x;
            }
        }

        return indexOfMinimum;
    }

    static int[] alternatingSums(int[] a) {
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < a.length; i++) {
            if (i % 2 == 0) {
                sum1 += a[i];
            } else {
                sum2 += a[i];
            }
        }
        return new int[]{sum1, sum2};
    }

    static int numberReverse(int input) {

        int reversed = 0;
        while (input != 0) {
            reversed = reversed * 10 + input % 10;
            input /= 10;
        }
        return reversed;
    }

    static int binarySearch(int[] inputArray, int searchElement) {

        int minIndex = 0;
        int maxIndex = inputArray.length - 1;
        int currentIndex = 0;
        int currentElement;

        while (minIndex <= maxIndex) {
            currentIndex = (minIndex + maxIndex) / 2;
            currentElement = inputArray[currentIndex];

            if (currentElement < searchElement) {
                minIndex = currentIndex + 1;
            } else if (currentElement > searchElement) {
                maxIndex = currentIndex - 1;
            } else {
                return currentIndex;
            }
        }

        return -1;
    }

    static int[] arrayComplexElementsProduct(int[] real, int[] imag) {
        class Helper {
            Helper() {
            }
            int[] product(int[] val1, int[] val2) {
                return new int[]{
                        val1[0] * val2[0] - val1[1] * val2[1],
                        val1[0] * val2[1] + val1[1] * val2[0]
                };
            }
        }
        Helper h = new Helper();
        int[] product = new int[]{real[0], imag[0]};
        for (int i = 1; i < real.length; i++) {
            product = h.product(product, new int[]{real[i], imag[i]});
        }
        return product;
    }

    public static void main(String[] args) {
        // System.out.println(squaresSumMinimization(new int[]{2, 4, 7}));
        // System.out.println(alternatingSums(new int[]{50, 60, 60, 45, 70}));
        // System.out.println(binarySearch(new int[]{1, 2, 3, 4}, 3));
        // System.out.println(arrayComplexElementsProduct(new int[]{1, 2}, new int[]{1, 3}));
        System.out.println(arrayComplexElementsProduct(new int[]{1, 2, 3}, new int[]{0, 0, 0}));
    }

}
