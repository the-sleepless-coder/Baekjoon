import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    // N에 있는 요소가 항상 M에 있는 요소 중 같거나 큰 것을 가리키되,
    // N에 있는 더 작은 요소가 M에 있는 요소 중 더 큰 것을 가리켜서는 안된다.

    // 다르게 생각하면 그냥 M개의 숫자 중 N개의 증가하는 숫자를 뽑기만 하면 되는 문제로 변환되기도 한다.
    // 0, 1, 2, 3
    // 0, 1, 2, 3, 4
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
         int testCase = Integer.parseInt(br.readLine());

         for(int i=0; i < testCase; i++){
             StringTokenizer st = new StringTokenizer(br.readLine());

             int N = Integer.parseInt(st.nextToken());
             int M = Integer.parseInt(st.nextToken());

//             int[] arr1 = new int[N];
//             int[] arr2 = new int[M];
//             for(int j=0; j<N; j++){
//                 arr1[j] = j;
//             }
//             for(int j=0; j<M; j++){
//                 arr2[j] = j;
//             }

             // System.out.println(Arrays.toString(arr1));
             // System.out.println(Arrays.toString(arr2));

             BigInteger result = fact(M).divide(fact(N)).divide(fact(M-N));

             System.out.println(result);


         }

        //System.out.println(Arrays.deepToString(arr));

    }

    // n-1이 들어가면 해당 자리에 그 숫자가 들어갈 것이고,
    // 0이 들어가면 1로 멈출테니까 재귀함수가 끝난다.


    // Recursive Case에서 반복적으로 호출이 너무 많이 일어날 경우,
    // Stack OverFlow가 나게 되니 반드시 재귀함수를 멈출 수 있는 Base Case를 잘 설정하는 것이 중요하다.
    public static BigInteger fact(int n){
        // Base case
        //
        if(n==0){
            return BigInteger.ONE;
        }

        // Recursive Case
        // 재귀함수의 반복이 진행되는 부분
        return BigInteger.valueOf(n).multiply(fact(n-1));
    }
}
