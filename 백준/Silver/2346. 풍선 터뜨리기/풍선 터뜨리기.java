import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            // idx, add 를 pair에 더해준다.
            ArrayList<Integer> pair = new ArrayList<>();
            pair.add(i);
            pair.add(Integer.parseInt(st.nextToken()));
            arr.add(pair);
        }

        // System.out.println(arr);

        int[] result = new int[N];
        int calcIdx = 0;
        for(int i=0; i<N; i++){
            // idx, add를 arr에서 가져온다.
            int idx = arr.get(calcIdx).get(0);
            int add = arr.get(calcIdx).get(1);

            // 원본 배열에서의 순서를 result에 넣어준다.
            result[i] = idx + 1;

            // arr에서 calcIdx를 없애주고, 새로운 calcIdx를 계산해준다.
            // arr에서 해당 calcIdx를 없애고 난 뒤 해당 idx의 순서를 구하기 위해서,
            // arr.size()를 더하고 나머지를 calcIdx로 구한다.

            // arr에서 삭제 후 바뀐 순서인 calcIdx를 고려하게 위해서,
            // add > 0 인 경우 -1을 계산하고 순서를 계산한다.
            arr.remove(calcIdx);
            if(!arr.isEmpty()){
                if(add > 0){
                    calcIdx -= 1;
                }

                calcIdx = ( calcIdx + add + arr.size()) % arr.size();
                while(calcIdx < 0){
                    calcIdx += arr.size();
                }

            }

        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb);

    }
}
