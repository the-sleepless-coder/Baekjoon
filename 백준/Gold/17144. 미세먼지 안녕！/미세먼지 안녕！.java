import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[][] graph = new int[R][C];
        for(int r=0; r<R; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<C; c++){
                graph[r][c]=Integer.parseInt(st.nextToken());
            }
        }

        int[][] spreadDust=null;
        for(int t=0; t<T; t++){
            spreadDust = new int[R][C];
            spreadDustFun(spreadDust, graph);
            //System.out.println(printsb(spreadDust));
            circDustFun(spreadDust);
            //System.out.println(printsb(spreadDust));

            graph = spreadDust;
        }

        int sum = 0;
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                if(spreadDust[r][c]!=-1){
                    sum+=spreadDust[r][c];
                }
            }
        }

        System.out.println(sum);
    }


    static void circDustFun(int[][] spreadDust) {
        int R = spreadDust.length;
        int C = spreadDust[0].length;

        int cR = -1;
        int cC = -1;
        outer:
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (spreadDust[r][c] == -1) {
                    cR = r;
                    cC = c;
                    break outer;
                }
            }
        }

        int sR1 = 0;
        int sC1 = cC;
        int eR1 = cR;
        int eC1 = C - 1;

        int prev = 0;

        // 1. 청정기 행: 오른쪽으로 밀기
        for (int c = 1; c <= eC1; c++) {
            int temp = spreadDust[eR1][c];
            spreadDust[eR1][c] = prev;
            prev = temp;
        }

        // 2. 오른쪽 열: 위로 올리기
        for (int r = eR1 - 1; r >= sR1; r--) {
            int temp = spreadDust[r][eC1];
            spreadDust[r][eC1] = prev;
            prev = temp;
        }

        // 3. 윗줄: 왼쪽으로 밀기
        for (int c = eC1 - 1; c >= sC1; c--) {
            int temp = spreadDust[sR1][c];
            spreadDust[sR1][c] = prev;
            prev = temp;
        }

        // 4. 왼쪽 열: 아래로 내리기
        for (int r = sR1 + 1; r <= eR1 - 1; r++) {
            int temp = spreadDust[r][sC1];
            spreadDust[r][sC1] = prev;
            prev = temp;
        }

        spreadDust[eR1][sC1] = -1;

        int sR2 = cR + 1;
        int sC2 = cC;
        int eR2 = R - 1;
        int eC2 = C - 1;

        prev = 0;
        // 윗줄
        // 이전칸을 prev에 넣고,
        // 다음칸에 넣어준다.
        for (int c = sC2; c <= eC2 - 1; c++) {
            int temp = spreadDust[sR2][c + 1];
            spreadDust[sR2][c + 1] = prev;
            prev = temp;
        }

        // 오른쪽
        for (int r = sR2; r <= eR2 - 1; r++) {
            int temp = spreadDust[r + 1][eC2];
            spreadDust[r+1][eC2]=prev;
            prev = temp;
        }

        // 아래쪽
        for (int c = eC2; c >= sC2 + 1; c--) {
            int temp = spreadDust[eR2][c - 1];
            spreadDust[eR2][c-1]= prev;
            prev = temp;
        }

        // 왼쪽
        for (int r = eR2; r >= sR2 + 1; r--) {
            int temp = spreadDust[r - 1][sC2];
            spreadDust[r-1][sC2] = prev;
            prev = temp;
        }

        spreadDust[sR2][sC2] = -1;
    }
    // ----------| v
    // ^         | v
    // ^         | v
    // ^ < < < < < <

    static void spreadDustFun(int[][] spreadDust, int[][] graph){
        int R = graph.length;
        int C = graph[0].length;

        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                spreadDust[r][c] = graph[r][c];
            }
        }

        // 퍼진만큼 원래 먼지는 빠지고,
        // 주변은 그만큼 퍼진다.
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                if(graph[r][c]!=0 && graph[r][c]!=-1){
                    int spread = graph[r][c]/5;

                    int spreadCount=0;
                    for(int k=0; k<4; k++){
                        int nr = r + dr[k];
                        int nc = c+ dc[k];

                        if(nr<0||nr>=R||nc<0||nc>=C) continue;

                        if(graph[nr][nc]==-1) continue;

                        spreadDust[nr][nc] += spread;
                        spreadCount++;
                        //graph[r][c]-=spread;
                    }
                    //spreadDust[r][c]=graph[r][c];
                    spreadDust[r][c] -= spreadCount*spread;

                }
            }
        }

    }

    static String printsb(int[][] graph){
        int R = graph.length;
        int C = graph[0].length;

        StringBuilder sb = new StringBuilder();
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                sb.append(graph[r][c]).append(" ");
            }
            sb.append("\n");
        }

        return String.valueOf(sb);
    }

}
