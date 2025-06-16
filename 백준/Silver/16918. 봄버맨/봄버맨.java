import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        char[][] map = new char[R][C];

        for(int i=0; i < R; i++){
            String temp = br.readLine();
            char[] charArray = temp.toCharArray();
            for(int j=0; j < C; j++){
                map[i][j] =  charArray[j];
            }
        }

        // System.out.println(Arrays.deepToString(map));

        int time = 0;
        char[][] temp = new char[R][C];
        char[][] result = map;
        while(time != S){
            time++;
            if ( time == 1 ){
                // 같은 참조값을 참고하게 하지 않기 위해서,
                // 반드시 deep Copy를 해준다.
                for(int i=0; i<map.length; i++){
                    temp[i] = map[i].clone();
                }
            }
            else{
                // 짝수 시간일 때, 폭탄을 설치한 위치 외 모든 곳에 폭탄을 설치한다.
                if( time % 2 == 0){
                    for(int i=0; i<R; i++){
                        for(int j=0; j<C; j++){
                            if(temp[i][j] != 'O'){
                                result[i][j] = 'O';
                            }
                        }
                    }
                    //System.out.println(time);
                    //System.out.println(Arrays.deepToString(temp));

                }else{
                    // 홀수 시간일 때, 자기 자신의 위치를 포함한 4방향으로 폭탄을 터뜨린다.
                    int[] dr =  {0, -1, 1, 0, 0};
                    int[] dc = {0, 0, 0, -1, 1};
                    if (time%2 == 1){
                        for(int i=0; i<R; i++){
                            for(int j=0; j<C; j++){
                                if(temp[i][j]=='O'){
                                    for(int k=0; k<5; k++){
                                        int nr = i+dr[k];
                                        int nc = j+dc[k];

                                        // 당연히 범위를 벗어나면 continue를 해줘야 한다.
                                        if(nr >= R || nr < 0 || nc >= C || nc<0)
                                            continue;

                                        result[nr][nc] = '.';
                                    }

                                }
                            }
                        }
                        //System.out.println(time);
                        //System.out.println(Arrays.deepToString(temp));
                        //System.out.println("-----");

                        // 여기도 마찬가지로, temp와 result가 같은 참조값을 참고하지 않게,
                        // deep copy를 해야 서로가 완전히 다른 참조값을 참고할 수 있게 한다.
                        for(int i=0; i<result.length; i++){
                            temp[i] = result[i].clone();
                        }
                        //System.out.println(Arrays.deepToString(temp));
                    }

                }
            }

        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                sb.append(result[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);



    }


}