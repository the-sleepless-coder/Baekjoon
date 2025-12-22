import java.util.Scanner;

public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();   // 테스트케이스 수

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[][] arr = new int[N][N];
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    arr[r][c] = sc.nextInt();
                }
            }

            int[][] maxArr = new int[N - (M - 1)][N - (M - 1)];
            int max = Integer.MIN_VALUE;

            for (int r = 0; r < N; r++) {
                if (r <= N - M) {
                    for (int c = 0; c < N; c++) {
                        if (c <= N - M) {
                            int sumLast;
                            if (c == 0) {
                                int sum = 0;
                                for (int i = 0; i < M; i++) {
                                    for (int j = 0; j < M; j++) {
                                        sum += arr[r + i][c + j];
                                    }
                                }
                                sumLast = sum;
                            } else {
                                int before = maxArr[r][c - 1];
                                int delta = 0;
                                for (int i = 0; i < M; i++) {
                                    delta -= arr[r + i][c - 1];
                                    delta += arr[r + i][c - 1 + M];
                                }
                                sumLast = before + delta;
                            }

                            maxArr[r][c] = sumLast;
                            if (sumLast > max) max = sumLast;
                        }
                    }
                }
            }

            System.out.println("#" + tc + " " + max);
        }

        sc.close();
    }
}
