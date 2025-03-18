import java.util.*;
public class lengthOfLongestSubstring {
    //given a string s find the length of longest substring without repeating chars
    //input = s = "abcabcbb"
    //output = 3
    //approach = sliding window
    //use two pointers (left and right to dine the window)
    //use a hashset to store the characters in the window
    //expand right until we find a duplicate character
    //shrink the window by moving left to the right until the duplicate character is removed

    public static int lengthOfLongestSubstring(String s) {
        
        Set<Character> set = new HashSet<>();
        int le = 0;
        int maxLen = 1;

        for(int ri =0;ri<s.length();ri++){
            while(set.contains(s.charAt(ri))){
                set.remove(s.charAt(le));
                le++;
            }
            set.add(s.charAt(ri));
            maxLen = Math.max(maxLen, ri-le+1);
        }
        
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
