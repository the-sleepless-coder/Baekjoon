import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];
        for(int r=0; r<N; r++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        // 해당 위치에서 가장 많이 먹을 수 있는 우유의 수를 기록한다.
        int[][] dp = new int[N][N];

        // 각 위치에서 우유를 먹을 수 있을 때,
        // 이전 위치에서의 최대값에서 +1을 해준다.
        int max = -1;
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                int val = arr[r][c];

                int prevMax = 0;
                if(r-1>=0) prevMax = Math.max(prevMax, dp[r-1][c]);
                if(c-1>=0) prevMax = Math.max(prevMax, dp[r][c-1]);

                // 해당 위치에서 우유를 마실 수 있다면,
                // 이전 최대값+1을 현재 값으로 넣어준다.
                if(prevMax%3==val) dp[r][c] = prevMax+1;
                else{
                    // 마시지 못하면 이전 위치까지의 최대값을 넣어준다.
                    dp[r][c] = prevMax;
                }

                max = Math.max(dp[r][c], max);
            }
        }

        // System.out.println(builder(dp));
        System.out.println(max);

    }

    static String builder(int[][] dp){
        int N = dp.length;

        StringBuilder sb = new StringBuilder();
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                sb.append(dp[r][c]).append(" ");
            }
            sb.append("\n");
        }

        return String.valueOf(sb);
    }



}
