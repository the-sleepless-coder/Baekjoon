import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        int idx = 0;
        int num = 0;
        Stack<Integer> s = new Stack<>();
        boolean isStack = true;
        while(true){
            // Stack이 비어 있다면 채워주고 +를 출력한다.
            if(s.isEmpty()){
                s.add(++num);
                sb.append("+").append("\n");
                continue;
            }
            // arr과 stack의 숫자가 같지 않다면 stack에 숫자를 더해준다.
            if(arr[idx] != s.peek()){
                if(s.peek() < arr[idx]){
                    s.add(++num);
                    sb.append("+").append("\n");
                }else if(s.peek() > arr[idx]){
                    isStack = false;
                    break;
                }
            }
            // arr과 stack의 숫자가 같다면 pop해준다.
            else{
                s.pop();
                idx++;
                if(idx!=N) sb.append("-").append("\n");
                else sb.append("-");
            }

            if(idx==N)
                break;

        }

        if(isStack){
            System.out.println(sb);
        }else{
            System.out.println("NO");
        }


    }
}
