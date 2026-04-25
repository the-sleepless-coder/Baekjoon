import java.util.*;
import java.io.*;

public class Main {
    static String[][] arr;
    static int R, C;
    static int[][] state;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new String[R][C];
        for(int r=0; r<R; r++){
            String[] input = br.readLine().split("");

            for(int c=0; c<C; c++){
                arr[r][c] = input[c];
            }
        }

        // dfs를 진행할 때마다,
        // state 배열에 지나온 경로에 대한 상태 처리
        // 1=지나온 경로, 2=나가는 경로, 3= 나가지 못하는 경로 표시
        state = new int[R][C];

        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++) {
                dfs(r, c);
            }
        }

        // System.out.println(Arrays.deepToString(state));

        int result = count(state);
        System.out.println(result);

    }

    // 각 시작점에서 탈출할 수 있는지를 확인해본다.
    // 자신이 탐색한 부분을 다시 탐색하면,
    // 탈출 실패를 반환한다.
    static int count(int[][]arr){
        int count = 0;
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                if(arr[r][c]==2){
                    count++;
                }
            }
        }

        return count;
    }
    static void dfs(int rVal, int cVal){
        // 매 dfs마다 경로를 처리하기 위한 배열을 만든다.
        ArrayList<int[]> path = new ArrayList<>();

        Stack<int[]> stack = new Stack<>();
        stack.add(new int[]{rVal, cVal});
        path.add(new int[]{rVal, cVal});

        while(!stack.isEmpty()){
            int[] curr = stack.pop();

            int givValR = curr[0];
            int givValC = curr[1];

            String Val = arr[givValR][givValC];

            if(Val.equals("R")) givValC+=1;
            else if(Val.equals("L")) givValC-=1;
            else if(Val.equals("D")) givValR+=1;
            else if(Val.equals("U")) givValR-=1;

            // 미로를 나갔다면 상태 2를 저장한다.
            if(givValR<0||givValR>=R||givValC<0||givValC>=C){
                for(int[] p:path){
                    state[p[0]][p[1]] = 2;
                }
                break;
            }

            // 이미 나가는 경로에 도달하면,
            // 이전 경로를 2로 처리해준다.
            if(state[givValR][givValC]==2){
                for(int[] p: path){
                    state[p[0]][p[1]] = 2;
                }
                break;
            }

            // 이미 방문한 곳을 지나치거나 이미 나갈 수 없는 경로를 지나간다면,
            // 미로를 탈출 못했으니 3을 경로로 처리한다.
            if(state[givValR][givValC]==3 || state[givValR][givValC]==1){
                for(int[] p:path){
                    state[p[0]][p[1]] = 3;
                }
                break;
            }
            else{ // 방문을 안했다면 탐색을 이어나간다.
                stack.add(new int[]{givValR, givValC});
                path.add(new int[]{givValR, givValC});
                state[givValR][givValC] = 1;
            }


        }

    }


    static boolean dfs_recursive(int rVal, int cVal, boolean[][] visited){

        // 이미 방문을 했던 곳을 방문하면 실패를 반환한다.
        String val = arr[rVal][cVal];
        if(visited[rVal][cVal]) return false;
        else{visited[rVal][cVal] = true;}

        // 이동을 하고 나서 계속 dfs를 재귀 방식으로 돈다.
        if(val.equals("R")) cVal+=1;
        else if(val.equals("L")) cVal-=1;
        else if(val.equals("D")) rVal+=1;
        else if(val.equals("U")) rVal-=1;

        if(rVal<0||rVal>=R||cVal<0||cVal>=C) return true;

        //dfs(rVal, cVal, visited);


        return true;
    }


    // R R D
    // U D D
    // U D L
    // 매번 시작점에서 DFS를 통해서 다시 방문한 곳을 또 방문하게 되면 미로를 탈출하지 못한다.

}
