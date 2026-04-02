import java.util.*;

class Solution {
    public int solution(int N, int[][] computers) {
        int answer = 0;
        
        // 110
        // 110
        // 001
        
        // 1
        // 0
        // 
        
        //1-idx기준.
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int n=0; n<N; n++){
            graph.add(new ArrayList<>());
        }
        
        // 양방향 그래프 형성.
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                if(r<c && computers[r][c]==1){
                    graph.get(r).add(c);
                    graph.get(c).add(r);
                }
            }
        }
        
        System.out.println(graph);
        
        // 연결된 네트워크의 개수를 구해준다.
        int count = 0 ;
        boolean[] visited = new boolean[N];
        for(int n=0; n<N; n++){
            if(!visited[n]){
                dfs(graph, visited, n);
                count++;
            }
        }
        
        return count;
    }
    
    // 연결된 노드를 구한다.
    // 깊이를 우선적으로 탐색하여, visited를 통해 방문 여부를 표시한다.
    
    // 유형을 외울 것이 아니라, 
    // 코드 구조가 왜 그렇게 짜이는지를 생각하면서 푸는 것이 훨씬 중요하다. 
    
    // 조건은 바뀔 수 있고 그것에 맞춰서 코드를 짜는 것이, 
    // 알고리즘 테스트의 핵심이니까.
    static void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int start){
        Stack<Integer> stack = new Stack<>();
        stack.add(start);
        visited[start] = true;
        
        while(!stack.isEmpty()){
            int curr = stack.pop();
            
            ArrayList<Integer> neighbors = graph.get(curr);
            for(int neigh:neighbors){
                if(!visited[neigh]){
                    stack.add(neigh);
                    visited[neigh] = true;
                }
            }
        }
        
    }
}