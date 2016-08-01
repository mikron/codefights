package am.lsoft.dev;

/**
 * Created by Davit on 31/07/16.
 */
public class TournamentDay49 {

    private static int points(String s) {
        if (s.equals("love"))
            return 0;
        if (s.equals("15"))
            return 1;
        if (s.equals("30"))
            return 2;
        return 3;
    }

    private static int tennisGamePoints(String score) {
        String[] v = score.split("-");
        String a = v[0];
        String b = v[1];
        if (b.equals("all")) {
            return points(a) * 2;
        }
        return points(a) + points(b);
    }

    private static int penaltyShots(int shots, int[] score) {
        if (shots >= 5) {
            if (score[0] != score[1])
                return 0;
            return 2;
        }
        for (int i = 1; i <= 10; i++) {
            int A = (i + 1) / 2, B = i - A;
            int AA = shots + A, BB = shots + B;
            if (score[0] + A > score[1] + (5 - BB)) {
                return i;
            }
            if (score[0] + (5 - AA) < score[1] + B) {
                return i;
            }
        }
        return -1;
    }

    private static int topTeamsTable(String[][] table) {
        int r = 0;
        for (int i = 0; i < table.length - 1; ++i) {
            for (int j = 0; j < table[0].length; ++j) {
                for (int k = j + 1; k < table[0].length; ++k) {
                    for (int jj = 0; jj < table[0].length; ++jj) {
                        for (int kk = jj + 1; kk < table[0].length; ++kk) {
                            if (table[i][j].equals(table[i + 1][kk])
                                    && table[i][k].equals(table[i + 1][jj]))
                                r++;

                        }
                    }
                }
            }
        }
        return r;
    }

    private static String reverse(String s) {
        String reversed = s;
        reversed.toCharArray()[0] = s.toCharArray()[s.length() - 1];
        reversed.toCharArray()[reversed.length() - 1] = s.toCharArray()[0];
        return reversed;
    }

    private static int logicalOrder(String current, String first, String second) {
        current = reverse(current);
        first = reverse(first);
        second = reverse(second);
        int r = 0;
        while (!first.isEmpty() && first.charAt(first.length() - 1) == second.charAt(second.length() - 1)) {
            if (current.charAt(current.length() - 1) != first.charAt(first.length() - 1)) r++;
            current = current.substring(0, current.length() - 2);
            second = second.substring(0, second.length() - 2);
            first = first.substring(0, first.length() - 2);
        }
        current = reverse(current);
        first = reverse(first);
        second = reverse(second);
        int res = 10000;
        //cout << first << " " << second << " " << current << endl;
        if (first.compareTo(current) < 0 && current.compareTo(second) < 0) return r;
        if (first.charAt(0) + 1 < second.charAt(0)) {
            return 1 + r;
        }
        for (int i = 0; i < current.length(); ++i) {
            String tmp = current;
            int now = 0;
            for (int a = 0; a < i; ++a) {
                if (tmp.charAt(a) != first.charAt(a)) {
                    now++;
                    tmp.toCharArray()[a] = first.charAt(a);
                }
            }
            if (tmp.compareTo(first) > 0 && tmp.compareTo(second) < 0) res = Math.min(res, now);
            for (char c = 'a'; c <= 'z'; ++c) {
                tmp.toCharArray()[i] = c;
                if (tmp.compareTo(first) > 0 && tmp.compareTo(second) < 0) res = Math.min(res, now + 1);
            }
        }
        for (int i = 0; i < current.length(); ++i) {
            String tmp = current;
            int now = 0;
            for (int a = 0; a < i; ++a) {
                if (tmp.charAt(a) != second.charAt(a)) {
                    now++;
                    tmp.toCharArray()[a] = second.charAt(a);
                }
            }
            if (tmp.compareTo(first) > 0 && tmp.compareTo(second) < 0) res = Math.min(res, now);
            for (char c = 'a'; c <= 'z'; ++c) {
                tmp.toCharArray()[i] = c;
                if (tmp.compareTo(first) > 0 && tmp.compareTo(second) < 0) res = Math.min(res, now + 1);
            }
        }


        return res + r;
    }

    private static int sq(int a) {
        return a * a;
    }

    private static int cropCircles(int[][] p, int[][] c) {
        int n = 0;
        for (int[] v : c) {
            boolean a = (sq(v[0] - p[0][0]) + sq(v[1] - p[0][1])) <= sq(v[2]);
            boolean b = (sq(v[0] - p[1][0]) + sq(v[1] - p[1][1])) <= sq(v[2]);
            if (a != b) n++;
        }
        return n;
    }

    private static int aquariumFish(int[] w, int[][][] f, int t) {
        /*
        def aquariumFish(w, f, t):
    a = []
    for i in range(len(f)):
        l = (f[i][0][0] ** 2 + f[i][0][1] ** 2) ** .5
        if l == 0: l = 1
        a += [[w[i], f[i][1], [f[i][0][0] / l, f[i][0][1] / l]]]

    while True:
        minT = t + 1
        for A in a:
            for B in a:
                curt = t + 1
                if A[2][0] != B[2][0]:
                    curt = (A[1][0] - B[1][0]) * 1.0 / (B[2][0] - A[2][0])
                elif A[2][1] != B[2][1]:
                    curt = (A[1][1] - B[1][1]) * 1.0 / (B[2][1] - A[2][1])

                x1 = A[1][0] + A[2][0] * curt
                y1 = A[1][1] + A[2][1] * curt
                x2 = B[1][0] + B[2][0] * curt
                y2 = B[1][1] + B[2][1] * curt

                if abs(x1 - x2) < 1e-6 > abs(y1 - y2):
                    if curt > -1.0e-6 and curt < minT:
                        minT = curt
                        l = a.index(A)
                        r = a.index(B)

        if minT > t: break

        for i in range(len(a)):
            a[i][1][0] += a[i][2][0] * minT
            a[i][1][1] += a[i][2][1] * minT

        if l > r: l, r = r, l

        if a[l][0] >= a[r][0]:
            a[l][0] += a[r][0]
            del a[r]
        else:
            a[r][0] += a[l][0]
            del a[l]

        t -= minT

    return len(a)

        */
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(tennisGamePoints("15-40"));
        System.out.println(penaltyShots(2, new int[]{1, 2}));
        System.out.println(topTeamsTable(new String[][]{{"Canada", "Sweden", "Czech", "Finland"},
                {"Canada", "Sweden", "Slovakia", "Czech"},
                {"Canada", "Sweden", "Czech", "Slovakia"},
                {"Sweden", "Canada", "Czech", "Finland"},
                {"Sweden", "Czech", "Slovakia", "Canada"}}));
        System.out.println(logicalOrder("fullb", "filea", "filew"));
        System.out.println(cropCircles(new int[][]{{-2, 0}, {9, 4}}, new int[][]{{0, 0, 4}, {-2, 0, 1}, {1, 1, 1}, {9, 1, 4}}));
        System.out.println(aquariumFish(new int[]{2, 3, 2, 1}, new int[][][]{{{1, 2}, {-1, 0}},
                {{1, 0}, {-3, 1}},
                {{-1, 2}, {1, 0}},
                {{0, 1}, {2, -4}}}, 5));
    }

}
