import java.util.*;

class Solution {
    static String[][] graph;
    static int startR, startC, endR, endC;
    static int R, C;
    
    public int solution(String[] board) {
        int answer = 0;
        // 목표 위치에 정확하게 멈추기 위해 최소 몇번의 이동이 필요한지 말하는 게임.
        // R 처음 위치, D 장애물, G 목표지점.
        // 해당되는 열과 행을 맞춰줄 수 있는 장애물이 필요하다.
        // 그래서 열을 맞춰줄 장애물과 행을 맞춰줄 장애물을 찾는 것이 목표이다.
        // 그렇게 하면 최소값을 보장하지 못하기 때문에,

        // 도달할 수 있는 좌표를 BFS로 처리하는 방식을 택해야 한다.
        // 벽에 부딪히기 전이나

        R = board.length;
        C = board[0].length();

        graph = new String[R][C];

        for (int r = 0; r < R; r++) {
            String[] temp = board[r].split("");
            for (int c = 0; c < C; c++) {
                if (temp[c].equals("R")) {
                    startR = r;
                    startC = c;
                } else if (temp[c].equals("G")) {
                    endR = r;
                    endC = c;
                }

                graph[r][c] = temp[c];
            }
        }

        int[][] distance = new int[R][C];
        boolean[][] visited = new boolean[R][C];
        // for(int r=0; r<R; r++){for(int c=0; c<C; c++) distance[r][c]=-1;}

        rico_bfs(distance, visited);

        if (distance[endR][endC] == 0) answer = -1;
        else answer = distance[endR][endC];

        System.out.println(builder(distance));

        return answer;
        
    }
    
    static StringBuilder builder(int[][] graph)
    {
        int R = graph.length;
        int C = graph[0].length;

        StringBuilder sb = new StringBuilder();
        sb.append(startR).append(" ").append(startC).append("\n");
        sb.append(endR).append(" ").append(endC).append("\n");

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

    static void rico_bfs(int[][] distance, boolean[][] visited)
    {
        // BFS를 실행하는데 큐가 빌때까지 도달 못하면 도착 못함.
        // 도착하면 최소 횟수를 distance에서 출력.
        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startR, startC});
        visited[startR][startC] = true;

        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

        while(!q.isEmpty())
        {
            int[] curr = q.poll();
            int currR = curr[0];
            int currC = curr[1];

            // 4방향 탐색을 벽 | 장애물을 만나기 직전의 칸까지 진행하고,
            // 해당 칸을 큐에 넣어준다.
            for(int i=0; i<4; i++)
            {
                int nr = currR + dr[i];
                int nc = currC + dc[i];

                int dirR = dr[i];
                int dirC = dc[i];

                // 게임 판 나가면 다음 경로 확인.
                if(nr<0||nr>=R||nc<0||nc>=C) continue;

                // 벽 | 장애물에 닿을 때까지 탐색을 이어가고,
                // 벽이나 장애물을 만나면 큐에 넣어준다.
                while(true)
                {
                    // 벽 | 장애물에 충돌하면 break;
                    boolean collision = false;

                    // 게임판 끝에 도달.
                    if(nr < 0|| nr >=R || nc < 0 || nc >= C)
                    {
                        if(!visited[nr-dirR][nc-dirC]) {
                            q.add(new int[]{nr - dirR, nc - dirC});
                            distance[nr - dirR][nc - dirC] = distance[currR][currC] + 1;
                            visited[nr - dirR][nc - dirC] = true;
                        }
                        collision = true;
                    }
                    // 장애물 충돌.
                    else if(graph[nr][nc].equals("D"))
                    {
                        if(!visited[nr-dirR][nc-dirC])
                        {
                            q.add(new int[]{nr -dirR ,nc -dirC });
                            distance[nr-dirR][nc-dirC] = distance[currR][currC] + 1;
                            visited[nr-dirR][nc-dirC] = true;
                        }
                        collision = true;

                    }

                    // 벽 | 장애물까지 탐색을 이어간다.
                    nr+=dirR;
                    nc+=dirC;


                    if(collision) break;

                }

            }
        }
    }
    
}