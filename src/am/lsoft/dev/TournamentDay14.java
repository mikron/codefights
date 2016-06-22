package am.lsoft.dev;

import java.util.ArrayList;

/**
 * Created by Davit on 13/06/16.
 */
public class TournamentDay14 {

    static boolean isCaseInsensitivePalindrome(String inputString) {

        for (int i = 0; i < inputString.length() / 2; i++) {
            char[] c = {
                    inputString.charAt(i),
                    inputString.charAt(inputString.length() - i - 1)
            };
            for (int j = 0; j < 2; j++) {
                if (c[j] >= 'a' && c[j] <= 'z') {
                    c[j] = (char) (c[j] - 'a' + 'A');
                }
            }
            if (c[0] != c[1]) {
                return false;
            }
        }

        return true;
    }

    static boolean higherVersion(String ver1, String ver2) {
        class Helper {
            Helper() {

            }

            ArrayList<Integer> toArray(String str) {
                ArrayList<Integer> result = new ArrayList<>();
                String num1 = "";
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == '.') {
                        result.add(Integer.parseInt(num1));
                        num1 = "";
                    } else {
                        num1 += str.charAt(i);
                    }
                }
                result.add(Integer.parseInt(num1));
                return result;
            }
        }

        Helper h = new Helper();
        ArrayList<Integer> num1 = h.toArray(ver1);
        ArrayList<Integer> num2 = h.toArray(ver2);

        for (int i = 0; i < num1.size(); i++) {
            if (num1.get(i) < num2.get(i))
                return false;
            else if (num1.get(i) > num2.get(i))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // System.out.println(isCaseInsensitivePalindrome("AaBaa"));
        System.out.println(higherVersion("1.10.2", "1.2.10"));
    }

}
