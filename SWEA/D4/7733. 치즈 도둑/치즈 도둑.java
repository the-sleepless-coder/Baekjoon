import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        sc.nextLine();

        for(int t=1; t<=testCase; t++){
            int N = sc.nextInt();

            int[][] arr = new int[N][N];
            int max = -1;
            for(int r=0; r<N; r++){
                for(int c=0; c<N; c++){
                    arr[r][c] = sc.nextInt();
                    max = Math.max(max,arr[r][c]);
                }
            }

            //가장 맛있는 치즈조각이하로만 검증하면 된다.
            //N일마다 해당 치즈맛을 내는 치즈를 먹고 arr을 처리
            //가장 많은 치즈 조각을 확인한다.

            int maxPiece = -1;
            for(int taste=0; taste<=max; taste++){
                int count = 0;
                
                // 치즈 처리
                for(int r=0; r<N; r++){
                    for(int c=0; c<N; c++){
                       int val = arr[r][c];
                       if(val == taste) {
                           arr[r][c] = -1;
                       }

                    }
                }

                //System.out.println(arrStringBuilder(arr));

                boolean[][] visited = new boolean[N][N];
                //치즈 조각 개수 확인.최대 개수 확인
                // 특정 조건에서 bfs가 몇번 도는지 확인하면,
                // 그것이 치즈조각을 세는 횟수인 셈이다.

                // 다만 반환값을 어떻게하지? 그걸 잘 모르겠네 그걸 좀 확인해보자.
                // 그러니까 몇번 bfs를 도는지를 어떻게 확인하는지만 보면 끝나겠다.
                // 조각을 세는 횟수를 count 변수로 넣는다.
                for(int r=0; r<N; r++){
                    for(int c=0; c<N; c++){
                        if( !visited[r][c] && arr[r][c] != -1){
                            bfs(arr, r, c, visited, N);
                            count++;
                        }
                    }
                }
                maxPiece = Math.max(maxPiece, count);

            }

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ").append(maxPiece);

            System.out.println(sb);
        }

    }

    // bfs를 통해서 나눠진 치크 조각을 확인한다.
    // 탐색할 좌표를 저장할 Queue와 다시 방문하지 않도록 만드는 visited변수를 추가한다.
    // 방문 안한 곳이라면 탐색을 지속하기 위해서 Queue에 넣는다.
    static void bfs(int[][] arr, int r, int c, boolean[][] visited, int N){
        // Queue에 넣어서 탐색할 좌표를 넣는다.
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r,c});
        visited[r][c] = true;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int currR = curr[0];
            int currC = curr[1];

            int[] dr = {-1,1,0,0};
            int[] dc = {0,0,-1,1};
            for(int k=0; k<4; k++){
                int nr = currR+dr[k];
                int nc = currC+dc[k];

                if(nr<0||nr>=N||nc<0||nc>=N)
                    continue;

                int val = arr[nr][nc];

                if(val==-1)
                    continue;

                if(!visited[nr][nc]){
                    visited[nr][nc] = true;
                    q.add(new int[]{nr,nc});
                }


            }
        }

    }

    //arr를 StringBuilder로 출력하는 메서드.
    static StringBuilder arrStringBuilder(int[][]arr){
        StringBuilder sb = new StringBuilder();
        int N = arr.length;

        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                int val = arr[r][c];
                sb.append(val).append(" ");
            }
            sb.append("\n");
        }

        return sb;
    }

}

//100일이 지날때까지 치즈 덩어리가 가장 많을 때의 개수를 구하라.
//그러니까 각 일마다 갉아먹힌 치즈를 제외하고, 치즈 덩어리가 몇개인지 파악하면 된다.

//1
//5
//6 8 2 6 2
//3 2 3 4 6
//6 7 3 3 2
//7 2 5 3 6
//8 9 5 2 7