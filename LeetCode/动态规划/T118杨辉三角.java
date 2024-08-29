package 动态规划;

import java.util.ArrayList;
import java.util.List;

public class T118杨辉三角 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> dp = new ArrayList<>();
        if(numRows == 0){
            return dp;
        }
        dp.add(new ArrayList<>());
        dp.get(0).add(1);
        // i表示行号，第一行已经输入1了，所以从第二行开始遍历
        for(int i = 1; i < numRows; i++){
            List<Integer> row = new ArrayList<>();
            List<Integer> preRow = dp.get(i-1);
            row.add(1);
            for(int j = 1; j < i-1; j++){
                row.add(preRow.get(i-1) + preRow.get(j-1));
            }
            row.add(1);
            dp.add(row);
        }
        return dp;
    }
}
