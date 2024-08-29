package 矩阵;

import java.util.ArrayList;
import java.util.List;

public class T54螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length ==0){
            return new ArrayList<Integer>();
        }
        int left = 0, right = matrix[0].length-1, top = 0, down = matrix.length-1;
        List<Integer> res = new ArrayList<>();
        while (true) {
            for (int i = left; i <= right; i++) res.add(matrix[top][i]);
            if (++top > down) break;
            for (int i = top; i <= down; i++) res.add(matrix[i][right]);
            if (--right < left) break;
            for (int i = right; i >= left; i--) res.add(matrix[down][i]);
            if (--down < top) break;
            for (int i = down; i >= top; i--) res.add(matrix[i][left]);
            if (++left > right) break;
        }
        return res;
    }
}
