import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] daysProfit = new int[N][2];
        int[] dp = new int[N];
        for(int idx=0; idx<N; idx++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int days = Integer.parseInt(st.nextToken());
            int profit = Integer.parseInt(st.nextToken());

            daysProfit[idx][0]= days;
            daysProfit[idx][1]= profit;
        }

        // 각 일마다 해당 상담을 진행하고 N일 뒤 최대 이익과 기존에 계산된 값과 비교해서 더 큰 값을,
        // dp 배열에 기록한다.

        for(int idx=0; idx<N; idx++){
            int day = daysProfit[idx][0];
            int profit = daysProfit[idx][1];

            // 상담을 하고 나서의 일 수가 전체 상담 일 수 내에 형성될 경우에만 코드를 실행한다.
            // previousMaxProfit + N일 지나고 나서의 수익 / 기존에 계산된 수익 중에서 더 큰것을,
            // 가장 큰 수익으로 dp 배열에 남긴다.

            // 1일차는 이전 날짜가 없기 때문에,
            // 해당 일의 소요시간이 1일 일 때만 profit을 반영해준다.
            if(idx==0){
                if(day==1){
                    dp[idx]= profit;
                }
            }

            // 값이 없다면 previousMaxProfit = 0이다.
            int previousMaxProfit = 0;
            for(int t=0; t<=idx-1; t++){
                previousMaxProfit = Math.max(previousMaxProfit, dp[t]);
            }
            if(idx+(day-1) < N){
                dp[idx+(day-1)] = Math.max(dp[idx+(day-1)], previousMaxProfit + profit );
            }
        }

        // dp 배열에서 가장 큰 수익을 뽑아낸다.
        int max = -1;
        for(int idx=0; idx<N; idx++){
            max = Math.max(dp[idx], max);
        }

        // System.out.println(Arrays.toString(dp));
        System.out.println(max);

    }
}

// 상담 시 걸리는 기간과 금액
// dp점화식이 무엇일까?
// dp[i] = dp[i+T(i)]+Pi
// 각 시점에서 N일 동안 상담했을 때의 이익 중에서 최대 값을 구한다.