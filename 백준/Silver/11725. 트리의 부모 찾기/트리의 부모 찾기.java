import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 루트에서부터 아래로 내려오면서 부모를 찾는 방식.
        int N = Integer.parseInt(br.readLine());


        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int n=0; n<=N; n++){
            graph.add(new ArrayList<>());
        }

        // 노드 간 관계 형성.
        for(int n=0; n<N-1; n++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        // 1-idx 기준.
        boolean[] visited = new boolean[N+1];
        int[] parents = new int[N+1];

        // bfs방식으로 루트에서 노드까지,
        // 방문한 순서대로 부모-자식 관계를 형성한다.
        int root = 1;
        bfs(graph, root, visited, parents);

        StringBuilder sb = new StringBuilder();
        for(int n=2; n<=N; n++){
            sb.append(parents[n]);

            if(n!=N) sb.append("\n");

        }

        System.out.println(sb);

    }


    static void bfs(ArrayList<ArrayList<Integer>> graph, int start, boolean[] visited, int[] parents){
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()){

            int curr = q.poll();

            ArrayList<Integer> neighbors = graph.get(curr);

            // parents배열에 자식에 대한 부모를 기록해둔다.
            for(int neigh:neighbors){
                if(!visited[neigh]){
                    q.add(neigh);
                    visited[neigh] = true;

                    parents[neigh] = curr;
                }
            }
        }


    }
}
