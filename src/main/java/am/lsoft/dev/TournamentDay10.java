package am.lsoft.dev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Davit on 09/06/16.
 */
public class TournamentDay10 {

    static int specialPolynomial(int x, int n) {
        int sum = 1,
                lastMonomial = 1,
                k = 0;
        while (sum + lastMonomial * x <= n) {
            lastMonomial *= x;
            sum += lastMonomial;
            k++;
        }
        return k;
    }

    static boolean nimGameNaive(int[] sequence) {

        for (int i = 0; i < sequence.length; i++) {
            int tmp = sequence[i];
            for (int j = 0; j < tmp; j++) {
                sequence[i] = j;

                if (!nimGameNaive(Arrays.copyOf(sequence, sequence.length))) {
                    return true;
                }
            }
            sequence[i] = tmp;
        }
        return false;
    }

    static boolean checkSameElementExistence(int[] arr1, int[] arr2) {
        for (int anArr1 : arr1) {
            for (int anArr2 : arr2) {
                if (anArr1 == anArr2)
                    return true;
            }
        }
        return false;
    }

    static int[] swapArrayHalves(int[] inputArray) {
        for (int i = 0; i < inputArray.length / 2; i++) {
            int tmp = inputArray[i];
            inputArray[i] = inputArray[i + inputArray.length / 2];
            inputArray[i + inputArray.length / 2] = tmp;
        }
        return inputArray;
    }

    static boolean chessBoardCellColor(String cell1, String cell2) {

        class Helper {
            int getX(String pos) {
                return pos.charAt(0) - 'A';
            }

            int getY(String pos) {
                return pos.charAt(0) - '1';
            }
        }
        Helper h = new Helper();

        int sum1 = h.getX("" + cell1.charAt(0)) + h.getY("" + cell1.charAt(1));
        int sum2 = h.getX("" + cell2.charAt(0)) + h.getY("" + cell2.charAt(1));
        if (sum1 % 2 == sum2 % 2) {
            return true;
        }
        return false;

    }

    static int maximizeNumberRoundness(int n) {
        // def maximizeNumberRoundness(n):
        int tmp = n, zeros = 0;
        while (tmp > 0) {
            if (tmp % 10 == 0) {
                zeros += 1;
            }
            tmp /= 10;
        }
        int result = zeros;
        for (int i = 0; i < zeros; i++) {
            if (n % 10 == 0) {
                result -= 1;
            }
            n /= 10;
        }
        return result;
    }

    static String smartAssigning(String[][] information) {
        String[] available = new String[]{"", "1", String.valueOf(Integer.MAX_VALUE), String.valueOf(Integer.MAX_VALUE)};
        for (int memberIdx = 0; memberIdx < information.length; memberIdx++) {
            if (information[memberIdx][1] == "1") {
                if (Integer.valueOf(information[memberIdx][3]) < Integer.valueOf(available[3])) {
                    available[0] = information[memberIdx][0];
                    available[1] = information[memberIdx][1];
                    available[2] = information[memberIdx][2];
                    available[3] = information[memberIdx][3];
                }
            }
        }
        return available[0];
    }

