import java.util.*;

class Solution {
    public int solution(int[][] graph) {
        int answer = 0;
        // 빈땅:0, 석유 있는 땅:1
        int R = graph.length;
        int C = graph[0].length;
        
        // 각 열별로 시추관을 꽂아보고, 
        // BFS를 시행했을 때 뽑을 수 있는 총 석유의 양을 구한다.
        
        // 이때 사실 매 열마다 BFS를 실행할 필요는 없고, 
        // 한번 BFS를 하고 각 열별로 얻을 수 있는 석유 양을 dp배열에 더해준다.
        
        // 각 열 별로 
        int[] dp = new int[C];
        boolean[][] visited = new boolean[R][C];
        
        for(int r=0; r<R; r++)
        {
            for(int c=0; c<C; c++)
            {
                // 석유가 있고 방문 안한 곳에서 BFS 실행.
                if(graph[r][c] == 1 && !visited[r][c])
                {
                    //지점별 BFS실행.
                    bfs(graph, visited, r, c, dp);
                }
            }
        }
        
        // dp 배열에서, 각 열별 추출 가능 석유양 중 가장 큰 값을 출력한다.
        // System.out.println(Arrays.toString(dp));
        
        return findMax(dp);
    }
    
    static int findMax(int[] dp)
    {
        int max = Integer.MIN_VALUE;
        for(int d:dp) max = Math.max(max, d);
        
        return max;
    }
    
    static void bfs(int[][] graph, boolean[][] visited, int r, int c, int[] dp)
    {
        int R = visited.length;
        int C = visited[0].length;
        
        Set<Integer> columns = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[]{r,c});
        visited[r][c]= true;
        columns.add(c);
        int amount = 1;
        
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        while(!q.isEmpty())
        {
            int[] curr = q.poll();
            int currR = curr[0];
            int currC = curr[1];
            
            for(int i=0; i<4; i++)
            {
                int nr = currR+dr[i];
                int nc = currC+dc[i];
                
                if(nr<0||nr>=R||nc<0||nc>=C) continue;
                
                if(graph[nr][nc]==0 ) continue;
                
                // 조건 통과하면 bfs 실행할 곳.
                if(!visited[nr][nc])
                {
                    q.add(new int[]{nr,nc});
                    visited[nr][nc] = true;
                    amount++;
                    
                    columns.add(nc);
                }    
            }
        }
        
        // dp에 각 열별로 석유의 양을 더해준다.
        for(int col:columns)
        {
            dp[col] += amount;
        }
    
    }
}