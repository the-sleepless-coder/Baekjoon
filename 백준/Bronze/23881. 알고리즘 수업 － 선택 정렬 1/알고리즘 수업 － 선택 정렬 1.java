import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        StringTokenizer st = new StringTokenizer(input);
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int idx=0; idx<N; idx++){
            arr[idx]=Integer.parseInt(st.nextToken());
        }

        int[] result = new int[2];
        result = selectionSort(arr, K, result);

        StringBuilder sb = new StringBuilder();
        if(result==null){
            sb.append("-1");
        }else{
            sb.append(result[0]).append(" ").append(result[1]);
        }

        System.out.println(sb);

    }

    // K번째 교환되는 수를 출력해라.
    static int[] selectionSort(int[] arr, int K, int[] result){
        int N = arr.length;

        int count = 0;
        // 교환할 i번째 인덱스 설정.
        for(int i=N-1; i >= 1 ; i--){
            int maxIdx = i;

            // 비교할 숫자를 탐색한다.
            for(int j = i-1; j>=0; j--){
                if( arr[j] > arr[maxIdx]){
                    maxIdx=j;
                }
            }

            // 더 큰 수를 발견하면 교환해주고,
            // 교환횟수를 올려준다.
            if(maxIdx!=i){
                int temp;
                temp=arr[maxIdx];
                arr[maxIdx]=arr[i];
                arr[i]=temp;

                count++;
            }
            
            //K번째 교환되는 숫자 출력.
            if(count==K){
                result[0]= arr[maxIdx];
                result[1]= arr[i];

                return result;
            }

        }
        // 그것 이상이면 빈 배열 출력.
        return null;

    }



}
// K번째 교환되는 수를 찾아라.
// 나의 뒤에 있는 가장 작은 수를 앞으로 가져온다.
// 나의 앞에 있는 가장 큰 수를 뒤로 가져온다.