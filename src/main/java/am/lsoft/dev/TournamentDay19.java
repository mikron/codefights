package am.lsoft.dev;

import java.util.*;

/**
 * Created by Davit on 19/06/16.
 */
public class TournamentDay19 {

    static String[] sortByLength(String[] inputArray) {
        HashMap<Integer, List<String>> inputMap = new HashMap<>();
        for (String str : inputArray) {
            if (inputMap.containsKey(str.length())) {
                List<String> vals = inputMap.get(str.length());
                vals.add(str);
            } else {
                List<String> vals = new ArrayList<>();
                vals.add(str);
                inputMap.put(str.length(), vals);
            }
        }


        String[] result = new String[inputArray.length];
        SortedSet<Integer> keys = new TreeSet<>(inputMap.keySet());
        int idx = 0;
        for (Integer key : keys) {
            for (String str : inputMap.get(key)) {
                result[idx] = str;
                idx++;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(sortByLength(new String[]{"abc", "", "aaa", "a", "zz"}));
    }

}
