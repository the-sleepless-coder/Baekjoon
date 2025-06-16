import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<ArrayList<Character>> arr = new ArrayList<>();
        int N = 5;
        for(int i = 0; i < N; i++){
            arr.add(new ArrayList<>());
        }

        // 최소한 쓰이고 있는 method 측면에서, 어떤 원리로 작동하고 있는지를 알고 있으면 좋다.
        // Library에 대해서 이해하고 있는 것도 좋을 것이다.
        // 그러니까 코드고 작성되는 것에 대해서,
        // under the hood에서 어떤 일이 일어나고 있는지를 이해하고 있는 것은 당연히 좋은 일이라고 생각한다.

        // 작동하는 것을 처음부터 끝까지 모든 이론적인 원리를 다 알 것은 없지만,
        // 작동하는 것이 있다면 그것이 어떻게 작동하는지에 대한 이해를 하는 것은 좋다.

        // 2차원 동적 배열에 값을 넣는다.
        int max = Integer.MIN_VALUE;
        for(int i=0; i<N; i++){
            char[] temp = br.readLine().toCharArray();
            int len = temp.length;
            max = Math.max(len, max);
            for(int j=0; j < len; j++){
                arr.get(i).add(temp[j]);
            }

        }

        StringBuilder sb = new StringBuilder();
        // 열 값을 고정해주고,
        // 값이 있다면 StringBuilder에 박아준다.

        // 열의 값보다 더 작은 열을 가진 값일 때만,
        // StringBuilder에 더해준다.
        for(int i=0; i < max; i++){
            for(int j=0; j < N; j++){
                if(i < arr.get(j).size()){
                    sb.append(arr.get(j).get(i));
                }
            }
        }


        // System.out.println(arr);
        System.out.println(sb);



    }

}
