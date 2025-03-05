public class closestPair {
    public static int[] closestPairs(int[] arr, int target){
        int left = 0, right = arr.length-1;
        int closestSum = Integer.MIN_VALUE;
        int[] closestPair = new int[2];

        while(left < right){
            int sum = arr[left] + arr[right];

            if(sum < target && sum > closestSum){
                closestSum = sum;
                closestPair[0] = arr[left];
                closestPair[1] = arr[right];
            }
            if(sum >= target){
                right--;
            }
            else{
                left++;
            }
        }
        return closestPair;
    }
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 8, 10};
        int target = 14;

        int[] result = closestPairs(arr, target);
        System.out.println("Closest Pair: [" + result[0] + ", " + result[1] + "]");
    }
}
