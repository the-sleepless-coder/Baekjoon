import java.util.*;
import java.io.*;

public class Main {
    static int N = 3;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        StringTokenizer st = new StringTokenizer(input);
        ArrayList<Integer> arr = new ArrayList<>();
        for (int idx=0; idx<N; idx++){
            arr.add( Integer.parseInt(st.nextToken()));
        }

        Collections.sort(arr);

        for(int idx=0; idx<N; idx++){
            System.out.printf("%d ",arr.get(idx));
        }
    }
    
}
