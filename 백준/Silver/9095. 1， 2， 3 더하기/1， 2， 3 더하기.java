import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t=0; t<testCase; t++){

            int N = Integer.parseInt(br.readLine());

            int result = calNum(N);

            sb.append(result);

            if(t!=testCase-1)
                sb.append("\n");
            //System.out.println(result);
        }

        System.out.println(sb);

    }

    // 변수 초기화는 함수 밖에서,
    // 선언은 함수 안에서 하는 것이 깔끔한가?
    static int calNum(int N){
        if(N==1) return 1;
        if(N==2) return 2;
        if(N==3) return 4;

        // 1-idx기준.
        int[] dp = new int[N+1];
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;

        for(int idx=4; idx<=N; idx++){
            dp[idx] = dp[idx-1]+dp[idx-2]+dp[idx-3];
        }

        return dp[N];
    }

}

// dp
// dp[1] = 1
// dp[2] = 1+1, 2
// dp[3] = 1+1+1 | 1+2, 2+1 |  3
// dp[4] = 1+1+1+1| 2+1+1, 1+2+1, 1+1+2 | 2+2 | 3+1, 1+3
// dp[5] = 1+1+1+1+1 | 2+1+1+1, 1+2+1+1, 1+1+2+1, 1+1+1+2 | 2+2+1, 2+1+2, 1+2+2 | 3+1+1 *3 | 3+2
// dp[6] = 1+1+1+1+1+1 | 2+1+1+1+1, ...                   | 2+2+1+1, 2+1+2+1, 2+1+1+2, 1+2+1+2, 1+1+2+2 |

//            1로만           2+1 로만                        2로만       1,3으로만   2,3으로만  3으로만  1, 2, 3으로

// 그러니까 dp[i] = dp[i-1]+dp
// dp[i-1]에서 계산한 값 +1, dp[i-2]에서 계산한 값 +2, dp[i-3]에서 계산한 값 +3
// 그래서 3개의 개수를 더하면 dp[i]가 된다.