import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] treeArr = new int[N];
        int[] treeDistanceArr = new int[N-1];

        for(int n=0; n < N; n++){
            treeArr[n] = Integer.parseInt(br.readLine());
        }
        for(int n=1; n <= N-1; n++){
            int dist = treeArr[n] - treeArr[n-1];
            treeDistanceArr[n-1] = dist;
        }

        // System.out.println(Arrays.toString(treeDistanceArr));
        // System.out.println(gcd(2, 6));

        // 첫번째 항목이라면 curr, next의 GCD를 구해준다.
        // 두번째 이상항목 부터는 이전에 구한 gcd, next의 GCD를 구해준다.
        int distanceLen = treeDistanceArr.length;
        int gcd = -1;
        for(int idx = 0; idx <= distanceLen-2; idx++){
            int curr = -1;
            if(idx == 0){
                curr = treeDistanceArr[idx];
            }else{
                curr = gcd;
            }
            int next = treeDistanceArr[idx+1];

            gcd = gcd(curr, next);
        }

        // System.out.println(gcd);

        // 총 나무 그루 수에서 원래 있던 나무 그루 수를 뺀다.
        // 13-1 = 12
        // 12/2 + 1
        int treeLen = treeArr.length;
        int treeStart = 0;
        int totLen = treeArr[treeLen-1] - treeArr[treeStart];
        int totTrees = totLen/gcd + 1;

        int additionalTrees = totTrees - treeLen;

        System.out.println(additionalTrees);
    }

    // 2개 수의 최대공약수를 뽑아내는 함수이다.
    // 2개의 수를 뺐을 때 나머지 역시 최대공약수의 배수가 돼야한다는 사실에서부터 함수가 형성된다.

    // 최대공약수가 존재한다면 더 작은 숫자를 출력한다.
    // 그렇지 않으면 더 큰 수를 나머지로 바꿔주고 동일한 작업을 반복한다.
    // 48, 72
    // 48, 36
    public static int gcd(int x, int y){
        int gcd = -1;
        while(true){
            if(x <= y){
                int remain = y % x;

                if(remain==0){
                    gcd = Math.min(y, x);
                    break;
                }
                else{
                    y = remain;
                }

            }else {
                int remain = x % y;

                if (remain == 0) {
                    gcd = Math.min(x, y);
                    break;
                } else {
                    x = remain;

                }
            }

        }

        return gcd;
    }

}
