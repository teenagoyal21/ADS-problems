import java.util.Arrays;

public class leetcode66 {
    public static int[] plusOne(int[] digits) {
        for(int i = digits.length-1;i>=0;i--){
            if(digits[i]+1 != 10){
                digits[i] += 1;
                return digits;
            }
            digits[i] = 0;
        }

        int newDigits[] = new int[digits.length+1];
        newDigits[0] = 1;
        return newDigits;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,4,5,9};
        System.out.println(Arrays.toString(plusOne(arr)));
    }
}