import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int startNum = Integer.parseInt(br.readLine());

        // 1-idx 기준.
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for(int v=0; v<=V; v++){
            graph.add(new ArrayList<>());
        }

        // 유방향 그래프
        for(int e=0; e<E; e++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            Node startNode = new Node(to, cost);

            graph.get(start).add(startNode);
        }

        // 최소 비용을 기록하기 위한 dist배열 생성.
        // 1-idx기준.
        int[] dist = new int[V+1];
        for(int v=0; v<=V; v++){
            dist[v] = Integer.MAX_VALUE;
        }
        Node startNode = new Node(startNum,0);
        dijkstra(graph, dist, startNode);

        StringBuilder sb = new StringBuilder();
        for(int v=1; v<=V; v++){
            if(dist[v]==Integer.MAX_VALUE) sb.append("INF");
            else sb.append(dist[v]);

            if(v!=V) sb.append("\n");
        }

        System.out.println(sb);

    }

    // 다익스트라로 한 노드에서 다른 노드까지의 최소 거리를 찾는다.
    static void dijkstra(ArrayList<ArrayList<Node>> graph, int[] dist, Node startNode){
        PriorityQueue<Node> pq = new PriorityQueue<>(
                (Node n1, Node n2) -> n1.cost-n2.cost
        );

        // 시작점은 0으로 처리.
        pq.add(startNode);
        dist[startNode.to] = 0;

        while(!pq.isEmpty()){
            Node curr = pq.poll();
            int to = curr.to ;
            int cost = curr.cost;
            
            // 인접 노드 중 비용이 가장 적은 것만,
            // 최소 비용으로 갱신

            // 노드에 비용을 누적해가면서,
            // 하나의 지점에서 다른 지점까지의 거리를 확인한다.
            ArrayList<Node> neighbors = graph.get(to);
            for(Node neigh:neighbors){
                int newCost = cost + neigh.cost;

                if(newCost<dist[neigh.to]){
                    dist[neigh.to] = newCost;
                    pq.add(new Node(neigh.to, newCost));
                }
            }

        }


    }

    static class Node{
        int to;
        int cost;

        public Node(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
    }

}
