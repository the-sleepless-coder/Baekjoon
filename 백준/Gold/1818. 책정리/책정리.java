import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int n=0; n<N; n++){
            arr[n]=Integer.parseInt(st.nextToken());
        }

        int result = findLis(arr);

        System.out.println(N-result);
    }

    // target 이상 숫자가 처음 나오는 위치를 찾는다.
    static int lowerbound(ArrayList<Integer>lis, int target){
        int start = 0;
        int end = lis.size()-1;

        while(start<end){
            int mid = (start+end) / 2;

            // target이 더 크다면, mid 보다 큰 값을 탐색한다.
            if(lis.get(mid) < target){
                start = mid+1;
            }
            // target이 더 작다면, mid를 포함해서 end로 잡는다.
            else if(lis.get(mid) >= target){
                end = mid;
            }

        }

        // target 이상의 값이 처음 나오는 인덱스 값을 반환한다.
        return end;
    }

    // 원래 배열에서 가장 긴 증가하는 수열을 구한다.
    static int findLis(int[] arr){
        ArrayList<Integer> lis = new ArrayList<>();
        lis.add(arr[0]);
        int N = arr.length;

        for(int i=1; i<N; i++){
            int curr = arr[i];

            // lis의 가장 마지막 값보다 크다면,
            // lis의 뒤에 더해준다.
            if(curr>lis.get(lis.size()-1)){
                lis.add(curr);
            }
            // 그것이 아니라면 lis내에서의 위치를 찾아준다.
            else{
                int pos = lowerbound(lis, curr);
                lis.set(pos, curr);
            }
        }


        return lis.size();
    }
    // 1 5 2 4 3


}
