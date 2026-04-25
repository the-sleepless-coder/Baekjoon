import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());


        int[] arr = new int[N];
        for(int n=0; n<N; n++){
            arr[n] =Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        // 각 숫자가 위 배열에 존재하는지 확인
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] find = new int[M];
        for(int m=0; m<M; m++){
            find[m]=Integer.parseInt(st.nextToken());
        }


        System.out.println(findNum(find, arr));


    }

    // 이분 탐색을 이용한 탐색
    // start, end 인덱스를 활용해,
    // 이분 탐색을 통한 숫자 탐색
    
    // 시간 복잡도: N*logN
    static String findNum(int[] find, int[]arr) {
        int M = find.length;
        int N = arr.length;

        StringBuilder sb = new StringBuilder();
        for (int m = 0; m < M; m++) {
            int num = find[m];

            int start = 0;
            int end = N - 1;

            boolean found = false;
            while (start <= end) {
                int mid = (start + end) / 2;

                if (arr[mid] == num) {
                    //System.out.println(mid);
                    sb.append(1).append("\n");
                    found = true;
                    break;
                }
                // 더 작은 부분 탐색
                else if (num < arr[mid]) {
                    end = mid - 1;
                }//더 큰 부분을 탐색
                else if (arr[mid] < num) {
                    start = mid + 1;
                }
            }

            if(!found) sb.append(0).append("\n");
        }

        return String.valueOf(sb);
    }



}
