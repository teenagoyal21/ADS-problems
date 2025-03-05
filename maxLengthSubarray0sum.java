import java.util.HashMap;

public class maxLengthSubarray0sum {
    public static int maxLen(int arr[]) {
        int maxLen = 0;
        int sum = 0;
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i = 0;i<arr.length;i++){
            sum += arr[i];
            if(sum == 0){
                maxLen = i+1;
            }
            if(mp.containsKey(sum)){
                maxLen = Math.max(maxLen, i - mp.get(sum));
            }
            else{
                mp.put(sum, i);
            }
        }
        return maxLen;
    }
    public static void main(String args[]){
        int arr[] = {1, 0, -4, 3, 1, 0};
        System.out.println(maxLen(arr));
    }
}
