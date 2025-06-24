import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int result = 0;

        for(int i=0; i < N; i++){
            // 각 케이스별로 짝이 맞는지를 확인한다.
            String st = br.readLine();
            char[] charArray = st.toCharArray();
            int len = charArray.length;

            Stack<Character> s = new Stack<>();
            boolean isMatch = true;
            for(int j=0; j<len; j++){
                // Stack이 비어 있거나 문자열이 서로 다를 때, char을 더해준다.
                // 변수화 해서 코드의 가독성을 높이고 이쁘게 짜는 것도, 좋은 코드 작성 습관이다.
                char top='?';
                if(!s.isEmpty())
                    top = s.peek();
                char adt = charArray[j];

                if(s.isEmpty() || top != charArray[j]){
                    s.add(adt);
                }

                // Stack의 위와 Additional 이 같을 때 pop을 해준다.
                // 물론 Stack이 비어 있지 않을 때만 가능 한 것이고, 그렇지 않으면 isMatch = false 처리해준다.
                if(top =='A' && adt == 'A' || top=='B' && adt=='B'){
                    s.pop();
                }

            }

            // isMatch가 필요 없는 것은 어차피 adt 가 있다면,
            // 그냥 Stack이 비어있지 않게 되니까 Stack이 비어 있는지 여부로만 확인하면 된다.
            if(s.isEmpty()){
                result++;
            }


        }

        System.out.println(result);


    }
}
