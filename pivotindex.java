
public class pivotindex {
    public static void main(String[] args) {
        int[] arr = {1,4,6,4,5,6};
        System.out.println(pivot(arr));
    }
    public static int pivot(int[] arr){
        int tsum = 0;
        for(int i = 0;i<arr.length;i++){
            tsum += arr[i];
        }

        int leftSum = 0;
        for (int i = 0; i < arr.length; i++) {
            int rightSum = tsum - leftSum - arr[i];
            if (leftSum == rightSum) {
                return i; 
            }
            leftSum += arr[i]; 
        }

        return -1;
    }
}
