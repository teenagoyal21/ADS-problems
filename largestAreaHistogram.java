public class largestAreaHistogram {

    //brute force
    public static int largestArea(int[] arr, int n){
        int maxArea = 0;
        for(int i = 0;i<n;i++){
            int minHieght = Integer.MAX_VALUE;
            for(int j = i;j<n;j++){
                minHieght = Math.min(minHieght, arr[j]);
                maxArea = Math.max(maxArea, (j-i+1)*minHieght);
            }
        }
        return maxArea;
    }
    //optimized - using stack
    
    public static void main(String[] args) {
        int arr[] = {2,1,5,6,2,3};
        int n = 6;
        System.out.println(largestArea(arr, n));
    }
}
