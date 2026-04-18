import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int root = -1;
        for(int n=0; n<N; n++){
            arr[n] = Integer.parseInt(st.nextToken());
            if(arr[n]==-1) root = n;
        }

        int d = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int n=0; n<N; n++){
            graph.add(new ArrayList<>());
        }

        // 루트를 제외하고 부모-자식 관계 형성하기.
        for(int c=0; c<N; c++){
            int parent = arr[c];
            if(parent!=-1) graph.get(parent).add(c);
        }

        // System.out.println(graph);

        boolean[] isNode = new boolean[N];
        for(int n=0; n<N; n++){
            isNode[n]= true;
        }

        checkLinked(graph, d, isNode);
        // System.out.println(Arrays.toString(isNode));

        int result = dfs(graph, root, isNode);

        System.out.println(result);

    }

    // 어차피 트리는 그래프의 특수한 형태이니,
    // 부모-자식 관계가 형성 돼 있고 사이클이 없는 형태의 자료구조이다.
    // 그래서 그래프를 dfs로 돌면서 연결 돼 있는 노드가 0개인 노드의 개수를 세면 그만이다.
    static int dfs(ArrayList<ArrayList<Integer>> graph, int node, boolean[] isNode){
        if(!isNode[node]) return 0;

        int sum =0;

        // 한 계층씩 노드를 타고 들어가서, 재귀 방식으로 DFS를 실행한다.
        // 자식 노드가 0개일 때만 1을 더하고,
        // 각 계층 안에 있는 sum을 하나의 계층씩 올라가면서 더한다.
        // 그래서 최종적인 sum에 합산하면 전체 리프 노드 자식을 리프에서부터 부모까지 다 합산해서 알 수 있다.
        ArrayList<Integer> neighbors = graph.get(node);
        int childNum = 0;
        for(int neigh: neighbors){
            if(isNode[neigh]){
                childNum++;
                sum+=dfs(graph, neigh, isNode);
            }
        }

        if(childNum==0) return 1;

        return sum;
    }

    // 연결 돼 있는 노드를 재귀적으로 모두 false 처리해준다.
    static void checkLinked(ArrayList<ArrayList<Integer>> graph, int d, boolean[] isNode){
        ArrayList<Integer> neighbors = graph.get(d);
        isNode[d] = false;

        for(int neigh: neighbors){
            checkLinked(graph, neigh, isNode);
        }
    }

}
