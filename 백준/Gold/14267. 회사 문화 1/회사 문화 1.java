import java.util.*;
import java.io.*;

public class Main{
    static int[] direct, parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        //1-idx기준
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int n=0; n<=N; n++){
            graph.add(new ArrayList<>());
        }

        // 부모 - 자식 관계를, 그래프 형태로 반영해준다.
        parents = new int[N+1];
        for(int c=1; c<= N; c++){
            int parent = Integer.parseInt(st.nextToken());
            if(parent==-1) continue;
            graph.get(parent).add(c);
            parents[c] = parent;
        }

        // System.out.println(graph);

        // 1-idx기준.
        // 직접적으로 칭찬 받은 값을 최상단 노드에 반영해준다.
        direct = new int[N+1];
        int[] scores = new int[N+1];
        for(int r=0; r<R; r++){
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());

            direct[node] += score;

        }

        // 직접적으로 받은 칭찬을 자식한테 전파한다.
        int root = 1;
        dfs(graph, root, scores);



        // System.out.println(Arrays.toString(scores));
        StringBuilder sb = new StringBuilder();
        for(int n=1; n<=N; n++){
            sb.append(scores[n]);
            if(n!=N) sb.append(" ");
        }

        System.out.println(sb);

    }

    // dfs를 통해서 모든 자식에 대해서 score를 더한다.
    // 한 계층씩 들어가면서 자기 자신을 포함해서 score를 더해간다.
    // 자식 = 부모까지 누적값 + 부모 칭찬 값
    static void dfs(ArrayList<ArrayList<Integer>> graph, int node, int[] scores){
        int parent = parents[node];
        scores[node] = scores[parent] + direct[node];

        ArrayList<Integer> neighbors = graph.get(node);
        for(int neigh: neighbors){
            dfs(graph, neigh, scores);

        }

    }

    // 상사가 직속 부하를 칭찬하면,
    // 그 부하의 모든 부하들이 칭찬 점수를 더한다.

    //    1
    //   2 2
    //  3 6
    // 4 6
    //5 12
}
