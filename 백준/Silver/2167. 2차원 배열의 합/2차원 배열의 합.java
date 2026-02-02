import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[][] arr = new int[R][C];
        for(int r=0; r<R; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<C; c++){
                arr[r][c]= Integer.parseInt(st.nextToken());
            }
        }

        int k = Integer.parseInt(br.readLine());
        int[][] position = new int[k][4];
        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<4; j++){
                position[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        //System.out.println(Arrays.deepToString(arr));
        //System.out.println(Arrays.deepToString(position));

        for(int idx=0; idx<k; idx++){
            int x1=-1;
            int y1=-1;
            int x2=-1;
            int y2=-1;

            int sum=0;

            x1=position[idx][0]-1;
            y1=position[idx][1]-1;
            x2=position[idx][2]-1;
            y2=position[idx][3]-1;

            for(int X=x1; X<=x2; X++){
                for(int Y=y1; Y<=y2; Y++){
                    sum += arr[X][Y];
                }
            }

            System.out.println(sum);

        }


    }
}
// 1 2 2 5

//1 3 5 7 9
//11 13 15 17 19
//21 23 25 27 29