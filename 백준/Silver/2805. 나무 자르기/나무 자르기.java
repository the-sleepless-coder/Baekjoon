import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 적어도 M미터의 나무를 가져가기 위한,
    // 나무 절단기의 최대 높이를 구한다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int treeNum = Integer.parseInt(st.nextToken());
        int meters = Integer.parseInt(st.nextToken());

        Integer[] treeArr = new Integer[treeNum];
        int treeMin = 0;
        int treeMax = -1;

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<treeNum; i++){
            int num = Integer.parseInt(st.nextToken());

            treeArr[i] = num;
            treeMax = Math.max(treeMax, num);
        }

        // 나무 합이 너무 길면 절단기를 늘린다.
        // 나무 합이 너무 짧으면 절단기를 줄인다.

        // mid = (low + high)/2
        // 상위 검색
        // low = mid + 1;
        // 하위 검색
        // high = mid -1;

        int result = -1;
        while(treeMin <= treeMax){
            int mid = (treeMin + treeMax) / 2;

            long sum = 0;
            for(int tree : treeArr){
                if(tree - mid >= 0){
                    sum += tree- mid;
                }
            }

            // 합이 적어서 절단기를 줄인다.
            if(sum < meters){
                treeMax = mid - 1 ;
            }

            // 합이 커서 절단기를 늘린다.
            if(sum >= meters){
                treeMin = mid + 1;
                result = mid;
            }

        }

        System.out.println(result);

    }
}
