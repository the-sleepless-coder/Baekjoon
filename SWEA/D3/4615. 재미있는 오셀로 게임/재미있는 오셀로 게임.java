import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        sc.nextLine();

        for (int test = 1; test <= testCase; test++) {
            int N = sc.nextInt();
            int M = sc.nextInt();


            int[][] arr = new int[N][N];
            int midIdx = N / 2;
            arr[midIdx - 1][midIdx - 1] = 2;
            arr[midIdx - 1][midIdx] = 1;
            arr[midIdx][midIdx - 1] = 1;
            arr[midIdx][midIdx] = 2;

            // 반복되는 코드는 함수로 작성해서 처리
            for (int idx = 0; idx < M; idx++) {
                int C = sc.nextInt();
                int R = sc.nextInt();
                int stone = sc.nextInt();

                arr[R-1][C-1] = stone;

                // 돌을 놓고 나서 돌을 더 놓을 수 있다면 오목 체크를 한다.
                // 그렇지 않으면 돌을 그만 놓는다.
                int result = checkNum(arr, N);
                if( result == 1){
                    checkBoard(arr, N, R-1, C-1);
                }else if( result == -1 )
                    break;

            }

            /**
            StringBuilder sb = new StringBuilder();
            for(int r=0; r<N; r++){
                for(int c=0; c<N; c++){
                    sb.append(arr[r][c]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
             */

            // 경기가 마무리되면 총 흑/백 돌의 개수를 센다.
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(test).append(" ");
            int blackStone = 0;
            int whiteStone = 0;
            for(int r=0; r<N; r++){
                for(int c=0; c<N; c++){
                    int val = arr[r][c];
                    if(val==1)
                        blackStone++;
                    if(val==2)
                        whiteStone++;
                }
            }

            sb.append(blackStone).append(" ").append(whiteStone);

            System.out.println(sb);
        }

    }

    // 돌을 놓을 수 있는지 여부를 반환값으로 받는다.
    static int checkNum(int[][] arr, int N){
        int blackStone = 0;
        int whiteStone = 0;

        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                int stone = arr[r][c];
                if(stone==1){
                    blackStone++;
                }else if(stone==2){
                    whiteStone++;
                }
            }
        }

        if(blackStone + whiteStone== N*N + 1){
            return -1;
        }else{
            return 1;
        }

    }

    // 8 방향 델타 탐색을 통해서, 연속적으로 배치된 돌이라면 색깔을 모두 바꿔준다.
    static void checkBoard(int[][] arr, int N, int r, int c){

        // 주어진 수에서 8방향 델타 탐색을 해서,
        // 바꿀 돌이 있는지 확인한다.

        // 그러니까 각 방향으로 몇개의 연속된 돌이 있는지를 확인하면 되는 것이다.
        // 다만 가장 먼저 만나는 나의 돌까지만 바꿔야 되기 때문에,
        // 한번 바꾸고 나서는 안 바뀌게 해야 한다.
        int[] dr = {0, 0,  1 , -1, -1, -1, 1, 1 };
        int[] dc = {1, -1, 0,  0, -1, 1, -1, 1,};

        int stone = arr[r][c];

        for(int k=0; k < 8; k++){
            boolean isStraight = true;
            int consecutiveStones = -1;
            for(int idx=1; idx<N; idx++){
                int nr = r + dr[k] * idx ;
                int nc = c + dc[k] * idx ;

                if(nr<0 || nr>=N || nc<0 || nc>=N) {
                    break;
                }

                int deltaVal = arr[nr][nc];
                if(deltaVal==0){
                    break;
                }

                if(stone != deltaVal){
                    continue;
                }

                if(consecutiveStones==-1)
                    consecutiveStones=idx;

            }

            if(isStraight){
                for(int cons =1; cons < consecutiveStones; cons++){
                    int nr = r + dr[k] * cons ;
                    int nc = c + dc[k] * cons ;

                    arr[nr][nc] = stone;
                }
            }




    }


    }
}

// 조금 더 최적화된 방식으로 코드를 작성하는 방식이 있는가를 고민하자.
// 물론 직관적으로 짜는 것도 좋지만,
// 연산량 자체를 줄이고 논리적으로 더 효율적인 방식의 코드를 짤 수 있는지를 고민해봐야 해.

// 8방향 델타 탐색을 통해서 흑,백 돌 사이에 연속적으로 동일한 돌이 있으면,
// 그 사이에 있는 돌을 다 바꿔준다.

//1
//6 2
//2 1 1
//2 5 1

// W B W 0 W B W