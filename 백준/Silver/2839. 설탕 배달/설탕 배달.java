import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 1-idx 기준.
        int[] dp = new int[N+1];
        int result = dp(N, dp);

        System.out.println(result);


    }

    static int dp(int N , int[] dp){
        if(N==3) return 1;
        if(N==4) return -1;
        if(N==5) return 1;

        dp[3]=1;
        dp[4]=0;
        dp[5]=1;
        // 1-idx 기준.
        for(int idx=6; idx<=N; idx++){
            int min = 5_000;
            if(dp[idx-3]!=0) min = Math.min(dp[idx-3] + 1, min);
            if(dp[idx-5]!=0) min = Math.min(dp[idx-5] + 1, min);

            dp[idx] = min;
        }

        // 만들 수 없다면 최소값이 계산 안될 것이고,
        // -1을 반환해준다.
        if(dp[N]==5_000) return -1;

        return dp[N];
    }

}
// dp[3] = 1
// dp[4] = 0
// dp[5] = 1

// dp[i] = min(dp[i-3]+1, dp[i-5]+1)