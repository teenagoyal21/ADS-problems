public class primeSieveTuesday {
    // legacy classes
    // contains duplicate question 217 leetcode
    // count prime numbers between L and R
    public static int countP(int L, int R){
        int[] prime = new int[R+1];
        for (int i = 0; i <= R; i++) {
            prime[i] = 1;
        }
    
        prime[0] = prime[1] = 0;
    
        for(int i = 2; i*i <= R; i++) {
            if(prime[i] == 1) {
                for(int j = i * i; j <= R; j += i) {
                    prime[j] = 0;
                }
            }
        }
    
        int count = 0;
        for(int i = L; i <= R; i++) {
            if(prime[i] == 1) {
                count++;
            }
        }
    
        return count;
    }
    public static void main(String[] args) {
        //to generate all prime numbers upto specified limit N
        //1. create bool array each index represents if number is prime or not

        //2. initially mark all numbers from 2 to N as true
        
        //starting from first prime 2 mark all multiples of 2 as false

        //move to next number that is true  and mark all its multiple as false;
        //continue this until you reach sqrt of n
        sieve(100);
        System.out.println("\nThe number of elements between 0 and 100 are "+ countP(0, 100));
    }

    public static void sieve(int n){
        boolean[] isPrime = new boolean[n+1];
        for(int i = 0;i<=n;i++){
            isPrime[i] = true;
        }
        isPrime[0] = isPrime[1] = false;
        for(int p = 2;p*p<=n;p++){
            if(isPrime[p] == true){
                for(int i = p*p;i<=n;i+=p){
                    isPrime[i] = false;
                }
            }
        }

        System.out.println("Prime numbers are:");
        for(int i = 0;i<=n;i++){
            if(isPrime[i] == true){
                System.out.print(i + " ");
            }
        }
    }
}
