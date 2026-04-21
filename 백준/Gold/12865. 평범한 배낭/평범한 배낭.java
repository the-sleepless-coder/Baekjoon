import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 물건 개수 / 최대 무게
        // 이차원 배열의 값에는 최대 가치를 담는다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        //1-idx기준.
        int[][] weightVal = new int[N+1][2];
        for(int n=1; n<=N; n++){
            st = new StringTokenizer(br.readLine());
            weightVal[n][0]=Integer.parseInt(st.nextToken());
            weightVal[n][1]=Integer.parseInt(st.nextToken());
        }

        // dp배열에 각 물건을 담았을 때 무게별로 최대 가치가 얼마인지를 기록한다.
        // 물건 개수 / 물건의 무게를 행열로 잡는다.
        int[][] dp = new int[N+1][W+1];

        // 이전 물건에서의 가치 값 / 이전 무게에서 남은 무게만큼의 물건을 하나 더 가져와서 가치를 추가했을 때의 가치 값 중 더 큰 것을 dp 배열에 담는다.
        for(int n=1;n<=N; n++){
            for(int w=1; w<=W; w++){
                int nWeight = weightVal[n][0];
                int nVal = weightVal[n][1];
                if(w-nWeight >= 0) dp[n][w] = Math.max( dp[n-1][w], dp[n-1][w - nWeight] + nVal );
                else dp[n][w] = dp[n-1][w];
            }
        }

        // System.out.println(builder(dp));
        // System.out.println(Arrays.deepToString(dp));
        System.out.println(maxVal(dp));

    }
    static int maxVal(int[][] dp){
        int max = -1;

        int R = dp.length;
        int C = dp[0].length;
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                max = Math.max(max, dp[r][c]);
            }
        }

        return max;
    }

    static String builder(int[][] dp){
        StringBuilder sb = new StringBuilder();

        int R = dp.length;
        int C = dp[0].length;
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                sb.append(dp[r][c]).append(" ");
            }
            sb.append("\n");
        }


        return String.valueOf(sb);
    }
}
