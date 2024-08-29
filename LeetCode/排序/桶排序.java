package 排序;

import java.util.*;

public class 桶排序 {
    /**
     * 以浮点数排序为例
     */
    public static void sort(float[] nums) {
        // 1.初始化桶，桶内会频繁插入数据，选用LinkedList
        ArrayList<LinkedList<Float>> buckets = new ArrayList<LinkedList<Float>>();
        for (int i = 0; i < 10; i++) {
            buckets.add(new LinkedList<>());
        }
        // 2.数据放入桶中并完成排序
        for (float num : nums) {
            int idx = getBucketIdx(num); // 桶序号
            insertSort(buckets.get(idx), num);
        }
        // 3.从桶中取出数据
        int idx = 0;
        for (LinkedList<Float> bucket : buckets) {
            for (Float num : bucket) {
                nums[idx++] = num;
            }
        }


    }

    // 计算元素放入哪个桶中
    public static int getBucketIdx(float num) {
        // 取浮点数的整数部分作为桶的索引值，实际具体怎么分桶可以变
        return (int) num;
    }

    // 桶内元素进排序，具体怎么排序自己定
    public static void insertSort(List<Float> bucket, float num) {
        ListIterator<Float> iterator = bucket.listIterator();
        boolean insertFlag = true;
        while (iterator.hasNext()) {
            if (num <= iterator.next()) {
                iterator.previous();
                iterator.add(num);
                insertFlag = false;
                break;
            }
        }
        if (insertFlag) {
            bucket.add(num);
        }
    }

    public static void main(String[] args) {
        float[] nums = new float[]{2f, 1f, 9f, 0, 5f, 9f, 4f, 4f, 3f};
        sort(nums);
        for (float i : nums) {
            System.out.print(i + " ");
        }
    }
}
