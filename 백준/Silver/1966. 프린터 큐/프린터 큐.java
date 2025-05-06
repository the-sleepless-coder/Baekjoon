import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // Queue의 가장 앞에 있는 문서의 중요도를 확인한다.
    // 현재 문서보다 중요도가 높은 문서가 하나라도 있으면, 그 문서를 Queue의 가장 뒤에 넣는다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for(int tc = 1; tc<=testCase; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());

            Queue<int[]> q = new LinkedList<>();
            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
                q.add(new int[]{i, arr[i]});
            }


            int cnt = 0;
            while(!q.isEmpty()){
                int[] current = q.poll();

                //현재 문서보다 더 우선순위가 높은 문서가 있는지 확인한다.
                boolean hasHigher = false;
                for( int[] doc: q){
                    if(current[1]<doc[1]){
                        hasHigher = true;
                        break;
                    }
                }

                // 현재 문서보다 더 우선순위가 높은 문서가 있다면,
                // 해당 문서를 Queue의 가장 뒤로 보낸다.
                if(hasHigher){
                    q.add(current);
                }
                // 현재 문서보다 더 우선순위가 높은 문서가 없다면,
                // 순번을 올리고 해당 문서를 출력한다.
                else{
                    cnt++;
                    if(current[0]==idx){
                        System.out.println(cnt);
                        break;
                    }

                }
            }



            // System.out.println(cnt);



        }

    }

    // 1
    // 5 2
    // 2 1 5 3 4
    // 1 5 3 4 2
    // 5 3 4 2 1
    // 5 4 2 1 3
    // 5 4 1 3 2
    // 5 4 3 2 1

//     1
//     5 3
//     2 1 5 3 4

}
