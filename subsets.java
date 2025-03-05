import java.util.ArrayList;
import java.util.List;

public class subsets {
    public static void gs(int index, int arr[], List<Integer> curr, List<List<Integer>> res){
        res.add(new ArrayList<>(curr));
        for(int i = index;i<arr.length;i++){
            curr.add(arr[i]);
            gs(i+1, arr, curr, res);
            curr.remove(curr.size()-1);
        }
    }

    public static List<List<Integer>> findSubsets(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        gs(0, nums, new ArrayList<>(), res);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(findSubsets(nums));
    }

}