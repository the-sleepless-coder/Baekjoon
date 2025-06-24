import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            // 각 케이스마다 괄호의 짝이 맞는지 확인한다.
            String st = br.readLine();
            char[] charArray = st.toCharArray();

            Stack<Character> s = new Stack<>();

            // Stack에 있는 모든 Character에 대해서 검사한다.
            int len = charArray.length;
            boolean isMatch = true;
            for(int j=0; j < len; j++){
                if(charArray[j]=='('){
                    s.add(charArray[j]);
                }else if(charArray[j]==')'){
                    // Stack에서 비어 있지 않을 때만 pop해준다.
                    if(!s.isEmpty()){
                        s.pop();
                    }else{
                        isMatch = false;
                        break;
                    }
                }
            }

            // Stack이 비어 있고 isMatch = true 일 때만, Yes를 출력한다.
            if(s.isEmpty() && isMatch){
                sb.append("YES").append("\n");
            }else{
                sb.append("NO").append("\n");
            }


            // System.out.println(s);
            //System.out.println(charArray);
        }

        System.out.println(sb);




    }
}
