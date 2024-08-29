package 排序;

public class 基数排序 {
    /**
     * @param d：数字的最大位数，1位数是10，2位数是100....
     */
    public static void sort(int[] nums, int d) {
        int n = 1; // 从右往左的第n位，相同的放一个桶
        int length = nums.length;
        int[][] bucket = new int[10][length]; // 0-9 10个数字，最多length个数字放在同一个桶中
        int[] order = new int[length]; // 记录各桶放了多少数字
        while (n < d) {
            // 分桶
            for (int num : nums) {
                int digit = (num / n) % 10; // 从右往左第n位
                bucket[digit][order[digit]] = num; // 入桶
                order[digit]++;
            }
            // 排序
            int k = 0;
            for (int i = 0; i < length; i++) {
                if (order[i] != 0) {// 如果有该桶
                    for (int j = 0; j < order[i]; j++) {
                        nums[k] = bucket[i][j];
                        k++;
                    }
                }
                order[i] = 0;
            }
            n *= 10;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10, 2, 1, 9, 0, 5, 9, 11, 4, 4, 3};
        sort(nums, 100);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}
