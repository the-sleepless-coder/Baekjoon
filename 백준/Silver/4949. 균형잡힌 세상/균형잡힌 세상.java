import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(br.readLine());

        while(true){
            String str = br.readLine();
            char chr = str.charAt(0);
            if(chr == '.')
                break;

            // Stack<Character> s = new Stack<>();
            Queue<Character> q = new LinkedList<>();
            Deque<Character> par = new LinkedList<>();
            char[] charArray = str.toCharArray();

            // 공백을 제외하고 q에 넣어준다.
            for(char c: charArray){
                if(c!=' '){
                    q.add(c);
                }
            }

            // System.out.println(q);

            while(!q.isEmpty()){
                char curr = q.poll();
                // System.out.println(curr);
                if(curr=='('||curr==')'||curr=='['||curr==']'){
                    par.add(curr);
                }
            }

            // System.out.println(par);

            // 괄호를 담고 있는 Queue에서 짝이 맞는지를 확인한다.
            // 그러니까 여는 괄호를 Stack에 넣고,
            // 대응하는 닫는 괄호가 있다면 Stack에 있는 여는 괄호를 pop해주면 되는구나.
            Stack<Character> s = new Stack<>();
            boolean isBalanced = true;
            while( !par.isEmpty() ){
                char curr = par.pollFirst();
                if(curr == '(' || curr == '['){
                    s.push(curr);
                }
                // 닫는 괄호를 검사한다.
                else{
                    // Stack이 차 있을 때만 pop을 할 수 있기 때문에,
                    // Stack이 채워져 있는지 확인한다.

                    // 닫는 괄호가 짝이 안 맞다면 isBalanced = false로 처리한다.
                    if(!s.isEmpty()){
                        if(curr==')' && s.peek()== '('){
                            s.pop();
                        }else if(curr==']' && s.peek()=='['){
                            s.pop();
                        }else{
                            isBalanced = false;
                            break;
                        }
                    }
                    // 닫는 괄호가 더 많다면 isBalanced = false로 처리한다.
                    else{
                        isBalanced = false;
                        break;
                    }
                }
            }

            // 여는 괄호가 더 많다면 false로 처리한다.
            if(!s.isEmpty()){
                isBalanced = false;
            }

            // System.out.println(s);

            if(isBalanced)
                System.out.println("yes");
            else
                System.out.println("no");




            // System.out.println(q);
            // System.out.println(par);

            // System.out.println(charArray);
            //System.out.println(str);
        }

    }
}
