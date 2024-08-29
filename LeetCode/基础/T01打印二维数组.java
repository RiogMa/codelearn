package 基础;

import java.util.Arrays;

public class T01打印二维数组 {
    public static void main(String[] args) {
        int[][] nums = {
                {1,2,3},{4,5,6},{7,8,9}
        };
        // 方式1:
        System.out.println(Arrays.deepToString(nums));
        // 方式2：
        for(int[] row:nums){
            for(int col:row){
                System.out.print(col+" ");
            }
            System.out.println();
        }
        // 方式3：
        Arrays.stream(nums)
                .map(Arrays::toString)
                .forEach(System.out::println);
    }
}
