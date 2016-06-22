package am.lsoft.dev;

/**
 * Created by Davit on 08/06/16.
 */
public class TournamentDay9 {

    static int minimalMultiple(int divisor, int lowerBound) {
        if (lowerBound % divisor == 0) {
            return lowerBound;
        }
        return (lowerBound / divisor + 1) * divisor;
    }

    static int adjacentElementsProduct(int[] inputArray) {

        int best = inputArray[0] * inputArray[1],
                cur = best;
        for (int i = 1; i < inputArray.length - 1; i++) {
            cur = inputArray[i] * inputArray[i + 1];
            if (best < cur) {
                best = cur;
            }
        }

        return best;
    }

    static int maxSubarray(int[] inputArray) {

        int max_ending_here = 0, max_so_far = 0;
        for (int i = 0; i < inputArray.length; i++) {
            max_ending_here = Math.max(0, max_ending_here + inputArray[i]);
            max_so_far = Math.max(max_so_far, max_ending_here);
        }
        return max_so_far;
    }

    static int segmentDeletionSlow(int[] left, int[] right) {

        int result = 0;

        for (int i = 0; i < left.length; i++) {
            int rightBound = left[i];
            for (int j = 0; j < left.length; j++) {
                for (int k = 0; k < left.length; k++) {
                    if (i != k && left[k] <= rightBound && right[k] > rightBound) {
                        rightBound = right[k];
                    }
                }
            }
            if (rightBound < right[i]) {
                result++;
            }
        }

        return result;
    }

    static boolean coolString(String inputString) {
        boolean result = false;
        for (int i = 0; i < inputString.length(); i++) {
            char chr = inputString.charAt(i);
            if (chr >= 'a' && chr <= 'z') {
                if (i != inputString.length() - 1
                        && i != 0
                        && (inputString.charAt(i + 1) >= 'A' && inputString.charAt(i + 1) <= 'Z')
                        && (inputString.charAt(i - 1) >= 'A' && inputString.charAt(i - 1) <= 'Z')) {
                    result = true;
                } else if (i == 0
                        && (inputString.charAt(i + 1) >= 'A' && inputString.charAt(i + 1) <= 'Z')) {
                    result = true;
                } else if (i == inputString.length() - 1
                        && (inputString.charAt(i - 1) >= 'A' && inputString.charAt(i - 1) <= 'Z')) {
                    result = true;
                } else {
                    return false;
                }
            } else if (chr >= 'A' && chr <= 'Z') {
                if (i != inputString.length() - 1
                        && i != 0
                        && (inputString.charAt(i + 1) >= 'a' && inputString.charAt(i + 1) <= 'z')
                        && (inputString.charAt(i - 1) >= 'a' && inputString.charAt(i - 1) <= 'z')) {
                    result = true;
                } else if (i == inputString.length() - 1
                        && (inputString.charAt(i - 1) >= 'a' && inputString.charAt(i - 1) <= 'z')) {
                    result = true;
                } else if (i == 0
                        && (inputString.charAt(i + 1) >= 'a' && inputString.charAt(i + 1) <= 'z')) {
                    result = true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // System.out.println(minimalMultiple(1, 239));
        // System.out.println(adjacentElementsProduct(new int[]{3, 6, -2, -5, 7, 3}));
        // System.out.println(maxSubarray(new int[]{-1, 7, -2, 3, 4, 0, 1, -1}));
        // System.out.println(segmentDeletionSlow(new int[]{4, 1, 1}, new int[]{7, 3, 6}));
        System.out.println(coolString("wWw1"));
    }

}
