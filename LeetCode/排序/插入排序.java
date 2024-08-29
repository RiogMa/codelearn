package 排序;

public class 插入排序 {
    public static void sort(int[] nums) {
        int n = nums.length;
        int pos, cur;
        for (int i = 1; i < n; i++) { // 默认第一张牌是排序好的，所以从第二张开始遍历
            pos = i - 1;// 已经排序好的牌中最大的那张
            cur = nums[i]; // 要插入的新牌
            while (pos >= 0 && cur < nums[pos]) { //查找cur应该插入的位置，从已排序部分的最后一个元素开始，向前遍历
                nums[pos + 1] = nums[pos]; //由于cur小于nums[pos]，我们需要为cur腾出空间
                pos--;//继续向前寻找，比较cur和前面的元素
            }
            // 循环结束后，pos指向了cur应该插入的位置的前一个位置
            // 因为循环中我们是比较后将pos减少，所以最终pos停留在正确插入点前的一个位置
            nums[pos + 1] = cur;
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
