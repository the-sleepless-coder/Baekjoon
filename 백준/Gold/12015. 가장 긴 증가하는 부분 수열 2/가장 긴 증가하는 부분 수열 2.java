import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 모든 경우를 다 탐색하게 될 경우 시간초과가 발생한다.
    // 따라서 LIS 배열을 만들고 그 해당 배열의 가장 끝 숫자보다,
    // arr[i]의 숫자가 더 클 경우에 더하는 방식으로 구해야 한다.
    // arr[i]가 LIS의 마지막 숫자보다 큰지는 이분탐색을 통해서 하기 때문에, N*log(N)의 시간 복잡도를 가진다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> lis = new ArrayList<>();
        lis.add(arr[0]);
        for(int i = 1; i < N; i++){
            // arr[i]의 값이 더 크면, lis에 더한다.
            if(arr[i] > lis.get(lis.size()-1))
                lis.add(arr[i]);
            // arr[i]의 값이 크지 않다면, 이분탐색을 통해서 lis의 적절한 위치에 넣는다.
            else{
                int idx = binarySearch(lis, arr[i]);
                lis.set(idx, arr[i]);
            }
        }

        System.out.println(lis.size());

    }

    // 이분탐색을 통해서 LIS의 마지막 숫자보다 큰 arr[i]의 값을 찾는다.
    static int binarySearch(ArrayList<Integer> array, int target){
        int min = 0;
        int max = array.size() - 1;

        while(min <= max){
            int mid = (min + max)/2;

            // target보다 큰 min값을 구해서, LIS를 구하는 데 쓴다.
            // target이 arr[mid]보다 크다면, min을 늘려준다.
            if(array.get(mid) < target){
                min = mid + 1;
            }
            // target이 arr[mid]보다 작다면, max를 작게 만든다.
            else{
                max = mid - 1;
            }
        }

        return min;
    }
}
