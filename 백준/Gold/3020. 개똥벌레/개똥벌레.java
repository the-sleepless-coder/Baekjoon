import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // N =  석순+종유석의 개수 (200,000)
        // H = 높이(500,000)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        // 이거 저장을 어떻게 해야 하지?
        // 석순, 종유석의 길이 배열 개수를 저장한다.
        int[] bottom = new int[H+1];
        int[] top = new int[H+1];
        for(int idx=1; idx <= N; idx++){
            int height = Integer.parseInt(br.readLine());

            if(idx % 2==1){
                bottom[height] += 1;
            }else{
                top[height] += 1;
            }
        }
        // System.out.println(Arrays.toString(bottom));
        // System.out.println(Arrays.toString(top));

        // 각 높이에서 자신을 포함해 더 높은 석순의 개수를 누적합으로 구한다.
        // 종유석은 자신을 포함해 자신보다 낮은 종유석의 개수를 누적합으로 구한다.
        int[] bottomSuffix = new int[H+1];
        int[] topSuffix = new int[H+1];
        for(int idx = 0; idx <= H-1; idx++){
            if(idx == 0){
                bottomSuffix[H - idx] = bottom[H - idx];
                topSuffix[H-idx ] = top[H-idx];
            }else{
                bottomSuffix[H - idx] = bottom[H-idx] + bottomSuffix[H-(idx-1)];
                topSuffix[H-idx] = top[H-idx] + topSuffix[H-idx +1]  ;
            }
        }

        // System.out.println(Arrays.toString(bottomSuffix));
        // System.out.println(Arrays.toString(topSuffix));

        // 각 높이 별로 top, bottom의
        int[] collisions = new int[H+1];

        for(int insH = 1; insH<=H; insH++){
            collisions[insH] = bottomSuffix[insH] + topSuffix[H-insH+1];
        }

        // System.out.println(Arrays.toString(collisions));

        //min의 값과 그 개수를 구한다.
        int min = Integer.MAX_VALUE;
        for(int idx=1; idx<=H; idx++){
            min = Math.min(min, collisions[idx]);
        }

        int count = 0;
        for(int idx=1; idx<=H; idx++) {
            if (min == collisions[idx]) {
                count++;
            }
        }

        System.out.printf("%d %d", min, count);


        // 반딧불이 높이 ins에 대해서,
        // ins >= bottom[idx]
        // ins >= top[idx]
        // collisions = count(ins>=bottom[idx] + ins>= top[idx])

        // 각 높이별 개똥벌레가 부딪히는 석순/종유석 개수.
        // 홀수면 석순, 짝수면 종유석

        //근데 사실 내가 한게 누적합 아닌가?
        // 그냥 그거를 모든 구간에 대해서 한게 아니라
        // 구간을 체크하고 넣는 것만 달라진 것 같은데


        // 6 7
        // 1 5 3 3 5 1

        // 3 2 3 2 3 2 3

        // 14 5
        // 1 3 4 2 2 4 3 4 3 3 3 2 3 3


    }

}
