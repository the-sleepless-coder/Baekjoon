import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[] prefix_sum = new int[N];

        for(int n=0; n<N; n++){
            arr[n] = Integer.parseInt(st.nextToken());

            if(n==0) prefix_sum[0] = arr[0];
            else{
                prefix_sum[n] = prefix_sum[n-1]+arr[n];
            }
        }

        // min에는 sum 합이 S이상이면서,
        // 가장 짧은 길이를 저장한다.
        int min = Integer.MAX_VALUE;
        int startIdx = 0;
        int endIdx = 0;

        // 2개의 인덱스가 같을 경우도 포함한다.
        // 자기 자신 하나만의 합을 구하기 위함이다.
        while(startIdx<=endIdx){
            int sum = -1;
            if(startIdx==0) sum = prefix_sum[endIdx];
            else{
                sum = prefix_sum[endIdx] - prefix_sum[startIdx-1];
            }
            
            // 당연히 최소값을 구하고 나서,
            // 인덱스 처리를 해줘야 한다.
            // 합이 작거나 같다면 endIdx를 늘려준다.
            if(sum<=S){
                if(sum==S){
                    min = Math.min( endIdx-startIdx + 1, min);
                }

                endIdx++;
            }
            // 합이 더 크다면 값을 더 줄이도록 startIdx를 늘려준다.
            else if(sum>S){
                min = Math.min(endIdx-startIdx+1, min);

                startIdx++;
            }

            // 값을 다 더해도 S에 도달하지 못한다면 break를 해준다.
            if(endIdx >= N) break;
        }

        StringBuilder sb = new StringBuilder();
        if(min==Integer.MAX_VALUE) sb.append(0);
        else{
            sb.append(min);
        }

        System.out.println(sb);

    }
    // prefix_sum[endIdx] - prefix_sum[startIdx-1] < target
    // end Idx ++;

    // prefix_sum[endIdx ] - prefix_sum[startIdx-1]>target
    // startIdx ++;

    // arr[ start Idx] + arr[end Idx]

    // 10 16
    // 1 1 1 1 1 1 1 1 1 1 1 1 15
}
