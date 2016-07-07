package am.lsoft.dev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Davit on 06/07/16.
 */
public class TournamentDay31 {

    private static int minMaxDifference(int[] inputArray) {

        int indexOfMinimum = 0,
                indexOfMaximum = 0;

        for (int i = 1; i < inputArray.length; i++) {
            if (inputArray[i] < inputArray[indexOfMinimum]) {
                indexOfMinimum = i;
            }
            if (inputArray[i] > inputArray[indexOfMaximum]) {
                indexOfMaximum = i;
            }
        }
        return inputArray[indexOfMaximum] - inputArray[indexOfMinimum];
    }

    private static int threeSplit(int[] a) {
        int sum1 = 0, sum2, sum3, ans = 0;
        boolean found;
        for (int i = 0; i < a.length - 2; i++) {
            sum1 += a[i];
            sum2 = 0;
            for (int j = i + 1; j < a.length - 1; j++) {
                sum2 += a[j];
                sum3 = 0;
                found = false;
                for (int k = j + 1; k < a.length; k++) {
                    sum3 += a[k];
                    found = true;
                }
                if (found && sum1 == sum2 && sum2 == sum3)
                    ans++;
            }
        }

        return ans;
    }

    // http://www.geeksforgeeks.org/greedy-algorithms-set-6-dijkstras-shortest-path-algorithm/
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

    private static int nightRoute(int[][] city) {
        int len = city.length;
        int dist[] = new int[len]; // The output array. dist[i] will hold
        // the shortest distance from src to i

        // sptSet[i] will true if vertex i is included in shortest
        // path tree or shortest distance from src to i is finalized
        Boolean sptSet[] = new Boolean[len];

        // Initialize all distances as INFINITE and stpSet[] as false
        for (int i = 0; i < len; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        // Distance of source vertex from itself is always 0
        dist[0] = 0;

        // Find shortest path for all vertices
        for (int count = 0; count < len - 1; count++) {
            // Pick the minimum distance vertex from the set of vertices
            // not yet processed. u is always equal to src in first
            // iteration.
            int u = minDistance(dist, sptSet);

            // Mark the picked vertex as processed
            sptSet[u] = true;

            // Update dist value of the adjacent vertices of the
            // picked vertex.
            for (int v = 0; v < len; v++)

                // Update dist[v] only if is not in sptSet, there is an
                // edge from u to v, and total weight of path from src to
                // v through u is smaller than current value of dist[v]
                if (!sptSet[v] && city[u][v] != -1 &&
                        dist[u] != Integer.MAX_VALUE &&
                        dist[u] + city[u][v] < dist[v])
                    dist[v] = dist[u] + city[u][v];
        }

        return dist[dist.length - 1];
    }

    private static String prefix(String src) {
        return src.substring(0, src.indexOf(" "));
    }

    private static boolean match(String str1, String str2) {
        /*String prefixStr2 = prefix(str2);
        if (str1.equals(prefixStr2))
            return true;
        else {
            int diff = 0;
            for (char ch : str1.toCharArray())
                if (!prefixStr2.contains(ch))
                    diff++;
            return diff == 1;

        }*/
        return false;
    }

    private static String closestLocation(String address, int[][] objects, String[] names) {
        ArrayList<String> nms = new ArrayList<>();
        ArrayList<ArrayList<Integer>> obj = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            if (match(address, names[i])) {
                nms.add(names[i]);
                obj.add(new ArrayList(Arrays.asList(objects[i])));
            }
        }



        return null;
    }

    public static void main(String[] args) {
        // System.out.println(minMaxDifference(new int[]{1, 4, 10, 4, 2}));
        // System.out.println(threeSplit(new int[]{0, -1, 0, -1, 0, -1}));
        // System.out.println(threeSplit(new int[]{0, 0, 0, 0, 0}));
        // System.out.println(nightRoute(new int[][]{{-1, 5, 20}, {21, -1, 10}, {-1, 1, -1}}));
        System.out.println(closestLocation("Cat", new int[][]{{-2, 0}, {1, 2}, {2, 1, 2, 4}, {-3, -1, 4, -1}},
                new String[]{"Bat building", "Cast exhibition", "At street", "Cat avenue"}));
    }

}
