package 动态规划;

public class T494目标和 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int num : nums) sum+= num;
        if(Math.abs(target) > sum) return 0;
        if((sum + target)%2 != 0 ) return 0;
        int bigSize = (sum + target)/2;
        int[] dp = new int[bigSize+1];
        dp[0] = 1;
        for(int i = 0;i<nums.length;i++){
            for(int j=bigSize;j>=nums[i];j--){
                dp[j] += dp[j-nums[i]];
            }
        }
        return dp[bigSize];
    }
}
