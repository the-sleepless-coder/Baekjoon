import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] inputArr = input.split(" ");
        int N = Integer.parseInt(inputArr[0]);
        int K = Integer.parseInt(inputArr[1]);

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int idx=0; idx<N; idx++){
            arr[idx] = Integer.parseInt(st.nextToken());
        }

        int[] result ;
        result = bubbleSort(arr, K);


        StringBuilder sb = new StringBuilder();
        if(result==null){
            sb.append(-1);
        }else{
            for(int n:result){
                sb.append(n).append(" ");
            }
        }

        System.out.println(sb);

    }

    // K 번 교환이 발생한 직후의 배열을 출력한다.
    static int[] bubbleSort(int[] arr, int K){
        int N = arr.length;

        int count = 0;
        // 비교 횟수 : N-1
        for(int i=0; i < N-1; i++){
            // 비교를 하고자 하는 인덱스 설정.
            for(int j=0; j<N-1-i; j++){
                // 오름차순으로 정렬할 경우,
                // 앞에 더 큰 숫자가 있으면 뒤로 보냄.
                int temp =-1;
                if(arr[j]>arr[j+1]){
                    temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;

                    count++;
                    if(count==K){
                        return arr;
                    }
                }
            }
        }

        return null;
    }

}


// 버블 정렬
// 선택 정렬
// 합병 정렬
// 퀵 정렬
// 삽입 정렬

