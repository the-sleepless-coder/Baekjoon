import java.util.*;
import java.io.*;

public class Main {
    static int N = 42;
    public static void main(String[] args) throws IOException {
        // Byte Stream -> Char Stream -> String으로 이어 붙인다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input="";

        // 42로 나눈 것의 나머지가,
        // 다른 것이 있으면 set에 넣는다.
        Set<Integer> set = new HashSet<>();
        while( (input= br.readLine()) != null){
            if(input.isEmpty()) break;
            int num = Integer.parseInt(input);
            int remain = num%N;
            if(set.contains(remain)){
                continue;
            }else{
                set.add(remain);
            }
        }

        System.out.println(set.size());

    }
}
