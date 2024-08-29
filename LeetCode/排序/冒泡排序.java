package 排序;

public class 冒泡排序 {
    public static void sort(int[] nums){
        int n = nums.length;
        for(int i = 0;i < n - 1;i++){ // i表示完成排序的元素个数，也就是排到末端的个数
            for(int j = 0;j < n - 1 - i;j++){
                if(nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10, 2, 1, 9, 0};
        sort(nums);
        for(int i:nums){
            System.out.print(i+" ");
        }
    }
}
