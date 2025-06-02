import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];
        for(int i=0; i < N; i++){
            arr[i] = br.readLine();

            // Stack<Character> front = new Stack<>();
            Deque<Character> front = new ArrayDeque<>();
            Deque<Character> back = new ArrayDeque<>();

            char[] charArray = arr[i].toCharArray();
            for(char c: charArray){
                // front에 문자가 존재한다면, 앞에 있는 문자를 뒤로 보낸다.
                if(c=='<'){
                    if(front.isEmpty()){
                        continue;
                    }
                    else{
                        char temp = front.pollLast();
                        back.addFirst(temp);
                    }
                }
                // back에 문자가 존재한다면, 뒤에 있는 문자를 앞으로 보낸다.
                else if (c=='>') {
                    if (back.isEmpty()) {
                        continue;
                    } else {
                        char temp = back.pollFirst();
                        front.addLast(temp);
                    }
                }
                // 커서 앞에 문자가 존자한다면 삭제한다.
                else if(c=='-'){
                    if(front.isEmpty()){
                        continue;
                    }else{
                        front.pollLast();
                    }
                }
                // 그 외 문자는 front의 뒤에 더해준다.
                else{
                    front.addLast(c);
                }
            }

            StringBuilder sb = new StringBuilder();
            while(!front.isEmpty()){
                sb.append(front.pollFirst());
            }

            while(!back.isEmpty()){
                sb.append(back.pollFirst());
            }

            //System.out.println(front);
            // System.out.println(back);
            System.out.println(sb);

        }


    }
}
