import java.util.*;

public class Main{
    static int[] p;
    
    // Edge를 클래스로 만들어서 객체를 형성할 수 있도록 한다.
    static class Edge{
        int from, to, cost;
        
        Edge(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
        
    }
    
    // 부모를 찾을 수 있는 find와
    // 서로 다른 집합인지를 확인하는 union함수를 만든다.
    
    // 자기 자신이 부모가 아니라면, 부모를 찾을 때까지 재귀적으로 함수를 돌린다.
    static int find(int x){
        
        if(x != p[x])
            p[x] = find(p[x]);
        
        return p[x];
    }
    
    // 서로 다른 집합에 포함돼 있는지 여부를 확인하는 union함수를 만든다.
    // 같은 함수에 들어 있다면 false, 
    // 다른 함수에 들어 있다면 y의 부모로 x를 지정한다.
    static boolean union(int x, int y){
        int px = find(x);
        int py = find(y);
        
        if(px == py)
            return false;
        
        p[py] = px;
        
        return true;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int V = sc.nextInt();
        int E = sc.nextInt();
        
        // 각 노드별 간선 정보를 받는다.
        Edge[] edges = new Edge[E];
        for(int i=0; i<E; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            int cost = sc.nextInt();
            
            edges[i] = new Edge(s, e, cost);
        }
        
        // 1. cost를 기준으로 오름차순 정렬한다.
        Arrays.sort(edges, (o1, o2)->o1.cost- o2.cost);
        
        // 2. Union-Find 배열을 초기화한다.
        p = new int[V+1];
        for(int i=1; i <= V; i++){
            p[i] = i;
        }
        
        // 3. 오름차순으로 정렬된 배열에서, 
        // 최소 비용 간선을 기준으로 서로 다른 집합에 있으면 포함하고
        // 같은 집합에 있으면 배제한다.
        int sum = 0;
        int cnt = 0;
        
        for(Edge edge:edges){
            // 서로 다른 집합에 있을 때만, sum에 더하고 cnt를 늘린다.
            if(union(edge.from, edge.to)){
                sum += edge.cost;
                cnt++;
                
                if(cnt==V-1)
                    break;
            }
            
        }
        
        System.out.println(sum);
        
    }
    
    
    
}