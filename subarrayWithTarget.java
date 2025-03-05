import java.util.HashMap;

public class subarrayWithTarget {
    public static void main(String[] args) {
        int[] nums = {1, -1, 5, -2, 3};
        int target = 3;
        System.out.println(findSubarraySir(nums, target));
    }
    public static int findSubarray(int[]arr, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLength = 0;

        map.put(0, -1);

        for(int i = 0;i<arr.length;i++){
            sum += arr[i];

            if(map.containsKey(sum - target)){
                int length = i - map.get(sum - target) ;
                maxLength = Math.max(maxLength, length); 
            }

            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
        }
        return maxLength;
    }
    public static int findSubarraySir(int[]arr, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLength = 0;

        map.put(0, -1);

        for(int i = 0;i<arr.length;i++){
            sum += arr[i];

            if(sum == target){
                maxLength =i+1;
            }

            if(map.containsKey(sum - target)){
                int length = i - map.get(sum - target) ;
                maxLength = Math.max(maxLength, length); 
            }

            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
        }
        return maxLength;
    }
}
