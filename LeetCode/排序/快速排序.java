package 排序;

public class 快速排序 {
    public static void sort(int[] nums, int start, int end) {
        if (start >= end) return;
        int left = start;
        int right = end;
        int temp = nums[left];
        while (left < right) {
            while (left < right && temp <= nums[right]) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && temp >= nums[left]) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = temp;
        sort(nums, start, left - 1);
        sort(nums, left + 1, end);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10, 2, 1, 9, 0, 5, 9, 11, 4, 4, 3};
        sort(nums, 0, nums.length - 1);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}
