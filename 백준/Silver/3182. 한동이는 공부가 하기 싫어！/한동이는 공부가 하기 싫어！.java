import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int idx=0; idx<=N; idx++){
            graph.add(new ArrayList<Integer>());
        }

        // 그래프 관계를 만들어준다.
        for(int idx=1; idx<=N; idx++){
            int start = idx;
            int end = Integer.parseInt(br.readLine());

            graph.get(start).add(end);

        }


        // dfs를 통해서 각 시작점에서 알 수 있는 사람의 수를 구한다.
        // 각 인덱스별로 연락할 수 있는 사람의 수를 기록한다.
        // 1-idx 기준.
        int[] result = new int[N+1];
        for(int idx=1; idx<=N; idx++){

            // 1-idx 기준으로 만든다.
            int start = idx;
            boolean[] visited = new boolean[N+1];

            int count = dfs(graph, visited, start);

            result[start] = count;
        }

        int max= -1;
        // 가장 많은 사람을 알 수 있는 연결관계의 시작점을 찾아본다.
        for(int idx=0; idx<=N; idx++){
            max = Math.max(result[idx], max);
        }

        // max를 기록한 resultIdx중 가장 작은 것을 구한다.
        int resultIdx = -1;
        for(int idx=0; idx<=N; idx++){
            if(result[idx]== max){
                resultIdx = idx;
                break;
            }
        }

        System.out.println(resultIdx);

    }

    // dfs를 통해서 몇명의 사람을 연락할 수 있는지를 확인해본다.
    static int dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int start){
        Stack<Integer> stack = new Stack<>();
        stack.add(start);
        visited[start] = true;

        int count = 0;
        while(!stack.isEmpty()){
            int curr = stack.pop();

            ArrayList<Integer> neighbors = graph.get(curr);

            for(int neigh: neighbors){
                if(!visited[neigh]){
                    visited[neigh] = true;
                    stack.add(neigh);
                    count++;
                }
            }
        }

        return count;

    }
}

