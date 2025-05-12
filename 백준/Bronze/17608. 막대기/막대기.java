import java.util.*;

public class Main {
    // 6 9 7 6 4 1
    // 7 3 4 2 3 1
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Stack<Integer> s = new Stack<>();

        for(int i=0; i<N; i++){
            s.push(sc.nextInt());
        }

//        System.out.println(s);
//        System.out.println(s.peek());

        // 가장 오른쪽 원소를 확인한다.
        Stack<Integer> result = new Stack<>();
        int right = s.pop();
        result.add(right);

        // 기본적으로 current를 확인하기 위해서 pop을 하고,
        // 가장 오른쪽 원소보다 큰 값이 나오면 result에 더해준다.

        // 근데 오른쪽에 있는 값 중 가장 큰 값과 비교해서,
        // current가 더 커야만 result에 더해줄 수 있는 것이다.
        
        // 그리고 더 큰 current 값이 나오면, right = current 로 바꿔준다.
        while(!s.isEmpty()){
            int current = s.pop();
            if( current > right ){
                result.add(current);
                right = current;
            }
        }

        // System.out.println(result);

        int answer = result.size();
        System.out.println(answer);

    }
}

//7
//5
//3
//7
//4
//2
//9
//1