package am.lsoft.dev;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Davit on 04/08/16.
 */
public class TournamentDay53 {

    private static int[] gravitation(String[] rows) {
        int[] ans = new int[rows[0].length()];
        char[] row = new char[4];
        for (int r = 0; r < rows[0].length(); r++) {
            int count = 0;
            int k = 3;
            int rocks = 0;
            int aster = -1;
            boolean hasBefore = true;
            for (int i = 0; i <= 3; i++) {
                row[i] = rows[i].charAt(r);
            }
            for (int i = 0; i <= 3; i++) {
                if (row[i] == '.') {
                    rocks++;
                }
            }

            if (rocks == 4) {
                ans[r] = 0;
            } else {
                for (int d = 1; d <= 3; d++) {

                    while (row[k] == '.' && aster != 0) {
                        for (int l = 0; l <= k - 1; l++) {
                            row[k - l] = row[k - l - 1];


                        }
                        row[0] = '.';
                        count++;


                    }
                    k--;
                    aster = 0;
                    for (int p = 0; p < k; p++) {
                        if (row[p] == '#') {
                            aster++;
                        }
                    }


                }
                ans[r] = count;
            }

        }
        ArrayList<Integer> answer = new ArrayList<Integer>();
        int minIndex = 0;
        for (int i = 1; i < ans.length; i++) {
            if (ans[i] < ans[minIndex]) {
                minIndex = i;
            }
        }
        System.out.println(minIndex);
        answer.add(minIndex);
        for (int j = 1; j < ans.length; j++) {
            if (ans[j] == ans[minIndex] && j != minIndex) {
                answer.add(j);
            }
        }
        int[] finalAns = new int[answer.size()];
        for (int k = 0; k < answer.size(); k++) {
            finalAns[k] = answer.get(k);
        }
        return finalAns;

    }

    private static int bfsConnectedComponents(boolean[][] matrix) {

        boolean[] visited = new boolean[matrix.length];
        LinkedList<Integer> queue = new LinkedList<>();
        int componentsCount = 0;

        for (int startVertex = 0; startVertex < matrix.length; startVertex++) {
            if (!visited[startVertex]) {
                visited[startVertex] = true;
                queue.add(startVertex);
                componentsCount++;
                while (queue.size() > 0) {
                    int currentVertex = queue.element();
                    queue.poll();
                    visited[currentVertex] = true;
                    for (int nextVertex = 0; nextVertex < matrix.length; nextVertex++) {
                        if (matrix[currentVertex][nextVertex] && !visited[nextVertex]) {
                            visited[nextVertex] = true;
                            queue.add(nextVertex);
                        }
                    }
                }
            }
        }

        return componentsCount;
    }

    private static int specialNumbers(int l, int r) {

        int ans = 0;
        for (int i = l; i <= r; i++) {
            char[] digits = String.valueOf(i).toCharArray();
            boolean ok = true;
            for (int j = 0; j < (digits.length + 1) / 2; j++) {
                if (digits[j] == '6' || digits[j] == '9') {
                    ok &= digits[digits.length - 1 - j] == '9' - digits[j] + '6';
                } else if (digits[j] == '8' || digits[j] == '0') {
                    ok &= digits[j] == digits[digits.length - 1 - j];
                } else {
                    ok = false;
                }
            }
            if (ok) {
                ans++;
            }
        }

        return ans;
    }

    private static int[] digitalSumSort(int[] a) {
        ArrayList<Integer> sorted = new ArrayList<>(a.length);
        for (int ai : a)
            sorted.add(ai);

        Collections.sort(sorted, new Comparator<Integer>() {
            int digitSum(int n) {
                int sum = 0;
                while (n != 0) {
                    sum += n % 10;
                    n /= 10;
                }
                return sum;
            }

            @Override
            public int compare(Integer o1, Integer o2) {
                int d1 = digitSum(o1), d2 = digitSum(o2);
                if (d1 == d2)
                    return o1 - o2;
                else
                    return d1 - d2;
            }
        });

        return sorted.stream().mapToInt(i -> i).toArray();
    }

