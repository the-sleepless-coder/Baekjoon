import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        int maxHeight = -1;
        int[][] arr = new int[N][N];
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                arr[r][c]=sc.nextInt();

                maxHeight = Math.max(arr[r][c], maxHeight);
            }
        }

        // 최대 높이 이하로만 빗물 처리 해주면 된다.
        int maxResult = -1;
        for(int rain =0; rain<=maxHeight; rain++){

            // 빗물 처리
            for(int r=0; r<N; r++){
                for(int c=0; c<N; c++){
                    if(arr[r][c]==rain)
                        arr[r][c] = -1;
                }
            }

            boolean[][] visited = new boolean[N][N];
            int count = 0;
            // bfs로 탐색했을 시, 영역의 개수를 구한다.
            for(int r=0; r<N; r++){
                for(int c=0; c<N; c++){
                    if( !visited[r][c] && arr[r][c]!=-1){
                        bfs(arr, visited, r, c, N);
                        count++;
                    }
                }
            }

            maxResult = Math.max(maxResult, count);
        }

        System.out.println(maxResult);


    }

    public static void bfs(int[][] arr, boolean[][] visited, int r, int c, int N){
        Queue<int[]> q = new LinkedList<>();
        visited[r][c] = true;
        q.add(new int[]{r,c});

        int[] dx = {1,-1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int currX = curr[0];
            int currY = curr[1];

            for(int k=0; k<4; k++){
                int nX = currX + dx[k];
                int nY = currY + dy[k];

                if(nX<0 || nX>=N || nY < 0 || nY>=N)
                    continue;

                if(arr[nX][nY]==-1)
                    continue;

                if(!visited[nX][nY]){
                    q.add(new int[]{nX, nY});
                    visited[nX][nY] = true;

                }
            }

        }

    }

}




// 안전한 영역의 개수를 구하라.
// 하루마다 땅이 물에 잠길 때,
// 영역의 개수를 구해라.

//5
//6 8 2 6 2
//3 2 3 4 6
//6 7 3 3 2
//7 2 5 3 6
//8 9 5 2 7