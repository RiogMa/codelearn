package 排序;

public class 计数排序 {
    public static void sort(int[] nums, int min, int max) {
        int n = nums.length;
        int[] temp = new int[max - min + 1];
        // 计数
        for (int i = 0; i < n; i++) {
            temp[nums[i] - min]++;
        }
        int idx = 0;
        for (int i = 0; i < temp.length; i++) {
            int cnt = temp[i];
            while (cnt != 0) {
                nums[idx] = i + min;
                idx++;
                cnt--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10, 2, 1, 9, 0, 5, 9, 11, 4, 4, 3};
        sort(nums, 0, 11);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}
