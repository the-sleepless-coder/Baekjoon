import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][2];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        // System.out.println(Arrays.deepToString(arr));

        // arr 내 각 객체에 대해서,
        // x의 값이 같다면 y의 값에 따라서 오름차순 정렬하고
        // 그렇지 않다면 기본적으로 x의 값에 따라서 정렬한다.

        // sort내 구현 돼 있는 함수가 1개 밖에 없을 때, 함수형 인터페이스에 대해서 추상 메서드를 람다식으로 overriding 해서 해당 함수를 구현할 수 있다.
        Arrays.sort(arr,
                (o1, o2) -> {
                    if (o1[0] == o2[0]) {
                        return o1[1] - o2[1];
                    }
                    return o1[0] - o2[0];
                }
        );

        // System.out.println(Arrays.deepToString(arr));
        StringBuilder sb = new StringBuilder();

        for(int[] row: arr){
            sb.append(row[0]).append(" ").append(row[1]).append("\n");
            //System.out.printf("%d %d",row[0], row[1]);
            //System.out.println();
        }

        System.out.println(sb);
    }


}
