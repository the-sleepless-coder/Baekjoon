import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 시험장 개수 N개
    // 각 시험장에 있는 응시자 수
    // 총감독관, 부감독관이 감시할 수 있는 응시자 수
    // 필요한 총감독관, 부감독관 수의 최소값
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++ ){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] drct = new int[2];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<2; i++){
            drct[i] = Integer.parseInt(st.nextToken());
        }

        long result = 0;
        for(int i=0; i<N; i++){
            // 기본적으로 총감독관 한명이 있다고 가정하고,
            // 총 감독관이 감독하고 있는 사람 외 나머지는 몇 명의 감독관이 감독하는지를 확인하면 된다.
            // 총 감독관이 감독하고 있는 사람의 수가 double로 나오면 ceiling을 만들어주고,
            // 그렇지 않다면 정수 그대로 처리해준다.
            int temp = 0;
            if(arr[i]-drct[0] >= 0)
                if((double)(arr[i]-drct[0])/drct[1] - (arr[i]-drct[0])/drct[1] != 0)
                    temp = 1 + (arr[i] - drct[0])/drct[1] + 1;
                else
                    temp = 1 + (arr[i] - drct[0])/drct[1];
            else
                temp = 1;

            result += temp;
            // System.out.println(temp);

        }

        System.out.println(result);


    }
}
