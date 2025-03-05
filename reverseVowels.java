import java.util.*;

public class reverseVowels {
    public static void main(String[] args) {
        reverseVowels r = new reverseVowels();
        String s1 = "hello";
        System.out.println("Input : " + s1);
        System.out.println("Output : " + r.reverseVowel(s1));
    }
    public String reverseVowel(String s){
        if(s == null || s.length() == 0){
            return s;
        }
        Set<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u'));
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while(left < right){
            while(left < right && !vowels.contains(chars[left])){
                left++;
            }
            while(left < right && !vowels.contains(chars[right])){
                right--;
            }
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }
}
