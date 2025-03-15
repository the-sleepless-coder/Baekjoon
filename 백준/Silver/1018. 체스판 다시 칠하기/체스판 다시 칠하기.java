import java.util.*;

public class Main {
    public static void main(String[] args) {
        // M*N
        // 8*8로 만드려고 한다.
        // 10 * 13일 경우 검증을 할 수 있는 칸의 개수는
        // (2+1) * (5+1)
        // (0, 1, 2) * (0, 1, 2, 3, 4, 5)

        // 첫번째 칸이 W인 경우와 B인 경우를 나눠서 확인하면 된다.
        // 홀수 행, 짝수 행에 따른 판별을 진행하면 된다.
        // 첫번째 칸에서 짝수 행 짝수 번째 칸만큼 떨어진 곳은, 첫번째 칸과 같아야 한다.
        // 첫번째 칸에서 홀수 행 홀수 번째 칸만큼 떨어진 곳은, 첫번째 칸과 같아야 한다.

        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        sc.nextLine();

        char[][] charArr = new char[r][c];
        for(int i=0; i<r; i++){
            String temp = sc.nextLine();
            char[] tempChar = temp.toCharArray();
            charArr[i] = tempChar;
        }

        // System.out.println(Arrays.deepToString(charArr));

        // 검증 범위 내 각 시작점을 확인한다.
        int checkR = r - 8 ;
        int checkC = c - 8 ;
        int min = Integer.MAX_VALUE;
        // System.out.println(checkR);
        // System.out.println(checkC);

        for(int i = 0; i <= checkR; i++){
            for(int j = 0; j <= checkC; j++) {
                // 시작점에서 각 행열로 떨어진만큼의 행열에 어떤 값이 있는지를 확인하면 된다.
                // 행 열 처리를 모두 해줘야 제대로 개수를 처리할 수 있다.
                //charArr에 대한 경우를 나눠준다.

                // System.out.printf("%d %d\n", i, j);

                // 시작 위치에서 'B', 'W' 모든 경우에 대한 케이스를 분석해주고, 그 중에서 체스판을 바꿔야 하는 경우의 수가 더 작은 것을 구한다.
                char[] charCase = {'B','W'};
                for(char chr: charCase){
                    // 각 시작 지점에서 changeCol은 초기화 돼야 한다.
                    // 경우를 나눌 때 초기화 위치에 신경쓰자.
                    int changeCol = 0;

                    char temp = chr;

                    // 첫번째 칸에서 k,l개의 칸을 떨어진만큼에 대한 처리를 해준다.
                    for (int k = 0; k < 8 ; k++){
                        for (int l = 0; l < 8; l++) {

                            if ( k % 2 == 0 ) {
                                // 짝수 행 짝수 열만큼 떨어진 곳은 같아야 한다.
                                if(l % 2 == 0){
                                    if (charArr[i + k][j + l] != temp) {
                                        changeCol += 1;
                                        //System.out.print(k);
                                        //System.out.print(l);
                                        //System.out.println();
                                    }
                                }else{
                                    // 짝수 행 홀수열만큼 떨어진 곳은 달라야 한다.
                                    if (charArr[i + k][j + l] == temp) {
                                        changeCol += 1;
                                    }
                                }

                            }else{
                                // 홀수 행 홀수 열만큼 떨어진 곳은 같아야 한다.
                                if(l % 2 == 1){
                                    if (charArr[i + k][j + l] != temp) {
                                        changeCol += 1;
                                    }
                                }else{
                                    // 홀수 행 짝수열만큼 떨어진 곳은 달라야 한다.
                                    if (charArr[i + k][j + l] == temp) {
                                        changeCol += 1;
                                    }
                                }


                            }


                        }


                    }

                    // 검증해줘야 하는 곳에서 모두 다 처리했다면, 바꿔야하는 체스판의 개수를 구해준다.
                    if (min > changeCol) {
                        min = changeCol;
                    }
                }



            }
        }

        System.out.println(min);

    }

}

//BBBBBBBB
//BBBBBBBB
//BBBBBBBB
//BBBBBBBB
//BBBBBBBB
//BBBBBBBB
//BBBBBBBB
//BBBBBBBB


//BBBWBWBW
//BBBBWBWB
//BBBWBWBW
//BBBBWBWB
//BBBWBWBW
//BBBBWBWB
//BBBWBWBW
//BBBBWBWB