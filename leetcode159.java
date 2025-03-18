import java.util.*;
public class leetcode159 {
    // longest substring with atmost two distint characters 
    // given a string s return the length of the longest substring that contains atmost two distinct characters
    // input = s = "eceba"
    // output = 3
    // approach = sliding window
    public static int lengthOfLongestSub(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int le = 0;
        int maxLen = 1;

        for(int ri =0;ri<s.length();ri++){
            map.put(s.charAt(ri), map.getOrDefault(s.charAt(ri), 0)+1);
            while(map.size() > 2){
                char leftChar = s.charAt(le);
                map.put(leftChar, map.get(leftChar)-1);
                if(map.get(leftChar) == 0){
                    map.remove(leftChar);
                } 
                
                le++;
            }
            maxLen = Math.max(maxLen, ri-le+1);
        }
        
        return maxLen;
    }
    public static void main(String[] args) {
        String s = "eceba";
        System.out.println(lengthOfLongestSub(s));
    }
}
