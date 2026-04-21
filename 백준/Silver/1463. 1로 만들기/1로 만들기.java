import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        //1-idx기준.
        int[] dp = new int[N+1];

        // 테뷸레이션 방식으로 작은값에서 큰 값을 채워나가는 방식으로 푼다.
        for(int n=2; n<=N; n++){
            // 2,3으로 나눴을 때 값, n-1로 의 값 중 더 작은 값이 dp[n] 값이 된다.
            int min = dp[n-1]+1;

            if(n%2==0) min = Math.min( min , dp[n/2] + 1);

            if(n%3==0) min = Math.min( min , dp[n/3] + 1);

            dp[n] = min;
        }

        // System.out.println(Arrays.toString(dp));
        System.out.println(dp[N]);



    }


    // 이분탐색, 슬라이딩 윈도우, 투포인터
    // 빡센 구현
}
