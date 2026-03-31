import java.util.*;
import java.io.*;

public class Main{
    static int N= 5;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        //0-idx기준
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int v=0; v<V; v++){
            graph.add(new ArrayList<>());
        }

        for(int e=0; e<E; e++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph.get(start).add(to);
            graph.get(to).add(start);
        }

        // 각 시작점에서 depth가 5를 도달하는지 확인한다.
        boolean[] visited = new boolean[V];
        int result=0;
        for(int node=0; node<V; node++){
            int depth = 1;
            result = dfsBacktrack(graph, visited, node, depth);

            if(result==1) break;
        }

        System.out.println(result);

    }

    // 깊이가 5를 도달했을 때, 값을 1을 반환한다.
    // 그렇지 않으면 0을 반환한다.
    static int dfsBacktrack(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int node, int depth){
        if(depth==N) return 1;

        visited[node] = true;

        ArrayList<Integer> neighbors = graph.get(node);
        for(int neigh:neighbors){
            if(!visited[neigh]){
                int result = dfsBacktrack(graph, visited, neigh, depth+1);
                if(result==1) return 1;
            }
        }
        // depth==N을 도달하지 못하면 다시 되돌아가서,
        // 들어왔던 모든 계층에서 다른 노드를 탐색할 수 있도록 visited = false로 만들어준다.
        visited[node]=false;
        return 0;
    }

    static int dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int node, int depth){
        visited[node] = true;

        int maxDepth = depth;

        ArrayList<Integer> neighbors = graph.get(node);
        for(int neigh:neighbors){
            if(!visited[neigh]){
                int result = dfs(graph, visited, neigh, depth+1);
                maxDepth = Math.max(maxDepth, result);
            }
        }

        return maxDepth;
    }
}
