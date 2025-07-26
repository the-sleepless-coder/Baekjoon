import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int testcase = Integer.parseInt(br.readLine());


       for(int tc=0; tc<testcase; tc++){
           int dbN = Integer.parseInt(br.readLine());
           StringTokenizer st = new StringTokenizer(br.readLine());
           HashSet<Integer> db = new HashSet<>();
           for(int i=0; i<dbN;i++){
               db.add(Integer.parseInt(st.nextToken()));
           }

           int findN = Integer.parseInt(br.readLine());
           st = new StringTokenizer(br.readLine());
           int[] findList = new int[findN];
           for(int i=0; i<findN;i++){
               findList[i] = Integer.parseInt(st.nextToken());
           }

           StringBuilder sb = new StringBuilder();
           for(int i=0; i<findN; i++){
               if(db.contains(findList[i])){
                   sb.append("1");
               }
               else{
                   sb.append("0");
               }

               if(i != findN -1)
                   sb.append("\n");
           }

           System.out.println(sb);
       }



    }
}
