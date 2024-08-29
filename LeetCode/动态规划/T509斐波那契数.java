package 动态规划;

import java.util.Scanner;

public class T509斐波那契数 {
    public static void main(String[] args) {
        int n = 0;
        System.out.println(fib(n));
    }

    public static int fib(int n) {
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2;i < n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }
}
