package 排序;

public class 希尔排序 {
    public static void sort(int[] nums) {
        // 分组 + 冒泡
        int n = nums.length;
        int gap = n / 2;
        while (gap > 0) {
            for (int j = gap; j < n; j++) {
                int i = j;
                while (i >= gap && nums[i - gap] > nums[i]) {
                    int temp = nums[i];
                    nums[i] = nums[i - gap];
                    nums[i - gap] = temp;
                    i -= gap;
                }
            }
            gap /= 2;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10, 2, 1, 9, 0, 5, 9, 11, 4, 4, 3};
        sort(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}
