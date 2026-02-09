import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){

            int R = sc.nextInt();
            int C = sc.nextInt();
            sc.nextLine();
            if(R==0 && C==0){
                break;
            }

            char[][] arr = new char[R][C];

            for(int r=0; r<R; r++){
                String line = sc.nextLine();
                for(int c=0; c<C; c++){
                    char[] charArr = line.toCharArray();
                    arr[r][c] = charArr[c];
                }
            }

            // 각 자리마다 8방향 탐색을 하고,
            // 각 자리마다 몇 개의 인접한 지뢰가 있는지 확인한다.
            int[] dr = {-1, 1, 0 , 0, -1 ,-1, 1, 1};
            int[] dc = {0,  0, -1, 1, -1, 1 , -1, 1 } ;
            int[][] intArr = new int[R][C];
            for(int r=0; r<R; r++){
                for(int c=0; c<C; c++){

                    // 지뢰면 -1로 표시한다.
                    if(arr[r][c]=='*'){
                        intArr[r][c]=-1;
                        continue;
                    }

                    int lmCount =0;
                    for(int k=0; k<8; k++){
                        int nr = r+dr[k];
                        int nc = c+dc[k];

                        if(nr<0 || nr>=R||nc<0 || nc>=C )
                            continue;

                        if(arr[nr][nc]=='*'){
                            lmCount++;
                        }
                    }

                    intArr[r][c]=lmCount;
                }
            }

            StringBuilder sb = new StringBuilder();
            for(int r=0; r<R; r++){
                for(int c=0;c<C; c++){
                    if(intArr[r][c]!=-1)
                        sb.append(intArr[r][c]);
                    else{
                        sb.append("*");
                    }
                }
                sb.append("\n");
            }

            System.out.print(sb);

        }

    }
}
