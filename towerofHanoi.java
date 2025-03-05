public class towerofHanoi {
    public static void main(String[] args) {
        int n = 4;
        towerOFH(n, 'A','B', 'C');
        System.out.println("total number of " + countMov(n));
    }
    //recursive formula = T(N) = 2T(N-1) + 1;
    // time comp = O(2^n)
    // space com = O(n)

    //algo:
    // move n-1 disks from source to auxilary
    // move nth from source to dest
    //move n-1 from auxil to dest
    public static void towerOFH(int n, char src, char aux, char dest){
        if(n==1){
            System.out.println("move disk 1 from " + src + " to " + dest);
            return;
        }

        towerOFH(n-1, src, dest, aux);
        System.out.println("Move disk " + n + " from " + src + " to " + dest);
        towerOFH(n-1, aux, src, dest);
    }
    public static int countMov(int n){
        if(n == 1){ 
            return 1;  //if only 1 disk, 1 move req.
        }  
        return 2 * countMov(n - 1) + 1;  //2T(n-1) + 1
    }
}
