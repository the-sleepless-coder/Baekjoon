import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // W*H = 전체
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        // Local Maximum이 있는 곳을 표시하고,
        // 좌측과 우측의 LocalMax를 비교해서 더 작은 것 기준으로 선을 그어서 빗물을 측정하는데 이용한다.
        st = new StringTokenizer(br.readLine());
        int[] blocks = new int[W];
        for (int idx = 0; idx < W; idx++) {
            blocks[idx] = Integer.parseInt(st.nextToken());
        }

        // 이전에 비교한 값 이용해서, 왼쪽부터 이미 계산한 값 이용해서 비교
        // 초기 값은 idx = 0에 대해 잡고
        // 그 이후의 값은 이전에 비교한 최대값을 이용해서, 현재 값과 비교를 한다.
        int[] localMaxLeftArr = new int[W];
        int[] localMaxRightArr = new int[W];
        for(int i=0; i<W; i++){
            int curr = blocks[i];
            if(i==0){
                localMaxLeftArr[i]=curr;
            }else{
                int before = localMaxLeftArr[i-1];
                localMaxLeftArr[i]=Math.max(curr, before);
            }
        }

        // System.out.println(Arrays.toString(localMaxLeftArr));

        // 이전에 비교한 값 이용해서, 오른쪽에서부터 이미 계산한 값 이용해서 비교
        // 동일한 로직인데 idx를 거꾸로 한다.
        for(int i=W-1; i>=0; i--){
            int curr = blocks[i];
            if(i == W-1){
                localMaxRightArr[i] = curr;
            }else{
                int localMax = localMaxRightArr[i+1];
                localMaxRightArr[i]=Math.max(curr, localMax);
            }

        }

        // System.out.println(Arrays.toString(localMaxRightArr));

        // 물은 낮은 곳에서부터 고이니까,
        // 왼쪽, 오른쪽에서부터 가장 높은 것 중 낮은 높이를 가져온다.
        int[] integratedArr = new int[W];
        for(int idx=0; idx<W; idx++){
            int localMin = Math.min(localMaxLeftArr[idx], localMaxRightArr[idx]);
            integratedArr[idx] = localMin;
        }

        // System.out.println(Arrays.toString(integratedArr));

        int count = 0;
        for(int idx=0; idx<W; idx++){
            int water = integratedArr[idx] - blocks[idx];
            if(water >= 0)
                count += water;
        }
        System.out.println(count);

/**
                for(int i=0; i < W; i++){
            int localMax = -1;
            for(int j=0; j < i; j++){
                int curr = blocks[i];
                int before = blocks[j];
                localMax = Math.max(before, curr);
                localMaxArr[i] = localMax;
            }
        }
 */

//4 8
//1 3 2 3 4 1 1 2

    }

}
