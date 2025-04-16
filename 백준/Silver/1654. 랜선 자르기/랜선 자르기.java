import java.util.*;

public class Main {
    // 영식이 갖고 있는 랜선의 개수 K개, 필요한 랜선의 개수 N개
    static int[] arr;
    static int K, N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        K = sc.nextInt();
        N = sc.nextInt();

        arr = new int[K];
        long max = Integer.MIN_VALUE;
        for(int i=0; i < K; i++){
            arr[i] = sc.nextInt();
            max = Math.max(arr[i], max);
        }


        long result = binary(max);

        System.out.println(result);

    }


    static long binary(long max){
        long l = 1;
        long r = max;
        long result = 0;

        while( l <= r ){
            long mid = (l+r)/2;

            int sum = 0;
            for(int i=0; i < K; i++){
                sum += arr[i] / mid;
            }

            // 잘라진 랜선의 개수가, 주어진 N개 보다 많다면 해당 숫자를 반환한다.
            // 잘라진 랜선의 개수가 주어진 N개보다 많다면, 랜선을 최대한 길게 만들어서 개수를 줄인다.
            if(N <= sum) {
                result = mid;
                l = mid + 1;
            }
/*
            else if( N < sum ){
                l = mid + 1;
            }
*/
            // 잘라진 랜선의 개수가 주어진 N개보다 적다면, 랜선을 더 짧게 자른다.
            else if(N > sum){
                r = mid - 1;
            }

        }

        return result;

    }

}
