import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){
            arr[n] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int target = Integer.parseInt(br.readLine());

        int count = 0;
        int startIdx = 0;
        int endIdx = N-1;

        // 서로 다른 두 포인터 이기 때문에,
        // 인덱스가 달라야 한다.
        // 시간 복잡도 O(N)
        while(startIdx < endIdx){
            // target 보다 작다면 작은 포인터를 늘려준다.
            if(arr[startIdx]+arr[endIdx] < target){
                startIdx++;
            }else if(arr[startIdx]+arr[endIdx] > target ){
                endIdx--;
            }else{
                startIdx++;
                endIdx--;
                count++;
                // 여기에서 추가로 뭔가를 해줘야될 것 같은데
            }

        }

        System.out.println(count);



    }
    // arr가 정렬된 상태일 때,
    // start, end 인덱스 2개의 포인터를 통해 구하고자 하는 숫자 합 쌍의 개수를 구한다.
    // 1 2 3 5 7 9 10 11 12

    // BJ 1940
}
