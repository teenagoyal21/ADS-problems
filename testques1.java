import java.util.HashMap;

public class testques1 {
    public static int longestSubarrayKsum(int[] arr, int k){
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int sum = 0, maxLength = 0;

        for(int i = 0;i<arr.length;i++){
            sum += arr[i];

            if (sum == k) {
                maxLength = i + 1;
            }
            if (hmap.containsKey(sum-k)) {
                maxLength = Math.max(maxLength, i - hmap.get(sum-k));
            }
            hmap.putIfAbsent(sum, i);
        }
        return maxLength;
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 1, 1, 1, 5, -1};
        int k = 5; 
        System.out.println(longestSubarrayKsum(arr, k));
    }
}
