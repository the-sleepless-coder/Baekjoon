import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int[] arr, res;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        res = new int[M];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(N, M, 0, 0);

        System.out.println(sb);

    }

    public static void dfs(int N, int M, int depth, int start){
        if(depth == M){
            for(int i=0; i<M; i++){
               sb.append(res[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        // 이미 방문했던 요소는 다시 방문하지 않게 하기 위해서는,
        // 출력을 시작하는 시점인 start 변수를 다르게 하면 된다.
        // 0 번째 인덱스에서 1~3번째 인덱스를, res에 넣고 출력한다.
        // 1 번째 인덱스에서 2~3번째 인덱스를, res에 넣고 출력한다.
        for(int i = start; i < N; i++){
            res[depth] = arr[i];
            dfs(N, M, depth + 1, i + 1);
        }

    }

}
