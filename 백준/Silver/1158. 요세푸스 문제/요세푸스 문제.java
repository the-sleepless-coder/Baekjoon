import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[2];
        for(int i = 0; i < 2; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int tot = arr[0];
        int n = arr[1];

        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i =1; i <= tot; i++){
            q.add(i);
        }

        // System.out.println(q);

        while(!q.isEmpty()){
            for(int i = 0; i < n - 1; i++){
                int temp = q.poll();
                q.add(temp);
            }
            int ext = q.poll();
            list.add(ext);
        }

        // System.out.println(list);

        for(int i=0; i<list.size(); i++){
            if(i==0){
                System.out.print("<");
            }
            
            System.out.printf("%d",list.get(i));
            if(i!=list.size()-1){
                System.out.print(", ");
            }

            if(i==list.size()-1){
                System.out.print(">");
            }

        }


    }
}
