import java.util.*;
public class Main {
    // 이분탐색을 통해서 주어진 배열에, 다른 배열의 숫자가 있는지 확인한다.
    static int[] arr;
    static int[] sel;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        // System.out.println(Arrays.toString(arr));


        int M = sc.nextInt();
        sel = new int[M];
        for(int i=0; i<M; i++){
            sel[i] = sc.nextInt();
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0 ;i<M; i++){
            sb.append(binary(sel[i])).append("\n");
        }

        System.out.println(sb);

    }

    static int binary(int num){
        int l = 0;
        int r = arr.length - 1;
        int mid = -1;
        // r < l
        // 그러니까 l과 r의 순서가 바뀔 때, 해당 배열에 주어진 숫자가 없다는 것을 의미한다.
        boolean match = false;
        while( l <= r ){
            mid = (l+r)/2;

            if (arr[mid] == num){
                match = true;
                return 1;
            }else if(arr[mid] < num){
                l = mid + 1;
            }else if(arr[mid] > num){
                r = mid - 1;
            }
        }


        return 0;
    }
}
