import java.util.*;

public class leetcode340 {
    //longest substring with atmost k distinct characters
    //given a string s and integer k find the length of the longest substring that contains atmost k distinct characters:

    //task - problem 76 leetcode
    //input = s = "eceba", k = 2
    //output = 3

    //approach = sliding window
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();
        if(n == 0 || k == 0){
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int le = 0;
        int maxLen = 1;

        for(int ri =0;ri<n;ri++){
            char c = s.charAt(ri);
            
            map.put(c, map.getOrDefault(c, 0)+1);
            while(map.size() > k){
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
        int k = 2;
        System.out.println(lengthOfLongestSubstringKDistinct(s, k));
    }
}
