import java.io.*;
import java.util.*;

public class Main {
    // 1<=N<=100,000
    // 1<=M<= 20억

    // 두 수를 골랐을 때( 같은 수 일 수 있음 )
    // 그 차이가 M이상이면서 제일 작은 경우를 구하는 프로그램을 구해라.

    // 모든 경우를 다 탐색하면 오래 걸리기 때문에,
    // 주어진 차이보다 작으면 차이를 늘리고
    // 주어진 차이보다 크면 차이를 줄인다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 여기에서 그러면 buffer에 있는 문자열을 읽어와서,
        // 공백을 기준으로 StringTokenizer가 하나씩 생성된 셈인가?
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int targetDiff = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for(int idx =0; idx < N; idx++){
            int num = Integer.parseInt(br.readLine());
            arr[idx] = num;
        }

        Arrays.sort(arr);

        // 일단 차이 중에 가장 작은 것을 구한다.
        // 일단 같은 수일 수는 있지만 인덱스가 서로 같으면 while문이 끝나야 한다.

        // 차이 중에서 targetDiff 이상의 값 중 가장 작은 것을 구한다.
        int left = 0;
        int right = 1;
        int minDiff = Integer.MAX_VALUE;
        while(left <= right){
            int diff = Math.abs(arr[right]- arr[left]) ;
            // 차이가 너무 작으면 rightIdx를 늘려준다.
            if(diff < targetDiff){
                right ++;
                if(right>=N)
                    break;
            }
            // 차이가 너무 크면 leftIdx를 늘려준다.
            else if(diff > targetDiff){
                minDiff = Math.min(minDiff, diff);
                left++;
            }
            // 차이가 minDiff와 동일하다면 while문을 벗어난다.
            else{
                minDiff = targetDiff;
                break;
            }

            if(left==right){
                right++;
                if(right>=N)
                    break;
            }

        }

        System.out.println(minDiff);

    }

//     5 4
//     -1 2 6 9 11
    // (1+N)*N/2
    // 모든 경우를 다 탐색하면 안돼
    // 어떻게 탐색의 경우를 줄일 수 있을까?
    // 우선 몇 개의 사례를 통해 패턴을 파악해본다.
    // 몇 개의 사례를 통해 우선 무식한 방식으로 짜본다.
    // 모든 경우를 탐색하지 않고 시간 복잡도를 개선할 방식을 생각해본다.

    // -1, 2, 6 너무 커졌다 5
    // 3, 6 너무 작아졌다 3
    // 3, 9 너무 커졌다 6
    // 6, 9 너무 작아졌다 3
    // 6, 11 5

    // 간단한 PseudoCode로 풀이에 대한 개괄적인 코드를 짜본다.
    // 그러니까 targetDiff보다 크다면 인덱스를 줄인다.
    // if(diff > targetDiff)
    // leftIdx ++
    // targetDiff보다 작다면 인덱스를 늘린다.
    // if(diff < targetDiff)
    // rightIdx --




}
