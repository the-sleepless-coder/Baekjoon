import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();

        for(int idx=0; idx<N; idx++){
            A.add(sc.nextInt());
        }
        for(int idx=0; idx<N; idx++){
            B.add(sc.nextInt());
        }

        int result = findMinBySort(A, B);
        System.out.println(result);


    }

    // 내림차순, 오름차순을 통해서 가장 작은 계산 값을 찾기.
    static int findMinBySort(ArrayList<Integer> A, ArrayList<Integer> B){
        int N = A.size();
        A.sort((i1, i2)-> Integer.compare(i2, i1));
        B.sort((i1, i2)-> Integer.compare(i1, i2));

        int sum = 0;
        for(int idx=0; idx<N; idx++){
            int a = A.get(idx);
            int b = B.get(idx);

            sum+=a*b;

        }

        return sum;

    }

    // Priority Queue를 통해서 가장 최소값과 최대값을 하나씩 곱해서 결과 구하기.
    static int findByPQ(ArrayList<Integer> A, ArrayList<Integer> B, int N){

        // A 최대값, B최소값을 곱해서 가장 작은 값을 구한다.
        PriorityQueue<Integer> pqA = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pqB = new PriorityQueue<>();

        int sum = 0;
        for(int idx=0; idx<N; idx++){
            int a = pqA.poll();
            int b = pqB.poll();

        }
        return 0;
    }

}

// 6 1 1 1 0
// 1 2 3 7 8


