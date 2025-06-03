import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    // 왼쪽 위가 W인 경우 바꿔야되는 체스판의 개수
    // 왼쪽 위가 B인 경우 바꿔야되는 체스 판의 개수
    // 중에서 작은 것을 고르면 되는 문제이다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        char[][] chess = new char[r][c];
        for(int i=0; i < r; i++){
            String row = br.readLine();
            char[] charArray = row.toCharArray();
            chess[i] = charArray;
        }

        // 시작점의 체스판 색깔에 따라서,
        // 짝수 줄과 홀수 줄에 대한 판별을 각각 다르게 해준다.
        // 세로 기준으로 판별하기는 했으나,
        // 어차피 첫 체스판 색깔 기준으로 나머지 체스판의 색깔 판별 시 반대로 된다면,
        // 더 쉬운 방법은 없을까 싶다.
        int result1 = Integer.MAX_VALUE;
        int result2 = Integer.MAX_VALUE;
        int size = 8;

        for(int row=0; row <= c - size; row++){
            for(int col=0; col <= r - size; col++){

                int temp= 0;
                for(int i = row; i < row + size; i++){
                    for(int j=col; j < col + size; j++){
                        if(i%2 == 0){
                            if(j%2==0){
                                if(chess[j][i]!='W'){
                                    temp+=1;
                                }
                            }else{
                                if(chess[j][i]!='B'){
                                    temp+=1;
                                }
                            }

                        }else{
                            if(j%2==0){
                                if(chess[j][i]!='B'){
                                    temp+=1;
                                }
                            }else{
                                if(chess[j][i]!='W'){
                                    temp+=1;
                                }
                            }

                        }


                    }
                }

                result1 = Math.min(result1,temp);

            }
        }

        for(int row=0; row <= c - size; row++){
            for(int col=0; col <= r - size; col++){

                int temp= 0;
                for(int i = row; i < row + size; i++){
                    for(int j=col; j < col + size; j++){
                        if(i%2 == 0){
                            if(j%2==0){
                                if(chess[j][i]!='B'){
                                    temp+=1;
                                }
                            }else{
                                if(chess[j][i]!='W'){
                                    temp+=1;
                                }
                            }

                        }else{
                            if(j%2==0){
                                if(chess[j][i]!='W'){
                                    temp+=1;
                                }
                            }else{
                                if(chess[j][i]!='B'){
                                    temp+=1;
                                }
                            }

                        }
                    }
                }
                result2 = Math.min(result2,temp);

            }
        }


        //System.out.println(Arrays.deepToString(chess));
        //System.out.println(result1);
        //System.out.println(result2);

        int answer = Math.min(result1, result2);
        System.out.println(answer);


    }
}
