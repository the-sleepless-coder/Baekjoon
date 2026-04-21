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


        int[] dp = new int[N];
        for(int i=0; i<N; i++){
            dp[i] = arr[i];
        }

        // dp배열에 각 지점별로 이전에 가장 큰 증가하는 값과 현재 자기 자신의 값을 더하고,
        // 여러 후보 중 제일 큰 값을 dp 배열에 저장한다.

        // 가장 큰 합을 가진 값을 출력한다.
        int max = -1;
        for(int i=0; i<N; i++){
            for(int j=0; j<i; j++){
                if(arr[j] < arr[i]){
                    dp[i] = Math.max(dp[j]+arr[i], dp[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }

        // System.out.println(Arrays.toString(dp));
        System.out.println(max);

    }
//10
//1 100 2 50 200 3 5 6 7 8

    // 증가하는 수열 중 합이 가장 큰 것을 구한다.
    static int[] LIS(int N, int[] arr){



        return null;
    }


    //가장 큰 증가하는 부분 수열.
}
