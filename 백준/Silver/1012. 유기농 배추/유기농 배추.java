import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 전체 배열을 순회하면서 상하좌우로 이동할 수 있는 BFS 탐색이 가능한 곳이 몇 군데 있는지 확인한다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        // int testCase = 1;

        for(int tc = 1; tc<=testCase; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int col = Integer.parseInt(st.nextToken());
            int row = Integer.parseInt(st.nextToken());
            int tot = Integer.parseInt(st.nextToken());

            // 행렬에 배추의 위치를 입력 받는다.
            int[][] arr = new int[row][col];
            for(int i=0; i < tot; i++ ){
                st = new StringTokenizer(br.readLine());
                int N = Integer.parseInt(st.nextToken());
                int M = Integer.parseInt(st.nextToken());

                arr[M][N] = 1;
            }

            //System.out.println(Arrays.deepToString(arr));

            // BFS를 도는 과정에서 방문했던 곳을 다시 방문하지 않게, visited 배열을 선언해준다.
            // 배추가 있고 이미 방문한 곳이 아닌 곳에서만 BFS 탐색을 진행해서,
            // 상하좌우로 연결된 곳을 확인한다.
            boolean[][] visited = new boolean[row][col];
            int result = 0;
            for(int i = 0; i < row; i++){
                for(int j = 0; j < col; j++){
                    if(arr[i][j] == 1 && !visited[i][j]){
                        bfs(arr, i, j, visited, row, col);
                        result++;
                    }

                }
            }

            System.out.println(result);

        }

    }

    // 상하좌우로 이동할 수 있는 곳에 대해 탐색을 진행하는 BFS 코드를 만든다.
    public static void bfs(int[][] arr, int x, int y, boolean[][] visited, int row, int col){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        visited[x][y] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int currX = curr[0];
            int currY = curr[1];

            for(int i=0; i<4; i++){
                int nx = currX + dx[i];
                int ny = currY + dy[i];

                if(nx < 0 || nx>= row || ny<0 || ny >= col)
                    continue;

                if(arr[nx][ny] == 0)
                    continue;

                if(!visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }

            }


        }




    }

}
