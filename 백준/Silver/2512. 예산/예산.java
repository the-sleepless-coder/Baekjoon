import java.util.Scanner;

public class Main {
    // 모든 요청이 그대로 배정될 수 있다면, 요청한 금액을 그대로 배정한다.
    // 모든 요청이 배정될 수 없으면 상한액, 배정 금액 중 작은 금액을 배정한다.
    // 상한액을 구하기 위해서 이분탐색을 이용해서, 어떤 상한선이 가장 큰 예산을 배정할 수 있는지 확인한다.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int max = Integer.MIN_VALUE;
        int min = 0;
        
        int sum = 0;
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
            max = Math.max(max, arr[i]);
            sum+=arr[i];
        }
        int totBudg = sc.nextInt();

        // 배정된 예산이 크다면, 최대값인 예산을 출력한다.
        if(sum < totBudg){
            System.out.println(max);
        }
        // 예산의 총합이 더 크다면, 이분탐색을 통해서 상한선을 구한다.
        else{
            int maxBudg = Integer.MIN_VALUE;
            int upperBound = Integer.MIN_VALUE;

            while( min <= max ){
                int mid = (min + max)/2;
                int tempSum = 0;
                for(int i=0; i<N; i++){
                    tempSum += Math.min(arr[i], mid);
                }

                // 예산의 총합이 너무 크다면, 상한액을 줄인다.
                if( tempSum > totBudg){
                    max = mid - 1;
                }
                // 예산의 총합이 너무 작다면, 상한액을 늘린다.
                else if (tempSum <= totBudg){
                    min = mid + 1;
                    if(maxBudg < tempSum){
                        maxBudg = tempSum;
                        upperBound = mid;
                    }

                }

            }
            System.out.println(upperBound);

        }


    }
}
