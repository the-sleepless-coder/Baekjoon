import java.util.*;

public class Main {
    // 재현이는 재민이를 도와서 돈을 관리하는 중이다.
    // 재현이는 잘못된 숫자를 부를 때마다 0을 외쳐서, 최근에 재민이가 쓴 숫자를 지우게 한다.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<N; i++){
            int num = sc.nextInt();
            if(num!=0){
                s.add(num);
            }else{
                s.pop();
            }
        }

        // System.out.println(s);
        int sum = 0;
        for(int ele: s){
            sum += ele;
        }

        System.out.println(sum);
    }
}
