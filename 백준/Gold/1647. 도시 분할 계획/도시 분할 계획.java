import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");

        int V = Integer.parseInt(strArr[0]);
        int E = Integer.parseInt(strArr[1]);

        //1-idx 기준.
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for(int v=0; v<=V; v++){
            graph.add(new ArrayList<>());
        }

        for(int e=0; e<E; e++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            Node startingNode = new Node(to, cost);
            Node toNode = new Node(start, cost);

            graph.get(start).add(startingNode);
            graph.get(to).add(toNode);
        }

        // System.out.println(graph);

        boolean[] visited = new boolean[V+1];
        Node startNode = new Node(1,0);

        // 애초에 최대값만 알면 되니까 최대값만 기록해두고, 빼는 것이 훨씬 더 빠르다.
        int[] resultArr = mspOptimized(graph, visited, startNode);

        int totalCost = resultArr[0];
        int maxCost = resultArr[1];

        // Collections.sort(order, (Node n1, Node n2)->n2.cost-n1.cost);
        // int maxCost = order.get(0).cost;

        int result = totalCost - maxCost;
        // System.out.println(order);
        System.out.println(result);
    }

    // 최대값을 기록해두고 빼는 방식
    // 정렬이 필요 없어서 훨씬 더 빠름.
    static int[] mspOptimized(ArrayList<ArrayList<Node>>graph, boolean[] visited, Node startNode){
        PriorityQueue<Node> pq = new PriorityQueue<>(
                (Node n1, Node n2)-> n1.cost-n2.cost
        );

        pq.add(startNode);

        // 굳이 정렬할 필요가 없다.
        // 그냥 최대 비용만 구하고 빼면 된다.
        int[] result = new int[2];
        int totalCost = 0;
        int maxCost = -1;

        while(!pq.isEmpty()){
            Node curr = pq.poll();

            // 가장 작은 비용의 간선을 선택하고,
            // 두 노드를 연결시켜준다.
            if(visited[curr.to]) continue;
            visited[curr.to] = true;
            totalCost += curr.cost;
            maxCost = Math.max(curr.cost, maxCost);

            // 주어진 노드에서 연결된 것 중에서,
            // 더해질만한 간선 후보를 더한다.
            ArrayList<Node> neighbors = graph.get(curr.to);
            for(Node neigh:neighbors){
                if(!visited[neigh.to]){
                    pq.add(neigh);
                }
            }
        }

        result[0]=totalCost;
        result[1]=maxCost;

        return result;

    }

    // 마지막으로 들어간 Node순서를 알기 위한 order배열 형성.
    static int msp(ArrayList<ArrayList<Node>>graph, boolean[] visited, Node startNode, ArrayList<Node> order){
        PriorityQueue<Node> pq = new PriorityQueue<>(
                (Node n1, Node n2)-> n1.cost-n2.cost
        );

        pq.add(startNode);

        int totalCost = 0;

        while(!pq.isEmpty()){
            Node curr = pq.poll();

            // 가장 작은 비용의 간선을 선택하고,
            // 두 노드를 연결시켜준다.
            if(visited[curr.to]) continue;
            visited[curr.to] = true;
            totalCost += curr.cost;
            order.add(curr);

            // 주어진 노드에서 연결된 것 중에서,
            // 더해질만한 간선 후보를 더한다.
            ArrayList<Node> neighbors = graph.get(curr.to);
            for(Node neigh:neighbors){
                if(!visited[neigh.to]){
                    pq.add(neigh);
                }
            }
        }

        return totalCost;

    }

    static class Node{
        int to;
        int cost;

        public Node(int to, int cost){
            this.to = to;
            this.cost = cost;
        }

        public String toString(){
            return String.format("to:%d cost:%d", to, cost);
        }

    }

}
// 아이디어는 비교적 단순하다.
// 모든 정점을 이어주는 최소 비용을 구하고,
// 그 다음에 가장 간선 비용이 높은 것 하나만 빼주면 된다.

// 가장 마지막에 더해지는 간선 비용은 제외해주면 된다.

//     1----------6
//     | \      / |
//     2 - 5---/  |
//     |   |      |
//     3 - 4 -----|
//     |          |
//     7----------