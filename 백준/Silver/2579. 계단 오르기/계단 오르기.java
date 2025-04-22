import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 10 20 15 25 10 20
    // 1  2  3  4  5  6
    // 1  1  0  1  0  1
    // 1  0  1  1  0  1
    // 0  1  1  0  1  1

    // 비어 있는 계단의 경우에 대한 분기
    // i%3 == 0
    // dp[i-1] + step[i]
    // i%3 == 1
    // dp[i-3] + step[i-1] + step[i]
    // i%3 == 2
    // dp[i-3] + step[i-2] + step[i]

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 한줄이 입력으로 나올 때마다, StringTokenizer를 생성하고 숫자를 받아준다.
        int N = Integer.parseInt(st.nextToken());
        int[] step = new int[N+1];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            step[i] = Integer.parseInt(st.nextToken());
        }

        // System.out.println(Arrays.toString(step));

        int[] dp = new int[N + 1];
        dp[1] = step[1];
        // N==1일 때, 답만 출력하고 끝내야 한다.
        if(N==1){
            System.out.println(dp[1]);
            return;
        }
        dp[2] = step[1] + step[2];
        for(int i = 3; i <= N; i++){
            // i-1번째를 밟으면 i-2번째는 밟지 않는다.
            int case1 = dp[i-3] + step[i-1] + step[i];

            // i-2번째를 밟으면 i-1번째는 밟지 않는다.
            int case2 = dp[i-2] + step[i];

            dp[i] = Math.max(case1, case2);
        }

        // System.out.println(Arrays.toString(dp));
        System.out.println(dp[N]);
    }
}
