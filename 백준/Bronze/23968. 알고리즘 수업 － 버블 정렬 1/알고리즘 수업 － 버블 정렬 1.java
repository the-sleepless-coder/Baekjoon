import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // char 값을 바이트로 하나씩 받고,
        // char로 값을 변환하고
        // 각각의 char값을 buffer에 저장한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        // String 반환, Integer로 형 변환.
        StringTokenizer st = new StringTokenizer(input);
        int N  = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // ,로 구분된다면 String으로 받은 input을 regex로 구분.
        // 공백을 기준으로 구분되는 string을 token 단위로 받고,
        // arr에 값을 입력 받는다.
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int idx=0; idx<N; idx++){
            arr[idx] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[2];
        int count = bubbleSort(arr, result, K);

        StringBuilder sb = new StringBuilder();

        if(count<K){
            count = -1;
            sb.append(count);
        }else{
            sb.append(result[0]).append(" ").append(result[1]);
        }

        System.out.println(sb);

    }

    // 알고리즘 풀이
    // 자료구조를 통한 데이터의 저장과 탐색
    // 스레드와 프로세스 단에서의 코드 실행
    // DB를 통한 데이터 저장
    // 네트워크를 통한 데이터의 전송

    // 버블 정렬을 통한 교환 횟수를 구한다.
    static int bubbleSort(int[] arr, int[] result, int K){
        int len = arr.length ;

        int count = 0;
        // 바꾸는 횟수
        for(int i=0; i < len - 1; i++){
            // 바꾸는 인덱스 결정
            // 오름차순일 경우 더 큰 수를 뒤로 바꿔야 해.
            for(int j=0; j < len-1 - i; j++){
                int temp = -1;
                if(arr[j]>arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    count++;

                    if(count==K){
                        result[0]=arr[j];
                        result[1]=arr[j+1];
                    }
                }
            }
        }

        return count;

    }


}

//6 10
//4 6 5 1 3 2

// 버블 정렬
// i번째 인덱스에서 2개의 숫자를 크기를 비교해서 정렬한다.
// 각 과정을 i-1개의 숫자가 다 정렬될때까지 한다.
// i-1 + i-2 + ... 1
// i * (i-1) /2


// 선택 정렬
// 퀵 정렬
// 병합 정렬
// 힙 정렬