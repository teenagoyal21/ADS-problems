
import java.util.*;

public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {

        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int left = 0, minStart = 0, minLength = Integer.MAX_VALUE, count = 0;
        Map<Character, Integer> sMap = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);

            if (tMap.containsKey(c) && sMap.get(c) <= tMap.get(c)) {
                count++;
            }

            while (count == t.length()) {
                if (right - left + 1 < minLength) {
                    minStart = left;
                    minLength = right - left + 1;
                }

                char leftChar = s.charAt(left);
                sMap.put(leftChar, sMap.get(leftChar) - 1);
                if (tMap.containsKey(leftChar) && sMap.get(leftChar) < tMap.get(leftChar)) {
                    count--;
                }
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
    }

    public static void main(String[] args) {
        //given : sadmap, maps 
        String s = "sadmap", t = "maps";
        System.out.println(minWindow(s, t));
    }
}
