import com.sun.security.jgss.GSSUtil;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // double/double을 해야 double이 나온다는 것을 기억해야 한다.
        // 그렇지 않으면 double/int를 할 경우 int가 나오기 때문이다.
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        int[] arr = new int[N];
        double max = Integer.MIN_VALUE;
        for(int i = 0; i<N; i++){
            arr[i] = sc.nextInt();
            max = Math.max(arr[i], max);
        }

        // System.out.println(max);

        double sum =0;
        for(int x: arr){
            double temp = x / max * 100;
            // System.out.println(temp);
            sum += temp;
        }

        double avg = sum / N;
        System.out.println(avg);

    }
}