    private static int quasifactorial(int n) {
        int answer = 1;
        for (int i = 2; i <= n; ++i) {
            answer *= i;
            --answer;
        }
        return answer;
    }

    private static int[] extractEachKth(int[] inputArray, int k) {

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < inputArray.length; i++) {
            if ((i + 1) % k != 0) {
                result.add(inputArray[i]);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();

    }

    private static int segmentsUnion(int[] left, int[] right) {

        class Pair implements Comparable<Pair> {
            int first;
            int second;

            Pair(int first, int second) {
                this.first = first;
                this.second = second;
            }

            @Override
            public int compareTo(Pair p) {
                return first != p.first ? Integer.compare(first, p.first) :
                        Integer.compare(second, p.second);
            }
        }

        int answer = 0;
        int opened = 0;
        ArrayList<Pair> events = new ArrayList<>();

        for (int i = 0; i < left.length; i++) {
            events.add(new Pair(left[i], 1));
            events.add(new Pair(right[i], -1));
        }

        Collections.sort(events);

        for (int i = 0; i < events.size(); i++) {
            if (opened > 0) {
                answer += events.get(i).first - events.get(i - 1).first;
            }
            opened += events.get(i).second;
        }

        return answer;
    }

    private static int kthDivisor(int n, int k) {
        ArrayList<Integer> divisors = new ArrayList<>();
        int i = 1;
        while (i * i < n) {
            if (n % i == 0) {
                divisors.add(i);
            }
            i++;
        }
        if (i * i > n) {
            i--;
        }
        while (i > 0) {
            if (n % i == 0) {
                divisors.add(n / i);
            }
            i--;
        }
        if (divisors.size() < k) {
            return -1;
        }
        return divisors.get(k - 1);
    }

    private static int rectanglesIntersection(int[] a, int[] b, int[] c, int[] d) {

        int x11 = a[0], x12 = b[0], x21 = c[0], x22 = d[0],
                y11 = a[1], y12 = b[1], y21 = c[1], y22 = d[1];


        int x_overlap = Math.max(0, Math.min(x12, x22) - Math.max(x11, x21));
        int y_overlap = Math.max(0, Math.min(y12, y22) - Math.max(y11, y21));
        return x_overlap * y_overlap;
    }

    private static int lrSegmentNumber(int l, int r) {
        String res = "";
        for (int i = l; i <= r; i++) {
            res += i;
        }
        return Integer.parseInt(res);


    }

    private static String[] splitString(String str) {
        Matcher match = Pattern.compile("\\w+").matcher(str + " ");
        ArrayList<String> slicedArray = new ArrayList<String>();
        boolean hasMatch = match.find();
        if (!hasMatch) {
            return new String[]{};
        }
        while (hasMatch) {
            String matchString = match.group();
            slicedArray.add(matchString.substring(0, matchString.length()));
            hasMatch = match.find();
        }
        String[] result = new String[slicedArray.size()];
        slicedArray.toArray(result);
        return result;
    }

    private static ArrayList<Integer> threeAndFour(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int counter = 0; counter < n; counter++) {
            if (counter % 3 == 0 && counter % 4 == 0)
                result.add(counter);
        }
        return result;
    }

