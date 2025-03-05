public class rangesum303 {
    
}
class NumArray {
    int[] sumList;

   public NumArray(int[] nums) {
        sumList = new int[nums.length];
        sumList[0] = nums[0];
        for(int i=1;i<nums.length;i++){
           sumList[i] = nums[i] + sumList[i-1];
        }
   }

   public int sumRange(int left, int right) {
       if (left == 0) {
           return sumList[right];
       }
       return sumList[right] - sumList[left-1];
   }
}

/**
* Your NumArray object will be instantiated and called as such:
* NumArray obj = new NumArray(nums);
* int param_1 = obj.sumRange(left,right);
*/