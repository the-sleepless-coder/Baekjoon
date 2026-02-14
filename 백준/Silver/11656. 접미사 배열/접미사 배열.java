import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s =br.readLine();

        ArrayList<String> arr = new ArrayList<>();
        char[] charArr = s.toCharArray();
        int len = charArr.length;
        for(int i=0; i<len; i++){
            // 각 시작점에서 문자열 끝까지 StringBuilder로 만들어준다.
            // List에 더해준다.
            StringBuilder sb = new StringBuilder();
            for(int r=i; r<len ; r++){
                sb.append(charArr[r]);
            }

            arr.add(String.valueOf(sb));
        }

        Collections.sort(arr);

        StringBuilder sb = new StringBuilder();
        for(int idx=0; idx<arr.size();idx++){
            sb.append(arr.get(idx)).append("\n");
        }
        System.out.println(sb);


    }
}

// 길이는 총 1000자보다 작기 때문에,
// 정렬하는 데 NlogN이 들면 괜찮을 것이다.