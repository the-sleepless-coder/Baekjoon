import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        sc.nextLine();
        // int testCase = 1;
        // 맨 좌측 위에서 하단 오른쪽으로 가는 데 최소 비용을 구하라.

        for(int test = 1; test<=testCase; test++){
            int N = sc.nextInt();
            sc.nextLine();

            int[][] arr = new int[N][N];
            for(int r=0; r<N; r++){
                String line = sc.nextLine();
                for(int c=0; c<N; c++){
                    char[] charArr = line.toCharArray();
                    arr[r][c]=Integer.parseInt(String.valueOf(charArr[c]));
                }
            }

            boolean[][] visited = new boolean[N][N];
            int[] start = new int[2];
            int[] end = new int[2];
            end[0] = N-1;
            end[1] = N-1;

            int[][] hours = new int[N][N];
            for(int r=0; r<N; r++){
                for(int c=0; c<N; c++){
                    if(r==0&&c==0)
                        continue;

                    hours[r][c]= Integer.MAX_VALUE;
                }
            }
            // System.out.println(Arrays.deepToString(arr));

            int resultHours = -1;
            resultHours = bfs(arr, start, end, N, hours);

            // System.out.println(resultHours);

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(test).append(" ").append(resultHours);
            System.out.println(sb);
        }


    }

    // 땅을 파기 위한 최소 비용을 구하기 위한 bfs 함수이다.
    // 내가 탐색한 비용값이 이전에 탐색했던 비용보다 작을 때만,
    // 큐에 넣어서 방문을 하게 한다.

    // visited를 쓰게 되면 여러 방문값 중 더 작은 것을 고르지 못하기 때문에,
    // visited를 쓰면 안된다.
    public static int bfs(int[][] arr, int[] start, int[] end, int N, int[][] hours){
        Queue<int[]> q = new LinkedList<>();
        q.add(start);

        int[] dx = {1,-1,0,0,};
        int[] dy = {0,0,1,-1};

        ArrayList<Integer> result = new ArrayList<>();
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int currX = curr[0];
            int currY = curr[1];

            // 최소 지점만 탐색 및 도착점 도달 시 결과 저장.
            // 이전 지점과 현재 지점의 합으로 시간을 구한다.
            // 도착지에 도달하면 result에 값을 넣는다.
            for(int idx=0; idx<4; idx++){
                int nx = currX + dx[idx];
                int ny = currY + dy[idx];

                if(nx<0 || nx>=N|| ny<0 || ny>=N)
                    continue;

                // 기존에 탐색했던 비용보다 더 싼 비용일 때만 큐에 넣고,
                // 그리고 hours를 갱신한다
                if(hours[currX][currY]+arr[nx][ny] < hours[nx][ny]){
                    q.add(new int[]{nx,ny});
                    hours[nx][ny] = hours[currX][currY] + arr[nx][ny];

                }

            }

        }

        return hours[N-1][N-1];

    }

}

//4
//0110
//1110
//0011
//0000