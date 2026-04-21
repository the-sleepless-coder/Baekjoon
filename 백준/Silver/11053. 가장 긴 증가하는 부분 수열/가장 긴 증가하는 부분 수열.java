import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int n=0; n<N; n++){
            arr[n]=Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        for(int i=0; i<N; i++){
            dp[i]=1;
        }

        // 증가하는 수열 중에서 길이가 긴 것을 dp배열에 저장한다.
        // 각 시작점에서 증가하는 수열을 구하되,
        // 그 중에서 가장 긴 것을 구한다.
        for(int i=0; i<N; i++){
            for(int j=0; j<i; j++){
                if(arr[j]<arr[i]){
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
            // System.out.println(Arrays.toString(dp));
        }

        /**
         for(int i=0;i<=N-2; i++){
             for(int j=i+1; j<N; j++){
                 if(arr[i]<arr[j]){
                    dp[j] = Math.max(dp[i]+1, dp[j]);
                 }
             }
         }
         */

        int max = -1;
        for(int i=0; i<N; i++){
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);

        // 가장 긴 증가하는 수열
        // 3,1,4,2,5,6,7,8
    }
}
