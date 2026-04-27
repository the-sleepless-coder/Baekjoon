import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] prefix_sum = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){
            arr[n] = Integer.parseInt(st.nextToken());

            if(n==0) prefix_sum[0] = arr[0];
            else{
                prefix_sum[n] = prefix_sum[n-1] + arr[n];
            }
        }


        StringBuilder sb = new StringBuilder();
        for(int k=0; k<K; k++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            start -= 1;
            end -= 1;

            int result = 0;
            if(start==0){
                result = prefix_sum[end];
            }else{
                result = prefix_sum[end]-prefix_sum[start-1];
            }

            sb.append(result).append("\n");
        }

        System.out.print(sb);


        // J~ P 까지 누적합을 구할 경우
        // 한번 계산된 누적합을 이용해서, 구간에 대한 합을 구하면 된다.
        // prefix_sum[P] - prefix_sum[J-1]

        // 5 9 12 14 15
        // 5, 4, 3, 2, 1
        // prefix_sum[i+1] = prefix_sum[i]+data[i]
        // 그러니까 이전 값에 대한 누적합을 이용해서, 합을 구하는 방식이다.

    }
}
