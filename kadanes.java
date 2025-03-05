public class kadanes {
    public static void main(String[] args) {
        //steps od kadanes algo: 
        //initialization:
        // [1, -2, 3, 4, -1, 2, 1, -5, 4];
        //start : currentSum = 0, maxSum = Integer.min
        //first els(1) = csum = max(1, 0+1)1, maxS = max(-In, 1)1
        //Second ele(-2) = csum = max(-2, 1-2) = -1, maxS = max(1, -1) =1;
        //third ele(3) = csum = max(3, -1+3) = 3, maxS= 3
        //fourth(4) = csum  = max(4, 3+4) = 7, maxS = max(3, 7) = 7
        //fifth(-1) csum = max(-1, 7+-1) = 6, maxS= max(7,6) = 7'
        //sixth (2) csum = max(2, 6+2) = 8, maxS = max(7,8) = 8;
        //seventh(1) csum = max(8+1, 1) = 9, maxS = max(9, 8) = 9;

        int arr[] = {1, -2, 3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubarray(arr));
    }
    public static int maxSubarray(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }
        int currSum = 0;
        int maxS = Integer.MIN_VALUE;
        for(int num: nums){
            currSum = Math.max(num, currSum+num);
            maxS = Math.max(currSum, maxS);
        }
        return maxS;
    }
    //to exclude negative sums
    public static int maxSubSum(int[] nums){
        int cSum = 0;
        int maxS = Integer.MIN_VALUE;
        for(int num: nums){
            cSum = Math.max(num, cSum+num);
            if(cSum < 0){
                cSum = 0;
            }
            maxS = Math.max(cSum, maxS);
        }
        return maxS;
    }
}
