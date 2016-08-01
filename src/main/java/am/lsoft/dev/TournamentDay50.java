package am.lsoft.dev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Davit on 31/07/16.
 */
public class TournamentDay50 {

    private static int maxNumberOfDivisorsPermutation(int n) {

        // A correct method to swap values in an array.
        class Helper {
            void swap(char[] a, int i, int j) {
                char t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        Helper h = new Helper();

        char[] digits = String.valueOf(n).toCharArray();
        Arrays.sort(digits);
        int bestDivCnt = 1;
        int bestNumber = n;
        while (true) {
            // Checking the number of divisors.
            int cur = Integer.parseInt(new String(digits));
            int divisors = 0;
            for (int i = 1; i <= cur; i++) {
                if (cur % i == 0) {
                    divisors++;
                }
            }
            if (divisors >= bestDivCnt) {
                bestDivCnt = divisors;
                bestNumber = cur;
            }

            // Obtaining the next permutation.
            int first;
            for (first = digits.length - 2; first >= 0; first--) {
                if (digits[first] < digits[first + 1]) {
                    break;
                }
            }
            if (first == -1) {
                break;
            }
            int second = first + 1;
            while (second + 1 < digits.length && digits[first] < digits[second + 1]) {
                second++;
            }
            h.swap(digits, first, second);
            first++;
            second = digits.length - 1;
            while (first < second) {
                h.swap(digits, first, second);
                first++;
                second--;
            }
        }

        return bestNumber;
    }

    private static int[] incrementalBackups(int lastBackupTime, int[][] changes) {
        ArrayList<Integer> fileList = new ArrayList<>();
        for (int[] files : changes) {
            if (files[0] > lastBackupTime && !fileList.contains(files[1]))
                fileList.add(files[1]);
        }
        Collections.sort(fileList);

        return fileList.stream().mapToInt(i -> i).toArray();

    }

    private static int[] troubleFiles(int[][] files, int[] backups) {

        int[] troubleFilesCount = new int[backups.length];
        boolean[] processedFiles = new boolean[files.length];

        int backUpEndTime = -1;
        int tickIdx = 0;

        if (files[0][0] <= backups[0]) {
            for (int i = 0; i < files.length; i++) {
                if (files[i][0] <= backups[0] && !processedFiles[i]) {
                    processedFiles[i] = true;
                    backUpEndTime += (backUpEndTime == -1 ? backups[0] + 1 : 0) + files[i][1];
                }
            }
        }

        for (int i = 0; i < backups.length; i++) {
            // add files to the queue;
            for (int j = 0; j < files.length; j++) {
                if (backups[i] >= files[j][0] && !processedFiles[j]) {
                    if (backUpEndTime == -1 || files[j][0] > backUpEndTime) {
                        processedFiles[j] = true;
                        backUpEndTime += (backUpEndTime == -1 ? backups[i] + 1 : 0) + files[j][1];
                    } else {
                        if (backups[i] <= files[j][0])
                            troubleFilesCount[tickIdx]++;
                        processedFiles[j] = true;
                    }
                }
            }
            if (backups[i] >= backUpEndTime && backUpEndTime != -1) {
                tickIdx = i;
            }
        }

        for (int i = 0; i < processedFiles.length; i++) {
            if (!processedFiles[i]) {
                if (backups[backups.length - 1] <= files[i][0] && files[i][0] <= backUpEndTime) {
                    troubleFilesCount[backups.length - 1]++;
                    processedFiles[tickIdx] = true;
                }
            }
        }

        return troubleFilesCount;
    }

    private static int[] troubleFiles2(int[][] files, int[] backups) {
        int[] troubleFilesCount = new int[backups.length];
        boolean[] processedFiles = new boolean[files.length];

        int backUpProcessStartTime = -1;
        int backUpProcessEndTime = 0;
        int filesToProcess = 0;
        int tickIdx = 0;
        for (int tick = Math.min(files[0][0], backups[0]); tick <= Math.max(files[files.length - 1][0], backups[backups.length - 1]); tick++) {

            if (filesToProcess == 0)
                backUpProcessEndTime = 0;

            for (int j = 0; j < files.length; j++) {
                if (!processedFiles[j] && files[j][0] == tick) {
                    if (files[j][0] <= backUpProcessStartTime) {
                        processedFiles[j] = true;
                    } else {
                        processedFiles[j] = true;
                        if (files[j][0] <= backUpProcessStartTime + filesToProcess || tick <= backUpProcessEndTime) {
                            troubleFilesCount[tickIdx]++;
                        } else {
                            filesToProcess += files[j][1];
                            backUpProcessEndTime += files[j][1];
                        }
                    }
                }
            }

            for (int i = 0; i < backups.length; i++) {
                if (backups[i] == tick) {
                    if (backUpProcessStartTime == -1 || filesToProcess == 0) {
                        tickIdx = i;
                        backUpProcessStartTime = tick;
                        backUpProcessEndTime += tick;
                    }
                }
            }


            if (tick >= backUpProcessStartTime && backUpProcessStartTime != -1)
                filesToProcess--;

        }

        return troubleFilesCount;

    }

    private static boolean isInfiniteProcess(int a, int b) {
        while (a != b) {
            a++;
            b--;
            if (a == b) return false;
            if (a > b) return true;
        }
        return false;
    }

    private static boolean rightTriangle(int[] sides) {

        class Helper {
            int sqr(int value) {
                return value * value;
            }
        }
        Helper h = new Helper();

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(sides[0], sides[1], sides[2]));
        Collections.sort(list);
        if (h.sqr(list.get(0)) + h.sqr(list.get(1)) == h.sqr(list.get(2))) {
            return true;
        }
        return false;
    }

    private static int lastDigit(int a, int b) {

        int result = 1;
        for (int i = 0; i < b; i++) {
            result = (result * a) % 10;
        }
        return result;
    }

    private static String removeDuplicateCharacters(String str) {
        int[] freq = new int[1024];
        char[] chars = str.toCharArray();
        for (char c : chars)
            freq[c]++;

        String res = str;
        for (int i = 0; i < freq.length; i++)
            if (freq[i] > 1)
                res = res.replaceAll(String.valueOf((char) (i)), "");

        return res;
    }

    public static void main(String[] args) {
        // System.out.println(maxNumberOfDivisorsPermutation(21));
        /*System.out.println(Arrays.toString(troubleFiles2(new int[][]{{461618501, 3},
                {461618502, 1},
                {461618504, 2},
                {461618506, 5},
                {461618507, 6}}, new int[]{461618501, 461618502, 461618504, 461618505, 461618506})));
        System.out.println(Arrays.toString(troubleFiles2(new int[][]{{461618501, 3},
                {461618502, 1},
                {461618504, 2},
                {461618506, 5},
                {461618507, 6}}, new int[]{461618504})));
        System.out.println(Arrays.toString(troubleFiles2(new int[][]{{461618501, 3}, {461618502, 1}, {461618504, 2},
                        {461618506, 5}, {461618507, 6}, {461618509, 1},
                        {461618509, 1}, {461618599, 4}},
                new int[]{461618502, 461618509})));

        System.out.println(Arrays.toString(troubleFiles2(new int[][]{{461618500, 7},
                        {461618505, 9},
                        {461618510, 4},
                        {461618515, 5},
                        {461618518, 9}},
                new int[]{461618504, 461618509})));*/
        System.out.println(removeDuplicateCharacters("zaabcbd"));
    }

}