    private static ArrayList<String> fileNaming(String[] names) {
        class HashMapElement {
            String element;
            int hash;
            int version; //the smallest possible integer to use with this name

            HashMapElement(String a, int b, int c) {
                element = a;
                hash = b;
                version = c;
            }
        }
        ;

        class Helper {
            /*
              Information about the string in the hash map
              is stored in the following way:
              [string itself,
               its hash,
               the smallest possible integer to use with this name]
            */
            int hashMapSize;
            HashMapElement[] hashMap;

            Helper(int halfSize) {
                hashMapSize = halfSize * 2;
                hashMap = new HashMapElement[hashMapSize];
                for (int i = 0; i < hashMapSize; i++) {
                    hashMap[i] = new HashMapElement("", -1, 0);
                }
            }

            int calculateHash(String inputString) {
                final int P = 997;
                final int M = 28001;
                int hashValue = 0;
                for (int i = 0; i < inputString.length(); i++) {
                    hashValue = (hashValue * P + (int) inputString.charAt(i)) % M;
                }
                return hashValue;
            }

            int searchHM(int position, int hash) {
                while (hashMap[position].element != ""
                        && hashMap[position].hash != hash) {
                    position = (position + 1) % hashMapSize;
                }
                return position;
            }
        }
        ;

        ArrayList<String> result = new ArrayList<>();
        Helper h = new Helper(names.length);

        for (int i = 0; i < names.length; i++) {
            int hash = h.calculateHash(names[i]);
            int startPos = h.searchHM(hash % h.hashMapSize, hash);
            if (h.hashMap[startPos].element == "") {
                // ...
            } else {
                String newName = names[i] + "(" +
                        Integer.toString(h.hashMap[startPos].version) + ")";
                int newNameHash = h.calculateHash(newName);
                int position = h.searchHM(newNameHash % h.hashMapSize, newNameHash);

                while (h.hashMap[position].element != "") {
                    h.hashMap[startPos].version++;
                    newName = names[i] + "(" +
                            Integer.toString(h.hashMap[startPos].version) + ")";
                    newNameHash = h.calculateHash(newName);
                    position = h.searchHM(newNameHash % h.hashMapSize, newNameHash);
                }
                h.hashMap[position] = new HashMapElement(newName, newNameHash, 1);
                result.add(newName);
                h.hashMap[startPos].version++;
            }
        }
        return result;
    }

    private static int fibonacciIndex(int N) {
        if (N == 1) return 1;
        int a = 0, b = 1;
        int index = 1;
        while (true) {
            int c = a + b;
            a = b;
            b = c;
            index++;

            if (String.valueOf(b).length() == N)
                return index;
        }
    }

    private static int applesDistribution(int apples, int boxCapacity, int maxResidue) {
        int result = 0;
        for (int i = 1; i <= boxCapacity; i++) {
            if (apples % i <= maxResidue) {
                result++;
            }
        }
        return result;
    }

    private static boolean insideCircle(int[] point, int[] center, int radius) {
        double dx = point[0] - center[0];
        double dy = point[1] - center[1];
        return dx * dx + dy * dy <= radius * radius;
    }


    private static int d(int[] v, int[] p, int a) {
        if (a == 0)
            return 0;
        if (v[a] == 1)
            return 0;
        v[a] = 1;
        return 1 + d(v, p, p[a]);
    }

    private static int treeHeight(int[] parent) {
        int[] v = new int[parent.length];

        int ans = 0;
        for (int i = 1; i < parent.length; i++) {
            v = new int[parent.length];
            ans = Math.max(ans, d(v, parent, i));
        }

        return ans;
    }

    public static void main(String[] args) {
        // System.out.println(Arrays.toString(gravitation(new String[]{"#..##", ".##.#", ".#.##", "....."})));
        // System.out.println(Arrays.toString(digitalSumSort(new int[]{13, 20, 7, 4})));
        // System.out.println(kthDivisor(63, 4));
        // System.out.println(rectanglesIntersection(new int[]{0, 0}, new int[]{2, 2}, new int[]{1, 1}, new int[]{3, 3}));
        // System.out.println(rectanglesIntersection(new int[]{3, -3}, new int[]{-3, 3}, new int[]{-1, 0}, new int[]{2, 1}));
        System.out.println(treeHeight(new int[]{0, 0, 1, 4, 1}));
        System.out.println(treeHeight(new int[]{0, 0, 0, 1, 1, 1, 2, 2, 7}));
        System.out.println(treeHeight(new int[]{0, 0, 0, 1, 1, 1, 2, 2, 9, 7}));
    }

}
