package 动态规划;

public class T1049最后一块石头的重量2 {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for(int num:stones){
            sum+=num;
        }
        int target = sum%2;
        int[] dp = new int[target+1];
        for(int i = 0;i<n;i++){
            for(int j=target;j>=stones[i];j--){
                dp[j] = Math.max(dp[j], dp[j-stones[i]]+stones[i]);
            }
        }
        return sum - 2*dp[target];
    }
}
