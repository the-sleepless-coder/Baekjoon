import java.util.*;
// 역시 전체 문제 풀이에 대한 설계를 제대로 해야, 문제를 풀 때 오류가 생기지 않는다.
// 디버깅을 할 때 어디가 잘못 됐는지 찾아내는 것도 능력이다.
// 자료구조를 잘 이해해야 어떤 자료구조를 써서 문제를 해결할 수 있는지를 알 수 있다.
// 세부적인 논리를 이해해야, 문제를 풀 때도 디버깅할 때도 오류가 생기지 안흔ㄴ다.

public class Main {
    // 시간이 지나면서 기존 배열에 토마토가 익는 것을 1로 표현한다.
    // 토마토가 익는 배열과 며칠이 지났는지를 기록하는 배열을 따로 둔다.

    // 익은 토마토가 있는 지점이 여러 곳에 있기 때문에,
    // Queue에 넣고 한꺼번에 처리해야 한다.

    // 입력
    // 익은 토마토 = 1, 익지 않은 토마토 = 0, 토마토가 없는 칸 = -1

    // 출력
    // 토마토가 익는 데 걸리는 시간을 출력하고,
    // 모든 토마토가 익어 있다면 -1, 토마토가 모두 익지 못하는 상황이면 -1
    static int N,M;
    static boolean[][] visited;
    static int[][] days;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 열, 행 정보를 받는다.
        M = sc.nextInt();
        N = sc.nextInt();

        int[][] arr = new int[N][M];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        // 방문한 곳을 처리하기 위한 visited 배열과
        // 토마토가 익는 데 걸리는 시간인 days 배열을 만든다.
        // 이때 안 익은 토마토가 있는지를 확인하기 위해, 토마토가 있는 곳을 -1로 초기화해준다.
        visited = new boolean[N][M];
        days = new int[N][M];
        boolean isTotalRipe = true;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j]==0){
                    days[i][j] = -1;
                    isTotalRipe = false;
                }
            }
        }

        // 배열에서 1로 시작하는 곳을 Queue에 집어넣는다.
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0 ; i < N; i++){
            for(int j = 0; j < M; j++){
                // 기존 배열에서 1인 곳을 시작점으로 넣고,
                // 해당 지점에서 날짜 계산을 위해 days[i][j]= 0으로 만든다.
                if(arr[i][j] == 1){
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                    days[i][j] = 0;
                }else if(arr[i][j]==-1){
                    visited[i][j] = true;
                }
            }
        }

        // Queue에 들어간 시작점을 기준으로 bfs를 실행한다.
        bfs(q, arr);

        /*
        // 전체 배열에서 1로 시작하는 곳에서,
        // bfs를 처리한다.
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j]==1){
                    bfs(i, j, arr);
                }
            }
        }
        */

        // System.out.println(cnt);
        // System.out.println(Arrays.deepToString(visited));

        /*
        for(int[] line: days){
            for(int ele: line){
                System.out.printf("%d ", ele);
            }
            System.out.println();
        }
        */

        boolean isGivenRipe = true;
        int maxDays = 0;
        for(int i=0; i < N; i++){
            for(int j=0; j < M; j++){
                // 토마토가 익었을 때 최대값을 계산한다.
                if(days[i][j]!=-1){
                    maxDays = Math.max(maxDays, days[i][j]);
                }
                // 토마토가 다 익지 못하는 상황
                else{
                    isGivenRipe = false;
                    break;
                }
            }
        }

        // System.out.println(maxDays);

        // 토마토 전체가 처음부터 다 익었으면 0을 출력한다.
        if(isTotalRipe){
            System.out.println(0);
        }
        // 주어진 토마토가 다 익었다면 최소 일수를, 다 익지 못했다면 -1을 출력한다.
        else{
            if(isGivenRipe){
                System.out.println(maxDays);
            }else{
                System.out.println(-1);
            }
        }




    }

    // Queue에 담긴 시작점을 기준으로,
    // 탐색 가능한 곳을 Queue에 추가해서 며칠이 지나야 토마토가 다 익는지를 확인한다.
    static void bfs( Queue<int[]> q , int[][] arr){
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        while(!q.isEmpty()){
            int[] curr = q.poll();

            int currX = curr[0];
            int currY = curr[1];

            for(int k=0; k<4; k++){
                int nx = currX+dx[k];
                int ny = currY+dy[k];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M)
                    continue;

                if(arr[nx][ny] == -1)
                    continue;

                // 판을 벗어나지 않고 토마토가 있는 칸이라면 Queue에 집어넣고,
                // 방문하지 않는 토마토를 방문 처리한다.

                // 하루가 지나면 방문한 토마토를 이전 토마토가 익는 데 걸리는 날 +1 처리해준다.
                if( !visited[nx][ny] ){
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    days[nx][ny] = days[currX][currY] + 1;

                    // ✅ 큐에 추가된 좌표 출력
                    // System.out.printf("  ==> Enqueue: (%d, %d), days=%d\n", nx, ny, days[nx][ny]);



                }

            }


        }


    }


}
