import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        sc.nextLine();
        // int testCase = 1;

        for(int test = 1; test<=testCase; test++){
            int R = sc.nextInt();
            int C = sc.nextInt();
            int[][] arr = new int[R][C];
            for(int r=0 ; r<R; r++) {
                for (int c = 0; c < C; c++) {
                    arr[r][c] = sc.nextInt();
                }
            }

            int max = Integer.MIN_VALUE;
            for(int r=0 ; r<R; r++) {
                for (int c = 0; c < C; c++) {
                    int sum = 0;
                    int curr = arr[r][c];

                    sum+=curr;
                    for(int rn = 1; rn <= curr; rn++){
                        if(r+rn<R){
                            sum += arr[r+rn][c];
                        }
                        if(c+rn<C)
                            sum += arr[r][c+rn];
                        if(r-rn>=0)
                            sum+= arr[r-rn][c];
                        if(c-rn>=0)
                            sum+= arr[r][c-rn];
                    }

                    max = Math.max(sum, max);
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(test).append(" ").append(max);
            System.out.println(sb);
        }



    }
}
