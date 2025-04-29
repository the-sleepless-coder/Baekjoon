import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // 1 2 1 1 0
    // 어떤 자료구조를 써야할지, 그리고 어떤 논리구조를 짜야할지에 대한 생각을 하는 과정이 필요하다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        int[] arr = new int[N];
        for(int i=0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int str = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            for(int j= str - 1; j<= end - 1; j++){
                arr[j] = num;
            }

        }

        // System.out.println(Arrays.toString(arr));

        for(int ele:arr){
            System.out.printf("%d ", ele);
        }

    }
}
