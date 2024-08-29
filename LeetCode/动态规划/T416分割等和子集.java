package 动态规划;

public class T416分割等和子集 {
    public boolean canPartition(int[] nums) {
        int n = nums.length;


        int sum = 0;
        for(int num : nums){
            sum+=num;
        }
        if(sum/2!=0) return false;
        int target = sum/2;
        int[] dp = new int[target+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            for(int j=target;j>=0;j--){
                dp[i] = Math.max(dp[i], dp[i-nums[j]]+nums[j]);
            }
            if(dp[i]==target)return true;
        }
        return false;
    }
}
