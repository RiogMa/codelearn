package 排序;

public class 归并排序 {
    public static void sort(int[] nums, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            // 分别排序
            sort(nums, start, mid);
            sort(nums, mid + 1, end);
            // 合并
            merge(nums, start, end);
        }
    }
    public static void merge(int[] nums, int left, int right) {
        // 合并的是两个有序数组
        int[] temp = new int[nums.length];
        int mid = left + (right - left) / 2;
        int p1 = left; // 左边的数组
        int p2 = mid + 1; // 右边的数组
        int k = left;
        while (p1 <= mid && p2 <= right) {//合并相同长度的部分
            if (nums[p1] <= nums[p2]) {
                temp[k++] = nums[p1++];
            } else {
                temp[k++] = nums[p2++];
            }
        }
        while (p1 <= mid) {//合并左边数组可能多的情况
            temp[k++] = nums[p1++];
        }
        while (p2 <= right) {//合并右边数组可能多的情况
            temp[k++] = nums[p2++];
        }
        for (int i = left; i <= right; i++) {
            nums[i] = temp[i];
        }
    }
    public static void main(String[] args) {
        int[] nums = new int[]{10, 2, 1, 9, 0, 5, 9, 11, 4, 4, 3};
        sort(nums,0,nums.length-1);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}
