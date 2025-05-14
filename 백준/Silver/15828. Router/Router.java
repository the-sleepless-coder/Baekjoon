import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();

        // pkt의 값이 -1이 아닐 때까지 일단 입력을 모두 받는다.
        while( true ){
            int pkt = Integer.parseInt(br.readLine());
            if( pkt == -1 )
                break;

            // pkt 개수가 buff가 넘치지 않을 때만 pkt값을 queue에 넣는다.
            // 0이라면 pkt을 처리한 것이기 때문에 queue에서 빼준다.
            int buff = q.size();
            if(pkt != 0 && buff < N){
                q.add(pkt);
            }else if( pkt == 0){
                q.poll();
            }


        }

        StringBuilder sb = new StringBuilder();

        if( q.isEmpty() ){
            sb.append("empty");
        }
        else{
            while( !q.isEmpty() ){
                int n = q.poll();
                sb.append(n).append(" ");
            }
        }

        // System.out.println(q);
        System.out.println(sb);

    }
}
