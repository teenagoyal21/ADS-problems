public class sumabsolute1685 {
    public int[] sumofAbsolute(int nums[]){
        int n=nums.length;
        int totalSum=0,leftSum=0;
        for(int num:nums) totalSum+=num;
        int[] ans=new int[n];

        for(int i=0;i<n;i++){
            int rightSum = totalSum-leftSum-nums[i]*(n-i);
            ans[i] = rightSum+(nums[i]*i-leftSum);
            leftSum+=nums[i];
        }
        return ans;
    }
}
