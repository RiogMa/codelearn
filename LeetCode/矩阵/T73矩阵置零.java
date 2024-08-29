package 矩阵;

import java.util.ArrayList;

public class T73矩阵置零 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        ArrayList<Integer> row  =new ArrayList<>();
        ArrayList<Integer> col  =new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for(int num:row){
            for(int i=0;i<n;i++) matrix[num][i]=0;
        }
        for(int num:col){
            for(int i=0;i<m;i++) matrix[i][num]=0;
        }
    }
}
