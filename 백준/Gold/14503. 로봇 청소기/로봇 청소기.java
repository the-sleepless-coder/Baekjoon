import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int stR = Integer.parseInt(st.nextToken());
        int stC = Integer.parseInt(st.nextToken());
        int dir  = Integer.parseInt(st.nextToken());

        // 벽을 나타내낼 수 있는 map과,
        // 방문했는지 여부를 나타낼 수 있는 여부인 visited를 따로 두는 것이 중요하다.
        int[][] map = new int[R][C];
        boolean[][] visited = new boolean[R][C];
        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        visited[stR][stC] = true;
        int count = 1;

        int currX = stR;
        int currY = stC;

        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

        while(true){
            // dir index에 따라 북, 동, 남, 서 방향을 바라보고 시작한다.
            int[] dr = {-1, 0, 1, 0};
            int[] dc = {0, 1, 0, -1};

            // 4방향 탐색을 반시계 방향으로 한다.
            // 4방향 탐색을 하고 탐색을 안했고 벽이 아니라면,
            // 해당 칸으로 움직이고 search = true로 바꿔준다.
            boolean search = false;
            for(int i = 0; i < 4; i++){
                dir = (dir - 1 + 4) % 4;

                int nR = currX + dr[dir];
                int nC = currY + dc[dir];

                if(!visited[nR][nC] && map[nR][nC]==0){
                    visited[nR][nC] = true;
                    currX = nR;
                    currY = nC;

                    count += 1;

                    ArrayList<Integer> pair = new ArrayList<>();
                    pair.add(currX);
                    pair.add(currY);
                    arr.add(pair);
                    // System.out.println(pair);

                    search = true;
                    break;
                }

            }

            // 4방향 탐색을 했는데도 청소할 곳이 없다면,
            // 후진을 하고 다시 4방향 탐색을 이어나간다.
            boolean terminate = false;
            if(!search){
                int backDir = (dir + 2 + 4) % 4;
                int nR = currX + dr[backDir];
                int nC = currY + dc[backDir];

                if(map[nR][nC] != 1){
                    currX = nR;
                    currY = nC;
                }else{
                    terminate = true;
                }

            }

            // 그리고 후진을 했는데 벽 밖에 없다면,
            // while문을 종료한다.
            if(terminate)
                break;
        }

        // System.out.println(Arrays.deepToString(map));
        // System.out.println(arr);
        System.out.println(count);

    }
}
