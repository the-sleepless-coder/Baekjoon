import java.util.*;

public class Main {
    // 1 2 3 4 5 7
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int S = sc.nextInt();

        arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int result = findArmorSet(S);
        System.out.println(result);
    }

    // 투 포인터를 이용해서, 몇개의 갑옷 조합을 만들 수 있는지 확인한다.
    static int findArmorSet(int S){
        int s = 0;
        int e = arr.length - 1;
        // 갑옷을 몇 벌 만들 수 있는 지 확인한다.
        int cnt = 0;

        // s와 e는 겹치면 안되기 때문에, s.equals(e)일 때 while문을 종료한다.
        while(s < e){
            if(arr[s]+ arr[e] == S){
                cnt++;
                s++;
                e--;
            }
            // 갑옷이 주어진 합보다 작다면, s의 인덱스를 늘려준다.
            else if(arr[s] + arr[e] < S){
                s++;
            }
            // 갑옷이 주어진 합보다 크다면, e의 인덱스를 줄여준다.
            else if(arr[s] + arr[e] > S){
                e--;
            }
        }


        return cnt;
    }
}
