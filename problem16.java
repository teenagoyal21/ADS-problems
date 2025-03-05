
import java.util.Arrays;

public class problem16 {
    public static int threeSumClosest(int nums[], int target){
        int closestSum = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for(int i = 0;i<nums.length-2;i++){
            int left = i+1;
            int right = nums.length-1;
            while(left < right){
                int currentSum = nums[i] + nums[left] + nums[right];
                if(Math.abs(target - currentSum) < Math.abs(target - closestSum)){
                    closestSum = currentSum;
                }
                if(currentSum < target){
                    left++;
                }
                else if(currentSum > target){
                    right--;
                }
                else{
                    return currentSum;
                }
            }
        }
        return closestSum;
    }
    public static void main(String[] args) {
        int nums[] = {-1,2,1,-4};
        int target1 = 1;

        int nums2[] = {1,3,5,8,10};
        int target2 = 14;

        System.out.println("closest sum of nums 1: " + threeSumClosest(nums, target1));
        System.out.println("closest sum of nums 2: " + threeSumClosest(nums2, target2));
    }
}
