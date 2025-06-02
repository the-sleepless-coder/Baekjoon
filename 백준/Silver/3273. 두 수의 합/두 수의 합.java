import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N =  Integer.parseInt(br.readLine());

        // 해당 줄에서 읽은 값에 대해서 Token으로 만들고 저장한다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        HashSet<Integer> s = new HashSet<>();

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            s.add(arr[i]);
        }

        int x = Integer.parseInt(br.readLine());

        //Set안에 x - arr[i]에 해당하는 숫자가 존재하는지 확인하고,
        // 존재한다면 result +1을 해준다.
        int result = 0;
        for(int i=0; i<N; i++){
            if(s.contains(x - arr[i])){
                result+=1;
            }
        }

        result = result/2;

        System.out.println(result);

    }
}
