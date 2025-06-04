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

        // 결과 값을 담을 arr 그리고 어떤 요소를 방문했는지를 보여줄 visited배열을 만든다.
        arr = new int[M];
        visited = new boolean[N];

        dfs(N, M, 0);
        System.out.println(sb);

    }

    public static void dfs(int N, int M, int depth){
        // 해당 깊이에 도달하면 배열에 있는 요소를 모두 출력한다.
        if(depth == M){
            for(int num : arr){
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        // 방문하지 않은 요소에 대해서 arr배열에 해당 숫자를 넣어주고,
        // dfs재귀함수를 돌면서 백트래킹을 실행해서 각 요소를 처리하고 다시 돌아오는 작업을 반복한다.
        // 특히 백트래킹에서 중요한 것은, 재귀함수를 나오면서 처리한 해당 요소를 다시 false로 만드는 것이다.
        // 그렇게 해야 다른 요소로 해당 처리된 요소를 다시 방문할 때, 해당 경우를 처리할 수 있으니까 말이다.
        // ex. 1 - 2, 1 - 3, 1- 4 // 2- 3, 2 - 4 같이 false처리를 하고 나와야 다른 요소에서 해당 요소를 다시 처리할 수 있다.
        for(int i = 0; i < N ; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i+1;
                dfs(N, M, depth+1);

                visited[i] = false;
            }
        }

    }

}
