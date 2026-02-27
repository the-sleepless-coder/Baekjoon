import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numArr = new int[N];
        for(int idx=0; idx<N; idx++){
            int num = Integer.parseInt(st.nextToken());
            numArr[idx] = num;
        }

        int[] dp = countLIS(numArr);
        // System.out.println(Arrays.toString(dp));
        
        int LISCount = -1;
        for(int idx=0; idx<N; idx++){
            LISCount = Math.max(LISCount, dp[idx]);
        }
        System.out.println(LISCount);

    }

    // dp로 가장 긴 증가하는 수열을 찾는다.
    static int[] countLIS(int[] numArr){
        int len = numArr.length;

        int[] dp = new int[len];
        for(int idx=0; idx<len; idx++){
            dp[idx]=1;
        }

        // 자기 자신의 뒤에 자기 자신 보다 큰 수가 있다면 +1을 해주고,
        // 해당 값과 기존에 있는 값을 비교해서 더 큰 수를 해당 자리에 넣어준다.
        for(int i=0; i<len; i++){

            for(int j=i+1; j<len; j++){
                if(numArr[i] < numArr[j]){
                    dp[j]= Math.max(dp[j] ,dp[i]+1);
                }
            }
        }

        return dp;

    }



}
// DP를 이용한 풀이
// 현재 위치보다 뒤에 있는 숫자 중, 더 큰 숫자가 있을 때 +1을 기록해주면 된다.