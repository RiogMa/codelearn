package hw;
import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int target = in.nextInt();
        int num = in.nextInt();
        int[] content = new int[num];
        for (int i = 0; i < num; i++) {
            content[i] = in.nextInt();
        }
        in.close();

        // 尝试找到满足条件的两个子集
        List<List<Integer>> result = findSubsets(content, target);
        if (result == null) {
            System.out.println("-1");
        } else {
            List<Integer> dev1 = result.get(0);
            List<Integer> dev2 = result.get(1);
            Collections.sort(dev1);
            Collections.sort(dev2);

            for (int i = 0; i < dev1.size(); i++) {
                if (i > 0) {
                    System.out.print(" ");
                }
                System.out.print(dev1.get(i));
            }
            System.out.println();
            for (int i = 0; i < dev2.size(); i++) {
                if (i > 0) {
                    System.out.print(" ");
                }
                System.out.print(dev2.get(i));
            }
        }
    }

    private static List<List<Integer>> findSubsets(int[] nums, int target) {
        int totalSum = Arrays.stream(nums).sum();

        // 总和如果不是目标的两倍，直接返回 null
        if (totalSum != 2 * target) {
            return null;
        }

        int n = nums.length;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        // 使用动态规划判断是否存在和为 target 的子集
        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        // 如果不存在和为 target 的子集，直接返回 null
        if (!dp[target]) {
            return null;
        }

        // 回溯找到具体的两个子集
        List<Integer> subset1 = new ArrayList<>();
        boolean[] used = new boolean[n];
        if (findSubset(nums, target, used, subset1)) {
            List<Integer> subset2 = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (!used[i]) {
                    subset2.add(nums[i]);
                }
            }
            List<List<Integer>> result = new ArrayList<>();
            result.add(subset1);
            result.add(subset2);
            return result;
        }

        return null;
    }

    private static boolean findSubset(int[] nums, int target, boolean[] used, List<Integer> subset) {
        int n = nums.length;
        for (int i = n - 1; i >= 0 && target > 0; i--) {
            if (target >= nums[i] && canPartition(nums, i, target - nums[i])) {
                used[i] = true;
                subset.add(nums[i]);
                target -= nums[i];
            }
        }
        return target == 0;
    }

    private static boolean canPartition(int[] nums, int endIndex, int target) {
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int i = 0; i <= endIndex; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}
