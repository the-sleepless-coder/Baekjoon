import java.util.*;

public class Solution {
    // 도착점에 대응되는 출발점을 찾아라.
    static int testCases = 10;
    static int N = 100;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int t=0; t<testCases;t++){
        int testCase = sc.nextInt();
        sc.nextLine();

        // 방문한 곳을 다시 방문하지 않게 visited배열을 만들어준다.
        // 검사를 하면서 방문했던 곳을 다시 방문하지 않게 만든다.
        int[][] arr = new int[N][N];
        boolean[][] visited = new boolean[N][N];

        int[] start = new int[2];
        for(int row = 0; row<N; row++){
            for(int col=0; col<N; col++){
                arr[row][col] = sc.nextInt() ;
                if(arr[row][col]==2){
                    start[0]=row;
                    start[1]=col;
                }
            }
        }

        // 위, 오른쪽, 아래, 왼쪽
        // 짝수가 위 아래
        // 홀수가 오른쪽 왼쪽 이동

        // 맨 윗 줄에 도달하면 그때 멈추는 것으로 하면 된다.
        int[] dx = { -1 , 0, 1 , 0 };
        int[] dy = { 0 , 1, 0, -1 };
        int startR = start[0];
        int startC = start[1];
        visited[startR][startC] = true;
        // System.out.println(Arrays.toString(start));

        int upIdx = 0;
        int rightIdx = 1;
        int leftIdx = 3;

        while(startR != 0){
            // 오른쪽이나 왼쪽을 이동할 수 있으면 먼저 이동한다.
            // 방문하지 않는 것에 대해서만 방문한다.

            // if문 else-if 문에 한번이라도 걸리면 해당 조건에서만 걸리기 때문에,
            // if문에 대한 분기 조건을 잘 처리해야 한다.
            // 그렇지 않으면 if-else문과 별개로 if문을 추가로 구성해야 하는 경우가 생길 수 있다.

            // visited를 찍고 이동해야지
            // 그렇게 해야 visited에서 내가 방문했다는 것을 표시하고,
            // 그 뒤에 이동을 할테니까 말이야.

            // 사실 별 것이 아니고 진짜 if문이 작동하는 순서,
            // if-else문의 분기 처리에 대한 기본적인 이해
            // 전체적인 논리를 어떻게 구성해서 제어문 안에 조건을 처리할 것인지에 대한 정말 가장 기본적인 논리부터 처리를 해야 알고리즘에서 큰 실수 없이 문제를 풀 수 있어.
            // 그렇지 않고 기본적인 제어문과 논리를 처리하는 것을 연습하지 않으면 무조건 알고리즘 문제에서 헤맬 수 밖에 없어.
            // 그래서 알고리즘 문제 풀이 처음에는 씩씩하게 가장 기본적인 논리를 구현하는 문제부터 풀어야,
            // 그 뒤에 더 어려운 논리를 구현해야 하는 문제를 푸는 데 있어서 어려움 없이 풀 수 있다는 사실을 잊지 말아라.

            if(startC + dy[rightIdx] >=0 && startC + dy[rightIdx] < N && arr[startR][startC+dy[rightIdx]]==1 && !visited[startR][startC+dy[rightIdx]]){
                visited[startR][startC+dy[rightIdx]] = true;
                startC = startC + dy[rightIdx];
            }
            else if(startC + dy[leftIdx] >= 0 && startC + dy[leftIdx] < N && arr[startR][startC + dy[leftIdx]] == 1 && !visited[startR][startC+dy[leftIdx]]) {
                visited[startR][startC+dy[leftIdx]] = true;
                startC = startC + dy[leftIdx];

            }
            // 오른쪽, 왼쪽 검사했는데 없다면, 위쪽으로 이동한다.
            else if (startR + dx[upIdx] >=0 && startR + dx[upIdx] < N && arr[startR + dx[upIdx]][startC] == 1 && !visited[startR + dx[upIdx]][startC]) {
                visited[startR + dx[upIdx]][startC] = true;
                startR = startR + dx[upIdx];
            }

        }

        // System.out.printf("%d %d\n", startR, startC);
        System.out.printf("#%d %d\n", testCase, startC);



    }
    // 보니까 위쪽으로 이동할 수 있는 경로를 파악할 수 있어야 한다.
    // 방향 전환을 어떻게 탐지할지에 대해서 생각해보자.

    // 그러니까 기본적으로는 위로 이동할 수 있다면 이동을 하고
    // 위로 이동하지 못하는 상황이라면 옆으로 이동한다는 논리로 가면 된다.

//1 0 0 0 1 0 1 0 0 1
//1 0 0 0 1 0 1 1 1 1
//1 0 0 0 1 0 1 0 0 1
//1 0 0 0 1 1 1 0 0 1
//1 0 0 0 1 0 1 0 0 1
//1 1 1 1 1 0 1 1 1 1
//1 0 0 0 1 0 1 0 0 1
//1 1 1 1 1 0 1 0 0 1
//1 0 0 0 1 1 1 0 0 1
//1 0 0 0 1 0 1 0 0 2

    // Sdoku
    // Ladder Game
    // 터미널로 하는 스도쿠 게임?

    // 자료구조 구현, CS50문제 풀이, 자료구조 정리
    // SSH로 서버 구성

    // 백엔드 기본 기능 구현 중에 내가 못한 것 마무리 할 것.
}
}
