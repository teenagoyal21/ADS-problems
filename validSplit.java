public class validSplit {
    public static void main(String[] args) {
        int[] arr = {10, 4, -8, 7};
        System.out.println(validSplits(arr)); 
    }

    public static long validSplits(int[] arr) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num; 
        }

        int leftSum = 0;
        long validSplitCount = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            leftSum += arr[i]; 
            int rightSum = totalSum - leftSum; 

            if (leftSum >= rightSum) {
                validSplitCount++;
            }
        }

        return validSplitCount;
    }
}
