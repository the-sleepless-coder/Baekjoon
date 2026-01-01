import java.util.*;

public class Solution {
    static int testCases = 10;
    static int N = 8;
    static int R = 5;
    static int GCD = 15;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        for(int test=1; test <= testCases; test++){
            int testNum = sc.nextInt();
            sc.nextLine();

            // 앞에서 빠지고 뒤에 들어갈 수 있게 arraydeque을 쓴다.
            Deque<Integer> deq = new ArrayDeque<>();

            for(int idx = 0; idx<N; idx++){
                int num = sc.nextInt();
                deq.add(num);
            }

            // System.out.println(deq);

            int first = -1;

            outer:
            while (true){
                for(int idx=1; idx<=R; idx++){
                    first = deq.pollFirst();
                    first -= idx;
                    if(first < 0){
                        first = 0;
                    }
                    deq.addLast(first);

                    if(deq.peekLast()<=0)
                        break outer;
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(testNum).append(" ");
            for(int ele: deq){
                sb.append(ele).append(" ");
            }
            // System.out.println(deq);
            System.out.println(sb);

        }




    }
    // 1 2 3 4 5 1 2 3
    // 4 5 1 2 3 4 5 1
    // 2 3 4 5 1 2 3 4
    // 5 1 2 3 4 5 1 2
    // 3 4 5 1 2 3 4 5

//1
//10 6 12 8 9 4 1 3

//1
//9550 9556 9550 9553 9558 9551 9551 9551

// 30 36 30 33 58 51 51 51 51

}
