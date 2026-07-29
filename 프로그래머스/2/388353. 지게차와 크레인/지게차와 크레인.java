import java.util.*;
import java.io.*;

class Solution {
    static String[][] graph;
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        
        int R = storage.length;
        int C = storage[0].length();
        
        // 외부 통로로 연결 여부를 나타내기 위해,
        // 외부와 연결된 지점을 -1로 표시.
        graph = new String[R+2][C+2];
        for(int r=0; r<R+2; r++)
        {
            // 첫번째, 마지막 행 -1 처리.
            if(r==0 || r==R+1)
            {
                for(int c=0; c<C+2; c++) graph[r][c]="-1";
                continue;
            }    
        
            // 바깥 열 -1 처리.
            String[] temp = storage[r-1].split("");
            
            for(int c=0; c<C+2; c++)
            {
                if(c==0 || c==C+1) graph[r][c]="-1";
                else graph[r][c] = temp[c-1];    
            }
        }
        
        // r=1~R-2, c=1~C-2
        // 모든 명령에 대한 진행.
        int len = requests.length;
        
        for(int i=0; i<len ; i++)
        {
            String req = requests[i];
            
            // 외부 탐색 진행.
            if(req.length()==1)
            {
                externalSearch(req);
                
                boolean[][] visited = new boolean[R+2][C+2];
                for(int r=0; r<R+2; r++)
                {
                    for(int c=0; c<C+2; c++) setExternal(visited, r, c);        
                }
                
                //System.out.println(builder(graph));
                
            }
            // 내부 탐색 진행.    
            else if(req.length() ==2)
            {
                String str = String.valueOf(req.charAt(0));
                internalSearch(str);
                
                boolean[][] visited = new boolean[R+2][C+2];
                for(int r=0; r<R+2; r++)
                {
                    for(int c=0; c<C+2; c++) setExternal(visited, r, c);        
                }
                
                //System.out.println(builder(graph));
                
            }
        }
        
        // 최종적으로는 -1과 0을 제외한 것을 컨테이너 개수로 세서 반환하면 된다.
        int count = 0;
        for(int r=0; r<graph.length; r++)
        {
            for(int c=0; c<graph[0].length;c++)
            {
                if(!graph[r][c].equals("0") && !graph[r][c].equals("-1")) count++;
            }
        }
        
        
        return count;
    }
    
    // 컨테이너 상태를 출력한다.
    static StringBuilder builder(String[][] graph)
    {
        int R = graph.length;
        int C = graph[0].length;
        
        StringBuilder sb = new StringBuilder();
        for(int r=0; r<R; r++)
        {
            for(int c=0; c<C; c++)
            {
                sb.append(graph[r][c]).append(" ");
            }
            sb.append("\n");
        }
        
        return sb;
    }
    
    // str로 일치하고 하나라도 -1과 닿아 있는 칸이라면,
    // 외부랑 연결 돼 있다고 판단하고 0으로 바꾼다.
    static void externalSearch(String str)
    {
        int R = graph.length;
        int C = graph[0].length;
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        
        for(int r=0; r<R; r++)
        {
            for(int c=0; c<C; c++)
            {
                for(int i=0; i<4; i++)
                {
                    int nr = r+dr[i];
                    int nc = c+dc[i];
                    
                    if(nr<0||nr>=R||nc<0||nc>=C) continue;
                    
                    if(graph[r][c].equals("-1") && graph[nr][nc].equals(str))
                    {
                        graph[nr][nc]="0";
                    }
                }  
            }
        }
    }
    
    // 외부와 연결 돼 있는지 확인.
    // -1로 표시된 곳 중에 4방향 탐색을 하고 0인 곳은 -1로 처리한다.(외부와 연결된 처리 : -1)
    static void setExternal(boolean[][] visited, int r, int c)
    {
        int R = graph.length;
        int C = graph[0].length;
        
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        
        // 결국 완전탐색을 하는데, 
        // 어떤 조건에 한해서 전체 탐색을 하느냐에 대한 문제이다.
        while(!q.isEmpty())
        {
            int[] curr = q.poll();
            int currR = curr[0];
            int currC = curr[1];
            
            for(int i=0;i<4; i++)
            {
                int nR = currR + dr[i];
                int nC = currC + dc[i];
                
                if(nR<0||nR>=R||nC<0||nC>=C) continue;
                
                // BFS로 탐색하고자 하는 조건.
                if(graph[r][c].equals("-1") && graph[nR][nC].equals("0"))
                {
                    // 큐에 더하고 거기에서부터 또 BFS탐색.
                    graph[nR][nC]="-1";
                    q.add(new int[]{nR, nC});
                    visited[nR][nC]=true;
                }           
            }
        }
    
    }
    
    // 내부 탐색
    // 해당하는 모든 str에 대해서 0으로 바꾼다. (빈공간 처리 : 0)
    static void internalSearch(String str)
    {
        int R = graph.length;
        int C = graph[0].length;
        
        for(int r=0; r<R; r++)
        {
            for(int c=0; c<C; c++)
            {
                if(graph[r][c].equals(str))
                {
                    graph[r][c]="0";    
                }
            }
        }
        
    }
    
}