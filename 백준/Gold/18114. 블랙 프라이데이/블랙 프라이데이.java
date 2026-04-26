import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int n=0; n<N; n++){
            arr[n] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);


        System.out.println(findIfTExists(arr, T));


    }

    static int findIfTExists(int[] arr, int target){
        int N = arr.length;

        // 가장 큰 숫자에서부터 T을 맞추기 위해 숫자를 하나씩
        for(int n=0; n < N; n++){
            int num = arr[n];

            // 1개의 물건 선택 시 조합 확인
            if(num==target) return 1;

            // 2개의 물건 선택 시 조합 확인
            // 투 포인터 방식으로 남은 수의 조합이 존재하는지 확인한다.
            int startIdx = 0;
            int endIdx = N-1;
            while(startIdx<endIdx){
                if(arr[startIdx]+arr[endIdx] < target){
                    startIdx++;
                }else if(arr[startIdx]+arr[endIdx] > target){
                    endIdx--;
                }else{
                    startIdx++;
                    endIdx--;
                    return 1;
                }

            }

            // 3개의 물건 선택 시 조합 확인
            if(n<=N-3){
                int remainNum = target-num;
                int startIdxR = n+1;
                int endIdxR = N-1;
                while(startIdxR<endIdxR){

                    if(arr[startIdxR] + arr[endIdxR]<remainNum){
                        startIdxR++;
                    }else if(arr[startIdxR]+arr[endIdxR]>remainNum){
                        endIdxR--;
                    }else{
                        startIdxR++;
                        endIdxR--;
                        return 1;
                    }

                }
            }

        }

        return 0;

    }
    // 큰수에서부터 작은 숫자까지 채워나가면서,
    // 목표 숫자를 만들 수 있는지 확인해본다.

//5 13
//1 3 5 9 11

}
