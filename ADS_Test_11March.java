import java.util.*;
public class ADS_Test_11March {
    public static int reverseNum(int num){
        int rev = 0;
        while(num != 0){
            rev = rev*10 + num%10;
            num = num/10;
        }
        return rev;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(reverseNum(n));
    }
}
