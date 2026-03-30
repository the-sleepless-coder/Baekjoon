import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for(int v=0; v<=V; v++){
            graph.add(new ArrayList<>());
        }

        for(int e=0; e<E; e++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            Node startNode = new Node(to, cost);
            Node toNode = new Node(start, cost);

            graph.get(start).add(startNode);
            graph.get(to).add(toNode);
        }

        //1-idx기준.
        boolean[] visited = new boolean[V+1];
        Node startNode = new Node(1, 0);
        int totCost = msp(graph, visited, startNode);
        int addedCost = incCost(V);

        int result = totCost+addedCost*t;

        System.out.println(result);
    }

    static int incCost(int V) {
        if (V == 1) return 0;
        if (V == 2) return 1;

        return (1 + V - 2) * (V - 2) / 2;
        // (v-1) * (v-2) /2
    }

    // 모든 정점을 다 지나는 최소 비용을 구한다.
    static int msp(ArrayList<ArrayList<Node>> graph, boolean[] visited, Node startNode){
        PriorityQueue<Node> pq = new PriorityQueue<>(
                (Node n1, Node n2)-> n1.cost-n2.cost
        );

        pq.add(startNode);

        int totCost = 0;
        while(!pq.isEmpty()){
            Node curr = pq.poll();

            // 가장 작은 비용을 가진 간선을 고르고,
            // 전체 비용에 더한다.
            if(visited[curr.to]) continue;
            visited[curr.to]= true;
            totCost += curr.cost;

            // to에서 탐색할 수 있는 노드 집합을 가져오고,
            // 방문하지 않는 것들을 pq에 더해서 최소 간선의 후보로 잡는다.
            ArrayList<Node> neighbors = graph.get(curr.to);
            for(Node neigh:neighbors){
                if(!visited[neigh.to]){
                    pq.add(neigh);
                }
            }
        }

        return totCost;
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
