import java.util.*;

public class Main {
    static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        int M = Integer.parseInt(sc.nextLine());

        // 2차원 ArrayList 자료형을 형성하고, graph에 1 인덱스를 기준으로 graph를 형성한다.
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        //graph에 노드에 따라 양방향으로 넣는다.
        for(int i = 0; i < M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph.get(a).add(b);
            graph.get(b).add(a);
        }



        // System.out.println(graph);
        // 1이라는 시작점에서 dfs를 통해, 몇개의 노드와 연결 돼 있는지를 찾는다.
        dfs(graph, 1, N);
        System.out.println(cnt-1);


    }

    //
    public static void dfs(ArrayList<ArrayList<Integer>> graph, int start, int N){
        boolean[] visited = new boolean[N+1];
        Stack<Integer> s = new Stack<>();

        // Stack에 처음 숫자를 넣고, visited = true로 처리한다.
        s.add(start);
        visited[start] = true;

        // Stack에 있는 값을 하나씩 뽑아서 curr로 받고, 해당 노드와 인접한 노드 중 방문하지 않는 것을 방문한다.
        while(!s.isEmpty()){
            int curr = s.pop();

            //System.out.println(curr);
            cnt++;

            // curr의 해당 노드 중 인접하지 않는 것을 방문하고, Stack에 추가해서 나중에 탐색하도록 만든다.
            for(int node: graph.get(curr)){
                if(!visited[node]){
                    s.add(node);
                    visited[node] = true;
                }
            }

        }



    }

    public static void bfs(){

    }


}
