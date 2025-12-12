import java.io.*;
import java.util.*;

public class Main {
    static int NUM = 8;
    static int CHOOSE = 5;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Problems> problemArr = new ArrayList<>();
        for(int idx=0; idx < NUM; idx++){
            int points = Integer.parseInt(br.readLine());
            int index = idx+1;

            Problems prob = new Problems(index, points);

            problemArr.add(idx, prob);
        }

        // 당연히 ArrayList에서 순서를 찾아야하기 때문에,
        // ArrayList로 만들어야 한다.
        Collections.sort(problemArr, (Problems p1,  Problems p2) -> Integer.compare(p2.points, p1.points));

        int sum = 0;
        int[] idxArr = new int[CHOOSE];
        for (int idx=0 ; idx< CHOOSE; idx++){
            sum += problemArr.get(idx).points;
            idxArr[idx] = problemArr.get(idx).index;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(sum).append("\n");
        Arrays.sort(idxArr);
        for(int index: idxArr){
            sb.append(index).append(" ");
        }

        System.out.println(sb);

    }

    public static class Problems{
        int index;
        int points;

        public Problems(int index, int points){
            this.index = index;
            this.points = points;
        }

    }

}
