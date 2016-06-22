package am.lsoft.dev;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by Davit on 10/06/16.
 */
public class TournamentDay11 {

    static boolean isLowerTriangularMatrix(int[][] matrix) {
        int matrixRows = matrix.length;
        int matrixCols = matrix.length;
        for (int rows = 0; rows < matrixRows; rows++) {
            for (int cols = 0; cols < matrixCols; cols++) {
                if (cols > rows) {
                    if (matrix[rows][cols] != 0)
                        return false;
                }
            }
        }
        return true;
    }

    static boolean crossroads(int[] road1, int[] road2, int crossTime) {
        int j = 0;
        for (int i = 0; i < road1.length; i++) {
            while (j < road2.length && road1[i] > road2[j]) {
                if (road2[j] + crossTime > road1[i]) {
                    return true;
                }
                j++;
            }
            if (j < road2.length && road1[i] + crossTime > road2[j]) {
                return true;
            }
        }
        return false;
    }

    static int arrayMode(int[] sequence) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < sequence.length; i++) {
            int sum = 0;
            if (hashMap.containsKey(sequence[i])) {
                sum = hashMap.get(sequence[i]);
            }
            hashMap.put(sequence[i], ++sum);
        }
        int maxValueInMap=(Collections.max(hashMap.values()));  // This will return max value in the Hashmap
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {  // Itrate through hashmap
            if (entry.getValue()==maxValueInMap) {
                System.out.println(entry.getKey());     // Print the key with max value
                return entry.getKey();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        // System.out.println(isLowerTriangularMatrix(new int[][]{{1, 0, 0}, {4, 0, 0}, {0, 3, 3}}));
        // System.out.println(isLowerTriangularMatrix(new int[][]{{1, 0, 1}, {0, 5, 0}, {2, 0, 3}}));
        // System.out.println(crossroads(new int[]{1, 5, 6, 7}, new int[]{3, 10}, 2));
        System.out.println(arrayMode(new int[]{1, 3, 3, 3, 1}));
    }

}
