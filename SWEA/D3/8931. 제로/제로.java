import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        // int testCase = 1 ;

        for(int test = 1; test<=testCase; test++){
            int k = sc.nextInt();
            sc.nextLine();

            Stack<Integer> stack = new Stack<>();

            for(int idx =0; idx<k ; idx++){
                int num = sc.nextInt();

                if(num==0 && !stack.isEmpty())
                    stack.pop();
                else
                    stack.add(num);

            }

            int sum=0;
            for(int num:stack)
                sum+=num;

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(test).append(" ").append(sum);
            System.out.println(sb);
        }

    }
}
