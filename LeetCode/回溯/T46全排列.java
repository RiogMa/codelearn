package 回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class T46全排列 {
    // 全局变量
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> res = new ArrayList<>();
    boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        if(nums.length == 0) return res;
        used = new boolean[nums.length];
        // 递归
        permuteHelper(nums);
        return res;
    }
    public void permuteHelper(int[] nums){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i]){
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            permuteHelper(nums);
            path.removeLast();
            used[i] = false;
        }
    }
}
