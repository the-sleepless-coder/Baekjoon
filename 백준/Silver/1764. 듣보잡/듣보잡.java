import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static String[] biggerString, smallerString;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> heard = new HashSet<>();
        HashSet<String> seen = new HashSet<>();

        for(int i=0; i < N; i++){
            heard.add(br.readLine());
        }

        for(int i=0; i < M ; i++){
            seen.add(br.readLine());
        }

        // System.out.println(heard);
        // System.out.println(seen);

        int H = heard.size();
        int S = seen.size();

        int bigger = Math.max(H, S);
        int smaller = Math.max(H,S);

        Iterator<String> itS = seen.iterator();
        // System.out.println(itS.next());
        Iterator<String> itH = heard.iterator();
        // System.out.println(itH.next());

        if(bigger == H) {
            biggerString = new String[H];
            for(int i=0; i<H; i++){
                biggerString[i] = itH.next();
            }
            /*smallerString = new String[S];
            for(int i=0; i<S; i++){
                smallerString[i] = itS.next();
            }*/
        }
        else{
            biggerString = new String[S];
            for(int i=0; i < S ; i++){
                biggerString[i] = itS.next();
            }

            /*smallerString = new String[H];
            for(int i=0; i<H; i++){
                smallerString[i] = itH.next();
            }*/

        }

        // HashSet<String> s = new HashSet<>();
        // s.contains()
        // 더 작은 Set에 더 큰 Set의 항목이 몇 개 들어가 있는지 확인한다.
        int result = 0;
        List<String> list = new ArrayList<>();

        if (bigger == H){
            for(int i = 0; i < bigger; i++){
                if(seen.contains(biggerString[i])){
                    list.add(biggerString[i]);
                    result += 1;
                }

            }
        }else{
            for(int i=0; i < bigger; i++){
                if(heard.contains(biggerString[i])){
                    list.add(biggerString[i]);
                    result += 1;
                }
            }
        }

        System.out.println(result);
        // 람다식을 이용해서, String a, b를 오름차순으로 정렬한다.
        list.sort((a,b) -> a.compareTo(b));

        for(String ele:list){
            System.out.println(ele);
        }


    }
}
