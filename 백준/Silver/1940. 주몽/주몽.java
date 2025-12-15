import java.io.*;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    // M(1<= M <= 10,000,000)
    // 2개의 합으로 갑옷 만들어짐.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int idx=0; idx<N; idx++){
            arr[idx] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        // 1, 2, 3, 4, 5, 7

        // 오름차순 기준 정렬된 배열
        // 숫자가 더 크니까 줄여야 한다.
        // arr[left] + arr[right] > target
        // right -=1
        // 숫자가 더 작으니까 늘려준다.
        // arr[left] + arr[right] < target
        // left +=1
        // 같다면 하나는 늘리고 하나는 줄여서,
        // target과 동일한 값이 나올지 검증.

        // 두 인덱스가 서로 같아서는 안되기 때문에,
        // 같을 때는 while문을 탈출하게 해야 한다.
        int left = 0;
        int right = N-1;
        int count = 0;
        while(left < right){
            int sum = arr[left] + arr[right];

            if(sum > target){
                right-=1;
            }else if(sum < target){
                left+=1;
            }else{
                count++;
                left ++;
                right --;
            }

        }

        System.out.println(count);
    }

}
