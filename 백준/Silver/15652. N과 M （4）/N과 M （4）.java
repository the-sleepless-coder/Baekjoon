import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] arr, tot;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 조합을 추적할 배열과 방문 여부를 확인할 배열을 만든다.
        arr = new int[M];
        tot = new int[N];
        for(int i=0; i<N; i++){
            tot[i] = i+1;
        }

        dfs(N, M, 0, 1);

        System.out.print(sb);
    }

    public static void dfs(int N, int M, int depth, int temp){
        if(depth == M){
            // 비내림차순에 해당되는 항목을 출력한다.
            for(int i = 0; i < M; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        // 방문 여부 자체를 확인하지 않으면, 애초에 겹치는 값도 출력할 수 있다.
        // StringBuilder에서 출력하는 데서 값을 처리하는 것 보다는,
        // arr에 넣는 곳에서 값을 처리하는 편이 더 낫다.
        // 재귀를 돌면서 앞에 있는 값보다 넣으려고 하는 i의 값이 크거나 같을 때에만,
        // arr에 넣는다.
        for(int i=1; i <= N; i++){
            if(temp <= i){
                arr[depth] = i;
                temp = arr[depth];
                dfs(N, M, depth + 1, temp);
            }
        }



    }
}