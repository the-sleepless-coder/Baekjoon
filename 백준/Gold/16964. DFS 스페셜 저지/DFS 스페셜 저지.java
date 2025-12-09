import java.io.InputStreamReader;
import java.io.*;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 트리에 대한 DFS 순회
        int V = Integer.parseInt(br.readLine());
        int E = V-1;

        // 그래프를 1-index 기준으로 만들어준다.
        // 0 1    2     3   4    5
        //   2,3  1,5   1   2    2
        List<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=V; i++){
            graph.add(new ArrayList<Integer>());
        }

        // 양방향 그래프를 만들어준다.
        for(int i=0; i < E; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph.get(start).add(end);
            graph.get(end).add(start);

        }

        // 정답 문자열 입력 받기
        // 각 숫자별로 몇 번째에 나오는지 order 클래스에 넣어준다.
        String answer = br.readLine();
        String[] strArr = answer.split(" ");
        int strLen = strArr.length;

        List<Order> orderList = new ArrayList<>();
        Map<Integer, Integer> orderMap = new HashMap<>();
        for(int i=0; i<strLen; i++){
            orderList.add(new Order());
            int num = Integer.parseInt(strArr[i]);
            int order = i+1;
            orderList.set(i,new Order(num , order));
            orderMap.put(num, order);
        }

        // System.out.println(orderList);

        // 정답의 순서에 맞게 그래프의 순서를 재정렬하고,
        // DFS를 돌아준다.

        // 그러면 모든 경우를 돌 필요 없이,
        // 정답에 맞는 순서가 DFS로 도는지를 알 수 있다.

        // 불변 객체, 가변 객체애 대한 개념 정리
        // String / String Builder

        // 얕은 복사, 깊은 복사
        // 참조값이 같아서는 안되기 떄문에 깊은 복사 이용.
        boolean[] visited = new boolean[V+1];
        int start = 1;
        StringBuilder sb = new StringBuilder();

        for(int i=0; i < graph.size(); i++){
            // 정렬할 수 있게 neighborOrder를 만들어준다.
            ArrayList<Integer> neighbors = graph.get(i);

            ArrayList<Order> neighborOrder = new ArrayList<>();
            for(int j=0; j < neighbors.size(); j++){
                int num = neighbors.get(j);
                int order = orderMap.get(num);
                neighborOrder.add(new Order( num, order));
            }

            // ArrayList에 대한 정적 함수이기 때문에,
            // ArrayList으로 정렬을 해줘야 한다.

            // order 기준으로 숫자를 정렬해주고,
            // neighbors에 반영해준다.
            Collections.sort(neighborOrder, (Order o1, Order o2) -> Integer.compare(o1.order, o2.order));

            for(int j=0; j<neighborOrder.size(); j++){
                neighbors.set( j, neighborOrder.get(j).number );
            }

        }

        // System.out.println(graph);
        dfs(graph, visited, start, sb);
        // System.out.println(sb);

        if(sb.toString().trim().equals(answer)){
            System.out.println(1);
        }else{
            System.out.println(0);
        }

    }

    // 재귀 방식으로 트리 순회
    public static void dfs(List<ArrayList<Integer>> graph, boolean[] visited, int start, StringBuilder sb){
        if(visited[start])
            return;
        visited[start] = true;
        sb.append(start).append(" ");

        ArrayList<Integer> neigh = graph.get(start);

        for(int node:neigh){
            dfs(graph, visited, node,sb);
        }

    }

    public static class Order{
        int number;
        int order;

        public Order(){

        }
        public Order (int number, int order){
            this.number = number;
            this.order = order;
        }

        @Override
        public String toString(){
            return "number: " + number + "order: " + order ;
        }
    }

//5
//1 2
//1 3
//1 5
//2 4
//1 3 5 2 4

}
