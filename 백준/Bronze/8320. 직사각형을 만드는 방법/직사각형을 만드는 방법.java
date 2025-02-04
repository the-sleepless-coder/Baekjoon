import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        // 6
        // 1*1, 1*2, 1*3, 1*4, 1*5, 1*6
        // 2*1(X), 2*2, 2*3

        // 8
        // 1*1, 1*2, 1*3, 1*4, 1*5, 1*6, 1*7, 1*8
        // 2*1(X), 2*2, 2*3, 2*4

        List<Integer> numList = new ArrayList<>();


        // 피제수 = 제수 * 몫
        // 제수 <= 몫
        for(int i=1; i<=Math.sqrt(num);i++){
            for(int j=i; i*j<=num; j++ ){
                numList.add(i*j);
            }
        }

        System.out.println(numList.size());

    }


}
