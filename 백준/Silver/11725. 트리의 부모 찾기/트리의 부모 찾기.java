import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 1-idx기준.
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int n=0; n<=N; n++){
            graph.add(new ArrayList<>());
        }

        // 어차피 노드 간 연결 관계만 표현하면 되기 때문에,
        // 노드를 굳이 안 만들어줘도 된다.
        for(int n=0; n<N-1; n++){
            String input = br.readLine();
            String[] strArr = input.split(" ");

            int node1 = Integer.parseInt(strArr[0]);
            int node2 = Integer.parseInt(strArr[1]);

            graph.get(node1).add(node2);
            graph.get(node2).add(node1);

        }

        // System.out.println(graph);

        boolean[] visited = new boolean[N+1];
        int startingNum = 1;
        Map<Integer, ChildrenParent> result = new HashMap<>();
        // bfs(graph, visited, startingNum, result);

        // 1-idx기준.
        int[] parentArr = new int[N+1];
        bfsFixed(graph, visited, startingNum, parentArr);
        /**
        for(Map<Integer, Integer> map: result){
            for(int key: map.keySet()){
                sb.append(key).append(" ").append(map.get(key)).append("\n");
            }
        }
         */

        StringBuilder sb = new StringBuilder();
        for(int child=2; child<=N; child++){
            //ChildrenParent cp = result.get(child);
            //sb.append(cp.parent);

            int parent =  parentArr[child];
            sb.append(parent);
            if(child!=N) sb.append("\n");
        }

        System.out.println(sb);
    }

    // 양방향 그래프이기 때문에,
    // 방문하지 않는 것들만 현재 노드의 자식 노드 그룹으로 넣어준다.
    static void bfs(ArrayList<ArrayList<Integer>>graph, boolean[] visited, int startingNum, Map<Integer, ChildrenParent> result){

        Queue<Integer> q = new LinkedList<>();
        q.add(startingNum);
        visited[startingNum]= true;

        while(!q.isEmpty()){

            int curr = q.poll();

            // 아예 꺼내기 편하게,
            // 자식, 부모 관계를 Map에 넣고 그것을 result배열에 넣어준다.
            Node node = new Node(curr);
            ArrayList<Integer> neighbors = graph.get(curr);
            ArrayList<Integer> children = node.children;
            for(int neigh:neighbors){
                if(!visited[neigh]){
                    q.add(neigh);
                    visited[neigh] = true;
                    // children.add(neigh);

                    ChildrenParent cp = new ChildrenParent(neigh, curr);
                    result.put(neigh, cp);
                }
            }


        }

    }

    // 최적화 코드
    // 굳이 새로운 클래스를 만들 필요가 없다.
    // parentArr에 넣어서 처리하면 훨씬 더 코드가 단순해진다.
    // 이래서 자료구조가 정말 중요하다.
    // 무엇에 데이터를 담아서 처리하냐에 따라 시간 복잡도가 아니라,
    // 새로운 데이터를 생성하는 데 드는 시간과 메모리를 둘다 아낄 수 있으니까 말이야.
    static void bfsFixed(ArrayList<ArrayList<Integer>>graph, boolean[] visited, int startingNum, int[] parentArr){

        Queue<Integer> q = new LinkedList<>();
        q.add(startingNum);
        visited[startingNum]= true;

        while(!q.isEmpty()){

            int curr = q.poll();

            // 아예 꺼내기 편하게,
            // 자식, 부모 관계를 Map에 넣고 그것을 result배열에 넣어준다.
            Node node = new Node(curr);
            ArrayList<Integer> neighbors = graph.get(curr);
            ArrayList<Integer> children = node.children;
            for(int neigh:neighbors){
                if(!visited[neigh]){
                    q.add(neigh);
                    visited[neigh] = true;
                    // children.add(neigh);

                    parentArr[neigh] = curr;
                }
            }


        }



    }

    static class ChildrenParent{
        int children;
        int parent;

        public ChildrenParent(int children, int parent){
            this.children = children;
            this.parent = parent;
        }

    }

    // ArrayList를 무조건 초기화해줘야 값을 넣을 수 있다.
    static class Node{
        int val;
        ArrayList<Integer> children ;

        public Node(int val){
            this.val = val;
            this.children = new ArrayList<>();
        }

        public String toString(){
            return String.format("%d", val);
        }

    }

}

// 각 노드의 부모를 구하여라.
// 1번 루트 노드에서부터 아래노드까지 트리를 탐색한다.
// 위에서부터 인접한 노드를 탐색하면서, 탐색하지 않게 되는 것이 자식 노드가 된다.