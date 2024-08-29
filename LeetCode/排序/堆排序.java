package 排序;

public class 堆排序 {
    public static void sort(int[] list) {
        /**
         * 构造堆
         * 从第一个非叶子节点，也就是倒数第二行最后一个开始调整
         * 左右孩子节点中较大的交换到父节点中
         * i是从下往上
         */
        for (int i = list.length / 2 - 1; i >= 0; i--) {
            headAdjust(list, list.length, i);
        }
        /**
         * 排序堆
         * 将最大节点list[0]放在堆尾list[i]
         * 然后从根节点重新调整
         * 每次把最后一个排好位置的最大值忽略掉
         */
        for (int i = list.length - 1; i >= 1; i--) {
            int temp = list[0];
            list[0] = list[i];
            list[i] = temp;
            headAdjust(list, i, 0);
        }
    }

    /**
     * 调整堆
     *
     * @param list：整个二叉树
     * @param len：list的长度
     * @param i：三个中的根节点
     */
    public static void headAdjust(int[] list, int len, int i) {
        int index = 2 * i + 1; // 左孩子
        while (index < len) {
            if (index + 1 < len) { // 说明还有右孩子
                if (list[index] < list[index + 1]) {
                    index = index + 1;
                }
            }
            // 检查是否有右孩子，且右孩子比左孩子大，如果是，更新index为右孩子索引
            if (list[index] > list[i]) {
                int temp = list[i];
                list[i] = list[index];
                list[index] = temp;
                i = index;
                index = 2 * i + 1;
            } else {
                break;
            }
        }

    }

    // 测试代码
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 7, 8, 2, 9, 6, 0, 5, 4};
        sort(nums);
        for (int num : nums)
            System.out.print(num + " ");
    }
}