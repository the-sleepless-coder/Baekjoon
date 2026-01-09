import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 한번 탐색을 하고 나서 해당 깊이에 도달했으면 출력하고,
    // 다시 이전 깊이에서 탐색을 이어나간다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[N];
        int[] path = new int[R];

        StringBuilder sb = new StringBuilder();

        backtrack(N, R, visited, path, 0, sb);
        System.out.println(sb);
    }


    public static void backtrack(int N, int R, boolean[] visited, int[] path, int depth, StringBuilder sb){
        // depth가 R에 도달했을 때,
        // 해당 숫자를 출력한다.
        if(depth==R){
            for(int i=0; i<R; i++){
                sb.append(path[i]).append(" ");
            }
            sb.append("\n");

            // 함수가 여기에서 종료가 돼야,
            // 다시 이전 depth로 돌아가서 탐색을 할 수 있다.
            return;
        }

        for(int i=0; i<N; i++){
            // 방문하지 않는 숫자에 대한 방문.
            // 깊이를 늘려가며 방문 후,
            // 해당 깊이 방문하고 나서 다시 뒤로 한단계 빠져서 다시 탐색 진행

            // 해당 depth마다 path에 값을 넣어야 한다.

            if(!visited[i]){
                visited[i] = true;
                path[depth] = i+1;
                backtrack(N, R, visited, path, depth+1, sb);
                visited[i] = false;
            }

        }

    }

}

