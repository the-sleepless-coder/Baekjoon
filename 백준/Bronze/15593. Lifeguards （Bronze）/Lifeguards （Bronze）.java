import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] arr = new int[N][2];
        int totHours = Integer.MIN_VALUE;
        for(int idx=0; idx<N; idx++){
            arr[idx][0]=sc.nextInt();
            arr[idx][1]=sc.nextInt();
            totHours = Math.max(totHours,arr[idx][1]);
        }

        //System.out.println(totHours);

        int maxHours = Integer.MIN_VALUE;
        // 빠질 idx를 miss로 지정한다.
        for(int miss=0; miss<N; miss++){

            boolean[] workingHours = new boolean[totHours+1];
            for(int idx=0; idx<N; idx++){
                if(idx==miss)
                    continue;

                int start = arr[idx][0];
                int end = arr[idx][1];

                for(int num=start+1; num<=end; num++){
                    workingHours[num]=true;
                }

            }

            int shifts = 0;
            for(int idx=0; idx<=totHours; idx++){
                if(workingHours[idx]){
                    shifts++;
                }
            }

            maxHours = Math.max(maxHours, shifts);
        }

        System.out.println(maxHours);

    }
}


// 그냥 한명씩 뺏을 때 가장 많은 근무 시간을 구하면 된다.
//3
//1 5
//14 15
//4 11
//2 3