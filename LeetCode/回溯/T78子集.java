package 回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class T78子集 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        subsetsHelper(nums, 0);
        return res;
    }
    private void subsetsHelper(int[] nums, int startIndex){
        res.add(new ArrayList<>(path));
        if(startIndex >= nums.length){
            return;
        }
        for(int i = startIndex; i < nums.length; i++){
            path.add(nums[i]);
            subsetsHelper(nums, i+1);
            path.removeLast();
        }
    }
}
