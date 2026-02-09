import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tot = sc.nextInt();
        sc.nextLine();

        // 한줄로 돼 있는 문자를
        // 2차원 배열로 만든다.
        for(int idx=0; idx<tot; idx++){
            String line = sc.nextLine();
            char[] charArr = line.toCharArray();
            int N = charArr.length;
            int sqr = (int) Math.sqrt(N);

            char[][] sqrArr = new char[sqr][sqr];
            for(int r=0; r<sqr;r++){
                for(int c=0; c<sqr; c++){
                    sqrArr[r][c] = charArr[r * sqr + c];
                }
            }

            char[][] resArr =new char[sqr][sqr];
            // 마지막 열에 있는 숫자를,
            // 첫번째 행으로 옮긴다.
            for(int c=sqr-1; c>=0; c--){
                for(int r=0; r<sqr; r++){

                    resArr[sqr-1 - c][r] =sqrArr[r][c];
                }
            }

            // sb.append에는 아무거나 다 들어가서 String으로 만들어주는건가?
            StringBuilder sb = new StringBuilder();
            for(int r=0;r<sqr; r++){
                for(int c=0; c<sqr; c++){
                    sb.append(resArr[r][c]);
                }
            }

            System.out.println(sb);


        }

    }
}

//r , c

//c-i, r