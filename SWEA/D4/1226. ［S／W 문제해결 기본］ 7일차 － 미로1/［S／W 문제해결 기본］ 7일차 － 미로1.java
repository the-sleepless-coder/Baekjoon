import java.util.*;

public class Solution {
    static int testCases = 10;
    static int N = 16;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        for(int t=0; t < testCases; t++){
            int test = sc.nextInt();
            sc.nextLine();

            int[][] arr = new int[N][N];
            int[] start = new int[2];
            int[] end = new int[2];

            boolean[][] visited = new boolean[N][N];

            for(int row = 0; row<N; row++){
                String str = sc.nextLine();
                for(int col=0; col<N; col++){
                    char c = str.toCharArray()[col];
                    arr[row][col] = Integer.parseInt(String.valueOf(c));

                    if(arr[row][col]==2){
                        start[0] = row;
                        start[1] = col;
                    }else if(arr[row][col]==3){
                        end[0] = row;
                        end[1] = col;
                    }
                }

            }

            // System.out.println(Arrays.deepToString(arr));
            // System.out.println(Arrays.toString(start));
            // System.out.println(Arrays.toString(end));

            int result = bfs(arr, start, end, visited);

            // System.out.println(result);
            System.out.printf("#%d %d\n", test, result);
            
        }


    }

    // bfs방식으로 시작 지점에서 끝지점까지 갈 수 있는지 확인한다.
    static int bfs(int[][]arr, int[] start, int[] end, boolean[][] visited ){
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        int rowStart = start[0];
        int colStart = start[1];
        visited[rowStart][colStart] = true;

        // 이동 방향 설정.
        int[] dx = {-1, 1 , 0, 0 };
        int[] dy = {0 , 0, -1, 1 };

        boolean arrival = false;
        outerLoop:
        while(!q.isEmpty()){
            // 현재 좌표 기준으로 주변에 있는 값들을 차례대로 queue 에 넣어준다.
            // 현재 좌표 기준으로 주변의 값들을 queue에 넣어줘서,
            // 매 while 문 순회 기준으로 자기 자신과 거리가 1만큼 떨어진 좌표를 지속적으로 탐색한다.
            int[] curr = q.poll();
            int currX = curr[0];
            int currY = curr[1];

            // 방문 가능한 곳이면 다시 방문하지 않게 visited처리를 해주고,
            // queue에 넣어서 현재 위치 주변으로 계속 값을 탐색할 수 있게 한다.
            for(int idx=0; idx<4; idx++){

                int newX = currX + dx[idx];
                int newY = currY + dy[idx];

                if(newX < 0 || newX >= N || newY < 0 || newY >= N)
                    continue;

                if(arr[newX][newY]==1)
                    continue;

                if(!visited[newX][newY] && arr[newX][newY]==0){
                    visited[newX][newY] = true;
                    q.add(new int[]{newX, newY});
                }
                else if(!visited[newX][newY] && arr[newX][newY]==3){
                    arrival = true;
                    break outerLoop;
                }
            }




        }

        if(arrival)
            return 1;
        else
            return 0;
    }
    // BFS로 배열을 탐색할 때,
    // 시작점 2에서 도착 지점 3에 도착할 수 있는지 여부를 확인한다.
}
