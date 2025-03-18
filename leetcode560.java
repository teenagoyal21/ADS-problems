import java.util.HashMap;
import java.util.Map;

public class leetcode560 {
    //number of subarrays with sum k
    public static int subarraySum(int[] nums, int k){
        Map<Integer, Integer> pmap = new HashMap<>();
        pmap.put(0, 1);
        int presum = 0, co=0;
        for(int num: nums){
            presum += num;
            if(pmap.containsKey(presum - k)){
                co += pmap.get(presum - k);
            }
            pmap.put(presum, pmap.getOrDefault(presum, 0)+1);
        }
        return co;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k = 2;
        System.out.println(subarraySum(nums, k));
    }
}
