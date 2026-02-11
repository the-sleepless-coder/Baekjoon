import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totCase = sc.nextInt();
        sc.nextLine();

        int N = 9;
        for(int test=1; test<=totCase; test++){

            // 스도쿠 판 입력 받기.
            int[][] arr = new int[N][N];
            for(int r=0; r<N; r++){
                for(int c=0; c<N; c++){
                    arr[r][c] = sc.nextInt();
                }
            }

            sc.nextLine();

            boolean result = checkSudoku(arr);
            String resultString = "";

            if(result){
                resultString = "CORRECT";
            }else{
                resultString = "INCORRECT";
            }

            // StringBuilder sb = new StringBuilder();
            System.out.printf("Case %d: %s\n", test, resultString);


        }

    }

    static boolean checkSudoku(int[][] arr){
        int N = arr.length;

        // row,col,boxNum 모두 1-인덱스 기준.

        // 행 체크
        boolean rowCheck = true;
        for(int r=0; r<N; r++){
            boolean[] rowNum = new boolean[N+1];
            for(int c=0; c<N; c++){
                int num = arr[r][c];
                if(!rowNum[num])
                    rowNum[num]=true;
                else{
                    rowCheck = false;
                    break;
                }

            }
        }

        // 열 체크
        boolean colCheck = true;
        for(int c=0; c<N; c++){
            boolean[] colNum = new boolean[N+1];
            for(int r=0; r<N; r++){
                int num = arr[r][c];
                if(!colNum[num])
                    colNum[num]=true;
                else{
                    colCheck = false;
                    break;
                }

            }
        }

        // 박스 체크
        int blockSize = N/3;

        boolean boxCheck = true;
        for(int br=0; br<blockSize; br++){
            for(int bc=0; bc<blockSize; bc++){

                int startR = br*blockSize;
                int startC = bc*blockSize;

                boolean[] boxNum = new boolean[N+1];
                // blockSize내 인덱스를 이용
                // startR ~ endR의 구간을 반복적으로 탐색한다.
                for(int r=startR; r < startR + blockSize; r++){
                    for(int c=startC; c < startC + blockSize; c++){
                        int idx = arr[r][c];

                        if(!boxNum[idx])
                            boxNum[idx] = true;
                        else{
                            boxCheck = false;
                            break;
                        }

                    }
                }


            }
        }

        //System.out.printf("%b %b %b\n",rowCheck, colCheck, boxCheck);

        boolean result;
        if(rowCheck && colCheck && boxCheck){
            result = true;
        }else{
            result = false;
        }

        return result;
    }
}
