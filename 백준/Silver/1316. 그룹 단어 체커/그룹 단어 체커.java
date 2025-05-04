import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];
        for(int i=0; i<N; i++){
            arr[i] = br.readLine();
        }

        int totCount = 0;
        String[] result = new String[N];
        ArrayList<String> arrList = new ArrayList<>();
        for(int i=0; i<N; i++){
            char[] charArr = arr[i].toCharArray();
            int len = charArr.length;

            // HashMap에 특정 문자와 가장 마지막으로 들어간 인덱스를 넣는다.
            // 인덱스가 한번만 들어가거나 가장 마지막으로 넣은 인덱스와의 차이가 1 일 때만 groupchecker = true를 만족시키게 한다.
            boolean groupchecker = true;
            HashMap<Character, Integer> map = new HashMap<>();
            for(int j = 0; j < len; j++){
                if ( !map.containsKey(charArr[j]) ){
                    map.put(charArr[j], j);
                }else if(map.containsKey(charArr[j])){
                    if( Math.abs(map.get(charArr[j]) - j) > 1 ){
                        groupchecker = false;
                    }else{
                        map.replace(charArr[j], j);
                    }
                }
            }


            if(groupchecker){
                result[i] = arr[i];
                totCount++;
            }


        }

        // System.out.println(Arrays.toString(arr));
        // System.out.println(Arrays.toString(result));
        System.out.println(totCount);



    }
}
