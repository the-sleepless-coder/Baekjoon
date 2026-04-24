import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 각 일자별 수익
        // 1-idx
        int[] dp = new int[N+1];

        int maxBeforeProfit = 0;
        for(int n=1; n<=N; n++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int days = Integer.parseInt(st.nextToken());
            int profit = Integer.parseInt(st.nextToken());

            // 주어진 기간 안에 벌 수 있는 수익인 경우 연산을 진행한다.
            // 전일 + 해당 기간 벌어들인 수익 / 해당일의 최대 수익과 비교해서,
            // 더 큰 수익을 dp값으로 기록한다.

            // 전일 수익은 이전 수익 중에서 가장 큰 값으로 잡아준다.
            maxBeforeProfit = Math.max(dp[n-1], maxBeforeProfit);

            if(n+days-1<=N){
                dp[n + days-1] = Math.max(maxBeforeProfit + profit, dp[n+days-1]);

                maxBeforeProfit = Math.max(dp[n], maxBeforeProfit);

            }

            // 0, 0, 10, 0, 0, 20, 0
        }

        // 수익의 최대값을 찾는다.
        int max = -1;
        for(int n=1; n<=N; n++){
            max = Math.max(dp[n], max);
        }


        // System.out.println(Arrays.toString(dp));
        System.out.println(max);

    }
}
