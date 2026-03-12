import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int V = Integer.parseInt(br.readLine());

        int[][] intArr = new int[V][V];

        //1-idx 기준 graph 생성.
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for(int idx=0; idx<=V; idx++){
            graph.add(new ArrayList<>());
        }

        for(int r=0; r<V; r++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c=0; c<V; c++){
                intArr[r][c]=Integer.parseInt(st.nextToken());

                // 양방향 그래프를 만들기 위한 코드.
                if(r<c){
                    int start = r;
                    int to = c;
                    int cost = intArr[r][c];

                    graph.get(start).add(new Node(to, cost));
                    graph.get(to).add(new Node(start, cost));
                }

            }
        }

        //1-idx기준으로 생성
        // int를 더하다보면 long 이 나올 수 있음.
        // 그래서 마지막 결과만 long으로 받으면 된다.
        boolean[] visited = new boolean[V+1];
        Node start = new Node(1,0);
        long result = prim(graph, start, visited);

        System.out.println(result);

    }

    static class Node{
        int to;
        int cost;

        public Node(int to, int cost){
            this.to= to;
            this.cost =cost;
        }
    }

    // 프림을 통해서 그래프의 모든 간선을 이어주는 서브 그래프인 트리를 찾는다.
    static long prim(ArrayList<ArrayList<Node>> graph, Node start, boolean[] visited){
        long totCost = 0;

        // cost 기준 가장 작은 것 기준으로,
        // 우선순위 큐를 정렬해준다.
        PriorityQueue<Node> pq = new PriorityQueue<>(
                (Node node1, Node node2) -> {return Integer.compare(node1.cost, node2.cost);}
        );
        pq.add(start);

        while(!pq.isEmpty()){
            Node curr = pq.poll();
            int to = curr.to;
            int cost = curr.cost;

            // 노드를 방문을 안 했다면 방문처리하고, 비용을 더해준다.
            if(visited[to]) continue;
            totCost +=cost;
            visited[to]=true;

            // 주어진 노드와 연결된 다른 노드 중 방문 안한 것을,
            // 간선 중 최소 비용이 나올 수 있는 것의 후보로 잡는다.
            ArrayList<Node> neighbors = graph.get(to);
            for(Node neigh:neighbors){
                if(!visited[neigh.to]){
                    pq.add(neigh);
                }

            }

        }

        return totCost;
    }



}

// DP, 그리디, 백트래킹, 재귀
// 자료구조 다시 한번 더 구현해보기.
// CS, 알고리즘 위주로 공부