    /*static String[] recurringTask(String firstDate, int k, String[] daysOfTheWeek, int n) {
        final List<String> daysInWeek = new ArrayList<>(
                Arrays.asList(new String[] {
                        "Monday", "Tuesday", "Wednesday",
                        "Thursday", "Friday", "Saturday", "Sunday"
                })
        );
        final int[] days = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        class Helper {
            boolean isLeap(int year) {
                return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
            }
            int countLeap(int yearLeft, int yearRight) {
                int result = 0;
                for (int i = yearLeft; i <= yearRight; i++) {
                    if (isLeap(i)) {
                        result++;
                    }
                }
                return result;
            }
            int getDaysInMonth(int month, int year) {
                int result = days[month];
                if (isLeap(year) && month == 1) {
                    result++;
                }
                return result;
            }
            boolean daysContainsIdx(int[] days, int idx) {
                for (int day : days)
                    if (idx == day)
                        return true;
                return false;
            }
        }

        ArrayList<String> recurringDays = new ArrayList<>();

        int weekDayInt = Integer.parseInt(firstDate.substring(0, 2)) - 1;
        int monthInt = Integer.parseInt(firstDate.substring(3, 5)) - 1;
        int yearNumber = Integer.parseInt(firstDate.substring(6, 10));

        Helper h = new Helper();
        int leaps = h.countLeap(2015, yearNumber);
        int newWeekDay = (daysInWeek.indexOf("Thursday") + leaps * 366 + (yearNumber - 2015 - leaps) * 365) % 7;
        for (int i = 0; i < monthInt; i++) {
            newWeekDay = (newWeekDay + h.getDaysInMonth(i, yearNumber)) % 7;
        }
        int[] daysOfTheWeekIdx = new int[daysOfTheWeek.length];
        for (int i = 0; i < daysOfTheWeek.length; i++) {
            daysOfTheWeekIdx[i] = daysInWeek.indexOf(daysOfTheWeek[i]);
        }

        recurringDays.add(firstDate);
        n--;
        boolean nextDate = true;
        int daysCount = weekDayInt + 1;
        int daysInMonth = h.getDaysInMonth(monthInt, yearNumber);
        while (n > 0) {
            daysCount++;
            newWeekDay = (newWeekDay + 1) % 7;
            if (nextDate
                    && h.daysContainsIdx(daysOfTheWeekIdx, newWeekDay)) {
                recurringDays.add(String.format("%02d", daysCount) + "/"
                        + String.format("%02d", monthInt + 1) + "/" + yearNumber);
                n--;
                nextDate = false;
            }
            if (h.daysContainsIdx(daysOfTheWeekIdx, newWeekDay)
                    && daysCount >= k * 7) {
                n--;
                recurringDays.add(String.format("%02d", daysCount) + "/"
                        + String.format("%02d", monthInt+ 1) + "/" + yearNumber);
            }

            if (daysCount > daysInMonth) {
                monthInt++;
                daysInMonth = h.getDaysInMonth(monthInt, yearNumber);
                daysCount = 0;
            }
        }

        String[] result = new String[recurringDays.size()];
        for (int i = 0; i < recurringDays.size(); i++) {
            result[i] = recurringDays.get(i);
        }
        return result;
    }*/
    static String[] recurringTask(String firstDate, int k, String[] daysOfTheWeek, int n) {
        final List<String> daysInWeek = new ArrayList<>(
                Arrays.asList(new String[] {
                        "Monday", "Tuesday", "Wednesday",
                        "Thursday", "Friday", "Saturday", "Sunday"
                })
        );
        final int[] days = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        class Helper {
            boolean isLeap(int year) {
                return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
            }
            int countLeap(int yearLeft, int yearRight) {
                int result = 0;
                for (int i = yearLeft; i <= yearRight; i++) {
                    if (isLeap(i)) {
                        result++;
                    }
                }
                return result;
            }
            int getDaysInMonth(int month, int year) {
                int result = days[month];
                if (isLeap(year) && month == 1) {
                    result++;
                }
                return result;
            }
            boolean daysContainsIdx(int[] days, int idx) {
                for (int day : days)
                    if (idx == day)
                        return true;
                return false;
            }
        }

        ArrayList<String> recurringDays = new ArrayList<>();

        int weekDayInt = Integer.parseInt(firstDate.substring(0, 2)) - 1;
        int monthInt = Integer.parseInt(firstDate.substring(3, 5)) - 1;
        int yearNumber = Integer.parseInt(firstDate.substring(6, 10));

        Helper h = new Helper();
        int leaps = h.countLeap(1991, yearNumber - 1);
        int newWeekDay = (daysInWeek.indexOf("Tuesday") + leaps * 366 + (yearNumber - 1991 - leaps) * 365) % 7;
        for (int i = 0; i < monthInt; i++) {
            newWeekDay = (newWeekDay + h.getDaysInMonth(i, yearNumber)) % 7;
        }
        int[] daysOfTheWeekIdx = new int[daysOfTheWeek.length];
        for (int i = 0; i < daysOfTheWeek.length; i++) {
            daysOfTheWeekIdx[i] = daysInWeek.indexOf(daysOfTheWeek[i]);
        }

        int num = n;
        recurringDays.add(firstDate);
        num--;
        boolean nextDate = true;
        int period = k * 7;
        int diffCount = 0;
        int daysCount = weekDayInt + 1;
        int daysInMonth = h.getDaysInMonth(monthInt, yearNumber);
        while (num > 0) {
            diffCount++;
            daysCount++;
            newWeekDay = (newWeekDay + 1) % 7;
            if (daysCount > daysInMonth) {
                monthInt++;
                if (monthInt > 11) {
                    monthInt = 0;
                    yearNumber++;
                }
                daysInMonth = h.getDaysInMonth(monthInt, yearNumber);
                period -= daysCount;
                daysCount = 1;
            }
            if (nextDate
                    && h.daysContainsIdx(daysOfTheWeekIdx, newWeekDay)) {
                recurringDays.add(String.format("%02d", daysCount) + "/"
                        + String.format("%02d", monthInt + 1) + "/" + yearNumber);
                num--;
                nextDate = false;
            } else if (h.daysContainsIdx(daysOfTheWeekIdx, newWeekDay)
                    && diffCount > period) {
                num--;
                recurringDays.add(String.format("%02d", daysCount) + "/"
                        + String.format("%02d", monthInt+ 1) + "/" + yearNumber);
            }
        }

        String[] result = new String[recurringDays.size()];
        for (int i = 0; i < recurringDays.size(); i++) {
            result[i] = recurringDays.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        // System.out.println(specialPolynomial(10, 111111110));
        // System.out.println(nimGameNaive(new int[]{2}));
        // System.out.println(swapArrayHalves(new int[]{1, 2, 3, 4}));
        // System.out.println(chessBoardCellColor("A1", "C3"));
        // System.out.println(maximizeNumberRoundness(902200100));
        // String[] recurringTask = recurringTask("01/01/2015", 2, new String[]{"Monday", "Thursday"}, 4);
        // String[] recurringTask = recurringTask("22/02/2020", 1, new String[]{"Saturday"}, 2);
        String[] recurringTask = recurringTask("23/02/2000", 2, new String[]{"Wednesday", "Friday"}, 4);
        for (String task:recurringTask) {
            System.out.println(task);
        }

    }

}
