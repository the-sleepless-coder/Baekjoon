import java.util.*;

public class Main {
    static int N, M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            N = sc.nextInt();
            M = sc.nextInt();
            if(N == 0 && M ==0)
                break;

            // 테스트케이스마다 arr, visited이 다르기 때문에, static으로 설정해주면 안된다.
            int[][] arr = new int[M][N];
            boolean[][] visited = new boolean[M][N];

            for(int i = 0; i < M; i++){
                for(int j = 0; j < N; j++){
                    arr[i][j] = sc.nextInt();
                }
            }

            // System.out.println(Arrays.deepToString(arr));

            int island = 0;
            for(int i=0; i < M; i++){
                for(int j= 0; j < N; j++){
                    // 섬이고 방문하지 않았을 때 dfs처리를 통해서,
                    // 방문하지 않는 좌표가 있을 때만 실행하기 때문에 group 개수를 구할 수 있다.
                    if(arr[i][j] == 1 && !visited[i][j]){
                        dfs(i, j, arr, visited);
                        island++;
                    }
                }
            }

            System.out.println(island);


        }

    }


    static void dfs(int x, int y, int[][] arr, boolean[][] visited){
        Stack<int[]> s = new Stack<>();
        s.add(new int[]{x,y});
        // 2차원 배열에서 이동한 곳을 확인하는 visited 배열을 만든다.
        visited[x][y] = true;

        int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1 };
        int[] dy = {0, 0, -1, 1, -1, 1, -1 ,1};

        while( !s.isEmpty() ){
            // 현재 노드가 섬이라면 해당 노드에서 움직일 수 있는 좌표를,
            // Stack에 담아서 탐색할 수 있는 곳을 처리한다.

            int[] curr = s.pop();

            int currX = curr[0];
            int currY = curr[1];

            for(int k = 0; k < 8; k++){
                int nx = currX + dx[k];
                int ny = currY + dy[k];

                // 판을 벗어날 때 continue 한다.
                if(nx < 0 || nx >= M || ny<0 || ny >= N)
                    continue;

                // 이동하지 못하거나 방문을 한 경우라면, continue 한다.
                if(arr[nx][ny] == 0 || visited[nx][ny])
                    continue;

                // 판 내에 있고 이동할 수 있다면, Stack에 넣고 visited = true 처리를 한다.
                s.add(new int[]{nx, ny});
                visited[nx][ny] = true;
            }



        }


    }

}
