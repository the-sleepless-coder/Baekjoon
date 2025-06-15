import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int R = 9;
        int C = 9;

        int[][] map = new int[R][C];

        int max = Integer.MIN_VALUE;
        int r = -1;
        int c = -1;

        for(int i=0 ; i<R; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(max < map[i][j]){
                    max = map[i][j];
                    r = i+1;
                    c = j+1;
                }
            }
        }

        System.out.println(max);
        System.out.printf("%d %d", r, c);

    }
}
