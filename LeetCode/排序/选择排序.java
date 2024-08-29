package 排序;

public class 选择排序 {
    public static void sort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i; // 最小值索引
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[minIdx];
            nums[minIdx] = temp;
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
