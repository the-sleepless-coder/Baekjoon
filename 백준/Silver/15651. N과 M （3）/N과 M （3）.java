import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N =Integer.parseInt(st.nextToken());
        int M =Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] sel = new int[M];
        for(int n=0;n<N; n++){
            arr[n]=n+1;
        }

        StringBuilder sb = new StringBuilder();
        int count=0;

        backtrack(arr, sel, count, sb);

        System.out.println(sb);

    }

    // 같은 수를 중복으로 골라도 된다.
    // 다만 수열은 중복돼서는 안된다.
    static void backtrack(int[] arr, int[] sel, int count, StringBuilder sb){
        int N = arr.length;
        int M = sel.length;

        // 목표 계층까지 도달했으면,
        // 원래 실행 흐름으로 돌아간다.
        if(count==M){
            for(int m=0;m<M; m++){
                sb.append(sel[m]).append(" ");
            }

            sb.append("\n");

            return;
        }

        // 마지막 계층에서는 숫자가 달라야 한다.
        // 그래야 중복되는 수열이 안 나오게 되니까 말이야.

        for(int n=0; n<N;n++){
            sel[count] = arr[n];
            count++;

            /**
            if(count==M){

            }
             */

            backtrack(arr, sel, count, sb);

            count--;
        }



    }
}

