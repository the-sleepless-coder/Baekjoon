import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        StringBuilder sb = new StringBuilder();
        for(int idx=1; idx<=N; idx++){
            sb.append(idx);
        }

        // idx+subString length까지 검사하면서 최초의 idx를 출력한다.
        String stringN =String.valueOf(N);
        int len = stringN.length();

        int result = -1;
        for(int idx=0; idx<idx+len; idx++){
            String subString = sb.substring(idx, idx+len);

            if(subString.equals(stringN)){
                  result= idx+1;
                break;
            }
        }
        System.out.println(result);

        //value.indexOf(stringN);
    }
}
