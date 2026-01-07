import java.util.Scanner;
import java.util.Stack;

public class Solution {
    static int testCase = 10;
    public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
        for(int test=1; test<=testCase; test++){
           
            int num = sc.nextInt();
            sc.nextLine();

            String str = sc.nextLine();
            char[] charArr = str.toCharArray();
            int len = charArr.length;

            Stack<Character> stack = new Stack<>();
            boolean isPar = true;
            for(int idx=0; idx<len; idx++){
                char ch = charArr[idx];

                //여는 괄호는 더해주기.
                if(ch=='{'||ch=='['||ch=='('||ch=='<')
                    stack.add(ch);
                else{
                // 닫는 괄호라면 stack 가장 위랑 비교해서 pop할지 결정하기
                // 그러니까 짝이 맞는 경우에만 pop하기.
                // 짝 안 맞으면 break하고 isPar = false해준다.
                    char top = stack.peek();
                    if(top=='{'&&ch=='}')
                        stack.pop();
                    else if(top=='['&&ch==']')
                        stack.pop();
                    else if(top=='<'&&ch=='>')
                        stack.pop();
                    else if(top=='('&&ch==')')
                        stack.pop();
                    else{
                        isPar=false;
                        break;
                    }
                }

            }

            StringBuilder sb = new StringBuilder();
            if(stack.isEmpty() && isPar){
                sb.append("#").append(test).append(" ").append(1);
            }
            else{
                sb.append("#").append(test).append(" ").append(0);
            }

            System.out.println(sb);
        }

    }
}

//16
//{[()]}<>[<{}><>]

