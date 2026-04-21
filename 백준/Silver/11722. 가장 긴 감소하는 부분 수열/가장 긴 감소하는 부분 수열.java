import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){
            arr[n] = Integer.parseInt(st.nextToken());
        }

        // 감소하는 수열의 길이를 저장하는 dp 배열 생성
        int[] dp = new int[N];
        for(int n=0; n<N; n++){
            dp[n]=1;
        }

        // 각 지점에서 자신보다 큰 숫자가 있으면,
        // 길이를 늘려준다.
        int max = -1;
        for(int i=0; i<N; i++){
            for(int j=0; j<i; j++){
                if(arr[j]>arr[i]){
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }

        // System.out.println(Arrays.toString(dp));
        System.out.println(max);
    }

    // 가장 긴 감소하는 수열을 구해라.
}
