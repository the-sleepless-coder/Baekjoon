import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // 테스트케이스 수
        StringBuilder out = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[][] arr = new int[N][N];
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    arr[r][c] = sc.nextInt();
                }
            }

            int max = Integer.MIN_VALUE;

            for (int r = 0; r <= N - M; r++) {
                for (int c = 0; c <= N - M; c++) {
                    int sum = 0;
                    for (int i = 0; i < M; i++) {
                        for (int j = 0; j < M; j++) {
                            sum += arr[r + i][c + j];
                        }
                    }
                    if (sum > max) max = sum;
                }
            }

            out.append("#").append(tc).append(" ").append(max).append("\n");
        }

        System.out.print(out);
        sc.close();
    }
}
