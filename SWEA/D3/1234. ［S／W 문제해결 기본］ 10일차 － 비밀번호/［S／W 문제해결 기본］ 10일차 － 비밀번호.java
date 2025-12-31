import java.util.*;

public class Solution{
    static int testCases = 10;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for(int t=1; t <= testCases; t++){
            int num = sc.nextInt();

            String str = sc.next();
            char[] charArr = str.toCharArray();
            int len = charArr.length;
            Stack<Integer> stack = new Stack<>();
            for(int idx = 0; idx < len; idx++){
                int added = Integer.parseInt(String.valueOf(charArr[idx]));

                // 값이 있으면 stack 맨위에 있는 값을 pop해준다.
                // 아니라면 값을 더해준다.
                if(!stack.isEmpty()){
                    if(stack.peek() == added){
                        stack.pop();
                    }else{
                        stack.add(added);
                    }
                }
                // 스택이 비어 있으면 값을 넣는다.
                else{
                    stack.add(added);
                }


            }

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ");
            int stackSize = stack.size();
            for(int idx=0; idx<stackSize; idx++){
                sb.append(stack.get(idx));
            }
            System.out.println(sb);

        }


    }
}
//10 1238099084
//16 4100112380990844