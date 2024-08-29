package backtrack;

import java.util.ArrayList;
import java.util.List;

public class t216组合总和3 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(n, k ,1, 0);
        return res;
    }
    public void dfs(int target, int k, int index, int sum){
        if(sum > target){
            return;
        }
        if(path.size() == k){
            if(sum == target) res.add(new ArrayList<>(path));
            return;
        }
        for(int i=index;i<= 9-(k-path.size())+1;i++){
            path.add(i);
            sum+=i;
            dfs(target, k, i+1, sum);
            path.remove(path.size()-1);
            sum-=i;
        }
    }
}
