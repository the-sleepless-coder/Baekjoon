import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] arr;
    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 조합을 추적할 배열과 방문 여부를 확인할 배열을 만든다.
        arr = new int[M];
        visited = new boolean[N];

        dfs(N, M, 0);

        System.out.print(sb);
    }

    public static void dfs(int N, int M, int depth){
        if(depth == M){
            for(int i=0; i<M; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        // 방문 여부 자체를 확인하지 않으면, 애초에 겹치는 값도 출력할 수 있다.
        for(int i=0; i < N; i++){
            arr[depth] = i+1;
            dfs(N, M, depth+1);
        }



    }
}
